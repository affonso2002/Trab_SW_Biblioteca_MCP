package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.model.Book;
import br.edu.ifpr.biblioteca.service.GutenbergService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GutenbergServiceTest {
    private ServerSocket server;
    private Thread serverThread;
    private volatile int responseStatus;
    private volatile String responseBody;
    private final AtomicReference<String> requestLine = new AtomicReference<>();
    private final AtomicReference<IOException> serverFailure = new AtomicReference<>();
    private GutenbergService service;

    @BeforeEach
    void startHttpFixture() throws IOException {
        server = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"));
        responseStatus = 200;
        responseBody = "{\"results\":[]}";
        AppProperties properties = new AppProperties();
        properties.setGutenbergUrl("http://127.0.0.1:" + server.getLocalPort() + "/books/");
        service = new GutenbergService(properties);
        serverThread = new Thread(this::serveOneRequest, "gutenberg-service-test-http");
        serverThread.setDaemon(true);
        serverThread.start();
    }

    @AfterEach
    void stopHttpFixture() throws Exception {
        if (server != null && !server.isClosed()) {
            server.close();
        }
        if (serverThread != null) {
            serverThread.join(1000);
        }
    }

    @Test
    void mapsApiResultsAndRespectsRequestedLimit() throws Exception {
        responseBody = "{\"results\":["
                + "{\"id\":123,\"title\":\"Livro A\",\"authors\":[{\"name\":\"Ana\"}],"
                + "\"subjects\":[\"Literatura\"],\"languages\":[\"pt\"],\"formats\":{}},"
                + "{\"id\":456,\"title\":\"Livro B\",\"authors\":[],\"subjects\":[],"
                + "\"languages\":[\"en\"],\"formats\":{}}]}";

        List<Book> books = service.search("arte literatura", 1);

        assertEquals(1, books.size());
        assertEquals(123L, books.getFirst().gutenbergId());
        assertEquals("Livro A", books.getFirst().title());
        assertEquals(List.of("Ana"), books.getFirst().authors());
        assertEquals(List.of("Literatura"), books.getFirst().subjects());
        assertEquals("pt", books.getFirst().language());
        assertEquals("/books/?search=arte+literatura&page=1 HTTP/1.1", requestLine.get().substring(requestLine.get().indexOf(" /") + 1));
        assertNull(serverFailure.get());
    }

    @Test
    void returnsEmptyListWhenApiHasNoResults() throws Exception {
        responseBody = "{\"results\":[]}";

        assertTrue(service.search("sem resultados", 5).isEmpty());
        assertNull(serverFailure.get());
    }

    @Test
    void reportsNonSuccessfulHttpStatus() {
        responseStatus = 503;
        responseBody = "{\"detail\":\"indisponivel\"}";

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> service.search("consulta", 3));

        assertTrue(exception.getMessage().contains("HTTP 503"));
    }

    private void serveOneRequest() {
        try (Socket socket = server.accept()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.US_ASCII));
            requestLine.set(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                // Consome os cabecalhos antes de enviar a resposta HTTP.
            }

            byte[] body = responseBody.getBytes(StandardCharsets.UTF_8);
            String reason = responseStatus == 200 ? "OK" : "Service Unavailable";
            String headers = "HTTP/1.1 " + responseStatus + " " + reason + "\r\n"
                    + "Content-Type: application/json; charset=utf-8\r\n"
                    + "Content-Length: " + body.length + "\r\n"
                    + "Connection: close\r\n\r\n";
            OutputStream output = socket.getOutputStream();
            output.write(headers.getBytes(StandardCharsets.US_ASCII));
            output.write(body);
            output.flush();
        } catch (IOException exception) {
            serverFailure.set(exception);
        }
    }
}
