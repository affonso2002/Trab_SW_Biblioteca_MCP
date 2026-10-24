package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.config.FileStorage;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileStorageTest {
    @TempDir Path tempDir;

    @Test void criaEstruturaDeDiretorios() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.resolve("dados").toString());
        FileStorage storage = new FileStorage(properties);
        assertAll(
            () -> assertTrue(Files.isDirectory(storage.documents())),
            () -> assertTrue(Files.isDirectory(storage.input())),
            () -> assertTrue(Files.isDirectory(storage.processed())),
            () -> assertTrue(Files.isDirectory(storage.lucene()))
        );
    }

    @Test void permiteArquivoNaPastaEsperada() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertEquals(storage.input().resolve("exemplo.pdf"), storage.safeInput("exemplo.pdf"));
    }

    @Test void bloqueiaTentativasDeSairDaPastaBase() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> storage.safeInput("../segredo.txt")),
            () -> assertThrows(IllegalArgumentException.class, () -> storage.safeProcessed("../../segredo.csv")),
            () -> assertThrows(IllegalArgumentException.class, () -> storage.safeInput(tempDir.getRoot().resolve("fora.txt").toString()))
        );
    }

    @Test void rejeitaNomeNulo() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertThrows(NullPointerException.class, () -> storage.safeInput(null));
    }
}
