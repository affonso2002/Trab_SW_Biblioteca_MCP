package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.config.FileStorage;
import br.edu.ifpr.biblioteca.service.PdfMetadataService;
import java.nio.file.Path;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class PdfMetadataServiceTest {
    @TempDir Path tempDir;

    @Test void extraiMetadadosDePdfValido() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        Path pdfPath = storage.input().resolve("metadados.pdf");
        try (PDDocument document = new PDDocument()) {
            document.addPage(new PDPage());
            document.getDocumentInformation().setTitle("Documento de teste");
            document.getDocumentInformation().setAuthor("Equipe de teste");
            document.save(pdfPath.toFile());
        }
        String result = new PdfMetadataService(storage).extract("metadados.pdf");
        assertAll(
            () -> assertTrue(result.contains("Documento de teste")),
            () -> assertTrue(result.contains("Equipe de teste")),
            () -> assertTrue(result.contains("Paginas: 1"))
        );
    }

    @Test void falhaQuandoPdfNaoExiste() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertThrows(Exception.class, () -> new PdfMetadataService(storage).extract("inexistente.pdf"));
    }

    @Test void bloqueiaCaminhoForaDaEntrada() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertThrows(IllegalArgumentException.class, () -> new PdfMetadataService(storage).extract("../secreto.pdf"));
    }
}
