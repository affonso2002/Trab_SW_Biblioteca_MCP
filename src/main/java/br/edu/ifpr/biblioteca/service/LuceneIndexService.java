/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.service` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.service;

/*
 * O que faz: Importa a classe IOException da biblioteca `java.io`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.io.IOException`; o ponto final do pacote identifica a classe importada.
 */
import java.io.IOException;
/*
 * O que faz: Importa a classe Path da biblioteca `java.nio.file`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.nio.file.Path`; o ponto final do pacote identifica a classe importada.
 */
import java.nio.file.Path;
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
 * O que faz: Importa a classe StandardAnalyzer da biblioteca `org.apache.lucene.analysis.standard`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.analysis.standard.StandardAnalyzer`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.analysis.standard.StandardAnalyzer;
/*
 * O que faz: Importa a classe Document da biblioteca `org.apache.lucene.document`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.document.Document`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.document.Document;
/*
 * O que faz: Importa a classe StringField da biblioteca `org.apache.lucene.document`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.document.StringField`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.document.StringField;
/*
 * O que faz: Importa a classe TextField da biblioteca `org.apache.lucene.document`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.document.TextField`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.document.TextField;
/*
 * O que faz: Importa a classe StoredField da biblioteca `org.apache.lucene.document`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.document.StoredField`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.document.StoredField;
/*
 * O que faz: Importa a classe DirectoryReader da biblioteca `org.apache.lucene.index`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.index.DirectoryReader`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.index.DirectoryReader;
/*
 * O que faz: Importa a classe IndexWriter da biblioteca `org.apache.lucene.index`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.index.IndexWriter`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.index.IndexWriter;
/*
 * O que faz: Importa a classe IndexWriterConfig da biblioteca `org.apache.lucene.index`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.index.IndexWriterConfig`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.index.IndexWriterConfig;
/*
 * O que faz: Importa a classe Term da biblioteca `org.apache.lucene.index`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.index.Term`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.index.Term;
/*
 * O que faz: Importa a classe QueryParser da biblioteca `org.apache.lucene.queryparser.classic`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.queryparser.classic.QueryParser`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.queryparser.classic.QueryParser;
/*
 * O que faz: Importa a classe IndexSearcher da biblioteca `org.apache.lucene.search`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.search.IndexSearcher`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
/*
 * O que faz: Importa a classe Query da biblioteca `org.apache.lucene.search`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.search.Query`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.search.Query;
/*
 * O que faz: Importa a classe ScoreDoc da biblioteca `org.apache.lucene.search`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.search.ScoreDoc`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.search.ScoreDoc;
/*
 * O que faz: Importa a classe TopDocs da biblioteca `org.apache.lucene.search`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.search.TopDocs`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.search.TopDocs;
/*
 * O que faz: Importa a classe FSDirectory da biblioteca `org.apache.lucene.store`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.lucene.store.FSDirectory`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.lucene.store.FSDirectory;

/*
 * O que faz: Importa a classe FileStorage da biblioteca `br.edu.ifpr.biblioteca.config`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.config.FileStorage`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.config.FileStorage;
/*
 * O que faz: Importa a classe Book da biblioteca `br.edu.ifpr.biblioteca.model`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.model.Book`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.model.Book;
/*
 * O que faz: Importa a classe SearchResult da biblioteca `br.edu.ifpr.biblioteca.model`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.model.SearchResult`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.model.SearchResult;


/*
 * O que faz: Declara a classe `LuceneIndexService`, que cria e consulta o indice local do Apache Lucene.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class LuceneIndexService {
    /*
     * O que faz: Declara o atributo `indexPath` do tipo `Path` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `Path` define o tipo de dado; `indexPath` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final Path indexPath;
    /*
     * O que faz: Declara o atributo `analyzer` do tipo `StandardAnalyzer` com visibilidade `private`. Ela comeca com new StandardAnalyzer().
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `StandardAnalyzer` define o tipo de dado; `analyzer` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final StandardAnalyzer analyzer = new StandardAnalyzer();
    /*
     * O que faz: Declara o construtor de `LuceneIndexService` e recebe `FileStorage storage){ this.indexPath=storage.lucene(`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `LuceneIndexService` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public LuceneIndexService(FileStorage storage){ this.indexPath=storage.lucene(); }
    /*
     * O que faz: Declara o metodo `index`; ele recebe `Book book` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `index` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void index(Book book) throws Exception {
        /*
         * O que faz: Inicia uma regiao de codigo em que erros de execucao podem ser capturados.
         * Por que esta aqui: garantir tratamento previsivel de falhas e, quando aplicavel, fechamento automatico de recursos.
         * Componentes: `try` delimita a operacao protegida; a forma com recursos entre parenteses tambem pede fechamento automatico ao terminar.
         */
        try(var directory=FSDirectory.open(indexPath); var writer=new IndexWriter(directory,new IndexWriterConfig(analyzer))){
            /*
             * O que faz: Cria um documento Lucene que representa um livro dentro do indice.
             * Por que esta aqui: organizar os dados pesquisaveis e os dados que precisam ser devolvidos como campos do mesmo registro de busca.
             * Componentes: `Document` e o conteiner de campos como id, titulo, autor e texto.
             */
            Document doc=new Document();
            /*
             * O que faz: Executa a instrucao `doc.add(new StringField("id",Long.toString(book.gutenbergId()),StringField.Store.YES))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new StringField("id",Long.toString(book.gutenbergId()),StringField.Store.YES));
            /*
             * O que faz: Executa a instrucao `doc.add(new TextField("title",book.title(),TextField.Store.YES))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new TextField("title",book.title(),TextField.Store.YES));
            /*
             * O que faz: Executa a instrucao `doc.add(new TextField("author",String.join(" ",book.authors()),TextField.Store.YES))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new TextField("author",String.join(" ",book.authors()),TextField.Store.YES));
            /*
             * O que faz: Executa a instrucao `doc.add(new TextField("subjects",String.join(" ",book.subjects()),TextField.Store.YES))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new TextField("subjects",String.join(" ",book.subjects()),TextField.Store.YES));
            /*
             * O que faz: Executa a instrucao `doc.add(new TextField("text",book.content(),TextField.Store.NO))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new TextField("text",book.content(),TextField.Store.NO));
            /*
             * O que faz: Executa a instrucao `doc.add(new StoredField("uri",book.textUri()))`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            doc.add(new StoredField("uri",book.textUri()));
            /*
             * O que faz: Executa a instrucao `writer.updateDocument(new Term("id",Long.toString(book.gutenbergId())),doc)`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            writer.updateDocument(new Term("id",Long.toString(book.gutenbergId())),doc);
            /*
             * O que faz: Executa a instrucao `writer.commit()`.
             * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
             * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
             */
            writer.commit();
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
     * O que faz: Declara o metodo `search`; ele recebe `String queryText,int page,int pageSize` e produz o tipo `List<SearchResult>`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `List<SearchResult>` e o retorno; `search` identifica a operacao; os parametros ficam entre parenteses.
     */
    public List<SearchResult> search(String queryText, int page, int pageSize) throws Exception {
        int safePage = Math.max(0, page);
        int safeSize = Math.max(1, Math.min(pageSize, 50));

        try (var directory = FSDirectory.open(indexPath)) {
            if (!DirectoryReader.indexExists(directory)) return List.of();

            try (var reader = DirectoryReader.open(directory)) {
                IndexSearcher searcher = new IndexSearcher(reader);
                Query query;
                if (queryText == null || queryText.isBlank()) {
                    query = new MatchAllDocsQuery();
                } else {
                    QueryParser parser = new QueryParser("text", analyzer);
                    parser.setDefaultOperator(QueryParser.Operator.OR);
                    query = parser.parse(queryText);
                }

                // Keep pagination predictable and avoid collecting an unbounded number of hits.
                long requestedHits = Math.min(((long) safePage + 1L) * safeSize, 10_000L);
                TopDocs hits = searcher.search(query, (int) requestedHits);
                int from = (int) Math.min((long) safePage * safeSize, hits.scoreDocs.length);
                int to = Math.min(from + safeSize, hits.scoreDocs.length);
                List<SearchResult> results = new ArrayList<>();
                for (int i = from; i < to; i++) {
                    ScoreDoc scoreDoc = hits.scoreDocs[i];
                    Document document = searcher.storedFields().document(scoreDoc.doc);
                    results.add(new SearchResult(document.get("id"), document.get("title"),
                            document.get("author"), scoreDoc.score, "lucene"));
                }
                return results;
            }
        }
    }
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
