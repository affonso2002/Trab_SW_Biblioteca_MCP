package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import org.junit.jupiter.api.Test;

class AppPropertiesTest {
    @Test void disponibilizaValoresPadraoValidos() {
        AppProperties properties = new AppProperties();
        assertEquals("data", properties.getDataDir());
        assertTrue(properties.getGutenbergUrl().startsWith("https://"));
        assertTrue(properties.getPostgresUrl().startsWith("jdbc:postgresql:"));
        assertTrue(properties.getMysqlUrl().startsWith("jdbc:mysql:"));
        assertFalse(properties.isSolrEnabled());
    }

    @Test void permiteDesativarSolrParaExecucaoLocal() {
        AppProperties properties = new AppProperties();
        properties.setSolrEnabled(false);
        assertFalse(properties.isSolrEnabled());
        properties.setSolrEnabled(true);
        assertTrue(properties.isSolrEnabled());
    }

    @Test void rejeitaConfiguracoesObrigatoriasVazias() {
        AppProperties properties = new AppProperties();
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> properties.setDataDir(" ")),
            () -> assertThrows(IllegalArgumentException.class, () -> properties.setPostgresUrl("")),
            () -> assertThrows(IllegalArgumentException.class, () -> properties.setMysqlUser(null))
        );
    }

    @Test void aceitaSenhasVaziasSeOAmbienteExigir() {
        AppProperties properties = new AppProperties();
        properties.setMysqlPassword(null);
        properties.setPostgresPassword("");
        assertEquals("", properties.getMysqlPassword());
        assertEquals("", properties.getPostgresPassword());
    }
}
