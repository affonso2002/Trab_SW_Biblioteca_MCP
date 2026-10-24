# Biblioteca Digital - Servidor e Cliente MCP em Java

Projeto academico de Servicos Web composto por **um servidor MCP e um cliente MCP**, implementados em Java e empacotados com Apache Maven. O transporte de comunicacao e **STDIO**: clientes MCP iniciam o processo Java e trocam mensagens pelo `stdin`/`stdout`. O servidor nao expoe uma URL HTTP/HTTPS nem requer certificado TLS. As mensagens de diagnostico sao enviadas a `stderr`, preservando o canal JSON-RPC.

A aplicacao nao usa Spring nem Lombok. O servidor monta suas dependencias Java explicitamente, separa as regras de negocio em servicos e registra as Tools, Resources e Prompts por classes de responsabilidade especifica.

## Requisitos

- JDK **21 ou superior** (o `pom.xml` compila com `release 21`; JDK 22, 25, 26 etc. tambem funcionam).
- Apache Maven **3.9 ou superior**.
- Node.js/npm apenas para usar o MCP Inspector.
- Acesso a internet para `indexar_gutenberg`; PostgreSQL ativo e necessario para essa Tool. MySQL e Solr sao opcionais, mas as Tools de metadados so funcionam com seus respectivos bancos acessiveis.

Confira a instalacao com `java -version` e `mvn -version`. Importe a raiz do projeto no Eclipse como **Existing Maven Project**.

## Arquitetura

- `br.edu.ifpr.mcp_server.main.McpServer01SyncStdio`: ponto de entrada e composicao do servidor STDIO.
- `br.edu.ifpr.mcp_server.main.McpClient01SyncStdio`: cliente de console, que descobre as ferramentas por `tools/list` e permite executar as ferramentas listadas, em vez de codificar uma lista diferente da do servidor.
- `br.edu.ifpr.biblioteca.mcp`: declara e registra Tools, Resources e Prompts.
- `br.edu.ifpr.biblioteca.service`: regras de indexacao, busca, PDF, Excel e metadados de bancos.
- `br.edu.ifpr.biblioteca.config`: configuracao e protecao dos caminhos do armazenamento.
- `src/test/java`: testes unitarios `*Test.java` e testes de integracao MCP real `*IT.java`.

### Guias complementares

- [Arquitetura da aplicacao](docs/ARQUITETURA.md).
- [Builds e testes Maven](docs/BUILD_E_TESTES.md).
- [Execucao do cliente Java STDIO](docs/CLIENTE01_STDIO.md).
- [Configuracao do Claude Desktop](docs/CLAUDE_DESKTOP.md).
- [Pacote de extensao MCPB para Claude Desktop (Windows)](docs/claude-desktop-mcpb/README.md).
- [Resumo do MCP Inspector](docs/MCP_INSPECTOR.md).
- [Passo a passo para executar o MCP Inspector no Windows](docs/MCP_INSPECTOR_PASSO_A_PASSO.md).
- [Checklist de entrega no GitHub](docs/FASE3_GITHUB.md).
- [Evidencias de ambiente e servicos auxiliares](docs/EVIDENCIAS_EXECUCAO.md).

## Ferramentas MCP

Todas as ferramentas retornam texto em conteudo MCP. `indexar_gutenberg`, `extrair_metadados_pdf` e `processar_excel` marcam excecoes como `isError=true` com texto iniciado por `ERRO:`. As Tools de metadados JDBC tratam falhas de conexao e devolvem `Erro:` no proprio texto de resultado. Os detalhes podem variar conforme os dados e servicos externos disponiveis.

