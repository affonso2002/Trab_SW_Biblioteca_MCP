package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.edu.ifpr.biblioteca.service.DatabaseMetadataService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Verifica a formatação dos metadados sem exigir um PostgreSQL ou MySQL real. */
class DatabaseMetadataServiceTest {

    /** Confirma que o resumo inclui as tabelas e as colunas recebidas pelo JDBC. */
    @Test
    void describeListaTabelasEColunas() {
        String result = new StubMetadataService(true).describe();

        assertTrue(result.contains("public.library_document"));
        assertTrue(result.contains("gutenberg_id | tipo=bigint | nulo=NO"));
        assertTrue(result.contains("title | tipo=varchar | nulo=NO"));
    }

    /** Garante que uma base sem tabelas seja reportada explicitamente, em vez de deixar a seção vazia. */
    @Test
    void describeInformaQuandoNaoHaTabelas() {
        String result = new StubMetadataService(false).describe();

        assertTrue(result.contains("Nenhuma tabela encontrada para esta conexão."));
    }

    /** Substitui somente a conexão JDBC e seus resultados para manter os testes isolados. */
    private static final class StubMetadataService extends DatabaseMetadataService {
        private final boolean includeTable;

        private StubMetadataService(boolean includeTable) {
            this.includeTable = includeTable;
        }

        @Override
        public String name() {
            return "PostgreSQL";
        }

        @Override
        protected Connection connect() {
            DatabaseMetaData metadata = proxy(DatabaseMetaData.class, (proxy, method, args) -> switch (method.getName()) {
                case "getDatabaseProductName" -> "PostgreSQL";
                case "getDatabaseProductVersion" -> "17.test";
                case "getURL" -> "jdbc:postgresql://localhost:5432/library";
                case "getTables" -> resultSet(includeTable ? List.of(Map.of(
                        "TABLE_CAT", "library",
                        "TABLE_SCHEM", "public",
                        "TABLE_NAME", "library_document",
                        "TABLE_TYPE", "TABLE")) : List.of());
                case "getColumns" -> resultSet(List.of(
                        Map.of("COLUMN_NAME", "gutenberg_id", "TYPE_NAME", "bigint", "IS_NULLABLE", "NO"),
                        Map.of("COLUMN_NAME", "title", "TYPE_NAME", "varchar", "IS_NULLABLE", "NO")));
                default -> defaultValue(method.getReturnType());
            });

            return proxy(Connection.class, (proxy, method, args) -> switch (method.getName()) {
                case "getMetaData" -> metadata;
                case "close" -> null;
                default -> defaultValue(method.getReturnType());
            });
        }
    }

    /** Cria um ResultSet mínimo para simular as linhas produzidas pelo JDBC. */
    private static ResultSet resultSet(List<Map<String, String>> rows) {
        int[] cursor = {-1};
        return proxy(ResultSet.class, (proxy, method, args) -> switch (method.getName()) {
            case "next" -> ++cursor[0] < rows.size();
            case "getString" -> rows.get(cursor[0]).get(String.valueOf(args[0]));
            case "close" -> null;
            case "wasNull" -> false;
            default -> defaultValue(method.getReturnType());
        });
    }

    /** Monta um proxy para as interfaces JDBC, respondendo apenas aos métodos usados pelo serviço. */
    @SuppressWarnings("unchecked")
    private static <T> T proxy(Class<T> type, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, handler);
    }

    /** Devolve valores neutros para métodos JDBC não utilizados diretamente pelo cenário simulado. */
    private static Object defaultValue(Class<?> type) {
        if (!type.isPrimitive()) return null;
        if (type == boolean.class) return false;
        if (type == char.class) return '\0';
        if (type == byte.class) return (byte) 0;
        if (type == short.class) return (short) 0;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0F;
        if (type == double.class) return 0D;
        return null;
    }
}
