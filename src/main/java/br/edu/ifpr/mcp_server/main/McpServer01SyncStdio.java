/*
 * O que faz: registra a classe no pacote usado pelo exemplo de Cliente 01 do professor.
 * Por que esta aqui: manter o mesmo caminho logico do exemplo facilita que o Cliente 01 encontre e invoque este servidor sem alterar o protocolo esperado.
 * Componentes: `package` organiza a classe dentro do namespace Java do projeto.
 */
package br.edu.ifpr.mcp_server.main;

/*
 * O que faz: importa `java.util.List` para montar a colecao de Features MCP que serao compartilhadas pelo servidor STDIO.
 * Por que esta aqui: o servidor precisa registrar as mesmas Tools, Resources e Prompts registradas no projeto.
 * Componentes: `List` representa uma colecao ordenada de objetos.
 */
import java.util.List;

/*
 * O que faz: importa a configuracao central de propriedades da biblioteca.
 * Por que esta aqui: o servidor STDIO precisa criar os servicos com os mesmos valores padrao usados pela aplicacao principal.
 * Componentes: `AppProperties` guarda URLs, diretorios, credenciais e flags de integracao.
 */
import br.edu.ifpr.biblioteca.config.AppProperties;
/*
 * O que faz: importa o armazenamento de arquivos compartilhado pela biblioteca.
 * Por que esta aqui: PDF, Excel, Gutenberg e Lucene usam a mesma estrutura fisica de dados.
 * Componentes: `FileStorage` cria e valida os diretorios de trabalho.
 */
import br.edu.ifpr.biblioteca.config.FileStorage;
/*
 * O que faz: importa o contrato comum das Features MCP.
 * Por que esta aqui: permite registrar Tools, Resources e Prompts sem duplicar o codigo funcional ja existente.
 * Componentes: `McpFeature` define o metodo de registro aceito pelos dois transportes.
 */
import br.edu.ifpr.biblioteca.mcp.McpFeature;
/*
 * O que faz: importa a Feature que contem as seis Tools substantivas do projeto.
 * Por que esta aqui: o Cliente 01 deve descobrir e executar as mesmas operacoes que qualquer cliente MCP consegue executar por STDIO.
 * Componentes: `LibraryToolsFeature` cria as definicoes e handlers das ferramentas.
 */
import br.edu.ifpr.biblioteca.mcp.LibraryToolsFeature;
/*
 * O que faz: importa a Feature responsavel pelos Resources MCP.
 * Por que esta aqui: manter o contrato MCP completo tambem no transporte STDIO.
 * Componentes: `ResourcesFeature` registra recursos estaticos e de arquivo.
 */
import br.edu.ifpr.biblioteca.mcp.ResourcesFeature;
/*
 * O que faz: importa a Feature responsavel pelos Prompts MCP.
 * Por que esta aqui: permitir que o Cliente 01 enxergue o mesmo catalogo de prompts disponibilizado pelo servidor MCP.
 * Componentes: `PromptsFeature` registra o prompt `pesquisar_biblioteca`.
 */
import br.edu.ifpr.biblioteca.mcp.PromptsFeature;
/*
 * O que faz: importa o servico que consulta o Project Gutenberg/Gutendex.
 * Por que esta aqui: a Tool de indexacao depende dele para obter os livros reais.
 * Componentes: `GutenbergService` encapsula a comunicacao com a API de catalogo.
 */
import br.edu.ifpr.biblioteca.service.GutenbergService;
/*
 * O que faz: importa o servico de indexacao do Lucene.
 * Por que esta aqui: a Tool de indexacao precisa gerar o indice local de texto.
 * Componentes: `LuceneIndexService` grava e pesquisa o indice local.
 */
import br.edu.ifpr.biblioteca.service.LuceneIndexService;
/*
 * O que faz: importa o servico de indexacao do Solr.
 * Por que esta aqui: a mesma Tool de indexacao pode enviar os livros para o Solr quando essa integracao estiver habilitada.
 * Componentes: `SolrIndexService` encapsula o cliente SolrJ.
 */