| Tool | Parametros | Comportamento e resultados | Possiveis erros
|---|---|---|---|
| `indexar_gutenberg` | `query` (string, obrigatoria); `limit` (inteiro de 1 a 20, padrao 5) | Consulta Gutendex/Project Gutenberg; salva os textos em `data/documents`, grava metadados no PostgreSQL (obrigatorio para esta Tool), atualiza o indice Lucene e o Solr quando habilitado. Retorna os IDs e titulos processados. | Consulta HTTP indisponivel, resposta remota invalida, erro de gravacao, PostgreSQL inacessivel ou falha de indexacao Solr.
| `buscar_livros` | `query` (string, obrigatoria); `page` (inteiro >= 0, padrao 0); `pageSize` (inteiro de 1 a 50, padrao 10) | Busca com relevancia e paginacao nos indices disponiveis; a busca local e feita com Lucene e o resultado indica a origem. | Sintaxe de consulta Lucene invalida, falha no indice ou erro no Solr se habilitado.
| `extrair_metadados_pdf` | `fileName` (string, obrigatoria) | Le `data/input/<fileName>` e devolve nome, quantidade de paginas, metadados PDF e ate 3.000 caracteres iniciais de texto. | Arquivo ausente, PDF invalido/corrompido ou nome tentando escapar da pasta de entrada.
| `processar_excel` | `fileName` (string, obrigatoria) | Le XLS/XLSX em `data/input`, converte todas as planilhas em CSV UTF-8 com campos escapados e salva em `data/processed`. Retorna o caminho do CSV. | Arquivo ausente/invalido, formato nao suportado, falha de leitura/escrita ou caminho nao permitido.
| `metadados_postgresql` | Nenhum | Usa JDBC para listar esquemas, tabelas e colunas (tipo e nulabilidade) do PostgreSQL configurado; informa explicitamente quando não encontra tabelas. | Banco indisponivel, URL/credenciais incorretas, driver ou permissao de metadados indisponivel.
| `metadados_mysql` | Nenhum | Usa JDBC para listar esquemas, tabelas e colunas (tipo e nulabilidade) do MySQL configurado; informa explicitamente quando não encontra tabelas. | Banco indisponivel, URL/credenciais incorretas, driver ou permissao de metadados indisponivel.

### Recursos MCP

- `library://index/info`: caminho absoluto do indice local Lucene.
- `library://file/exemplo.pdf`: conteudo binario do PDF de exemplo quando `data/input/exemplo.pdf` existe.

### Prompt MCP

- `pesquisar_biblioteca`: recebe `tema` (string obrigatoria) e monta uma instrucao para orientar uma pesquisa na biblioteca.

## Configuracao

O servidor aceita configuracao atraves de variaveis de ambiente ou propriedades JVM (`-DCHAVE=valor`); a propriedade JVM tem precedencia. `APP_DATA_DIR` define a pasta de dados (padrao `data`), `GUTENBERG_URL` define o endpoint Gutendex, `SOLR_ENABLED` ativa ou desativa o Solr e as variaveis `SOLR_URL`, `POSTGRES_URL`, `POSTGRES_USER`, `POSTGRES_PASSWORD`, `MYSQL_URL`, `MYSQL_USER` e `MYSQL_PASSWORD` configuram as integracoes respectivas. Consulte `.env.example` como referencia; **copie-o para `.env` apenas no seu ambiente e preencha segredos locais**. O servidor STDIO nao carrega automaticamente `.env`; variaveis nele so se aplicam quando exportadas pelo shell, IDE ou passadas na configuracao do assistente.

Para pesquisar o indice local ou processar PDFs e planilhas sem Solr, configure `SOLR_ENABLED=false`. A Tool `indexar_gutenberg` requer internet e PostgreSQL acessivel; `metadados_postgresql` e `metadados_mysql` exigem os bancos e credenciais correspondentes. Valores de senha no `.env.example` sao demonstrativos: altere-os no seu ambiente.

## Build e testes Maven

Na raiz do projeto:

```bash
# Compila o codigo, executa testes unitarios e testes de integracao MCP reais
mvn clean verify

# Gera o artefato e suas dependencias de runtime para o servidor MCP
mvn clean package -Pserver -DskipTests -DskipITs

# Gera o artefato e suas dependencias de runtime para o cliente MCP; nao usar clean neste segundo build
mvn package -Pclient -DskipTests -DskipITs
```

Artefatos esperados:

- Servidor: `target/dist-server/mcp_server01_server.jar` e `target/dist-server/libs/`.
- Cliente: `target/dist-client/mcp_server01_client.jar` e `target/dist-client/libs/`.

O perfil `server` e o perfil `client` empacotam um JAR fino com manifesto `Class-Path` apontando para a pasta `libs`. Nao mova o JAR isoladamente para fora da estrutura de distribuicao. O cliente procura o servidor em `../dist-server/mcp_server01_server.jar` a partir de `target/dist-client`, entao preserve a estrutura da pasta `target`. Nao use `clean` no segundo build, pois ele apagaria o servidor gerado no primeiro. Nao execute `clean` antes do build do cliente, pois isso apagaria o artefato servidor gerado anteriormente.

### Executar o cliente Java

Gere servidor e cliente, depois execute a partir da pasta do cliente: 

```bash
cd target/dist-client
java -jar mcp_server01_client.jar
```

