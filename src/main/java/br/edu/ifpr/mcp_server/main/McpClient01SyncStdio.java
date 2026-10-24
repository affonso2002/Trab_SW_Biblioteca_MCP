/*
 * O que faz: declara que esta classe pertence ao pacote usado pelo Cliente 01 do professor.
 * Por que esta aqui: manter o nome e o pacote esperados pelo perfil Maven facilita executar o cliente sem alterar a estrutura didatica fornecida.
 * Componentes: `package` define o namespace da classe dentro do projeto Java.
 */
package br.edu.ifpr.mcp_server.main;

/*
 * O que faz: importa a classe `File` usada para verificar e localizar o JAR do servidor.
 * Por que esta aqui: o Cliente 01 precisa iniciar o servidor MCP da Biblioteca Digital como um processo separado.
 * Componentes: `File` representa um arquivo ou diretorio do sistema de arquivos.
 */
import java.io.File;

/*
 * O que faz: importa `LinkedHashMap` para montar os argumentos das Tools preservando a ordem apresentada pelo esquema.
 * Por que esta aqui: a entrada interativa do cliente precisa transformar os valores digitados pelo usuario em um mapa enviado ao servidor.
 * Componentes: `LinkedHashMap` e uma implementacao de `Map` que preserva a ordem de insercao.
 */
import java.util.LinkedHashMap;

/*
 * O que faz: importa a interface `List` para trabalhar com listas de Tools e propriedades obrigatorias.
 * Por que esta aqui: o protocolo MCP devolve colecoes que precisam ser percorridas pelo cliente.
 * Componentes: `List` representa uma sequencia ordenada de elementos.
 */
import java.util.List;

/*
 * O que faz: importa a interface `Map` usada para representar argumentos e esquemas JSON das Tools.
 * Por que esta aqui: o Cliente 01 precisa ler o `inputSchema` de cada Tool e montar os argumentos da chamada.
 * Componentes: `Map` associa chaves a valores.
 */
import java.util.Map;

/*
 * O que faz: importa `Scanner` para ler comandos e parametros digitados no console.
 * Por que esta aqui: o Cliente 01 e interativo e foi projetado para que o professor possa escolher uma Tool e informar seus valores.
 * Componentes: `Scanner` le texto recebido pela entrada padrao.
 */
import java.util.Scanner;

/*
 * O que faz: importa a interface de logging do SLF4J.
 * Por que esta aqui: registrar eventos do Cliente 01 e mensagens recebidas do servidor facilita acompanhar a comunicacao durante o teste.
 * Componentes: `Logger` oferece metodos como `info`, `warn` e `error`.
 */
import org.slf4j.Logger;

/*
 * O que faz: importa a fabrica usada para criar o logger da classe.
 * Por que esta aqui: o logger precisa estar associado ao Cliente 01 para identificar a origem das mensagens.
 * Componentes: `LoggerFactory` cria uma implementacao de `Logger`.
 */
import org.slf4j.LoggerFactory;

/*
 * O que faz: importa a fabrica sincrona do cliente MCP.
 * Por que esta aqui: o projeto utiliza comunicacao MCP sincrona, seguindo o mesmo modelo do exemplo fornecido pelo professor.
 * Componentes: `McpClient` oferece o metodo `sync(...)` para criar um cliente sincrono.
 */
import io.modelcontextprotocol.client.McpClient;

/*
 * O que faz: importa a interface concreta do cliente MCP sincrono.
 * Por que esta aqui: esta referencia e usada para inicializar, listar Tools, executar chamadas e fechar a conexao.
 * Componentes: `McpSyncClient` representa o cliente pronto para trocar mensagens MCP.
 */
import io.modelcontextprotocol.client.McpSyncClient;

/*
 * O que faz: importa o builder dos parametros usados para iniciar o processo servidor.
 * Por que esta aqui: o Cliente 01 precisa executar `java -jar` sobre o JAR STDIO gerado pelo perfil `server` do nosso projeto.
 * Componentes: `ServerParameters` descreve o executavel e os argumentos do processo filho.
 */
import io.modelcontextprotocol.client.transport.ServerParameters;

/*
 * O que faz: importa o transporte de cliente baseado em STDIO.
 * Por que esta aqui: o segundo criterio da avaliacao exige que o Cliente 01 se comunique com o servidor por STDIO.
 * Componentes: `StdioClientTransport` liga o cliente MCP aos canais padrao do processo servidor.
 */
import io.modelcontextprotocol.client.transport.StdioClientTransport;

/*
 * O que faz: importa o adaptador Jackson usado para converter as mensagens MCP em JSON.
 * Por que esta aqui: o protocolo troca estruturas JSON entre o Cliente 01 e o servidor.
 * Componentes: `JacksonMcpJsonMapper` integra o JSON do Jackson ao SDK MCP.
 */
import io.modelcontextprotocol.json.jackson3.JacksonMcpJsonMapper;

/*
 * O que faz: importa a requisicao utilizada para chamar uma Tool.
 * Por que esta aqui: depois de escolher uma ferramenta e seus argumentos, o cliente precisa montar uma chamada MCP formal.
 * Componentes: `CallToolRequest` representa a operacao `tools/call` do protocolo.
 */
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;

/*
 * O que faz: importa o resultado devolvido pelo servidor depois de uma chamada de Tool.
 * Por que esta aqui: o cliente precisa mostrar ao usuario o resultado ou eventual erro da execucao.
 * Componentes: `CallToolResult` contem conteudo textual/estruturado e o indicador de erro.
 */
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;

/*
 * O que faz: importa o resultado da operacao que lista as Tools disponiveis.
 * Por que esta aqui: o menu do Cliente 01 e construido dinamicamente a partir do que o servidor anuncia.
 * Componentes: `ListToolsResult` contem a lista de `Tool` retornada pelo servidor.
 */
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;

/*
 * O que faz: importa o enum usado para definir o nivel de logging solicitado ao servidor.
 * Por que esta aqui: manter o comportamento de observabilidade do Cliente 01 alinhado ao exemplo do professor.
 * Componentes: `LoggingLevel.INFO` solicita mensagens de informacao ou superiores.
 */
import io.modelcontextprotocol.spec.McpSchema.LoggingLevel;

/*
 * O que faz: importa a estrutura das notificacoes de logging recebidas do servidor.
 * Por que esta aqui: o cliente registra essas mensagens para que a comunicacao possa ser acompanhada durante a demonstracao.
 * Componentes: `LoggingMessageNotification` contem origem, nivel e dados da mensagem.
 */
import io.modelcontextprotocol.spec.McpSchema.LoggingMessageNotification;

/*
 * O que faz: importa o modelo que representa uma Tool anunciada pelo servidor.
 * Por que esta aqui: o cliente precisa exibir a lista, identificar a selecao e ler o esquema de argumentos.
 * Componentes: `Tool` contem nome, descricao e `inputSchema`.
 */
import io.modelcontextprotocol.spec.McpSchema.Tool;

/*
 * O que faz: importa o `JsonMapper` do Jackson 3 usado pelo adaptador MCP.
 * Por que esta aqui: fornecer ao `JacksonMcpJsonMapper` um conversor concreto para as mensagens JSON.
 * Componentes: `JsonMapper` transforma objetos Java em JSON e JSON em objetos Java.
 */
import tools.jackson.databind.json.JsonMapper;

/*
 * O que faz: declara a classe do Cliente 01 usada para testar o servidor MCP da Biblioteca Digital.
 * Por que esta aqui: esta classe e a ponte entre o processo interativo do professor e as Tools do servidor.
 * Componentes: a classe concentra somente a comunicacao do cliente; a logica de negocio continua no servidor.
 */
public class McpClient01SyncStdio {
   /*
    * O que faz: cria o logger associado a classe do Cliente 01.
    * Por que esta aqui: permitir registrar as etapas de inicializacao, chamadas e encerramento sem misturar mensagens tecnicas com o fluxo de dados MCP em stdout.
    * Componentes: `LoggerFactory.getLogger(...)` cria o objeto de logging; `private static final` mantem uma unica referencia imutavel por classe.
    */
   private static final Logger LOG =
                            LoggerFactory.getLogger(McpClient01SyncStdio.class);

