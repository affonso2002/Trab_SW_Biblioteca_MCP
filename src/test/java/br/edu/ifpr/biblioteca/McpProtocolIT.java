package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import io.modelcontextprotocol.spec.McpSchema.GetPromptRequest;
import io.modelcontextprotocol.spec.McpSchema.ReadResourceRequest;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class McpProtocolIT extends McpIntegrationSupport {
    @Test void inicializacaoAnunciaNomeECapacidadesMcp() {
        assertTrue(client.isInitialized());
        assertEquals("Biblioteca Digital MCP Java - STDIO", client.getServerInfo().name());
        assertNotNull(client.getServerCapabilities());
        assertNotNull(client.getServerCapabilities().tools());
        assertNotNull(client.getServerCapabilities().resources());
        assertNotNull(client.getServerCapabilities().prompts());
    }

    @Test void listaResourcesEPrompts() {
        Set<String> resourceUris = client.listResources().resources().stream()
                .map(resource -> resource.uri()).collect(Collectors.toSet());
        assertTrue(resourceUris.contains("library://index/info"));
        Set<String> promptNames = client.listPrompts().prompts().stream()
                .map(prompt -> prompt.name()).collect(Collectors.toSet());
        assertTrue(promptNames.contains("pesquisar_biblioteca"));
    }

    @Test void obtemPromptELeResourceDoIndice() {
        var prompt = client.getPrompt(new GetPromptRequest("pesquisar_biblioteca", Map.of("tema", "romances classicos")));
        assertNotNull(prompt);
        assertFalse(prompt.messages().isEmpty());
        var resource = client.readResource(new ReadResourceRequest("library://index/info"));
        assertNotNull(resource);
        assertFalse(resource.contents().isEmpty());
    }
}