O cliente inicia o servidor STDIO automaticamente e lista as Tools disponiveis. Por padrao, ele informa ao servidor a pasta `data` da raiz do projeto por meio de `APP_DATA_DIR`, mesmo quando o comando e executado dentro de `target/dist-client`. Se precisar usar outra pasta, defina `APP_DATA_DIR` no ambiente ou passe `-DAPP_DATA_DIR=CAMINHO` ao iniciar o cliente; caminhos relativos sao resolvidos a partir da pasta em que o cliente foi iniciado. Para encerrar, use a opcao de saida do menu do cliente.

### Testes unitarios e de integracao

- Surefire (`mvn test`) executa os testes unitarios `*Test.java`, que verificam os caminhos de sucesso, entradas invalidas, limites e erros previsiveis dos servicos.
- Failsafe (`mvn verify`) executa `*IT.java`, que inicia o servidor como um processo Java real, negocia o protocolo MCP via STDIO, lista Tools/Resources/Prompts, invoca a busca e le um Resource/Prompt. O teste automatizado nao depende de banco ativo, Solr ou consulta real a internet.
- `mvn -Dtest=FileStorageTest test` executa um teste unitario especifico.
- `mvn -Dtest=GutenbergServiceTest,IndexingServiceTest,LibraryRepositoryTest,SolrIndexServiceTest test` executa os testes adicionados para os servicos de busca externa, indexacao, repositorio e integracao opcional com Solr.
- `mvn -Dit.test=McpProtocolIT verify` executa o teste de integracao de protocolo.

## Conectar ao Claude Desktop

O método recomendado para usar o projeto no ambiente registrado é cadastrar o servidor em **Configurações → Desenvolvedor → Editar configuração**. Os registros e a interface do Claude Desktop mostraram o servidor `biblioteca-digital` em execução e respostas de descoberta MCP. Consulte o procedimento formal em [`docs/CLAUDE_DESKTOP.md`](docs/CLAUDE_DESKTOP.md) e use o exemplo de configuração em `docs/claude_desktop_config.windows.PC.example.json`.

A extensão opcional `docs/claude-desktop-mcpb/biblioteca-digital.mcpb` foi preservada, mas apresentou erro de conexão no ambiente de teste e deve permanecer desativada enquanto se utiliza o cadastro direto em Desenvolvedor. Não ative os dois mecanismos para iniciar o mesmo servidor durante o diagnóstico.

## Testar com o Cliente 01 e com o MCP Inspector

O enunciado prevê o teste do servidor com o Cliente MCP desenvolvido e com o MCP Inspector, além do Claude Desktop. Consulte [`docs/CLIENTE01_STDIO.md`](docs/CLIENTE01_STDIO.md) para gerar e executar `mcp_server01_client.jar` e [`docs/MCP_INSPECTOR_PASSO_A_PASSO.md`](docs/MCP_INSPECTOR_PASSO_A_PASSO.md) para conectar o Inspector por STDIO e executar uma ferramenta real.

## Servicos auxiliares opcionais com Docker

`compose.yaml` inicia apenas PostgreSQL, MySQL e Solr; nao inicia o servidor MCP porque STDIO exige que o cliente abra os fluxos do processo. Preencha um `.env` local com as variaveis necessarias e execute `docker compose up -d`. No host, o MySQL esta publicado na porta 3307; dentro da rede Docker, a porta do servico e 3306. O Dockerfile constroi uma imagem do servidor STDIO para cenarios em que outro processo pode conecta-lo via `-i`; ele nao publica uma porta HTTP.

## Seguranca e entrega

- Nao versionar `.env`, arquivos `.p12`, `.pfx`, `.jks`, `.pem` ou chaves privadas.
- `data/lucene` e `data/processed` sao dados gerados e sao ignorados pelo Git.
- Mantenha os arquivos de demonstracao sem dados privados em `data/input`.
- Para entrega no GitHub, inclua o codigo-fonte, `pom.xml`, testes, README, guias em `docs/` e `.env.example`, mas nao `.git`, `target`, dependencias copiadas ou credenciais locais. Se o repositorio do trabalho for privado, adicione o acesso do professor conforme o enunciado.

## Criterios da atividade cobertos

- Java e Maven; cliente e servidor no mesmo projeto.
- Seis Tools de objetivos variados, mais Resources e Prompt.
- Cliente MCP que descobre a lista de ferramentas do servidor em tempo de execucao.
- Testes unitarios (`*Test`) e de integracao do protocolo MCP via STDIO (`*IT`).
- Instrucoes de build e de configuracao para o cliente Java, Claude Desktop e MCP Inspector.
- Codigo sem Spring e Lombok.
