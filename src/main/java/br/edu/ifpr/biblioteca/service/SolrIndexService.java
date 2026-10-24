/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.service` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.service;

/*
 * O que faz: Importa a classe ArrayList da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.ArrayList`; o ponto final do pacote identifica a classe importada.
 */
import java.net.URI;
import java.util.ArrayList;
/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;
/*
 * O que faz: Importa a classe SolrClient da biblioteca `org.apache.solr.client.solrj`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.solr.client.solrj.SolrClient`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.solr.client.solrj.SolrClient;
/*
 * O que faz: Importa a classe SolrQuery da biblioteca `org.apache.solr.client.solrj`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.solr.client.solrj.request.SolrQuery`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.solr.client.solrj.request.SolrQuery;
/*
 * O que faz: Importa a classe HttpJdkSolrClient da biblioteca `org.apache.solr.client.solrj.impl`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.solr.client.solrj.impl.HttpJdkSolrClient`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.solr.client.solrj.impl.HttpJdkSolrClient;
/*
 * O que faz: Importa a classe QueryResponse da biblioteca `org.apache.solr.client.solrj.response`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.solr.client.solrj.response.QueryResponse`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.solr.client.solrj.response.QueryResponse;
/*
 * O que faz: Importa a classe SolrInputDocument da biblioteca `org.apache.solr.common`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.apache.solr.common.SolrInputDocument`; o ponto final do pacote identifica a classe importada.
 */