   /*
    * O que faz: informa o caminho relativo do JAR do servidor STDIO que sera iniciado pelo Cliente 01.
    * Por que esta aqui: o perfil `server` do nosso POM gera exatamente `target/dist-server/mcp_server01_server.jar`, e o JAR do cliente fica em `target/dist-client`, tornando este caminho relativo compativel com a estrutura de entrega.
    * Componentes: `String` guarda o caminho relativo `../dist-server/mcp_server01_server.jar`, que parte de `target/dist-client` e aponta para o JAR do servidor na pasta irma `target/dist-server`.
    */
   private static final String SERVER_PATH =
                                         "../dist-server/mcp_server01_server.jar";

   /*
    * O que faz: guarda o objeto cliente MCP que sera usado por todos os metodos de comunicacao.
    * Por que esta aqui: manter uma unica conexao facilita executar varias Tools durante a mesma sessao do Cliente 01.
    * Componentes: `McpSyncClient` representa a conexao sincrona pronta para `initialize`, `listTools` e `callTool`.
    */
   private final McpSyncClient client;

   /*
    * O que faz: recebe uma notificacao de logging enviada pelo servidor e registra seus dados no console de log.
    * Por que esta aqui: o servidor da Biblioteca Digital pode enviar mensagens durante a execucao das Tools, e o Cliente 01 deve conseguir observa-las sem alterar o protocolo.
    * Componentes: `LoggingMessageNotification` entrega logger, nivel e mensagem; `LOG.info(...)` grava esses tres valores.
    */
   private void loggingMessageNotification(
                                      LoggingMessageNotification notification) {
      /*
       * O que faz: registra a origem, o nivel e o conteudo da notificacao MCP.
       * Por que esta aqui: deixar visivel o que o servidor comunica durante a execucao ajuda a comprovar a comunicacao cliente-servidor.
       * Componentes: os `{}` sao marcadores do SLF4J; os argumentos seguintes preenchem esses marcadores.
       */
      LOG.info("[NOTIFICACAO MCP] Origem: {} | Nivel: {} | Mensagem: {}",
               notification.logger(),
               notification.level(),
               notification.data());
   }

   /*
    * O que faz: cria e devolve o Cliente MCP configurado para falar com o servidor da Biblioteca Digital por STDIO.
    * Por que esta aqui: concentrar toda a montagem do transporte em um metodo torna explicito onde a comunicacao e preparada.
    * Componentes: `File`, `ServerParameters`, `JacksonMcpJsonMapper`, `StdioClientTransport` e `McpClient.sync(...)` formam o caminho completo ate o servidor.
    */
   private McpSyncClient createClient() {
      /*
       * O que faz: transforma o caminho relativo do servidor em um objeto de arquivo.
       * Por que esta aqui: validar o JAR antes de criar o processo evita uma falha menos clara mais adiante.
       * Componentes: `File` representa o caminho armazenado na constante `SERVER_PATH`.
       */
      File serverJar = new File(SERVER_PATH);

      /*
       * O que faz: interrompe a criacao do cliente quando o JAR do servidor nao existe como arquivo.
       * Por que esta aqui: o Cliente 01 so pode iniciar a comunicacao depois que o servidor STDIO puder ser localizado.
       * Componentes: `isFile()` verifica a existencia de um arquivo; `IllegalStateException` sinaliza configuracao invalida.
       */
      if (!serverJar.isFile())
         /*
          * O que faz: lanca a mensagem de erro mostrando o caminho absoluto que o cliente tentou usar.
          * Por que esta aqui: tornar o diagnostico imediato caso os perfis Maven tenham sido executados em ordem incorreta.
          * Componentes: `getAbsolutePath()` transforma o caminho relativo em uma localizacao completa para facilitar a correcao.
          */
         throw new IllegalStateException("JAR do servidor nao encontrado: " +
                                         serverJar.getAbsolutePath());

      /*
       * O que faz: obtem o caminho absoluto do JAR servidor.
       * Por que esta aqui: o processo filho precisa receber uma localizacao inequivoca do executavel.
       * Componentes: `getAbsolutePath()` resolve o caminho a partir da pasta corrente do Cliente 01.
       */
      String jarPath = serverJar.getAbsolutePath();

      /*
       * O que faz: registra qual JAR do servidor sera iniciado.
       * Por que esta aqui: deixar o caminho visivel facilita conferir que o Cliente 01 esta conectado ao servidor correto da Biblioteca Digital.
       * Componentes: `LOG.info` registra uma mensagem informativa.
       */
      LOG.info("Servidor MCP da Biblioteca Digital: {}", jarPath);

      /*
       * O que faz: localiza a raiz do projeto a partir da pasta de distribuicao do JAR servidor.
       * Por que esta aqui: o servidor iniciado pelo Cliente 01 precisa usar a pasta `data` da raiz do projeto, mesmo quando o cliente e executado dentro de `target/dist-client`.
       * Componentes: os tres `getParentFile()` sobem de `dist-server` para `target` e depois para a raiz do projeto.
       */
      File projectDir = serverJar.getAbsoluteFile().getParentFile()
                                  .getParentFile().getParentFile();

      /*
       * O que faz: escolhe a pasta de dados que sera informada ao processo servidor.
       * Por que esta aqui: respeitar primeiro a propriedade JVM e depois a variavel de ambiente `APP_DATA_DIR`; sem configuracao explicita, usar a pasta `data` da raiz do projeto.
       * Componentes: `System.getProperty` consulta a propriedade JVM; `System.getenv` consulta o ambiente herdado; `File` representa o caminho escolhido.
       */
      String configuredDataDir = System.getProperty("APP_DATA_DIR");
      if (configuredDataDir == null || configuredDataDir.isBlank())
         configuredDataDir = System.getenv("APP_DATA_DIR");
      File dataDirectory = configuredDataDir == null || configuredDataDir.isBlank()
            ? new File(projectDir, "data")
            : new File(configuredDataDir);

      /*
       * O que faz: monta os parametros para executar o comando `java -jar <jarPath>` e define `APP_DATA_DIR` no processo filho.
       * Por que esta aqui: o Cliente 01 inicia o servidor MCP como processo filho e precisa garantir que ele encontre os arquivos de exemplo na pasta de dados correta.
       * Componentes: `args` define os argumentos; `addEnvVar` informa o caminho absoluto de dados; `build()` finaliza a configuracao.
       */
      ServerParameters params = ServerParameters.builder("java")
                                                .args("-jar", jarPath)
                                                .addEnvVar("APP_DATA_DIR", dataDirectory.getAbsolutePath())
                                                .build();

      /*
       * O que faz: cria o conversor JSON que sera usado nas mensagens MCP.
       * Por que esta aqui: o transporte STDIO precisa serializar e desserializar as estruturas do protocolo.
       * Componentes: `JsonMapper` fornece o mecanismo JSON; `JacksonMcpJsonMapper` adapta esse mecanismo ao SDK MCP.
       */
      JacksonMcpJsonMapper jsonMapper = new JacksonMcpJsonMapper(
                                                              new JsonMapper());

      /*
       * O que faz: cria o transporte de cliente baseado em STDIO usando os parametros e o conversor JSON ja preparados.
       * Por que esta aqui: este e o canal que efetivamente conecta o Cliente 01 ao processo servidor iniciado pelo Java.
       * Componentes: `StdioClientTransport` encaminha mensagens MCP pelos fluxos padrao do processo.
       */
      StdioClientTransport transport = new StdioClientTransport(params,
                                                                   jsonMapper);

      /*
       * O que faz: direciona o stderr do processo servidor para o logger do Cliente 01.
       * Por que esta aqui: o servidor STDIO deve manter stdout reservado as mensagens do protocolo MCP, enquanto mensagens humanas podem ser observadas pelo canal de erro.
       * Componentes: `setStdErrorHandler(...)` recebe uma funcao que registra cada linha em `[SERVER STDERR]`.
       */
      transport.setStdErrorHandler(
                                   line -> LOG.info("[SERVER STDERR] {}", line)
                                  );

      /*
       * O que faz: cria o cliente MCP sincrono sobre o transporte STDIO e configura o listener de logging.
       * Por que esta aqui: depois deste ponto, os metodos da classe podem executar `initialize`, `listTools` e `callTool`.
       * Componentes: `McpClient.sync(transport)` cria a configuracao sincrona; `loggingConsumer(...)` registra o metodo que recebe notificacoes; `build()` produz o cliente final.
       */
      return McpClient.sync(transport)
                      .loggingConsumer(this::loggingMessageNotification)
                      .build();
   }