import br.edu.ifpr.biblioteca.service.SolrIndexService;
/*
 * O que faz: importa o repositorio PostgreSQL da biblioteca.
 * Por que esta aqui: a indexacao persiste os metadados dos livros nesse banco.
 * Componentes: `LibraryRepository` cria e grava a tabela de documentos.
 */
import br.edu.ifpr.biblioteca.service.LibraryRepository;
/*
 * O que faz: importa o servico orquestrador da indexacao Gutenberg.
 * Por que esta aqui: concentrar em um unico objeto o fluxo Gutenberg -> arquivo -> PostgreSQL -> Lucene -> Solr.
 * Componentes: `IndexingService` coordena as etapas.
 */
import br.edu.ifpr.biblioteca.service.IndexingService;
/*
 * O que faz: importa o servico de leitura de metadados PDF.
 * Por que esta aqui: permitir que o Cliente 01 execute a Tool de PDF compartilhada pelo servidor MCP.
 * Componentes: `PdfMetadataService` usa Apache PDFBox.
 */
import br.edu.ifpr.biblioteca.service.PdfMetadataService;
/*
 * O que faz: importa o servico de processamento de Excel.
 * Por que esta aqui: permitir que o Cliente 01 execute a Tool baseada no Apache POI.
 * Componentes: `ExcelService` le XLS/XLSX e gera CSV.
 */
import br.edu.ifpr.biblioteca.service.ExcelService;
/*
 * O que faz: importa o servico de metadados PostgreSQL.
 * Por que esta aqui: disponibilizar a Tool de consulta estrutural do banco ao Cliente 01.
 * Componentes: `PostgresMetadataService` usa JDBC `DatabaseMetaData`.
 */
import br.edu.ifpr.biblioteca.service.PostgresMetadataService;
/*
 * O que faz: importa o servico de metadados MySQL.
 * Por que esta aqui: disponibilizar a Tool de consulta estrutural do banco ao Cliente 01.
 * Componentes: `MySqlMetadataService` usa JDBC `DatabaseMetaData`.
 */
import br.edu.ifpr.biblioteca.service.MySqlMetadataService;

/*
 * O que faz: importa a fabrica principal de servidores MCP sincronos.
 * Por que esta aqui: construir o servidor usando exatamente a mesma API MCP 2.0.1 usada no exemplo do professor.
 * Componentes: `McpServer` oferece o metodo `sync(...)`.
 */
import io.modelcontextprotocol.server.McpServer;
/*
 * O que faz: importa o tipo da especificacao sincrona de uma unica sessao.
 * Por que esta aqui: o transporte STDIO usado pelo Cliente 01 e criado pelo metodo `McpServer.sync(...)` com esse tipo de especificacao.
 * Componentes: `SingleSessionSyncSpecification` e o subtipo sincrono do SDK para transporte STDIO tradicional.
 */
import io.modelcontextprotocol.server.McpServer.SingleSessionSyncSpecification;
/*
 * O que faz: importa a classe concreta do servidor sincrono ja construido.
 * Por que esta aqui: armazenar o servidor para manter a referencia ativa e poder fecha-lo corretamente.
 * Componentes: `McpSyncServer` representa o servidor MCP pronto para atender chamadas.
 */
import io.modelcontextprotocol.server.McpSyncServer;
/*
 * O que faz: importa a implementacao do transporte STDIO do servidor.
 * Por que esta aqui: STDIO e o canal esperado pelo Cliente 01 do professor para iniciar o JAR do servidor como processo filho.
 * Componentes: `StdioServerTransportProvider` le e escreve as mensagens MCP pelo stdin/stdout do processo.
 */
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
/*
 * O que faz: importa as capacidades MCP anunciadas durante a inicializacao.
 * Por que esta aqui: informar ao Cliente 01 que Tools, Resources, Prompts e logging estao disponiveis.
 * Componentes: `ServerCapabilities` representa as capacidades negociadas no handshake.
 */
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
/*
 * O que faz: importa a identificacao do servidor apresentada ao cliente.
 * Por que esta aqui: manter o servidor identificavel durante o `initialize` do protocolo MCP.
 * Componentes: `Implementation` contem nome e versao do servidor.
 */
