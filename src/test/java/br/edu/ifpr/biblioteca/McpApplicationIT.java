package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class McpApplicationIT extends McpIntegrationSupport {
    @Test void registraTodasAsFerramentasEsperadas() {
        Set<String> names = client.listTools().tools().stream()
                .map(tool -> tool.name()).collect(Collectors.toSet());
        assertEquals(Set.of("indexar_gutenberg", "buscar_livros", "extrair_metadados_pdf",
                "processar_excel", "metadados_postgresql", "metadados_mysql"), names);
    }

    @Test void executaUmaFerramentaPeloProtocoloMcp() {
        var result = client.callTool(new CallToolRequest("buscar_livros",
                Map.of("query", "termo-que-nao-esta-no-indice", "page", 0, "pageSize", 5)));
        assertNotNull(result);
        assertNotNull(result.content());
        assertFalse(result.content().isEmpty());
        assertNotEquals(Boolean.TRUE, result.isError());
    }
    @Test void executaTodasAsFerramentasPorMcpInclusiveCaminhosDeErroControlados() {
        assertToolResponds("indexar_gutenberg", Map.of("query", "teste-local", "limit", 1));
        assertToolResponds("buscar_livros", Map.of("query", "sem-resultados", "page", 0, "pageSize", 5));

        var pdf = client.callTool(new CallToolRequest("extrair_metadados_pdf",
                Map.of("fileName", "../arquivo-fora.pdf")));
        assertNotNull(pdf);
        assertEquals(Boolean.TRUE, pdf.isError());
        assertFalse(pdf.content().isEmpty());

        var excel = client.callTool(new CallToolRequest("processar_excel",
                Map.of("fileName", "../arquivo-fora.xlsx")));
        assertNotNull(excel);
        assertEquals(Boolean.TRUE, excel.isError());
        assertFalse(excel.content().isEmpty());

        assertToolResponds("metadados_postgresql", Map.of());
        assertToolResponds("metadados_mysql", Map.of());
    }

    private void assertToolResponds(String name, Map<String, Object> arguments) {
        var result = client.callTool(new CallToolRequest(name, arguments));
        assertNotNull(result, "A Tool " + name + " deve devolver uma resposta MCP");
        assertNotNull(result.content(), "A Tool " + name + " deve devolver conteudo");
        assertFalse(result.content().isEmpty(), "A Tool " + name + " nao deve devolver conteudo vazio");
    }

}