   /*
    * O que faz: inicializa a sessao MCP e inicia o menu interativo do Cliente 01.
    * Por que esta aqui: separar a entrada em operacao da construcao do cliente deixa o fluxo de inicializacao claro e testavel.
    * Componentes: `initialize()` negocia a sessao MCP; `setLoggingLevel(...)` solicita logging; `listSelectRunToolLooping()` inicia a interacao com as Tools.
    */
   private void execute() {
      /*
       * O que faz: executa a inicializacao do protocolo MCP com o servidor.
       * Por que esta aqui: nenhuma operacao de lista ou chamada de Tool deve ocorrer antes de a sessao estar estabelecida.
       * Componentes: `initialize()` envia a negociacao inicial e prepara o cliente para as operacoes seguintes.
       */
      client.initialize();

      /*
       * O que faz: define INFO como nivel minimo de logging desejado pelo Cliente 01.
       * Por que esta aqui: receber mensagens uteis do servidor durante a demonstracao sem solicitar niveis mais detalhados desnecessariamente.
       * Componentes: `LoggingLevel.INFO` e um valor do enum `LoggingLevel`.
       */
      client.setLoggingLevel(LoggingLevel.INFO);

      /*
       * O que faz: inicia o ciclo que lista, seleciona e executa as Tools anunciadas pelo servidor.
       * Por que esta aqui: este e o fluxo principal do Cliente 01 exigido para demonstrar comunicacao funcional com o servidor.
       * Componentes: `listSelectRunToolLooping()` concentra o menu, leitura de argumentos, chamada da Tool e exibicao do resultado.
       */
      listSelectRunToolLooping();
   }

   /*
    * O que faz: encerra o cliente MCP de forma ordenada.
    * Por que esta aqui: fechar a sessao corretamente libera os recursos do transporte e evita processos ou canais deixados abertos.
    * Componentes: `closeGracefully()` solicita ao SDK um encerramento limpo.
    */
   private void close() {
      /*
       * O que faz: registra que o encerramento da sessao comecou.
       * Por que esta aqui: facilitar a leitura do console durante a demonstracao.
       * Componentes: `LOG.info` envia uma mensagem de informacao.
       */
      LOG.info("Fechando Cliente 01 MCP...");

      /*
       * O que faz: fecha a sessao MCP de maneira controlada.
       * Por que esta aqui: liberar recursos do Cliente 01 e do transporte STDIO ao terminar a execucao.
       * Componentes: `closeGracefully()` e a operacao de encerramento oferecida por `McpSyncClient`.
       */
      client.closeGracefully();

      /*
       * O que faz: registra que o cliente foi encerrado.
       * Por que esta aqui: fornecer uma evidencia simples de que a sessao terminou corretamente.
       * Componentes: `LOG.info` registra a mensagem final.
       */
      LOG.info("Cliente 01 MCP fechado.");
   }

   /*
    * O que faz: mantem o menu interativo em funcionamento ate o usuario escolher sair.
    * Por que esta aqui: permitir demonstrar mais de uma Tool sem reiniciar o processo do Cliente 01 a cada chamada.
    * Componentes: `Scanner` le a entrada; `loadTools` obtem Tools; `while` mantem o ciclo; `selectTool` encontra a selecao; `executeTool` realiza a chamada.
    */
   private void listSelectRunToolLooping() {
      /*
       * O que faz: cria um leitor para os comandos digitados no console.
       * Por que esta aqui: o Cliente 01 deve receber os nomes/numeros de Tools e seus argumentos pela entrada padrao.
       * Componentes: `Scanner(System.in)` liga a leitura a entrada padrao do processo.
       */
      Scanner scanner = new Scanner(System.in);

      /*
       * O que faz: solicita ao servidor a lista atualizada de Tools.
       * Por que esta aqui: o menu precisa refletir exatamente as funcionalidades disponibilizadas pela Biblioteca Digital naquele momento.
       * Componentes: `loadTools()` usa `client.listTools()` para consultar o servidor.
       */
      ListToolsResult tools = loadTools();

      /*
       * O que faz: mantem o menu ativo ate encontrar uma condicao explicita de encerramento.
       * Por que esta aqui: uma sessao interativa do Cliente 01 precisa permitir varias chamadas consecutivas.
       * Componentes: `while (true)` repete o bloco ate que `break` encerre o laco.
       */
      while (true) {
         /*
          * O que faz: mostra as Tools disponiveis e os comandos de controle.
          * Por que esta aqui: o usuario precisa visualizar as opcoes antes de escolher uma operacao.
          * Componentes: `showMenu` percorre e exibe os dados devolvidos pelo servidor.
          */
         showMenu(tools);

         /*
          * O que faz: mostra o marcador usado para receber um comando.
          * Por que esta aqui: indicar visualmente onde o usuario deve digitar a proxima acao.
          * Componentes: `System.out.print` escreve sem quebrar a linha.
          */
         System.out.print("> ");

         /*
          * O que faz: encerra o menu quando a entrada padrao nao possui mais linhas.
          * Por que esta aqui: impedir que o laco tente ler uma entrada inexistente em execucao redirecionada ou finalizada.
          * Componentes: `hasNextLine()` verifica se ainda existe entrada; `break` encerra o laco.
          */
         if (!scanner.hasNextLine())
            break;

         /*
          * O que faz: le o comando digitado e remove espacos das extremidades.
          * Por que esta aqui: aceitar entradas como ` 1 ` sem tratar os espacos como parte do comando.
          * Componentes: `nextLine()` le a linha; `trim()` remove espacos nas extremidades.
          */
         String command = scanner.nextLine().trim();

         /*
          * O que faz: ignora entradas vazias e volta ao inicio do menu.
          * Por que esta aqui: uma linha vazia nao representa uma Tool ou comando valido.
          * Componentes: `isBlank()` identifica texto vazio ou formado apenas por espacos; `continue` reinicia o laco.
          */
         if (command.isBlank())
            continue;

         /*
          * O que faz: encerra a sessao quando o usuario digita `sair`.
          * Por que esta aqui: oferecer um comando simples e independente da quantidade de Tools disponiveis.
          * Componentes: `equalsIgnoreCase` aceita maiusculas/minusculas; `break` termina o laco.
          */
         if ("sair".equalsIgnoreCase(command))
            break;

         /*
          * O que faz: atualiza a lista de Tools quando o usuario solicita `listar`.
          * Por que esta aqui: permitir que o cliente reconheca alteracoes no conjunto de Tools sem reiniciar a aplicacao.
          * Componentes: `loadTools()` chama novamente `tools/list`; `continue` volta ao menu com a nova lista.
          */
         if ("listar".equalsIgnoreCase(command)) {
            tools = loadTools();
            continue;
         }

         /*
          * O que faz: tenta encontrar a Tool escolhida pelo numero ou pelo nome digitado.
          * Por que esta aqui: o Cliente 01 precisa transformar a entrada humana em uma Tool real do protocolo MCP.
          * Componentes: `selectTool(...)` consulta a lista recebida em `ListToolsResult`.
          */
         Tool selectedTool = selectTool(tools.tools(), command);

         /*
          * O que faz: informa quando a selecao nao corresponde a nenhuma Tool disponivel e volta ao menu.
          * Por que esta aqui: evitar chamar o servidor com um nome que ele nao anunciou.
          * Componentes: `selectedTool == null` identifica a falha de busca; `LOG.warn` registra o aviso; `continue` reinicia o ciclo.
          */
         if (selectedTool == null) {
            LOG.warn("Ferramenta nao encontrada: {}", command);
            continue;
         }

         /*
          * O que faz: executa a Tool selecionada e coleta os argumentos que o servidor declarou no `inputSchema`.
          * Por que esta aqui: este e o ponto em que a escolha feita no menu se transforma em uma chamada MCP real.
          * Componentes: `executeTool` le parametros, monta `CallToolRequest` e usa `client.callTool(...)`.
          */
         executeTool(selectedTool, scanner);
      }
   }