import io.modelcontextprotocol.spec.McpSchema.Implementation;
/*
 * O que faz: importa o conversor JSON especifico usado pelo SDK MCP 2.0.1 com Jackson 3.
 * Por que esta aqui: o transporte STDIO precisa serializar e desserializar as mensagens MCP.
 * Componentes: `JacksonMcpJsonMapper` adapta o `JsonMapper` do Jackson ao MCP.
 */
import io.modelcontextprotocol.json.jackson3.JacksonMcpJsonMapper;
/*
 * O que faz: importa o `JsonMapper` do Jackson 3 usado pelo adaptador MCP.
 * Por que esta aqui: fornecer ao transporte um componente real de conversao JSON.
 * Componentes: `JsonMapper` converte objetos Java em JSON e JSON em objetos Java.
 */
import tools.jackson.databind.json.JsonMapper;
/*
 * O que faz: importa a especificacao generica de servidor sincrono do SDK.
 * Por que esta aqui: permite registrar Tools, Resources e Prompts na especificacao sincrona usada pelo servidor STDIO.
 * Componentes: `SyncSpecification<?>` representa a configuracao MCP a qual as Features sao adicionadas.
 */
import io.modelcontextprotocol.server.McpServer.SyncSpecification;

/*
 * O que faz: declara o servidor STDIO compativel com o Cliente 01.
 * Por que esta aqui: este e o ponto que fecha o criterio de comunicacao cliente -> servidor por STDIO sem duplicar a logica das Tools.
 * Componentes: a classe concentra somente montagem do transporte e composicao das Features; as regras de negocio continuam nos servicos existentes.
 */
public class McpServer01SyncStdio {
    /*
     * O que faz: guarda a instancia concreta do servidor MCP depois que ela e construida.
     * Por que esta aqui: a referencia precisa permanecer viva enquanto o processo filho atende mensagens do Cliente 01.
     * Componentes: `McpSyncServer` representa o servidor sincrono ja pronto para uso.
     */
    private final McpSyncServer server;

