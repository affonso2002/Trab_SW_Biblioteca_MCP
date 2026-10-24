/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.mcp` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.mcp;

/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;
/*
 * O que faz: Importa a classe Map da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.Map`; o ponto final do pacote identifica a classe importada.
 */
import java.util.Map;
/*
 * O que faz: Importa a classe ExcelService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.ExcelService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.ExcelService;
/*
 * O que faz: Importa a classe IndexingService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.IndexingService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.IndexingService;
/*
 * O que faz: Importa a classe LuceneIndexService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.LuceneIndexService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.LuceneIndexService;
/*
 * O que faz: Importa a classe MySqlMetadataService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.MySqlMetadataService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.MySqlMetadataService;
/*
 * O que faz: Importa a classe PdfMetadataService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.PdfMetadataService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.PdfMetadataService;
/*
 * O que faz: Importa a classe PostgresMetadataService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.PostgresMetadataService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.PostgresMetadataService;
/*
 * O que faz: Importa a classe SolrIndexService da biblioteca `br.edu.ifpr.biblioteca.service`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.service.SolrIndexService`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.service.SolrIndexService;
/*
 * O que faz: Importa a classe SyncToolSpecification da biblioteca `io.modelcontextprotocol.server.McpServerFeatures`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.server.McpServer.SyncSpecification;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
/*
 * O que faz: Importa a classe McpSyncServerExchange da biblioteca `io.modelcontextprotocol.server`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.server.McpSyncServerExchange`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.server.McpSyncServerExchange;
/*
 * O que faz: Importa a classe CallToolRequest da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.CallToolRequest`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
/*
 * O que faz: Importa a classe CallToolResult da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.CallToolResult`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
/*
 * O que faz: Importa a classe TextContent da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.TextContent`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.TextContent;
/*
 * O que faz: Importa a classe Tool da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.Tool`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.Tool;


/*
 * O que faz: Declara a classe `LibraryToolsFeature`, que registra as ferramentas MCP que executam as operacoes da biblioteca.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class LibraryToolsFeature implements McpFeature {
    /*
     * O que faz: Declara o atributo `indexingService` do tipo `IndexingService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `IndexingService` define o tipo de dado; `indexingService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final IndexingService indexingService;
    /*
     * O que faz: Declara o atributo `luceneService` do tipo `LuceneIndexService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `LuceneIndexService` define o tipo de dado; `luceneService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final LuceneIndexService luceneService;
    /*
     * O que faz: Declara o atributo `solrService` do tipo `SolrIndexService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `SolrIndexService` define o tipo de dado; `solrService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final SolrIndexService solrService;
    /*
     * O que faz: Declara o atributo `pdfService` do tipo `PdfMetadataService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `PdfMetadataService` define o tipo de dado; `pdfService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final PdfMetadataService pdfService;
    /*
     * O que faz: Declara o atributo `excelService` do tipo `ExcelService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `ExcelService` define o tipo de dado; `excelService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final ExcelService excelService;
    /*
     * O que faz: Declara o atributo `postgresService` do tipo `PostgresMetadataService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `PostgresMetadataService` define o tipo de dado; `postgresService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final PostgresMetadataService postgresService;
    /*
     * O que faz: Declara o atributo `mysqlService` do tipo `MySqlMetadataService` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `MySqlMetadataService` define o tipo de dado; `mysqlService` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final MySqlMetadataService mysqlService;

    /*
     * O que faz: Declara o construtor de `LibraryToolsFeature` e recebe ``.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `LibraryToolsFeature` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public LibraryToolsFeature(
            /*
             * O que faz: Recebe o servico responsavel por indexar livros do Gutenberg.
             * Por que esta aqui: A dependencia e fornecida ao construir a Feature, mantendo a regra de negocio fora do registro MCP.
             * Componentes: `IndexingService` e o tipo da dependencia e `indexingService` e o parametro do construtor.
             */
            IndexingService indexingService,
            /*
             * O que faz: Recebe o servico de busca local baseado em Lucene.
             * Por que esta aqui: A Feature pode encaminhar chamadas MCP ao indice local sem implementar a busca aqui.
             * Componentes: `LuceneIndexService` e o tipo da dependencia e `luceneService` e o parametro do construtor.
             */
            LuceneIndexService luceneService,
            /*
             * O que faz: Recebe o servico de busca remoto baseado em Solr.
             * Por que esta aqui: A Feature reutiliza a implementacao existente para consultar o indice Solr quando habilitado.
             * Componentes: `SolrIndexService` e o tipo da dependencia e `solrService` e o parametro do construtor.
             */
            SolrIndexService solrService,
            /*
             * O que faz: Recebe o servico responsavel por extrair metadados de PDF.
             * Por que esta aqui: A Feature delega o processamento do documento ao servico especializado.
             * Componentes: `PdfMetadataService` e o tipo da dependencia e `pdfService` e o parametro do construtor.
             */
            PdfMetadataService pdfService,
            /*
             * O que faz: Recebe o servico que processa planilhas Excel.
             * Por que esta aqui: A Feature mantem separada a definicao do contrato MCP da conversao de planilhas.
             * Componentes: `ExcelService` e o tipo da dependencia e `excelService` e o parametro do construtor.
             */
            ExcelService excelService,
            /*
             * O que faz: Recebe o servico que consulta os metadados do PostgreSQL.
             * Por que esta aqui: A Feature delega a inspecao do banco a classe que centraliza essa responsabilidade.
             * Componentes: `PostgresMetadataService` e o tipo da dependencia e `postgresService` e o parametro do construtor.
             */
            PostgresMetadataService postgresService,
            /*
             * O que faz: Recebe o servico que consulta os metadados do MySQL e inicia o construtor.
             * Por que esta aqui: A dependencia permite registrar a ferramenta de metadados MySQL sem embutir acesso JDBC nesta Feature.
             * Componentes: `MySqlMetadataService` define o tipo; `mysqlService` e o parametro; `{` inicia o corpo do construtor.
             */
            MySqlMetadataService mysqlService) {
        /*
         * O que faz: Atribui a expressao `this.indexingService` o valor `indexingService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.indexingService = indexingService;
        /*
         * O que faz: Atribui a expressao `this.luceneService` o valor `luceneService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.luceneService = luceneService;
        /*
         * O que faz: Atribui a expressao `this.solrService` o valor `solrService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.solrService = solrService;
        /*
         * O que faz: Atribui a expressao `this.pdfService` o valor `pdfService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.pdfService = pdfService;
        /*
         * O que faz: Atribui a expressao `this.excelService` o valor `excelService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.excelService = excelService;
        /*
         * O que faz: Atribui a expressao `this.postgresService` o valor `postgresService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.postgresService = postgresService;
        /*
         * O que faz: Atribui a expressao `this.mysqlService` o valor `mysqlService`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        this.mysqlService = mysqlService;
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Informa ao compilador que o metodo seguinte substitui uma implementacao herdada ou declarada em contrato.
     * Por que esta aqui: deixar explicito que a classe esta cumprindo um comportamento definido por uma classe-base ou interface.
     * Componentes: `@Override` verifica se realmente existe um metodo compativel para sobrescrever.
     */
    @Override
    /*
     * O que faz: Declara o metodo `register`; ele recebe `SyncSpecification<?> mcp` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `register` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void register(SyncSpecification<?> mcp) throws Exception {
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createIndexTool());
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createSearchTool());
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createPdfTool());
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createExcelTool());
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createPostgresTool());
        /*
         * O que faz: Registra no servidor MCP a Tool criada pelo metodo correspondente.
         * Por que esta aqui: fazer com que o cliente consiga descobrir e chamar a ferramenta por meio do protocolo.
         * Componentes: `tools(...)` recebe a especificacao da Tool e a adiciona ao servidor MCP.
         */
        mcp.tools(createMysqlTool());
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createIndexTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createIndexTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createIndexTool() {
        /*
         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
         */
        Map<String, Object> schema = Map.of(
                /*
                 * O que faz: Define como objeto JSON o esquema dos argumentos da ferramenta.
                 * Por que esta aqui: O protocolo MCP precisa informar o formato esperado para que clientes possam validar os argumentos.
                 * Componentes: A chave `type` recebe o valor `object`, indicando um mapa de propriedades JSON.
                 */
                "type", "object",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                "properties", Map.of(
                        /*
                         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                         */
                        "query", Map.of("type", "string"),
                        /*
                         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                         */
                        "limit", Map.of("type", "integer", "minimum", 1, "maximum", 20)),
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                "required", List.of("query"),
                /*
                 * O que faz: Executa a instrucao `"additionalProperties", false)`.
                 * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
                 * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
                 */
                "additionalProperties", false);
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("indexar_gutenberg", schema)
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Indexa livros do Project Gutenberg/Gutendex, salvando conteudo, metadados e indices."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Indexa livros do Project Gutenberg/Gutendex, salvando conteudo, metadados e indices.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request, ignored -> {
                    /*
                     * O que faz: Converte o valor recebido para representacao textual segura.
                     * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
                     * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
                     */
                    String query = String.valueOf(request.arguments().get("query"));
                    /*
                     * O que faz: Atribui a expressao `int limit` o valor `request.arguments().get("limit") instanceof Number number ? number.intValue() : 5`.
                     * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
                     * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
                     */
                    int limit = request.arguments().get("limit") instanceof Number number ? number.intValue() : 5;
                    /*
                     * O que faz: Devolve ao chamador o resultado calculado por `indexingService.indexGutenberg(query, limit)`.
                     * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
                     * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
                     */
                    return indexingService.indexGutenberg(query, limit);
                /*
                 * O que faz: Fecha o bloco de codigo aberto anteriormente.
                 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
                 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
                 */
                }))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createSearchTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createSearchTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createSearchTool() {
        /*
         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
         */
        Map<String, Object> schema = Map.of(
                /*
                 * O que faz: Define como objeto JSON o esquema dos argumentos da ferramenta.
                 * Por que esta aqui: O protocolo MCP precisa informar o formato esperado para que clientes possam validar os argumentos.
                 * Componentes: A chave `type` recebe o valor `object`, indicando um mapa de propriedades JSON.
                 */
                "type", "object",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                "properties", Map.of(
                        /*
                         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                         */
                        "query", Map.of("type", "string"),
                        /*
                         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                         */
                        "page", Map.of("type", "integer", "minimum", 0),
                        /*
                         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                         */
                        "pageSize", Map.of("type", "integer", "minimum", 1, "maximum", 50)),
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                "required", List.of("query"),
                /*
                 * O que faz: Executa a instrucao `"additionalProperties", false)`.
                 * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
                 * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
                 */
                "additionalProperties", false);
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("buscar_livros", schema)
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Busca livros com relevancia e paginacao em Lucene e Solr."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Busca livros com relevancia e paginacao em Lucene e Solr.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request, ignored -> {
                    /*
                     * O que faz: Converte o valor recebido para representacao textual segura.
                     * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
                     * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
                     */
                    String query = String.valueOf(request.arguments().get("query"));
                    /*
                     * O que faz: Atribui a expressao `int page` o valor `request.arguments().get("page") instanceof Number number ? number.intValue() : 0`.
                     * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
                     * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
                     */
                    int page = request.arguments().get("page") instanceof Number number ? number.intValue() : 0;
                    /*
                     * O que faz: Atribui a expressao `int pageSize` o valor `request.arguments().get("pageSize") instanceof Number number ? number.intValue() : 10`.
                     * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
                     * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
                     */
                    int pageSize = request.arguments().get("pageSize") instanceof Number number ? number.intValue() : 10;
                    /*
                     * O que faz: Cria um acumulador de texto para montar a resposta gradualmente.
                     * Por que esta aqui: evitar a criacao excessiva de varias `String` temporarias ao concatenar muitos resultados.
                     * Componentes: `StringBuilder` mantem um texto mutavel; chamadas como `append` acrescentam partes a resposta.
                     */
                    StringBuilder result = new StringBuilder("Lucene:\n");
                    /*
                     * O que faz: Percorre os livros encontrados no indice Lucene e acrescenta seus dados a resposta.
                     * Por que esta aqui: Inclui na resposta os resultados da busca local antes de considerar a origem Solr opcional.
                     * Componentes: `search` executa a consulta paginada; `forEach` percorre cada item; `result` acumula o texto.
                     */
                    luceneService.search(query, page, pageSize).forEach(item -> result
                            /*
                             * O que faz: Acrescenta o valor indicado ao texto que esta sendo construido.
                             * Por que esta aqui: montar uma resposta final com varias informacoes sem criar uma nova string completa a cada pequena juncao.
                             * Componentes: `append` recebe o proximo trecho e devolve o mesmo `StringBuilder` para permitir encadeamento.
                             */
                            .append(item.id()).append(" | ").append(item.title()).append(" | ")
                            /*
                             * O que faz: Acrescenta o valor indicado ao texto que esta sendo construido.
                             * Por que esta aqui: montar uma resposta final com varias informacoes sem criar uma nova string completa a cada pequena juncao.
                             * Componentes: `append` recebe o proximo trecho e devolve o mesmo `StringBuilder` para permitir encadeamento.
                             */
                            .append(item.author()).append(" | score=").append(item.score()).append('\n'));
                    /*
                     * O que faz: Testa a condicao `solrService.enabled()` e so executa o bloco seguinte quando ela for verdadeira.
                     * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
                     * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
                     */
                    if (solrService.enabled()) {
                        /*
                         * O que faz: Acrescenta o valor indicado ao texto que esta sendo construido.
                         * Por que esta aqui: montar uma resposta final com varias informacoes sem criar uma nova string completa a cada pequena juncao.
                         * Componentes: `append` recebe o proximo trecho e devolve o mesmo `StringBuilder` para permitir encadeamento.
                         */
                        result.append("Solr:\n");
                        /*
                         * O que faz: Percorre os livros encontrados no Solr e acrescenta seus dados a resposta.
                         * Por que esta aqui: Permite apresentar tambem os resultados do indice Solr quando esse servico esta habilitado.
                         * Componentes: `search` executa a consulta paginada; `forEach` percorre cada item; `result` acumula o texto.
                         */
                        solrService.search(query, page, pageSize).forEach(item -> result
                                /*
                                 * O que faz: Acrescenta o valor indicado ao texto que esta sendo construido.
                                 * Por que esta aqui: montar uma resposta final com varias informacoes sem criar uma nova string completa a cada pequena juncao.
                                 * Componentes: `append` recebe o proximo trecho e devolve o mesmo `StringBuilder` para permitir encadeamento.
                                 */
                                .append(item.id()).append(" | ").append(item.title()).append(" | ")
                                /*
                                 * O que faz: Acrescenta o valor indicado ao texto que esta sendo construido.
                                 * Por que esta aqui: montar uma resposta final com varias informacoes sem criar uma nova string completa a cada pequena juncao.
                                 * Componentes: `append` recebe o proximo trecho e devolve o mesmo `StringBuilder` para permitir encadeamento.
                                 */
                                .append(item.author()).append(" | score=").append(item.score()).append('\n'));
                    /*
                     * O que faz: Fecha o bloco de codigo aberto anteriormente.
                     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
                     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
                     */
                    }
                    /*
                     * O que faz: Devolve ao chamador o resultado calculado por `result.toString()`.
                     * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
                     * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
                     */
                    return result.toString();
                /*
                 * O que faz: Fecha o bloco de codigo aberto anteriormente.
                 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
                 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
                 */
                }))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createPdfTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createPdfTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createPdfTool() {
        /*
         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
         */
        Map<String, Object> schema = Map.of(
                /*
                 * O que faz: Define como objeto JSON o esquema dos argumentos da ferramenta.
                 * Por que esta aqui: O protocolo MCP precisa informar o formato esperado para que clientes possam validar os argumentos.
                 * Componentes: A chave `type` recebe o valor `object`, indicando um mapa de propriedades JSON.
                 */
                "type", "object",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                "properties", Map.of("fileName", Map.of("type", "string")),
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                "required", List.of("fileName"),
                /*
                 * O que faz: Executa a instrucao `"additionalProperties", false)`.
                 * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
                 * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
                 */
                "additionalProperties", false);
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("extrair_metadados_pdf", schema)
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Extrai metadados e uma amostra de texto de um PDF em data/input."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Extrai metadados e uma amostra de texto de um PDF em data/input.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request,
                        /*
                         * O que faz: Converte o valor recebido para representacao textual segura.
                         * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
                         * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
                         */
                        ignored -> pdfService.extract(String.valueOf(request.arguments().get("fileName")))))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createExcelTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createExcelTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createExcelTool() {
        /*
         * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
         * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
         * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
         */
        Map<String, Object> schema = Map.of(
                /*
                 * O que faz: Define como objeto JSON o esquema dos argumentos da ferramenta.
                 * Por que esta aqui: O protocolo MCP precisa informar o formato esperado para que clientes possam validar os argumentos.
                 * Componentes: A chave `type` recebe o valor `object`, indicando um mapa de propriedades JSON.
                 */
                "type", "object",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                "properties", Map.of("fileName", Map.of("type", "string")),
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                "required", List.of("fileName"),
                /*
                 * O que faz: Executa a instrucao `"additionalProperties", false)`.
                 * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
                 * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
                 */
                "additionalProperties", false);
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("processar_excel", schema)
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Converte XLS/XLSX para CSV UTF-8 usando Apache POI."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Converte XLS/XLSX para CSV UTF-8 usando Apache POI.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request,
                        /*
                         * O que faz: Converte o valor recebido para representacao textual segura.
                         * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
                         * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
                         */
                        ignored -> excelService.convertToCsv(String.valueOf(request.arguments().get("fileName")))))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createPostgresTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createPostgresTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createPostgresTool() {
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("metadados_postgresql",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                Map.of("type", "object", "properties", Map.of(), "additionalProperties", false))
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Exibe metadados das estruturas do PostgreSQL configurado."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Exibe metadados das estruturas do PostgreSQL configurado.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request, ignored -> postgresService.describe()))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `createMysqlTool`; ele recebe `` e produz o tipo `SyncToolSpecification`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `SyncToolSpecification` e o retorno; `createMysqlTool` identifica a operacao; os parametros ficam entre parenteses.
     */
    private SyncToolSpecification createMysqlTool() {
        /*
         * O que faz: Comeca a construir a definicao da Tool MCP.
         * Por que esta aqui: descrever para o cliente o nome, os parametros aceitos e o objetivo funcional antes de definir o codigo que a executa.
         * Componentes: `Tool.builder` recebe o nome da ferramenta e o esquema de entrada; metodos seguintes completam sua descricao.
         */
        Tool tool = Tool.builder("metadados_mysql",
                /*
                 * O que faz: Cria um mapa imutavel com as chaves e valores definidos na linha.
                 * Por que esta aqui: montar rapidamente estruturas pequenas de configuracao, JSON ou esquemas sem criar um mapa manualmente.
                 * Componentes: `Map.of` alterna pares chave/valor; cada chave e seguida pelo valor correspondente.
                 */
                Map.of("type", "object", "properties", Map.of(), "additionalProperties", false))
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Exibe metadados das estruturas do MySQL configurado."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Exibe metadados das estruturas do MySQL configurado.")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `SyncToolSpecification.builder()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return SyncToolSpecification.builder()
                /*
                 * O que faz: associa a definicao da Tool ao executor, usando os argumentos `tool`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.tool` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .tool(tool)
                /*
                 * O que faz: Associa a Tool uma funcao que sera executada quando o cliente fizer uma chamada.
                 * Por que esta aqui: transformar a descricao MCP em comportamento real dentro da aplicacao.
                 * Componentes: `callHandler` recebe a troca MCP e a requisicao; a lambda executa a acao correspondente.
                 */
                .callHandler((exchange, request) -> execute(request, ignored -> mysqlService.describe()))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }

    /*
     * O que faz: Declara o metodo `execute`; ele recebe `CallToolRequest request, Function<CallToolRequest, String> action` e produz o tipo `CallToolResult`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `CallToolResult` e o retorno; `execute` identifica a operacao; os parametros ficam entre parenteses.
     */
    /*
     * O que faz: Define o contrato das operacoes de Tool que podem lancar excecoes verificaveis.
     * Por que esta aqui: servicos de rede, banco e arquivos usados pelas Tools podem falhar e precisam chegar ao tratamento central.
     * Componentes: @FunctionalInterface permite usar lambdas; CheckedToolAction recebe CallToolRequest e devolve String.
     */
    @FunctionalInterface
    private interface CheckedToolAction {
        /*
         * O que faz: Declara a execucao de uma Tool a partir da requisicao MCP recebida.
         * Por que esta aqui: mantem uma assinatura comum para indexacao, busca, PDF, Excel e banco.
         * Componentes: apply recebe a requisicao e throws Exception permite informar falhas reais da operacao.
         */
        String apply(CallToolRequest request) throws Exception;
    }

    private CallToolResult execute(CallToolRequest request, CheckedToolAction action) {
        /*
         * O que faz: Inicia o bloco protegido que executa a operacao da ferramenta.
         * Por que esta aqui: As excecoes da execucao podem ser convertidas em uma resposta de erro MCP no bloco de tratamento correspondente.
         * Componentes: `try` delimita o trecho cuja falha sera tratada pelo `catch` associado.
         */
        try {
            /*
             * O que faz: Devolve ao chamador o resultado calculado por `CallToolResult.builder()`.
             * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
             * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
             */
            return CallToolResult.builder()
                    /*
                     * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                     * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                     * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                     */
                    .content(List.of(TextContent.builder(action.apply(request)).build()))
                    /*
                     * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .build();
        /*
         * O que faz: Fecha o bloco que poderia falhar e inicia o tratamento da excecao.
         * Por que esta aqui: evitar que um erro de execucao interrompa sem explicacao a operacao em andamento.
         * Componentes: `}` encerra o bloco protegido e `catch` recebe o tipo de erro que sera tratado.
         */
        } catch (Exception exception) {
            /*
             * O que faz: Devolve ao chamador o resultado calculado por `CallToolResult.builder()`.
             * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
             * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
             */
            return CallToolResult.builder()
                    /*
                     * O que faz: marca o resultado da Tool como erro, usando os argumentos `true`.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.isError` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .isError(true)
                    /*
                     * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                     * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                     * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                     */
                    .content(List.of(TextContent.builder("ERRO: " + exception.getMessage()).build()))
                    /*
                     * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .build();
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
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