   /*
    * O que faz: solicita ao servidor a lista de Tools disponiveis e registra a quantidade recebida.
    * Por que esta aqui: centralizar `tools/list` evita repetir o mesmo codigo em diferentes pontos do Cliente 01.
    * Componentes: `client.listTools()` envia a operacao MCP; `result.tools().size()` conta as Tools anunciadas.
    */
   private ListToolsResult loadTools() {
      /*
       * O que faz: chama `tools/list` no servidor MCP e guarda o resultado.
       * Por que esta aqui: obter a fonte oficial das ferramentas que o Cliente 01 pode executar.
       * Componentes: `listTools()` retorna `ListToolsResult`.
       */
      ListToolsResult result = client.listTools();

      /*
       * O que faz: registra quantas Tools o servidor da Biblioteca Digital disponibilizou.
       * Por que esta aqui: servir como evidencia rapida durante o teste de que o cliente realmente recebeu o catalogo de Tools.
       * Componentes: `tools()` devolve a lista e `size()` informa sua quantidade.
       */
      LOG.info("Servidor disponibilizou {} ferramenta(s).", result.tools().size());

      /*
       * O que faz: devolve ao metodo chamador a lista de Tools obtida.
       * Por que esta aqui: permitir que o menu e a selecao trabalhem com o resultado do servidor.
       * Componentes: `return` entrega o objeto `ListToolsResult`.
       */
      return result;
   }

   /*
    * O que faz: apresenta as Tools e os comandos de controle no terminal.
    * Por que esta aqui: tornar a execucao do Cliente 01 simples para demonstracao e teste pelo professor.
    * Componentes: `System.out` escreve no console; o laco `for` percorre a lista; `Tool` fornece nome e descricao.
    */
   private void showMenu(ListToolsResult tools) {
      /*
       * O que faz: imprime uma linha em branco para separar visualmente a nova rodada do menu.
       * Por que esta aqui: melhorar a leitura do console durante varias chamadas de Tools.
       * Componentes: `println()` escreve uma quebra de linha.
       */
      System.out.println();

      /*
       * O que faz: imprime o titulo visual do Cliente 01.
       * Por que esta aqui: deixar explicito que o usuario esta operando o cliente e nao o servidor diretamente.
       * Componentes: `println(...)` envia o texto para stdout.
       */
      System.out.println("========================================");

      /*
       * O que faz: identifica o programa em execucao como Cliente 01 da Biblioteca Digital.
       * Por que esta aqui: facilitar a comprovacao visual do segundo criterio da avaliacao.
       * Componentes: `println(...)` escreve o rotulo.
       */
      System.out.println(" CLIENTE 01 - BIBLIOTECA DIGITAL MCP");

      /*
       * O que faz: imprime a linha de fechamento do cabecalho.
       * Por que esta aqui: completar a separacao visual do menu.
       * Componentes: `println(...)` escreve a linha.
       */
      System.out.println("========================================");

      /*
       * O que faz: informa quando o servidor nao anunciou nenhuma Tool.
       * Por que esta aqui: deixar explicito um estado valido do protocolo em vez de mostrar um menu vazio sem explicacao.
       * Componentes: `tools.tools().isEmpty()` testa se a lista esta vazia.
       */
      if (tools.tools().isEmpty()) {
         /*
          * O que faz: informa no console que nao existem Tools disponiveis.
          * Por que esta aqui: esclarecer ao usuario por que nao ha opcoes numeradas para selecionar.
          * Componentes: `println(...)` mostra a mensagem.
          */
         System.out.println("Nenhuma ferramenta disponibilizada.");
      }
      /*
       * O que faz: entra no caminho normal quando o servidor devolveu uma ou mais Tools.
       * Por que esta aqui: apresentar as opcoes que o Cliente 01 realmente recebeu do servidor.
       * Componentes: `else` executa apenas quando a condicao anterior for falsa.
       */
      else {
         /*
          * O que faz: imprime o titulo da lista de Tools.
          * Por que esta aqui: separar as opcoes funcionais das instrucoes de controle.
          * Componentes: `println(...)` escreve o texto.
          */
         System.out.println("Ferramentas disponiveis:");

         /*
          * O que faz: percorre todas as Tools recebidas e atribui um numero visual para cada uma.
          * Por que esta aqui: permitir selecao simples por numero e manter a ordem devolvida pelo servidor.
          * Componentes: `for` repete o bloco; `i` e o indice da lista.
          */
         for (int i = 0; i < tools.tools().size(); i++) {
            /*
             * O que faz: recupera a Tool correspondente a posicao atual da lista.
             * Por que esta aqui: os proximos comandos precisam do nome e da descricao daquele item.
             * Componentes: `get(i)` acessa o elemento pelo indice.
             */
            Tool tool = tools.tools().get(i);

            /*
             * O que faz: mostra o numero da opcao e o nome da Tool.
             * Por que esta aqui: fornecer ao usuario a informacao minima para escolher uma operacao.
             * Componentes: `%d` representa o numero; `%s` representa o nome; `%n` quebra a linha; `printf` substitui os valores.
             */
            System.out.printf(" %d - %s%n", i + 1, tool.name());

            /*
             * O que faz: verifica se a Tool possui descricao antes de imprimi-la.
             * Por que esta aqui: evitar mostrar uma linha vazia quando o servidor nao enviou descricao.
             * Componentes: a primeira condicao testa `null`; `isBlank()` ignora textos vazios ou so com espacos.
             */
            if (tool.description() != null && !tool.description().isBlank())
               /*
                * O que faz: mostra a descricao da Tool logo abaixo do nome.
                * Por que esta aqui: ajudar o usuario a escolher a operacao correta sem precisar conhecer os detalhes internos da implementacao.
                * Componentes: `printf` usa `%s` para inserir o texto da descricao.
                */
               System.out.printf(" %s%n", tool.description());
         }
      }

      /*
       * O que faz: adiciona espacamento antes dos comandos gerais do cliente.
       * Por que esta aqui: separar as Tools das opcoes de controle.
       * Componentes: `println()` escreve uma quebra de linha.
       */
      System.out.println();

      /*
       * O que faz: imprime o titulo das opcoes de controle.
       * Por que esta aqui: distinguir comandos `listar` e `sair` das Tools.
       * Componentes: `println(...)` escreve o texto.
       */
      System.out.println("Comandos:");

      /*
       * O que faz: documenta o comando que atualiza a lista de Tools.
       * Por que esta aqui: ensinar ao usuario como solicitar novamente `tools/list`.
       * Componentes: `println(...)` mostra a instrucao.
       */
      System.out.println(" listar - atualizar lista de ferramentas");

      /*
       * O que faz: documenta o comando que encerra o Cliente 01.
       * Por que esta aqui: oferecer uma saida controlada da sessao interativa.
       * Componentes: `println(...)` mostra a instrucao.
       */
      System.out.println(" sair - encerrar o cliente");

      /*
       * O que faz: adiciona o espacamento final do menu.
       * Por que esta aqui: deixar o prompt seguinte visualmente separado das instrucoes anteriores.
       * Componentes: `println()` escreve uma quebra de linha.
       */
      System.out.println();
   }

