/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.service` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.service;

/*
 * O que faz: Importa a classe Connection da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.Connection`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.Connection;
/*
 * O que faz: Importa a classe DriverManager da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.DriverManager`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.DriverManager;
/*
 * O que faz: Importa a classe PreparedStatement da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.PreparedStatement`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.PreparedStatement;
/*
 * O que faz: Importa a classe ResultSet da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.ResultSet`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.ResultSet;
/*
 * O que faz: Importa a classe SQLException da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.SQLException`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.SQLException;
/*
 * O que faz: Importa a classe ArrayList da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.ArrayList`; o ponto final do pacote identifica a classe importada.
 */
import java.util.ArrayList;
/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;

/*
 * O que faz: Importa a classe AppProperties da biblioteca `br.edu.ifpr.biblioteca.config`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.config.AppProperties`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.config.AppProperties;
/*
 * O que faz: Importa a classe Book da biblioteca `br.edu.ifpr.biblioteca.model`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.model.Book`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.model.Book;


/*
 * O que faz: Declara a classe `LibraryRepository`, que persiste e consulta metadados dos livros no PostgreSQL.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class LibraryRepository {
    /*
     * O que faz: Declara o atributo `p` do tipo `AppProperties` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `AppProperties` define o tipo de dado; `p` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final AppProperties p;
    /*
     * O que faz: Declara o construtor de `LibraryRepository` e recebe `AppProperties p`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `LibraryRepository` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public LibraryRepository(AppProperties p){this.p=p;}
    /*
     * O que faz: Declara o metodo `initialize`; ele recebe `` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `initialize` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void initialize(){
        /*
         * O que faz: Atribui a expressao `String sql` o valor `"CREATE TABLE IF NOT EXISTS library_document (id BIGSERIAL PRIMARY KEY, gutenberg_id BIGINT UNIQUE NOT NULL, title TEXT NOT NULL, authors TEXT, subjects TEXT, language VARCHAR(16), text_uri TEXT, content_path TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        String sql="CREATE TABLE IF NOT EXISTS library_document (id BIGSERIAL PRIMARY KEY, gutenberg_id BIGINT UNIQUE NOT NULL, title TEXT NOT NULL, authors TEXT, subjects TEXT, language VARCHAR(16), text_uri TEXT, content_path TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        /*
         * O que faz: Inicia uma regiao de codigo em que erros de execucao podem ser capturados.
         * Por que esta aqui: garantir tratamento previsivel de falhas e, quando aplicavel, fechamento automatico de recursos.
         * Componentes: `try` delimita a operacao protegida; a forma com recursos entre parenteses tambem pede fechamento automatico ao terminar.
         */
        try(Connection c=DriverManager.getConnection(p.getPostgresUrl(),p.getPostgresUser(),p.getPostgresPassword()); PreparedStatement s=c.prepareStatement(sql)){s.execute();}catch(SQLException e){ throw new IllegalStateException("PostgreSQL indisponivel: "+e.getMessage(),e); }
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `save`; ele recebe `Book b,String contentPath` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `save` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void save(Book b,String contentPath) throws SQLException{
        /*
         * O que faz: Atribui a expressao `String sql` o valor `"INSERT INTO library_document(gutenberg_id,title,authors,subjects,language,text_uri,content_path) VALUES(?,?,?,?,?,?,?) ON CONFLICT(gutenberg_id) DO UPDATE SET title=EXCLUDED.title, authors=EXCLUDED.authors, subjects=EXCLUDED.subjects, language=EXCLUDED.language, text_uri=EXCLUDED.text_uri, content_path=EXCLUDED.content_path, updated_at=CURRENT_TIMESTAMP"`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        String sql="INSERT INTO library_document(gutenberg_id,title,authors,subjects,language,text_uri,content_path) VALUES(?,?,?,?,?,?,?) ON CONFLICT(gutenberg_id) DO UPDATE SET title=EXCLUDED.title, authors=EXCLUDED.authors, subjects=EXCLUDED.subjects, language=EXCLUDED.language, text_uri=EXCLUDED.text_uri, content_path=EXCLUDED.content_path, updated_at=CURRENT_TIMESTAMP";
        /*
         * O que faz: Inicia uma regiao de codigo em que erros de execucao podem ser capturados.
         * Por que esta aqui: garantir tratamento previsivel de falhas e, quando aplicavel, fechamento automatico de recursos.
         * Componentes: `try` delimita a operacao protegida; a forma com recursos entre parenteses tambem pede fechamento automatico ao terminar.
         */
        try(Connection c=DriverManager.getConnection(p.getPostgresUrl(),p.getPostgresUser(),p.getPostgresPassword()); PreparedStatement s=c.prepareStatement(sql)){
            /*
             * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
             * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
             * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
             */
            s.setLong(1,b.gutenbergId()); s.setString(2,b.title()); s.setString(3,String.join(", ",b.authors())); s.setString(4,String.join(", ",b.subjects())); s.setString(5,b.language()); s.setString(6,b.textUri()); s.setString(7,contentPath); s.executeUpdate();
        /*
         * O que faz: Fecha o bloco de codigo aberto anteriormente.
         * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
         * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
         */
        }
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `count`; ele recebe `` e produz o tipo `long`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `long` e o retorno; `count` identifica a operacao; os parametros ficam entre parenteses.
     */
    public long count() throws SQLException{
        /*
         * O que faz: Inicia uma regiao de codigo em que erros de execucao podem ser capturados.
         * Por que esta aqui: garantir tratamento previsivel de falhas e, quando aplicavel, fechamento automatico de recursos.
         * Componentes: `try` delimita a operacao protegida; a forma com recursos entre parenteses tambem pede fechamento automatico ao terminar.
         */
        try(Connection c=DriverManager.getConnection(p.getPostgresUrl(),p.getPostgresUser(),p.getPostgresPassword()); PreparedStatement s=c.prepareStatement("SELECT COUNT(*) FROM library_document"); ResultSet r=s.executeQuery()){r.next(); return r.getLong(1);}
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `recentTitles`; ele recebe `int limit` e produz o tipo `List<String>`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `List<String>` e o retorno; `recentTitles` identifica a operacao; os parametros ficam entre parenteses.
     */
    public List<String> recentTitles(int limit) throws SQLException{
        /*
         * O que faz: Inicia uma regiao de codigo em que erros de execucao podem ser capturados.
         * Por que esta aqui: garantir tratamento previsivel de falhas e, quando aplicavel, fechamento automatico de recursos.
         * Componentes: `try` delimita a operacao protegida; a forma com recursos entre parenteses tambem pede fechamento automatico ao terminar.
         */
        try(Connection c=DriverManager.getConnection(p.getPostgresUrl(),p.getPostgresUser(),p.getPostgresPassword()); PreparedStatement s=c.prepareStatement("SELECT title FROM library_document ORDER BY id DESC LIMIT ?")){s.setInt(1,limit); try(ResultSet r=s.executeQuery()){List<String> out=new ArrayList<>(); while(r.next())out.add(r.getString(1)); return out;}}
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
