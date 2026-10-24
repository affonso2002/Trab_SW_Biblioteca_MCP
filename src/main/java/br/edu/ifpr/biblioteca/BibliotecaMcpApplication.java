package br.edu.ifpr.biblioteca;

import br.edu.ifpr.mcp_server.main.McpServer01SyncStdio;

/** Ponto de entrada da aplicacao MCP da Biblioteca Digital. */
public final class BibliotecaMcpApplication {
    private BibliotecaMcpApplication() { }

    public static void main(String[] args) throws Exception {
        McpServer01SyncStdio.main(args);
    }
}
