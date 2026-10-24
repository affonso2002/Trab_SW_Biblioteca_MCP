package br.edu.ifpr.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.ifpr.biblioteca.config.AppProperties;
import br.edu.ifpr.biblioteca.model.Book;
import br.edu.ifpr.biblioteca.service.LibraryRepository;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryRepositoryTest {
    private LibraryRepository repository;

    @BeforeEach
    void configureUnavailableDatabase() {
        repository = repositoryFor("jdbc:postgresql://127.0.0.1:1/library?connectTimeout=1");
    }

    @Test
    void reportsUnavailableDatabaseWhenInitializingSchema() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, repository::initialize);
        assertTrue(exception.getMessage().contains("PostgreSQL indisponivel"));
        assertInstanceOf(SQLException.class, exception.getCause());
    }

    @Test
    void propagatesDatabaseFailureWhenSavingBook() {
        Book book = new Book(1L, "Livro de teste", List.of(), List.of(), "pt", "", "texto");
        assertThrows(SQLException.class, () -> repository.save(book, "1.txt"));
    }

    @Test
    void propagatesDatabaseFailureWhenCountingBooks() {
        assertThrows(SQLException.class, repository::count);
    }

    @Test
    void propagatesDatabaseFailureWhenListingRecentTitles() {
        assertThrows(SQLException.class, () -> repository.recentTitles(5));
    }

    @Test
    void createsSchemaWhenDatabaseIsAvailable() throws Exception {
        try (StubDriver driver = new StubDriver()) {
            repository = repositoryFor("jdbc:repository-test:library");

            repository.initialize();

            assertTrue(driver.lastSql.contains("CREATE TABLE IF NOT EXISTS library_document"));
            assertTrue(driver.statementExecuted);
        }
    }

    @Test
    void savesBookFieldsAndContentPath() throws Exception {
        try (StubDriver driver = new StubDriver()) {
            repository = repositoryFor("jdbc:repository-test:library");
            Book book = new Book(42L, "Livro de teste", List.of("Autora A", "Autor B"),
                    List.of("Ficcao", "Historia"), "pt", "https://example.test/42.txt", "texto");

            repository.save(book, "documents/42.txt");

            assertTrue(driver.lastSql.contains("INSERT INTO library_document"));
            assertEquals(1, driver.updateCount);
            assertEquals(42L, driver.lastParameters.get(1));
            assertEquals("Livro de teste", driver.lastParameters.get(2));
            assertEquals("Autora A, Autor B", driver.lastParameters.get(3));
            assertEquals("Ficcao, Historia", driver.lastParameters.get(4));
            assertEquals("documents/42.txt", driver.lastParameters.get(7));
        }
    }

    @Test
    void returnsBookCountFromDatabase() throws Exception {
        try (StubDriver ignored = new StubDriver()) {
            repository = repositoryFor("jdbc:repository-test:library");
            assertEquals(7L, repository.count());
        }
    }

    @Test
    void returnsRecentTitlesInDatabaseOrder() throws Exception {
        try (StubDriver driver = new StubDriver()) {
            repository = repositoryFor("jdbc:repository-test:library");

            assertEquals(List.of("Titulo recente", "Titulo anterior"), repository.recentTitles(2));
            assertTrue(driver.lastSql.contains("ORDER BY id DESC LIMIT ?"));
            assertEquals(2, driver.lastParameters.get(1));
        }
    }

    private LibraryRepository repositoryFor(String url) {
        AppProperties properties = new AppProperties();
        properties.setPostgresUrl(url);
        properties.setPostgresUser("library-test");
        properties.setPostgresPassword("library-test");
        return new LibraryRepository(properties);
    }

    private static final class StubDriver implements Driver, AutoCloseable {
        private static final String URL_PREFIX = "jdbc:repository-test:";
        private String lastSql = "";
        private Map<Integer, Object> lastParameters = Map.of();
        private boolean statementExecuted;
        private int updateCount;

        private StubDriver() throws SQLException {
            DriverManager.registerDriver(this);
        }

        @Override
        public Connection connect(String url, Properties info) throws SQLException {
            if (!acceptsURL(url)) return null;
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
                    new Class<?>[]{Connection.class}, (proxy, method, args) -> {
                        if (method.getName().equals("prepareStatement")) {
                            return preparedStatement((String) args[0]);
                        }
                        if (method.getName().equals("close")) return null;
                        if (method.getName().equals("isClosed")) return false;
                        return defaultValue(method.getReturnType());
                    });
        }

        private PreparedStatement preparedStatement(String sql) {
            Map<Integer, Object> parameters = new HashMap<>();
            return (PreparedStatement) Proxy.newProxyInstance(PreparedStatement.class.getClassLoader(),
                    new Class<?>[]{PreparedStatement.class}, (proxy, method, args) -> {
                        String name = method.getName();
                        if (name.startsWith("set") && args != null && args.length >= 2
                                && args[0] instanceof Integer index) {
                            parameters.put(index, args[1]);
                            return null;
                        }
                        if (name.equals("execute")) {
                            record(sql, parameters);
                            statementExecuted = true;
                            return true;
                        }
                        if (name.equals("executeUpdate")) {
                            record(sql, parameters);
                            updateCount = 1;
                            return updateCount;
                        }
                        if (name.equals("executeQuery")) {
                            record(sql, parameters);
                            return resultSet(sql);
                        }
                        if (name.equals("close")) return null;
                        if (name.equals("isClosed")) return false;
                        return defaultValue(method.getReturnType());
                    });
        }

        private void record(String sql, Map<Integer, Object> parameters) {
            lastSql = sql;
            lastParameters = Map.copyOf(parameters);
        }

        private ResultSet resultSet(String sql) {
            List<Object> values = sql.contains("COUNT(*)")
                    ? List.of(7L)
                    : List.of("Titulo recente", "Titulo anterior");
            int[] position = {-1};
            return (ResultSet) Proxy.newProxyInstance(ResultSet.class.getClassLoader(),
                    new Class<?>[]{ResultSet.class}, (proxy, method, args) -> {
                        return switch (method.getName()) {
                            case "next" -> ++position[0] < values.size();
                            case "getLong" -> ((Number) values.get(position[0])).longValue();
                            case "getString" -> String.valueOf(values.get(position[0]));
                            case "close" -> null;
                            case "isClosed" -> false;
                            default -> defaultValue(method.getReturnType());
                        };
                    });
        }

        private Object defaultValue(Class<?> type) {
            if (type == boolean.class) return false;
            if (type == byte.class) return (byte) 0;
            if (type == short.class) return (short) 0;
            if (type == int.class) return 0;
            if (type == long.class) return 0L;
            if (type == float.class) return 0F;
            if (type == double.class) return 0D;
            if (type == char.class) return '\0';
            return null;
        }

        @Override public boolean acceptsURL(String url) { return url != null && url.startsWith(URL_PREFIX); }
        @Override public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) { return new DriverPropertyInfo[0]; }
        @Override public int getMajorVersion() { return 1; }
        @Override public int getMinorVersion() { return 0; }
        @Override public boolean jdbcCompliant() { return false; }
        @Override public Logger getParentLogger() { return Logger.getLogger("LibraryRepositoryTest"); }
        @Override public void close() throws SQLException { DriverManager.deregisterDriver(this); }
    }
}
