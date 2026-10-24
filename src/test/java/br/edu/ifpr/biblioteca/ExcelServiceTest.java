package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.config.FileStorage;
import br.edu.ifpr.biblioteca.service.ExcelService;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ExcelServiceTest {
    @TempDir Path tempDir;

    @Test void convertePlanilhaParaCsvUtf8EscapandoCampos() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        Path workbookPath = storage.input().resolve("livros.xlsx");
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            var sheet = workbook.createSheet("Catalogo");
            var header = sheet.createRow(0);
            header.createCell(0).setCellValue("Titulo");
            header.createCell(1).setCellValue("Autor");
            var row = sheet.createRow(1);
            row.createCell(0).setCellValue("Livro \"Especial\"");
            row.createCell(1).setCellValue("Ana");
            try (var output = Files.newOutputStream(workbookPath)) { workbook.write(output); }
        }
        String output = new ExcelService(storage).convertToCsv("livros.xlsx");
        String csv = Files.readString(Path.of(output), StandardCharsets.UTF_8);
        assertAll(
            () -> assertTrue(csv.contains("# PLANILHA: Catalogo")),
            () -> assertTrue(csv.contains("\"Titulo\";\"Autor\"")),
            () -> assertTrue(csv.contains("\"Livro \"\"Especial\"\"\";\"Ana\""))
        );
    }

    @Test void falhaQuandoPlanilhaNaoExiste() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertThrows(Exception.class, () -> new ExcelService(storage).convertToCsv("ausente.xlsx"));
    }

    @Test void bloqueiaCaminhoForaDaEntrada() throws Exception {
        AppProperties properties = new AppProperties();
        properties.setDataDir(tempDir.toString());
        FileStorage storage = new FileStorage(properties);
        assertThrows(IllegalArgumentException.class, () -> new ExcelService(storage).convertToCsv("../fora.xlsx"));
    }
}