    /*
     * O que faz: cria o servidor STDIO completo usando as mesmas Features MCP compartilhadas pelo projeto.
     * Por que esta aqui: centralizar esta montagem deixa explicito que o novo transporte nao cria uma segunda implementacao das ferramentas.
     * Componentes: cada objeto de servico e criado com suas dependencias e depois entregue a `LibraryToolsFeature`, `ResourcesFeature` e `PromptsFeature`.
     */
    private McpSyncServer createServer() throws Exception {
        
        AppProperties properties = new AppProperties();

        /*
         * O que faz: cria o armazenamento fisico dos arquivos da aplicacao.
         * Por que esta aqui: o servidor STDIO deve compartilhar `data/` com o restante da aplicacao para que o comportamento das Tools seja o mesmo.
         * Componentes: `FileStorage` cria e organiza `documents`, `input`, `processed` e `lucene`.
         */
        FileStorage storage = new FileStorage(properties);

        /*
         * O que faz: cria o servico que consulta o catalogo Gutenberg.
         * Por que esta aqui: a Tool `indexar_gutenberg` usa essa dependencia para buscar livros reais.
         * Componentes: `GutenbergService` recebe a configuracao de URL do Gutendex.
         */
        GutenbergService gutenberg = new GutenbergService(properties);
        /*
         * O que faz: cria o indice local do Lucene.
         * Por que esta aqui: a indexacao e a busca precisam ter acesso ao mesmo diretorio fisico.
         * Componentes: `LuceneIndexService` recebe o armazenamento e usa a pasta `data/lucene`.
         */
        LuceneIndexService lucene = new LuceneIndexService(storage);
        /*
         * O que faz: cria o cliente de integracao com Solr.
         * Por que esta aqui: manter a Tool `indexar_gutenberg` e a busca com as demais funcionalidades MCP.
         * Componentes: `SolrIndexService` le a URL e a flag `solr-enabled` das propriedades.
         */
        SolrIndexService solr = new SolrIndexService(properties);
        /*
         * O que faz: cria o repositorio PostgreSQL.
         * Por que esta aqui: persistir os metadados dos livros indexados no mesmo banco configurado pela aplicacao principal.
         * Componentes: `LibraryRepository` usa JDBC com os valores das propriedades.
         */
        LibraryRepository repository = new LibraryRepository(properties);
        /*
         * O que faz: cria o servico que coordena todo o fluxo de indexacao Gutenberg.
         * Por que esta aqui: concentrar a sequencia de gravacao de arquivo, banco, Lucene e Solr em uma unica dependencia da Tool.
         * Componentes: o construtor recebe os cinco objetos necessarios para a orquestracao.
         */
        IndexingService indexing = new IndexingService(gutenberg, lucene, solr, repository, storage);
        /*
         * O que faz: cria o servico de leitura de PDF.
         * Por que esta aqui: disponibilizar a mesma funcionalidade PDFBox no Cliente 01.
         * Componentes: `PdfMetadataService` usa `FileStorage` para localizar o PDF informado.
         */
        PdfMetadataService pdf = new PdfMetadataService(storage);
        /*
         * O que faz: cria o servico de processamento de planilhas.
         * Por que esta aqui: disponibilizar a mesma funcionalidade Apache POI no Cliente 01.
         * Componentes: `ExcelService` usa `FileStorage` para localizar a entrada e gravar o CSV.
         */
        ExcelService excel = new ExcelService(storage);
        /*
         * O que faz: cria o servico de metadados PostgreSQL.
         * Por que esta aqui: permitir a execucao da Tool estrutural pelo Cliente 01.
         * Componentes: `PostgresMetadataService` usa as credenciais JDBC de `AppProperties`.
         */
        PostgresMetadataService postgres = new PostgresMetadataService(properties);
        /*
         * O que faz: cria o servico de metadados MySQL.
         * Por que esta aqui: permitir a execucao da Tool estrutural pelo Cliente 01.
         * Componentes: `MySqlMetadataService` usa as credenciais JDBC de `AppProperties`.
         */
        MySqlMetadataService mysql = new MySqlMetadataService(properties);

        /*
         * O que faz: reune as Features MCP em uma lista unica.
         * Por que esta aqui: o servidor STDIO deve reutilizar exatamente as mesmas definicoes de Tools, Resources e Prompt do projeto.
         * Componentes: `List.of` cria uma colecao fixa; cada Feature recebe as dependencias que ja foram criadas acima.
         */
        List<McpFeature> features = List.of(
                new LibraryToolsFeature(indexing, lucene, solr, pdf, excel, postgres, mysql),
                new ResourcesFeature(storage),
                new PromptsFeature());

        /*
         * O que faz: cria o conversor JSON usado no transporte STDIO.
         * Por que esta aqui: o protocolo MCP troca mensagens estruturadas em JSON entre o Cliente 01 e o servidor.
         * Componentes: `JsonMapper` e adaptado pelo `JacksonMcpJsonMapper` para o SDK MCP.
         */
        JacksonMcpJsonMapper jsonMapper = new JacksonMcpJsonMapper(new JsonMapper());
        /*
         * O que faz: cria o provedor de transporte STDIO.
         * Por que esta aqui: o Cliente 01 inicia este JAR como processo filho e espera comunicacao MCP pelos fluxos padrao do processo.
         * Componentes: `StdioServerTransportProvider` implementa o transporte STDIO do SDK.
         */
        StdioServerTransportProvider transportProvider = new StdioServerTransportProvider(jsonMapper);

        /*
         * O que faz: declara que este servidor anuncia suporte a Tools, Resources, Prompts e logging.
         * Por que esta aqui: o Cliente 01 consulta essas capacidades durante `initialize` antes de usar `tools/list` e outras operacoes.
         * Componentes: `ServerCapabilities.builder()` cria a declaracao; cada metodo habilita uma familia de recursos.
         */
        ServerCapabilities capabilities = ServerCapabilities.builder()
                .tools(true)
                .resources(false, true)
                .prompts(true)
                .logging()
                .build();

        /*
         * O que faz: identifica o servidor MCP para o cliente.
         * Por que esta aqui: o nome e a versao aparecem durante o handshake e ajudam o professor a comprovar qual servidor foi iniciado.
         * Componentes: `Implementation.builder` recebe nome e versao e `build()` finaliza o objeto.
         */
        Implementation implementation = Implementation.builder("Biblioteca Digital MCP Java - STDIO", "1.0.0").build();

        /*
         * O que faz: cria a especificacao sincrona do servidor sobre o transporte STDIO.
         * Por que esta aqui: este e o ponto equivalente, no servidor novo, ao `McpServer.sync(transportProvider)` do exemplo do professor.
         * Componentes: `McpServer.sync(...)` devolve `SyncSpecification<SingleSessionSyncSpecification>` para configuracao posterior.
         */
        SyncSpecification<SingleSessionSyncSpecification> specification = McpServer.sync(transportProvider);
        /*
         * O que faz: define o nome e a versao do servidor que serao anunciados durante o `initialize`.
         * Por que esta aqui: separar a identificacao da aplicacao das demais capacidades mantem a configuracao legivel e alinhada ao exemplo do professor.
         * Componentes: `serverInfo` recebe a implementacao construida anteriormente.
         */
        specification.serverInfo(implementation);
        /*
         * O que faz: associa as capacidades declaradas a especificacao do servidor.
         * Por que esta aqui: o cliente precisa conhecer os recursos disponiveis antes de tentar lista-los ou executa-los.
         * Componentes: `capabilities` recebe o objeto `ServerCapabilities` preparado acima.
         */
        specification.capabilities(capabilities);

        /*
         * O que faz: percorre todas as Features e registra seus componentes na especificacao STDIO.
         * Por que esta aqui: este laco conecta o novo transporte a logica funcional compartilhada do projeto.
         * Componentes: `for` percorre a lista; `feature.register` adiciona Tools, Resources ou Prompts ao servidor.
         */
        for (McpFeature feature : features) {
            feature.register(specification);
        }

        /*
         * O que faz: constroi a instancia final do servidor MCP.
         * Por que esta aqui: somente depois de transportar, capacidades e Features estarem configurados o servidor pode comecar a atender o Cliente 01.
         * Componentes: `build()` transforma a especificacao em `McpSyncServer`.
         */
        return specification.build();
    }

