package br.edu.ifpr.biblioteca.config;

/** Configuracoes lidas de propriedades JVM ou variaveis de ambiente. */
public final class AppProperties {
    private String dataDir = value("APP_DATA_DIR", "data");
    private String gutenbergUrl = value("GUTENBERG_URL", "https://gutendex.com/books/");
    private String solrUrl = value("SOLR_URL", "http://localhost:8983/solr/gutenberg");
    private String postgresUrl = value("POSTGRES_URL", "jdbc:postgresql://localhost:5432/library");
    private String postgresUser = value("POSTGRES_USER", "library");
    private String postgresPassword = value("POSTGRES_PASSWORD", "library");
    private String mysqlUrl = value("MYSQL_URL", "jdbc:mysql://localhost:3306/library");
    private String mysqlUser = value("MYSQL_USER", "library");
    private String mysqlPassword = value("MYSQL_PASSWORD", "library");
    private boolean solrEnabled = Boolean.parseBoolean(value("SOLR_ENABLED", "false"));

    private static String value(String name, String fallback) {
        String systemValue = System.getProperty(name);
        if (systemValue != null && !systemValue.isBlank()) return systemValue.trim();
        String envValue = System.getenv(name);
        return envValue == null || envValue.isBlank() ? fallback : envValue.trim();
    }

    public String getDataDir() { return dataDir; }
    public void setDataDir(String value) { dataDir = required(value, "APP_DATA_DIR"); }
    public String getGutenbergUrl() { return gutenbergUrl; }
    public void setGutenbergUrl(String value) { gutenbergUrl = required(value, "GUTENBERG_URL"); }
    public String getSolrUrl() { return solrUrl; }
    public void setSolrUrl(String value) { solrUrl = required(value, "SOLR_URL"); }
    public String getPostgresUrl() { return postgresUrl; }
    public void setPostgresUrl(String value) { postgresUrl = required(value, "POSTGRES_URL"); }
    public String getPostgresUser() { return postgresUser; }
    public void setPostgresUser(String value) { postgresUser = required(value, "POSTGRES_USER"); }
    public String getPostgresPassword() { return postgresPassword; }
    public void setPostgresPassword(String value) { postgresPassword = value == null ? "" : value; }
    public String getMysqlUrl() { return mysqlUrl; }
    public void setMysqlUrl(String value) { mysqlUrl = required(value, "MYSQL_URL"); }
    public String getMysqlUser() { return mysqlUser; }
    public void setMysqlUser(String value) { mysqlUser = required(value, "MYSQL_USER"); }
    public String getMysqlPassword() { return mysqlPassword; }
    public void setMysqlPassword(String value) { mysqlPassword = value == null ? "" : value; }
    public boolean isSolrEnabled() { return solrEnabled; }
    public void setSolrEnabled(boolean value) { solrEnabled = value; }

    private static String required(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " nao pode ser vazio.");
        }
        return value.trim();
    }
}