import org.apache.solr.common.SolrInputDocument;

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
 * O que faz: Importa a classe SearchResult da biblioteca `br.edu.ifpr.biblioteca.model`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.model.SearchResult`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.model.SearchResult;


/*
 * O que faz: Declara a classe `SolrIndexService`, que envia documentos para o Solr e executa buscas remotas com relevancia.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class SolrIndexService implements AutoCloseable {
    /*
     * O que faz: Declara o atributo `enabled` do tipo `boolean` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `boolean` define o tipo de dado; `enabled` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final boolean enabled;
    /*
     * O que faz: Declara o atributo `client` do tipo `SolrClient` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `SolrClient` define o tipo de dado; `client` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final SolrClient client;
    /*
     * O que faz: Declara o construtor de `SolrIndexService` e recebe `AppProperties properties`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `SolrIndexService` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public SolrIndexService(AppProperties properties){
        /*
         * O que faz: le da configuracao se a integracao com Solr esta habilitada.
         * Por que esta aqui: a aplicacao precisa decidir antes da criacao do cliente se deve se conectar a um servidor Solr.
         * Componentes: `properties` contem as configuracoes; `isSolrEnabled()` devolve o valor booleano; `=` armazena esse valor em `enabled`.
         */
        enabled = properties.isSolrEnabled();
        /*
         * O que faz: cria o cliente Solr somente quando a integracao esta habilitada.
         * Por que esta aqui: evita criar um cliente desnecessario quando o projeto estiver usando apenas o Lucene.
         * Componentes: `client` recebe o resultado; o operador ternario escolhe entre `createClient(...)` e `null`.
         */
        client = enabled ? createClient(properties.getSolrUrl()) : null;
    }

    /*
     * O que faz: cria um cliente Solr usando a URL configurada, tratando corretamente a mudanca de Solr 10 para URLs-raiz com colecao padrao.
     * Por que esta aqui: o Solr 10 deixou de aceitar com seguranca URLs especificas de colecao como base do cliente e recomenda `withDefaultCollection(...)`.
     * Componentes: `String url` recebe a configuracao; `URI` separa esquema, autoridade e caminho; `HttpJdkSolrClient.Builder` cria o cliente HTTP; `withDefaultCollection` define a colecao usada nas consultas e indexacoes.
     */
    private SolrClient createClient(String url) {
        /*
         * O que faz: converte a URL textual em um objeto URI.
         * Por que esta aqui: precisamos separar o caminho `/solr` do nome da colecao quando a configuracao contem ambos.
         * Componentes: `URI.create` valida e interpreta a URL; `url` e a string recebida da configuracao.
         */
        URI uri = URI.create(url);
        /*
         * O que faz: obtem o caminho da URL, por exemplo `/solr/gutenberg`.
         * Por que esta aqui: o caminho permite identificar se uma colecao foi colocada junto da URL raiz.
         * Componentes: `getPath()` retorna apenas a parte de caminho da URI.
         */
        String path = uri.getPath();
        /*
         * O que faz: procura a posicao em que comeca o caminho `/solr`.
         * Por que esta aqui: precisamos construir uma URL-raiz aceita pelo SolrJ 10 e, se existir, separar a colecao.
         * Componentes: `indexOf` localiza a sequencia textual dentro do caminho.
         */
        int solrRootPosition = path == null ? -1 : path.indexOf("/solr");
        /*
         * O que faz: verifica se a configuracao possui uma parte `/solr` e algum trecho depois dela que pode representar uma colecao.
         * Por que esta aqui: somente nesse caso devemos converter a URL antiga para a forma recomendada pelo Solr 10.
         * Componentes: `solrRootPosition >= 0` verifica a presenca do caminho; `path.length()` mede o tamanho; a condicao composta evita acessar posicoes invalidas.
         */
        if (solrRootPosition >= 0 && path != null && path.length() > solrRootPosition + 5) {
            /*
             * O que faz: extrai o trecho que aparece depois de `/solr/`.
             * Por que esta aqui: esse trecho e usado como nome da colecao padrao.
             * Componentes: `substring` recorta o texto a partir da posicao calculada; `+ 6` ignora `/solr/`.
             */
            String collection = path.substring(solrRootPosition + 6);
            /*
             * O que faz: reduz o caminho para a raiz `/solr`.
             * Por que esta aqui: SolrJ 10 espera receber a URL-raiz e a colecao separadamente.
             * Componentes: `substring` mantem a parte anterior ao nome da colecao.
             */
            String rootPath = path.substring(0, solrRootPosition + 5);
            /*
             * O que faz: monta uma nova URI contendo o mesmo protocolo e servidor, mas somente o caminho-raiz `/solr`.
             * Por que esta aqui: preserva HTTP/HTTPS e a porta configurada sem enviar o nome da colecao no base URL.
             * Componentes: o construtor `URI` recebe esquema, autoridade, caminho, consulta e fragmento da URI original.
             */
            URI rootUri = URI.create(
                    uri.getScheme() + "://" + uri.getRawAuthority() + rootPath);
            /*
             * O que faz: cria o cliente usando a URL-raiz e define a colecao extraida como padrao.
             * Por que esta aqui: esta e a forma compativel com o modelo de URL do Solr 10.
             * Componentes: `Builder` recebe a URL-raiz; `withDefaultCollection` recebe o nome da colecao; `build` cria o cliente final.
             */
            return new HttpJdkSolrClient.Builder(rootUri.toString())
                    .withDefaultCollection(collection)
                    .build();
        }
        /*
         * O que faz: cria o cliente diretamente quando a URL ja aponta para a raiz do Solr.
         * Por que esta aqui: permite continuar funcionando caso o usuario configure apenas `http://host:8983/solr`.
         * Componentes: `Builder` recebe a URL configurada e `build` cria a instancia.
         */
        return new HttpJdkSolrClient.Builder(url).build();
    }
    /*
     * O que faz: Declara o metodo `enabled`; ele recebe `` e produz o tipo `boolean`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `boolean` e o retorno; `enabled` identifica a operacao; os parametros ficam entre parenteses.
     */
    public boolean enabled(){ return enabled; }
    /*
     * O que faz: Declara o metodo `index`; ele recebe `Book book` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `index` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void index(Book book) throws Exception {
        /*
         * O que faz: Testa a condicao `!enabled` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(!enabled) return;
        /*
         * O que faz: Cria o documento que sera enviado ao Solr para indexacao.
         * Por que esta aqui: transformar o livro Java em campos reconhecidos pelo esquema de busca do Solr.
         * Componentes: `SolrInputDocument` recebe pares campo/valor por chamadas `addField`.
         */
        SolrInputDocument d=new SolrInputDocument();
        /*
         * O que faz: Executa a instrucao `d.addField("id",Long.toString(book.gutenbergId()))`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("id",Long.toString(book.gutenbergId()));
        /*
         * O que faz: Executa a instrucao `d.addField("title_txt",book.title())`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("title_txt",book.title());
        /*
         * O que faz: Executa a instrucao `d.addField("author_txt",String.join(", ",book.authors()))`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("author_txt",String.join(", ",book.authors()));
        /*
         * O que faz: Executa a instrucao `d.addField("subjects_txt",String.join(", ",book.subjects()))`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("subjects_txt",String.join(", ",book.subjects()));
        /*
         * O que faz: Executa a instrucao `d.addField("language_s",book.language())`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("language_s",book.language());
        /*
         * O que faz: Executa a instrucao `d.addField("text_txt",book.content())`.
         * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
         * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
         */
        d.addField("text_txt",book.content());
        /*
         * O que faz: Envia o documento preparado ao Solr e confirma a gravacao para tornar a atualizacao imediatamente disponivel nas consultas.
         * Por que esta aqui: indexar o livro e, logo depois, solicitar ao Solr que confirme a alteracao no indice remoto.
         * Componentes: `client.add(d)` envia `d`; `client.commit()` confirma a alteracao; o `;` separa as duas instrucoes da mesma linha.
         */
        client.add(d); client.commit();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `search`; ele recebe `String query,int page,int pageSize` e produz o tipo `List<SearchResult>`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `List<SearchResult>` e o retorno; `search` identifica a operacao; os parametros ficam entre parenteses.
     */
    public List<SearchResult> search(String query,int page,int pageSize) throws Exception {
        /*
         * O que faz: Testa a condicao `!enabled` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(!enabled) return List.of();
        /*
         * O que faz: Cria a estrutura de parametros da consulta enviada ao Solr.
         * Por que esta aqui: montar uma busca com texto, paginacao e campos ponderados antes de envia-la ao servidor Solr.
         * Componentes: `SolrQuery` guarda a expressao, inicio, quantidade de linhas e demais parametros da consulta.
         */
        SolrQuery q=new SolrQuery();
        /*
         * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
         * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
         * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
         */
        q.setQuery(query==null||query.isBlank()?"*:*":query);
        /*
         * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
         * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
         * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
         */
        q.set("defType","edismax");
        /*
         * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
         * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
         * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
         */
        q.set("qf","title_txt^5 author_txt^3 subjects_txt^2 text_txt");
        /*
         * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
         * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
         * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
         */
        q.setStart(Math.max(0,page)*Math.max(1,pageSize));
        /*
         * O que faz: Define um valor em um objeto usando o metodo `set...` indicado na linha.
         * Por que esta aqui: preencher uma propriedade ou parametro que sera consumido pela chamada feita em seguida.
         * Componentes: o metodo `set...` escolhe o tipo da propriedade e o argumento entre parenteses e o valor atribuido.
         */
        q.setRows(Math.max(1,Math.min(pageSize,50)));
            /*
             * O que faz: Solicita os campos necessarios para montar o resultado, incluindo a pontuacao.
             * Por que esta aqui: o score sera lido como campo porque getFieldValue("score") nao existe mais em SolrDocument.
             * Componentes: fl define a lista de campos devolvidos pelo Solr.
             */
            q.set("fl", "id,title_txt,author_txt,score");
        /*
         * O que faz: Obtem o resultado de `query` e o guarda em `QueryResponse response`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `client` e o objeto ou expressao chamadora; `query` e o metodo; os argumentos `q` fornecem suas entradas; `=` faz a atribuicao.
         */
        QueryResponse response=client.query(q);
        /*
         * O que faz: Cria uma lista mutavel para armazenar resultados que serao acrescentados durante o processamento.
         * Por que esta aqui: ter uma colecao vazia pronta para receber itens na ordem em que forem encontrados.
         * Componentes: `ArrayList` oferece insercao sequencial e cresce conforme novos elementos sao adicionados.
         */
        List<SearchResult> out=new ArrayList<>();
        /*
         * O que faz: Converte o valor recebido para representacao textual segura.
         * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
         * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
         */
        response.getResults().forEach(document -> {
            /*
             * O que faz: Recupera a pontuacao devolvida pelo Solr como campo do documento.
             * Por que esta aqui: SolrDocument no Solr 10 nao expoe getFieldValue("score"), entao score e solicitado no field list e lido como valor de campo.
             * Componentes: getFieldValue("score") retorna o valor calculado pelo Solr.
             */
            Object rawScore = document.getFieldValue("score");

            /*
             * O que faz: Converte a pontuacao numerica para float ou usa zero quando ela nao estiver disponivel.
             * Por que esta aqui: SearchResult espera a relevancia como float.
             * Componentes: instanceof verifica Number e floatValue faz a conversao.
             */
            float score = rawScore instanceof Number number ? number.floatValue() : 0.0f;

            /*
             * O que faz: Converte o documento Solr para o modelo SearchResult da aplicacao.
             * Por que esta aqui: mantem o Solr isolado na camada de infraestrutura.
             * Componentes: getFieldValue recupera id, titulo e autor; score registra a relevancia; "solr" identifica a origem.
             */
            out.add(new SearchResult(
                    String.valueOf(document.getFieldValue("id")),
                    String.valueOf(document.getFieldValue("title_txt")),
                    String.valueOf(document.getFieldValue("author_txt")),
                    score,
                    "solr"));
        });
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `out`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return out;
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Indica que o metodo `close` implementa ou substitui um metodo herdado e declara sua execucao, recebendo `` e retornando `void`.
     * Por que esta aqui: combinar a verificacao do `@Override` com a assinatura do metodo deixa claro, no mesmo ponto, qual contrato da classe-base esta sendo atendido.
     * Componentes: `@Override` marca a sobrescrita; `public` controla o acesso; `void` e o retorno; `close` e o metodo; os parametros ficam entre parenteses; `throws` declara excecoes quando presente.
     */
    @Override public void close() throws Exception { if(client!=null) client.close(); }
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