    /*
     * O que faz: cria o servidor e guarda a instancia resultante.
     * Por que esta aqui: manter a construcao separada do `main` facilita leitura, teste e encerramento controlado.
     * Componentes: o construtor chama `createServer()` e o operador `this` grava o resultado no atributo da classe.
     */
    public McpServer01SyncStdio() throws Exception {
        this.server = createServer();
        System.err.println("MCP Server 01 da Biblioteca Digital iniciado via STDIO.");
    }

    /*
     * O que faz: fecha o servidor MCP de forma segura quando o processo termina.
     * Por que esta aqui: liberar o transporte e os recursos associados evita deixar o processo ou canais abertos desnecessariamente.
     * Componentes: `closeGracefully()` pede ao SDK um encerramento ordenado.
     */
    private void close() {
        try {
            server.closeGracefully();
        }
        catch (Exception exception) {
            System.err.println("Erro ao fechar o servidor STDIO: " + exception.getMessage());
        }
    }

    /*
     * O que faz: cria o objeto servidor e registra uma rotina de encerramento da JVM.
     * Por que esta aqui: o Cliente 01 inicia este metodo como processo separado; o hook garante limpeza quando a JVM receber sinal de termino.
     * Componentes: `main` e o ponto de entrada do Java; `Runtime.getRuntime().addShutdownHook` registra uma thread de limpeza.
     */
    public static void main(String[] args) throws Exception {
        /*
         * O que faz: constroi o servidor STDIO e, junto disso, registra as Tools, Resources e Prompts.
         * Por que esta aqui: esta e a primeira operacao necessaria quando o Cliente 01 iniciar o processo.
         * Componentes: `new McpServer01SyncStdio()` chama o construtor da classe e mantem o servidor pronto para receber mensagens.
         */
        McpServer01SyncStdio server = new McpServer01SyncStdio();
        /*
         * O que faz: registra uma rotina executada automaticamente quando a JVM estiver sendo encerrada.
         * Por que esta aqui: fechar o servidor mesmo quando o processo for finalizado pelo Cliente 01 ou pelo sistema operacional.
         * Componentes: `Runtime` representa a JVM atual; `addShutdownHook` associa uma thread ao encerramento.
         */
        Runtime.getRuntime().addShutdownHook(new Thread(server::close));
    }
}
