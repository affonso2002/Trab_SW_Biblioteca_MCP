package br.edu.ifpr.biblioteca;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.json.jackson3.JacksonMcpJsonMapper;
import io.modelcontextprotocol.spec.McpSchema.Implementation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import tools.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/** Starts the actual server process and connects through the MCP STDIO transport. */
abstract class McpIntegrationSupport {
    protected Path dataDir;
    protected McpSyncClient client;

    @BeforeEach
    void startServerOverStdio() throws Exception {
        dataDir = Files.createTempDirectory("biblioteca-mcp-it-");
        String javaExecutable = Path.of(System.getProperty("java.home"), "bin",
                System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java").toString();
        String classpath = System.getProperty("surefire.test.class.path", System.getProperty("java.class.path"));
        ServerParameters parameters = ServerParameters.builder(javaExecutable)
                .args("-cp", classpath, "br.edu.ifpr.mcp_server.main.McpServer01SyncStdio")
                .addEnvVar("APP_DATA_DIR", dataDir.toString())
                .addEnvVar("SOLR_ENABLED", "false")
                .addEnvVar("GUTENBERG_URL", "http://127.0.0.1:1/books/")
                .addEnvVar("POSTGRES_URL", "jdbc:postgresql://127.0.0.1:59999/library?connectTimeout=1")
                .addEnvVar("MYSQL_URL", "jdbc:mysql://127.0.0.1:59998/library?connectTimeout=1")
                .build();
        var mapper = new JacksonMcpJsonMapper(new JsonMapper());
        var transport = new StdioClientTransport(parameters, mapper);
        client = McpClient.sync(transport)
                .clientInfo(new Implementation("biblioteca-mcp-integration-test", "1.0.0"))
                .requestTimeout(Duration.ofSeconds(20))
                .initializationTimeout(Duration.ofSeconds(20))
                .build();
        client.initialize();
    }

    @AfterEach
    void stopServerAndDeleteTemporaryData() throws IOException {
        if (client != null) client.close();
        if (dataDir != null && Files.exists(dataDir)) {
            try (var paths = Files.walk(dataDir)) {
                paths.sorted(java.util.Comparator.reverseOrder()).forEach(path -> {
                    try { Files.deleteIfExists(path); }
                    catch (IOException exception) {
                        throw new IllegalStateException("Nao foi possivel remover o dado temporario " + path, exception);
                    }
                });
            }
        }
    }
}
