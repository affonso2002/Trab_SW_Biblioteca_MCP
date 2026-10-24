package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.config.FileStorage;
import br.edu.ifpr.biblioteca.model.Book;
import br.edu.ifpr.biblioteca.service.GutenbergService;
import br.edu.ifpr.biblioteca.service.IndexingService;
import br.edu.ifpr.biblioteca.service.LibraryRepository;
import br.edu.ifpr.biblioteca.service.LuceneIndexService;
import br.edu.ifpr.biblioteca.service.SolrIndexService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class IndexingServiceTest {
    @TempDir
    Path temporaryDirectory;

    @Test
    void indexesBooksAndWritesTheirContent() throws Exception {
        AppProperties properties = properties();
        FileStorage storage = new FileStorage(properties);
        Book book = new Book(123L, "Livro A", List.of("Ana"), List.of("Literatura"), "pt", "", "Texto do livro");
        List<Book> luceneIndexed = new ArrayList<>();
        List<Book> solrIndexed = new ArrayList<>();
        AtomicBoolean repositoryInitialized = new AtomicBoolean();
        AtomicReference<String> savedPath = new AtomicReference<>();
        AtomicInteger requestedLimit = new AtomicInteger(-1);

        GutenbergService gutenberg = new GutenbergService(properties) {
            @Override
            public List<Book> search(String query, int limit) {
                assertEquals("literatura", query);
                requestedLimit.set(limit);
                return List.of(book);
            }
        };
        LuceneIndexService lucene = new LuceneIndexService(storage) {
            @Override
            public void index(Book value) {
                luceneIndexed.add(value);
            }
        };
        SolrIndexService solr = new SolrIndexService(properties) {
            @Override
            public boolean enabled() {
                return true;
            }

            @Override
            public void index(Book value) {
                solrIndexed.add(value);
            }
        };
        LibraryRepository repository = new LibraryRepository(properties) {
            @Override
            public void initialize() {
                repositoryInitialized.set(true);
            }

            @Override
            public void save(Book value, String contentPath) {
                savedPath.set(contentPath);
            }
        };

        String result = new IndexingService(gutenberg, lucene, solr, repository, storage)
                .indexGutenberg("literatura", 4);

        assertEquals(4, requestedLimit.get());
        assertTrue(repositoryInitialized.get());
        assertEquals("Livros processados: 1\n123 - Livro A", result);
        assertEquals(List.of(book), luceneIndexed);
        assertEquals(List.of(book), solrIndexed);
        assertEquals(storage.documents().resolve("123.txt").toString(), savedPath.get());
        assertEquals("Texto do livro", Files.readString(storage.documents().resolve("123.txt")));
        solr.close();
    }

    @Test
    void returnsZeroWhenGutenbergSearchHasNoResults() throws Exception {
        AppProperties properties = properties();
        FileStorage storage = new FileStorage(properties);
        AtomicBoolean repositoryInitialized = new AtomicBoolean();
        List<Book> indexed = new ArrayList<>();
        GutenbergService gutenberg = new GutenbergService(properties) {
            @Override
            public List<Book> search(String query, int limit) {
                return List.of();
            }
        };
        LuceneIndexService lucene = new LuceneIndexService(storage) {
            @Override
            public void index(Book book) {
                indexed.add(book);
            }
        };
        SolrIndexService solr = new SolrIndexService(properties);
        LibraryRepository repository = new LibraryRepository(properties) {
            @Override
            public void initialize() {
                repositoryInitialized.set(true);
            }
        };

        String result = new IndexingService(gutenberg, lucene, solr, repository, storage)
                .indexGutenberg("nenhum", 5);

        assertEquals("Livros processados: 0\n", result);
        assertTrue(repositoryInitialized.get());
        assertTrue(indexed.isEmpty());
        solr.close();
    }

    @Test
    void propagatesGutenbergFailureBeforeInitializingRepository() throws Exception {
        AppProperties properties = properties();
        FileStorage storage = new FileStorage(properties);
        AtomicBoolean repositoryInitialized = new AtomicBoolean();
        GutenbergService gutenberg = new GutenbergService(properties) {
            @Override
            public List<Book> search(String query, int limit) throws Exception {
                throw new IllegalStateException("falha simulada da API");
            }
        };
        LuceneIndexService lucene = new LuceneIndexService(storage);
        SolrIndexService solr = new SolrIndexService(properties);
        LibraryRepository repository = new LibraryRepository(properties) {
            @Override
            public void initialize() {
                repositoryInitialized.set(true);
            }
        };

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> new IndexingService(gutenberg, lucene, solr, repository, storage)
                        .indexGutenberg("consulta", 2));

        assertEquals("falha simulada da API", exception.getMessage());
        assertFalse(repositoryInitialized.get());
        solr.close();
    }

    private AppProperties properties() {
        AppProperties properties = new AppProperties();
        properties.setDataDir(temporaryDirectory.resolve("data").toString());
        properties.setSolrEnabled(false);
        return properties;
    }
}