   /*
    * O que faz: localiza uma Tool pelo numero mostrado no menu ou pelo nome informado pelo usuario.
    * Por que esta aqui: converter uma entrada simples do console em um objeto `Tool` do protocolo MCP.
    * Componentes: `Integer.parseInt` trata a opcao numerica; o laco `for` trata o nome textual.
    */
   private Tool selectTool(List<Tool> tools, String command) {
      /*
       * O que faz: tenta interpretar o comando como numero da opcao exibida no menu.
       * Por que esta aqui: a forma mais simples de selecionar uma Tool e digitar seu numero.
       * Componentes: `try` delimita a tentativa de conversao e permite tratar uma entrada nao numerica sem encerrar o cliente.
       */
      try {
         /*
          * O que faz: converte o texto para inteiro e subtrai um para ajustar ao indice iniciado em zero.
          * Por que esta aqui: o menu mostra 1, 2, 3..., enquanto `List` usa posicoes 0, 1, 2....
          * Componentes: `Integer.parseInt` converte o texto; `- 1` adapta a numeracao humana ao indice Java.
          */
         int index = Integer.parseInt(command) - 1;

         /*
          * O que faz: verifica se o indice esta dentro da lista e, quando esta, devolve a Tool correspondente.
          * Por que esta aqui: evitar `IndexOutOfBoundsException` para uma opcao inexistente.
          * Componentes: as duas comparacoes garantem limite inferior e superior; `return` entrega a Tool encontrada.
          */
         if (index >= 0 && index < tools.size())
            return tools.get(index);
      }
      /*
       * O que faz: trata o caso em que o comando nao e um numero.
       * Por que esta aqui: o Cliente 01 tambem permite selecionar uma Tool pelo nome, entao uma entrada textual nao deve ser considerada erro fatal.
       * Componentes: `NumberFormatException` e lancada por `Integer.parseInt` quando o texto nao representa um inteiro; o bloco vazio indica que a busca por nome continuara.
       */
      catch (NumberFormatException ignored) {
         /*
          * O que faz: mantem o fluxo sem interromper o cliente quando a entrada nao era numerica.
          * Por que esta aqui: a proxima etapa tentara exatamente o formato textual desejado.
          * Componentes: o bloco vazio representa um tratamento intencional; `ignored` deixa explicito que a excecao nao e necessaria para a busca por nome.
          */
      }

      /*
       * O que faz: percorre as Tools procurando uma com o mesmo nome informado pelo usuario.
       * Por que esta aqui: permitir selecao pelo identificador textual definido no protocolo MCP.
       * Componentes: `for` percorre a lista; `equalsIgnoreCase` ignora diferenca entre maiusculas e minusculas.
       */
      for (Tool tool : tools)
         /*
          * O que faz: devolve imediatamente a Tool quando seu nome corresponde ao comando.
          * Por que esta aqui: nao e necessario continuar procurando depois de encontrar uma correspondencia.
          * Componentes: `tool.name()` fornece o identificador anunciado pelo servidor; `return` encerra o metodo.
          */
         if (tool.name().equalsIgnoreCase(command))
            return tool;

      /*
       * O que faz: devolve `null` quando nenhuma Tool correspondeu a entrada.
       * Por que esta aqui: o chamador usa esse valor para mostrar um aviso e retornar ao menu sem tentar uma chamada invalida.
       * Componentes: `null` representa a ausencia de objeto encontrado.
       */
      return null;
   }

   /*
    * O que faz: prepara e executa a Tool selecionada, coletando os argumentos definidos pelo servidor.
    * Por que esta aqui: concentrar em um unico metodo o caminho completo desde a selecao ate o resultado `CallToolResult`.
    * Componentes: `readArguments` le o esquema; `CallToolRequest.builder(...)` monta a chamada; `client.callTool(...)` envia a requisicao.
    */
   private void executeTool(Tool tool, Scanner scanner) {
      /*
       * O que faz: separa visualmente a execucao de uma nova Tool.
       * Por que esta aqui: facilitar a leitura dos resultados durante a demonstracao.
       * Componentes: `println()` escreve uma quebra de linha.
       */
      System.out.println();

      /*
       * O que faz: imprime a linha superior da area de execucao.
       * Por que esta aqui: destacar o inicio da chamada escolhida.
       * Componentes: `println(...)` escreve o separador.
       */
      System.out.println("----------------------------------------");

      /*
       * O que faz: mostra o nome da Tool que sera executada.
       * Por que esta aqui: deixar claro para o usuario e para o professor qual operacao sera chamada.
       * Componentes: concatenacao `+` junta o texto fixo ao nome devolvido pelo servidor.
       */
      System.out.println("Ferramenta: " + tool.name());

      /*
       * O que faz: mostra a descricao quando o servidor informou esse texto.
       * Por que esta aqui: contextualizar a operacao antes da entrada dos parametros.
       * Componentes: `!= null` evita imprimir um valor inexistente.
       */
      if (tool.description() != null)
         /*
          * O que faz: imprime a descricao da Tool.
          * Por que esta aqui: ajudar o usuario a confirmar que selecionou a operacao certa.
          * Componentes: `println(...)` escreve o conteudo no console.
          */
         System.out.println("Descricao: " + tool.description());

      /*
       * O que faz: le os parametros da Tool a partir do esquema JSON anunciado pelo servidor.
       * Por que esta aqui: evitar que o Cliente 01 tenha que conhecer antecipadamente os argumentos especificos de cada Tool da Biblioteca Digital.
       * Componentes: `readArguments` devolve um `Map<String,Object>` compativel com a chamada MCP.
       */
      Map<String, Object> arguments = readArguments(tool, scanner);

      /*
       * O que faz: constroi a requisicao `tools/call` usando o nome da Tool e os argumentos coletados.
       * Por que esta aqui: transformar os dados do console no objeto formal que o SDK envia ao servidor.
       * Componentes: `CallToolRequest.builder(tool.name())` inicia a requisicao; `arguments(...)` associa os parametros; `build()` finaliza.
       */
      CallToolRequest request = CallToolRequest.builder(tool.name())
                                                .arguments(arguments)
                                                .build();

      /*
       * O que faz: registra no log qual Tool sera chamada.
       * Por que esta aqui: fornecer uma evidencia adicional de que a selecao chegou ao ponto de comunicacao com o servidor.
       * Componentes: `LOG.info` grava o nome da Tool como parametro estruturado.
       */
      LOG.info("Executando ferramenta '{}'", tool.name());

      /*
       * O que faz: tenta enviar a requisicao ao servidor e recuperar seu resultado.
       * Por que esta aqui: chamadas MCP podem falhar por erro de transporte, parametro ou execucao da Tool e precisam ser tratadas sem derrubar o menu inteiro.
       * Componentes: `try` delimita a operacao que pode lancar excecao.
       */
      try {
         /*
          * O que faz: envia a requisicao `tools/call` e guarda a resposta do servidor.
          * Por que esta aqui: esta e a operacao efetiva que comprova a comunicacao do Cliente 01 com uma Tool da Biblioteca Digital.
          * Componentes: `client.callTool(request)` executa a chamada sincrona e devolve `CallToolResult`.
          */
         CallToolResult result = client.callTool(request);

         /*
          * O que faz: apresenta ao usuario o conteudo textual ou estruturado devolvido pela Tool.
          * Por que esta aqui: demonstrar o resultado real retornado pelo servidor e parte essencial do teste de comunicacao.
          * Componentes: `showResult` interpreta `CallToolResult` e imprime seus campos.
          */
         showResult(result);
      }
      /*
       * O que faz: captura qualquer excecao ocorrida durante a chamada da Tool.
       * Por que esta aqui: manter o Cliente 01 funcionando para novas tentativas mesmo quando uma execucao especifica falhar.
       * Componentes: `Exception` cobre falhas verificadas e de execucao; `LOG.error` registra o contexto e a excecao.
       */
      catch (Exception ex) {
         /*
          * O que faz: registra o erro junto do nome da Tool que falhou.
          * Por que esta aqui: facilitar a identificacao da operacao que precisa ser corrigida durante a validacao.
          * Componentes: o ultimo argumento `ex` permite ao SLF4J registrar tambem a excecao.
          */
         LOG.error("Erro executando ferramenta '{}'", tool.name(), ex);
      }
   }

