package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.config.FileStorage;
import br.edu.ifpr.biblioteca.model.Book;
import br.edu.ifpr.biblioteca.service.LuceneIndexService;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class LuceneIndexServiceTest {
    @TempDir Path tempDir;

    private LuceneIndexService createService() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.resolve("data").toString());
        return new LuceneIndexService(new FileStorage(properties));
    }

    @Test void indiceVazioRetornaListaVazia() throws Exception {
        assertTrue(createService().search("termo", 0, 10).isEmpty());
    }

    @Test void indexaELocalizaLivro() throws Exception {
        LuceneIndexService service = createService();
        service.index(new Book(1342, "Pride and Prejudice", List.of("Jane Austen"),
                List.of("Classic", "Romance"), "en", "https://example.org/book",
                "It is a truth universally acknowledged that a single man in possession of a good fortune"));
        var results = service.search("truth universally acknowledged", 0, 10);
        assertEquals(1, results.size());
        assertEquals("Pride and Prejudice", results.getFirst().title());
        assertEquals("lucene", results.getFirst().source());
    }

    @Test void consultaVaziaListaTudoEPaginacaoLimitaResultados() throws Exception {
        LuceneIndexService service = createService();
        service.index(new Book(1, "Alpha Book", List.of("Author One"), List.of(), "en", "u1", "alpha subject"));
        service.index(new Book(2, "Beta Book", List.of("Author Two"), List.of(), "en", "u2", "beta subject"));
        assertEquals(2, service.search("   ", 0, 10).size());
        assertEquals(1, service.search("subject", 0, 1).size());
        assertTrue(service.search("subject", 99, 10).isEmpty());
    }
}
