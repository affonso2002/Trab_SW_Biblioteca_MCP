package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.model.Book;
import br.edu.ifpr.biblioteca.service.SolrIndexService;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolrIndexServiceTest {
    @Test
    void leavesSolrInactiveWithoutReturningSearchResults() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setSolrEnabled(false);

        try (SolrIndexService service = new SolrIndexService(properties)) {
            assertFalse(service.enabled());
            assertTrue(service.search("qualquer termo", 0, 10).isEmpty());
            assertTrue(service.search(null, 0, 10).isEmpty());
            assertDoesNotThrow(() -> service.index(new Book(
                    1L, "Livro", List.of(), List.of(), "pt", "", "texto")));
        }
    }

    @Test
    void rejectsMalformedSolrUrlWhenIntegrationIsEnabled() {
        AppProperties properties = new AppProperties();
        properties.setSolrEnabled(true);
        properties.setSolrUrl("://url-invalida");

        assertThrows(IllegalArgumentException.class, () -> new SolrIndexService(properties));
    }
}