   /*
    * O que faz: le os parametros declarados no `inputSchema` de uma Tool e devolve os valores preenchidos pelo usuario.
    * Por que esta aqui: o Cliente 01 deve ser generico para conseguir testar as seis Tools da Biblioteca Digital sem codificar um formulario separado para cada uma.
    * Componentes: `LinkedHashMap` guarda os argumentos; `tool.inputSchema()` fornece a definicao; `readArgument` coleta cada valor.
    */
   private Map<String, Object> readArguments(Tool tool, Scanner scanner) {
      /*
       * O que faz: cria o mapa vazio que recebera os argumentos preenchidos.
       * Por que esta aqui: iniciar com uma colecao vazia permite tambem executar Tools que nao exigem parametros.
       * Componentes: `LinkedHashMap` preserva a ordem de insercao e implementa `Map<String,Object>`.
       */
      Map<String, Object> arguments = new LinkedHashMap<>();

      /*
       * O que faz: recupera o esquema JSON que descreve os parametros esperados pela Tool.
       * Por que esta aqui: o cliente precisa descobrir os argumentos dinamicamente, em vez de duplicar essas regras no codigo.
       * Componentes: `inputSchema()` devolve um mapa com propriedades e, quando necessario, itens obrigatorios.
       */
      Map<String, Object> schema = tool.inputSchema();

      /*
       * O que faz: retorna imediatamente o mapa vazio quando o esquema nao existe ou nao possui dados.
       * Por que esta aqui: Tools sem parametros podem ser chamadas sem entrada adicional.
       * Componentes: `null` representa ausencia de esquema; `isEmpty()` verifica o conteudo; `return` encerra o metodo naquele caso.
       */
      if (schema == null || schema.isEmpty())
         return arguments;

      /*
       * O que faz: busca no esquema a parte que contem as propriedades dos parametros.
       * Por que esta aqui: e dentro de `properties` que o cliente encontra nome, tipo e descricao de cada argumento.
       * Componentes: `schema.get("properties")` recupera o valor associado a chave JSON `properties`.
       */
      Object propertiesObject = schema.get("properties");

      /*
       * O que faz: devolve o mapa vazio quando `properties` nao possui a estrutura esperada.
       * Por que esta aqui: proteger o cliente contra um esquema incompleto sem inventar parametros.
       * Componentes: `instanceof Map<?, ?>` verifica em tempo de execucao se o objeto e um mapa.
       */
      if (!(propertiesObject instanceof Map<?, ?>))
         return arguments;

      /*
       * O que faz: converte o objeto de propriedades para um mapa generico e obtem a lista de propriedades obrigatorias.
       * Por que esta aqui: as proximas etapas precisam percorrer os argumentos e saber quais nao podem ficar vazios.
       * Componentes: o cast para `Map<?, ?>` preserva a flexibilidade do esquema JSON; `getRequiredProperties` le a chave `required`.
       */
      Map<?, ?> properties = (Map<?, ?>) propertiesObject;
      List<?> required = getRequiredProperties(schema);

      /*
       * O que faz: retorna o mapa vazio quando nao existem propriedades configuradas.
       * Por que esta aqui: sem propriedades nao ha nada para solicitar ao usuario.
       * Componentes: `isEmpty()` testa a colecao; `return` devolve o mapa ainda vazio.
       */
      if (properties.isEmpty())
         return arguments;

      /*
       * O que faz: apresenta uma mensagem antes de iniciar a entrada dos parametros.
       * Por que esta aqui: avisar ao usuario que a proxima sequencia de perguntas pertence a Tool selecionada.
       * Componentes: `println(...)` escreve no terminal.
       */
      System.out.println();

      /*
       * O que faz: identifica o inicio da coleta de argumentos.
       * Por que esta aqui: melhorar a compreensao do fluxo interativo.
       * Componentes: `println(...)` escreve o texto.
       */
      System.out.println("Informe os parametros:");

      /*
       * O que faz: percorre cada propriedade do esquema e prepara sua entrada.
       * Por que esta aqui: o numero e o conteudo dos parametros variam de Tool para Tool, entao a leitura precisa ser dinamica.
       * Componentes: `Map.Entry` representa chave e valor de uma propriedade.
       */
      for (Map.Entry<?, ?> entry : properties.entrySet()) {
         /*
          * O que faz: transforma a chave do esquema em texto para usar como nome do argumento.
          * Por que esta aqui: o protocolo fornece as chaves JSON de forma generica e o console precisa exibi-las como texto.
          * Componentes: `String.valueOf` converte inclusive valores nao nulos sem exigir cast especifico.
          */
         String name = String.valueOf(entry.getKey());

         /*
          * O que faz: ignora uma propriedade cujo valor nao tenha formato de mapa.
          * Por que esta aqui: a leitura de tipo, descricao e demais detalhes depende de um esquema JSON representado como mapa.
          * Componentes: `instanceof Map<?, ?>` valida a estrutura antes do cast.
          */
         if (!(entry.getValue() instanceof Map<?, ?>))
            continue;

         /*
          * O que faz: obtem o esquema da propriedade atual e extrai seus dados principais.
          * Por que esta aqui: preparar exatamente as informacoes necessarias para perguntar o valor ao usuario.
          * Componentes: `getStringValue` fornece valores padrao; `required.contains(name)` verifica obrigatoriedade; `readArgument` coleta o valor.
          */
         Map<?, ?> property = (Map<?, ?>) entry.getValue();
         String type = getStringValue(property, "type", "string");
         String description = getStringValue(property, "description", "");
         boolean isRequired = required.contains(name);
         Object value = readArgument(scanner, name, type, description,
                                    isRequired, property);

         /*
          * O que faz: adiciona ao mapa somente valores efetivamente fornecidos.
          * Por que esta aqui: parametros opcionais podem ser deixados vazios, e nesse caso nao devem ser enviados sem necessidade.
          * Componentes: `put` grava chave/valor no mapa de argumentos.
          */
         if (value != null)
            arguments.put(name, value);
      }

      /*
       * O que faz: devolve o mapa final de argumentos coletados.
       * Por que esta aqui: `executeTool` precisa desse mapa para construir `CallToolRequest`.
       * Componentes: `return` entrega o objeto ao metodo chamador.
       */
      return arguments;
   }

   /*
    * O que faz: recupera um valor textual do esquema ou devolve um padrao quando a chave nao existe.
    * Por que esta aqui: simplificar a leitura de propriedades opcionais como `type` e `description` sem repetir condicionais.
    * Componentes: `Map.get` consulta a chave; `String.valueOf` converte o resultado; o operador ternario escolhe entre valor e padrao.
    */
   private String getStringValue(Map<?, ?> map, String key,
                                 String defaultValue) {
      /*
       * O que faz: consulta o valor associado a chave solicitada.
       * Por que esta aqui: separar a leitura do mapa da decisao sobre qual texto devolver.
       * Componentes: `map.get(key)` procura o valor dentro do esquema.
       */
      Object value = map.get(key);

      /*
       * O que faz: devolve o valor como texto quando ele existe ou o valor padrao quando nao existe.
       * Por que esta aqui: garantir que o chamador sempre receba uma String utilizavel.
       * Componentes: `value != null` testa a existencia; `String.valueOf` faz a conversao; `?:` escolhe o caminho.
       */
      return value != null ? String.valueOf(value) : defaultValue;
   }

   /*
    * O que faz: recupera do esquema a lista de parametros obrigatorios.
    * Por que esta aqui: o Cliente 01 precisa impedir que um argumento marcado como obrigatorio seja enviado vazio.
    * Componentes: a chave JSON `required` normalmente contem uma lista de nomes.
    */
   private List<?> getRequiredProperties(Map<String, Object> schema) {
      /*
       * O que faz: consulta a propriedade `required` do esquema.
       * Por que esta aqui: separar a recuperacao do valor da validacao de seu tipo.
       * Componentes: `schema.get("required")` procura a chave no mapa.
       */
      Object required = schema.get("required");

      /*
       * O que faz: verifica se o valor recebido realmente e uma lista e, nesse caso, devolve essa lista.
       * Por que esta aqui: o esquema JSON pode nao declarar parametros obrigatorios.
       * Componentes: `instanceof List<?>` valida a estrutura; o cast converte o valor para a interface `List`.
       */
      if (required instanceof List<?>)
         return (List<?>) required;

      /*
       * O que faz: devolve uma lista vazia quando nenhum parametro obrigatorio foi declarado.
       * Por que esta aqui: simplificar as verificacoes futuras e representar corretamente a ausencia de obrigatoriedade.
       * Componentes: `List.of()` cria uma lista imutavel vazia.
       */
      return List.of();
   }

   /*
    * O que faz: le um unico argumento no console, valida se ele e obrigatorio e converte seu texto para o tipo declarado.
    * Por que esta aqui: cada Tool pode possuir parametros diferentes, e este metodo concentra o comportamento generico de entrada.
    * Componentes: `Scanner` le o texto; `convertValue` converte; `while` permite repetir ate uma entrada valida.
    */
   private Object readArgument(Scanner scanner, String name, String type,
                              String description, boolean required,
                              Map<?, ?> schema) {
      /*
       * O que faz: mantem a leitura ativa ate que um valor aceitavel seja obtido ou a entrada termine.
       * Por que esta aqui: erros de digitacao nao devem encerrar o Cliente 01; o usuario deve poder corrigir o valor.
       * Componentes: `while (true)` cria o ciclo de validacao.
       */
      while (true) {
         /*
          * O que faz: mostra o nome, tipo e obrigatoriedade do argumento.
          * Por que esta aqui: o usuario precisa saber qual valor devera fornecer.
          * Componentes: concatenacao `+` monta a mensagem; `required ? ... : ...` escolhe o rotulo.
          */
         System.out.println();
         System.out.println("'" + name + "' [" + type + "] " +
                            (required ? "(obrigatorio)" : "(opcional)"));

         /*
          * O que faz: mostra a descricao declarada pelo servidor para o argumento.
          * Por que esta aqui: reduzir ambiguidades sobre o significado do valor solicitado.
          * Componentes: `println(...)` escreve o texto da descricao.
          */
         System.out.println("Descricao: " + description);

         /*
          * O que faz: mostra o rotulo do campo que o usuario precisa preencher.
          * Por que esta aqui: indicar onde a entrada sera digitada.
          * Componentes: `print(...)` mantem o cursor na mesma linha.
          */
         System.out.print("Valor: ");

         /*
          * O que faz: encerra a leitura quando nao ha mais entrada disponivel.
          * Por que esta aqui: evitar espera ou erro quando stdin for encerrado.
          * Componentes: `hasNextLine()` verifica disponibilidade; `return null` representa ausencia de valor.
          */
         if (!scanner.hasNextLine())
            return null;

         /*
          * O que faz: le e limpa a linha digitada.
          * Por que esta aqui: remover espacos externos antes de validar ou converter.
          * Componentes: `nextLine()` le a entrada; `trim()` normaliza espacos nas extremidades.
          */
         String value = scanner.nextLine().trim();

         /*
          * O que faz: trata uma entrada vazia levando em conta se o campo e obrigatorio.
          * Por que esta aqui: parametros opcionais podem ser omitidos, enquanto parametros obrigatorios precisam de uma tentativa nova.
          * Componentes: `isBlank()` identifica entrada vazia; `return null` omite opcional; `continue` volta ao inicio para obrigatorio.
          */
         if (value.isBlank()) {
            /*
             * O que faz: devolve `null` quando o campo opcional ficou sem valor.
             * Por que esta aqui: representar corretamente a decisao do usuario de nao enviar aquele argumento.
             * Componentes: `return null` encerra somente o metodo de leitura daquele argumento.
             */
            if (!required) return null;

            /*
             * O que faz: avisa que o valor nao pode ficar vazio porque o argumento e obrigatorio.
             * Por que esta aqui: orientar o usuario para uma nova tentativa.
             * Componentes: `println(...)` imprime a mensagem de validacao.
             */
            System.out.println("Este parametro e obrigatorio.");

            /*
             * O que faz: volta ao inicio do ciclo para solicitar novamente o mesmo argumento.
             * Por que esta aqui: uma entrada obrigatoria vazia nao pode ser enviada ao servidor.
             * Componentes: `continue` pula as instrucoes restantes desta repeticao.
             */
            continue;
         }

         /*
          * O que faz: tenta converter o texto para o tipo definido pelo esquema da Tool.
          * Por que esta aqui: o servidor espera tipos MCP como `integer`, `number`, `boolean` ou `string`, nao somente texto cru.
          * Componentes: `convertValue(...)` contem as conversoes; `try` permite tratar valores invalidos.
          */
         try {
            /*
             * O que faz: devolve o objeto convertido quando a entrada possui formato aceitavel.
             * Por que esta aqui: entregar a `executeTool` o valor ja pronto para entrar no mapa de argumentos.
             * Componentes: `return` encerra o metodo com o valor produzido por `convertValue`.
             */
            return convertValue(value, type, schema);
         }
         /*
          * O que faz: captura erros de conversao provocados por uma entrada invalida.
          * Por que esta aqui: permitir nova tentativa sem derrubar o Cliente 01.
          * Componentes: `IllegalArgumentException` representa valor incompativel com o tipo esperado.
          */
         catch (IllegalArgumentException ex) {
            /*
             * O que faz: informa ao usuario por que o valor foi rejeitado.
             * Por que esta aqui: tornar o teste interativo autoexplicativo.
             * Componentes: `ex.getMessage()` recupera a explicacao produzida pela conversao.
             */
            System.out.println("Valor invalido: " + ex.getMessage());
         }
      }
   }

   /*
    * O que faz: converte uma String para o tipo MCP declarado no esquema da Tool.
    * Por que esta aqui: centralizar as conversoes deixa a leitura dos argumentos generica e reutilizavel para todas as Tools.
    * Componentes: o `switch` seleciona a conversao de acordo com `type`.
    */
   private Object convertValue(String value, String type, Map<?, ?> schema) {
      /*
       * O que faz: escolhe a operacao de conversao e devolve o resultado diretamente.
       * Por que esta aqui: permitir que o mesmo metodo atenda inteiros, numeros decimais, booleanos, textos e casos especiais.
       * Componentes: `switch` seleciona por texto; `Integer.valueOf`, `Double.valueOf` e `parseBoolean` realizam conversoes especificas; `parseComplexValue` trata tipos nao suportados pelo modo interativo.
       */
      return switch (type) {
         /*
          * O que faz: converte o texto para `Integer` quando o esquema informa `integer`.
          * Por que esta aqui: enviar um numero inteiro real para o servidor, e nao uma String contendo numeros.
          * Componentes: `Integer.valueOf(value)` faz a conversao.
          */
         case "integer" -> Integer.valueOf(value);

         /*
          * O que faz: converte o texto para `Double` quando o esquema informa `number`.
          * Por que esta aqui: representar valores numericos com parte decimal corretamente.
          * Componentes: `Double.valueOf(value)` faz a conversao.
          */
         case "number" -> Double.valueOf(value);

         /*
          * O que faz: converte o texto para `Boolean` quando o esquema informa `boolean`.
          * Por que esta aqui: aceitar os formatos de verdade/falsidade previstos pelo Cliente 01.
          * Componentes: `parseBoolean(value)` centraliza a validacao.
          */
         case "boolean" -> parseBoolean(value);

         /*
          * O que faz: mantem o valor como texto quando o esquema informa `string`.
          * Por que esta aqui: textos nao precisam de transformacao antes do envio ao servidor.
          * Componentes: `value` ja possui o conteudo pronto.
          */
         case "string" -> value;

         /*
          * O que faz: delega tipos diferentes dos quatro casos basicos para o tratamento especial.
          * Por que esta aqui: evitar aceitar silenciosamente estruturas que este cliente interativo nao sabe representar.
          * Componentes: `default` cobre todos os demais tipos do `switch`.
          */
         default -> parseComplexValue(value, type, schema);
      };
   }

   /*
    * O que faz: converte textos comuns em booleanos aceitando `true/false` e `sim/nao`.
    * Por que esta aqui: oferecer uma entrada amigavel em portugues sem deixar de aceitar a forma booleana tradicional.
    * Componentes: `equalsIgnoreCase` compara sem diferenciar maiusculas e minusculas; `throw` rejeita valores desconhecidos.
    */
   private Boolean parseBoolean(String value) {
      /*
       * O que faz: reconhece os valores positivos `true` e `sim`.
       * Por que esta aqui: transformar essas duas formas de entrada no booleano `true` esperado pelo protocolo.
       * Componentes: `equalsIgnoreCase` compara o texto ignorando caixa; `||` permite duas alternativas.
       */
      if ("true".equalsIgnoreCase(value) || "sim".equalsIgnoreCase(value))
         return true;

      /*
       * O que faz: reconhece os valores negativos `false`, `nao` e `nao`.
       * Por que esta aqui: aceitar tanto a grafia acentuada quanto a forma sem acento em uma entrada de console.
       * Componentes: `||` combina tres alternativas e `return false` produz o booleano correspondente.
       */
      if ("false".equalsIgnoreCase(value) ||
          "nao".equalsIgnoreCase(value) || "nao".equalsIgnoreCase(value))
         return false;

      /*
       * O que faz: rejeita qualquer texto que nao represente um booleano conhecido.
       * Por que esta aqui: impedir o envio de um valor semanticamente invalido para uma Tool que espera `boolean`.
       * Componentes: `IllegalArgumentException` interrompe a conversao e permite que o metodo `readArgument` solicite nova entrada.
       */
      throw new IllegalArgumentException("informe true/false ou sim/nao");
   }

   /*
    * O que faz: trata tipos de esquema que nao podem ser preenchidos pelo modo interativo simples deste Cliente 01.
    * Por que esta aqui: deixar explicito o limite do cliente sem inventar uma serializacao para objetos complexos.
    * Componentes: o metodo reconhece `null` e rejeita os demais tipos com uma excecao compreensivel.
    */
   private Object parseComplexValue(String value, String type,
                                   Map<?, ?> schema) {
      /*
       * O que faz: retorna `null` quando o esquema declara explicitamente o tipo `null`.
       * Por que esta aqui: preservar a possibilidade de uma Tool aceitar um valor nulo sem criar uma estrutura artificial.
       * Componentes: `equals` compara o tipo informado.
       */
      if ("null".equals(type))
         return null;

      /*
       * O que faz: interrompe a conversao para informar que o modo interativo nao suporta aquele tipo complexo.
       * Por que esta aqui: e mais seguro recusar uma entrada desconhecida do que enviar JSON incorreto para o servidor.
       * Componentes: `IllegalArgumentException` transporta a mensagem para `readArgument`.
       */
      throw new IllegalArgumentException("tipo nao suportado pelo modo " +
                                         "interativo: " + type);
   }

   /*
    * O que faz: apresenta o resultado retornado por uma chamada de Tool.
    * Por que esta aqui: tornar visivel no Cliente 01 o resultado da operacao executada no servidor da Biblioteca Digital.
    * Componentes: `CallToolResult` fornece indicador de erro, conteudo e conteudo estruturado.
    */
   private void showResult(CallToolResult result) {
      /*
       * O que faz: adiciona espacamento antes do resultado.
       * Por que esta aqui: separar a resposta da entrada anterior e facilitar a leitura.
       * Componentes: `println()` escreve uma quebra de linha.
       */
      System.out.println();

      /*
       * O que faz: imprime o cabecalho da area de resultados.
       * Por que esta aqui: destacar visualmente que a resposta recebida do servidor comeca naquele ponto.
       * Componentes: `println(...)` escreve o separador.
       */
      System.out.println("=============== RESULTADO ===============");

      /*
       * O que faz: informa se o servidor marcou a chamada como erro.
       * Por que esta aqui: permitir distinguir rapidamente uma execucao bem-sucedida de uma resposta de erro.
       * Componentes: `isError()` devolve o estado; o operador ternario converte para `Sim` ou `Nao`.
       */
      System.out.println("   Erro: " + (result.isError() ? "Sim" : "Nao"));

      /*
       * O que faz: imprime o conteudo textual ou visual do resultado MCP.
       * Por que esta aqui: o conteudo e a principal resposta da Tool para o usuario.
       * Componentes: `content()` devolve os itens; `forEach` percorre cada item e `System.out.println` o exibe.
       */
      System.out.println("Content:");
      result.content().forEach(content -> System.out.println(" " + content));

      /*
       * O que faz: verifica se o servidor tambem devolveu conteudo estruturado.
       * Por que esta aqui: algumas Tools podem fornecer dados adicionais que nao aparecem somente no texto.
       * Componentes: `structuredContent()` retorna o objeto estruturado ou `null` quando nao existe.
       */
      if (result.structuredContent() != null) {
         /*
          * O que faz: imprime um titulo para os dados estruturados.
          * Por que esta aqui: diferenciar o conteudo estruturado da lista textual anterior.
          * Componentes: `println(...)` escreve o rotulo.
          */
         System.out.println();

         /*
          * O que faz: mostra o titulo `Structured Content`.
          * Por que esta aqui: facilitar a identificacao do segundo tipo de resposta.
          * Componentes: `println(...)` escreve o texto.
          */
         System.out.println("Structured Content:");

         /*
          * O que faz: imprime o objeto estruturado retornado pelo servidor.
          * Por que esta aqui: permitir visualizar todos os dados disponiveis para o Cliente 01 sem converter manualmente o objeto.
          * Componentes: `result.structuredContent()` recupera o conteudo e `println` chama sua representacao textual.
          */
         System.out.println(result.structuredContent());
      }

      /*
       * O que faz: imprime a linha final da area de resultados.
       * Por que esta aqui: marcar visualmente o termino da resposta da Tool.
       * Componentes: `println(...)` escreve o separador.
       */
      System.out.println("==========================================");
   }

   /*
    * O que faz: cria o Cliente 01 chamando o metodo de construcao do transporte STDIO.
    * Por que esta aqui: deixar o objeto pronto logo que a classe e instanciada, seguindo a estrutura do exemplo do professor.
    * Componentes: `this.client` referencia o atributo e `createClient()` realiza toda a configuracao necessaria.
    */
   public McpClient01SyncStdio() {
      this.client = createClient();
   }

   /*
    * O que faz: define o ponto de entrada da aplicacao Cliente 01.
    * Por que esta aqui: o perfil `client` cria um JAR executavel que comeca exatamente neste metodo.
    * Componentes: `main` e o metodo chamado pela JVM; `try/finally` garante o fechamento mesmo quando a execucao terminar por erro.
    */
   public static void main(String... args) {
      /*
       * O que faz: cria o Cliente 01 e, com isso, inicia a preparacao da comunicacao STDIO com o servidor da Biblioteca Digital.
       * Por que esta aqui: esta e a primeira etapa do programa antes de `initialize` e das chamadas de Tools.
       * Componentes: `new` cria uma instancia e executa seu construtor.
       */
      McpClient01SyncStdio clientStdio = new McpClient01SyncStdio();

      /*
       * O que faz: executa o fluxo principal e garante o fechamento do cliente ao sair.
       * Por que esta aqui: evitar que uma excecao impeca a liberacao dos recursos MCP.
       * Componentes: `try` executa o fluxo; `finally` sempre tenta chamar `close()` quando o bloco termina.
       */
      try {
         /*
          * O que faz: inicia a sessao MCP e abre o menu interativo.
          * Por que esta aqui: este e o fluxo que efetivamente testa a comunicacao com as Tools do servidor.
          * Componentes: `execute()` reune `initialize`, logging e o laco de Tools.
          */
         clientStdio.execute();
      }
      finally {
         /*
          * O que faz: fecha a conexao MCP do Cliente 01 mesmo se alguma etapa anterior terminar com excecao.
          * Por que esta aqui: garantir encerramento previsivel do teste e do processo filho.
          * Componentes: `close()` chama `closeGracefully()` no cliente.
          */
         clientStdio.close();
      }
   }
}
