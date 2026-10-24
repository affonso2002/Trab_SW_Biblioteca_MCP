# Evidências de ambiente, builds e integrações

Esta pasta reúne capturas reais do ambiente de desenvolvimento, de builds e dos testes da Biblioteca Digital MCP. A numeração 01–26 já existia no projeto; as capturas recebidas depois foram incorporadas como 27–83, com nomes descritivos, e há ainda uma captura complementar identificada como "extra". As capturas documentam etapas distintas e não devem ser interpretadas isoladamente como prova de um resultado que a tela não mostra.

## Índice

| Faixa | Conteúdo |
|---|---|
| 01–06 | Pré-requisitos e serviços auxiliares |
| 07–10 | Testes Maven e artefatos |
| 11–26 | Claude Desktop: configuração e teste pelo método Desenvolvedor (Resource PDF e Tool `extrair_metadados_pdf`) |
| 27–32 | Claude Desktop: Tools `processar_excel` e `buscar_livros` (antes da indexação) |
| 33–46 | Bancos PostgreSQL e MySQL em Docker e Tools `metadados_postgresql` e `metadados_mysql` |
| 47–50 | Claude Desktop: Tool `indexar_gutenberg` e nova busca |
| 51–77 | MCP Inspector: conexão STDIO, Tools, Prompt e Resources |
| 78–83 | Cliente Java Cliente 01 (STDIO) |
| extra | Docker Desktop com os contêineres da aplicação |

## Pré-requisitos e serviços auxiliares

### 01 — Pré-requisitos do ambiente

![Versões de Java, Maven, Docker e Node.js](execucao/01-prerequisitos-java-maven-docker-node.png)

### 02 — Core Gutenberg no Solr

![Painel do Solr com core Gutenberg](execucao/02-solr-core-gutenberg.png)

### 03 — Inicialização do PostgreSQL

![Logs de inicialização do PostgreSQL](execucao/03-postgresql-inicializacao.png)

### 04 — Inicialização do MySQL

![Logs de inicialização do MySQL](execucao/04-mysql-inicializacao.png)

### 05 — Inicialização do Solr

![Logs de inicialização do Solr](execucao/05-solr-inicializacao.png)

### 06 — Verificação das portas dos serviços

![Validação das portas locais dos serviços](execucao/06-validacao-portas-servicos.png)

## Testes Maven e artefatos

### 07 — Execução dos testes Maven

![Execução dos testes Maven](execucao/07-testes-maven.png)

### 07 (continuação) — Resultado/continuação dos testes Maven

![Continuação da execução dos testes Maven](execucao/07-testes-maven-Continuacao.png)

### 08 — Build do servidor MCP

![Geração do artefato servidor](execucao/08-build-servidor.png)

### 08 (continuação) — Continuação do build do servidor

![Continuação da geração do artefato servidor](execucao/08-build-servidor-Continuacao.png)

### 09 — Build do cliente MCP

![Geração do artefato cliente](execucao/09-build-cliente.png)

### 10 — Limpeza dos artefatos gerados

![Remoção dos artefatos de build após os testes](execucao/10-remove-os-artefatos-gerados.png)

## Claude Desktop: configuração e teste pelo método Desenvolvedor

### 11 — Configurações avançadas de extensões

![Configurações avançadas de extensões no Claude Desktop](execucao/11-claude-desktop-extensoes-avancadas.png)

### 12 — Tela de instalação da extensão MCPB e aviso de segurança

![Tela de instalação da extensão MCPB com aviso de origem e segurança](execucao/12-instalacao-extensao-mcpb-aviso-de-seguranca.png)

### 13 — Confirmação da instalação da extensão MCPB

![Confirmação para instalar a extensão local Biblioteca Digital MCP](execucao/13-confirmacao-de-instalacao-da-extensao-mcpb.png)

### 14 — Caminhos configurados na extensão

![Formulário com caminhos do Java, JAR servidor e pasta data](execucao/14-configuracao-dos-caminhos-java-jar-e-data-da-extensao.png)

### 15 — Extensão listada como instalada

![Extensão Biblioteca Digital MCP listada no Claude Desktop](execucao/15-extensao-biblioteca-digital-listada-como-instalada.png)

### 16 — Tela inicial de Desenvolvedor sem servidores cadastrados

![Estado inicial da página Servidores MCP locais sem entradas](execucao/16-desenvolvedor-sem-servidores-mcp-cadastrados-inicialmente.png)

### 17 — Falha de conexão apresentada pela extensão MCPB

![Mensagem de erro informando que não foi possível conectar ao servidor da extensão](execucao/17-extensao-mcpb-mensagem-de-falha-de-conexao.png)

Esta captura documenta o problema que levou a manter a extensão MCPB instalada, porém desativada, enquanto se utiliza o cadastro direto em Desenvolvedor.

### 18 — Servidor direto em execução na tela de Desenvolvedor

![Servidor biblioteca-digital exibido como Em execução em Servidores MCP locais](execucao/18-servidor-biblioteca-digital-em-execucao-no-desenvolvedor.png)

### 19 — Opções avançadas das extensões do Claude Desktop

![Opções de atualização automática e uso de Node.js integrado para MCP](execucao/19-configuracoes-avancadas-de-extensoes-do-claude.png)

### 20 — Menu Conectores com Biblioteca Digital habilitada

![Menu de conectores do Claude Desktop com biblioteca-digital habilitada](execucao/20-menu-conectores-com-biblioteca-digital-habilitada.png)

### 21 — Opções de carregamento das ferramentas

![Opções de carregamento sob demanda ou carregamento antecipado das ferramentas](execucao/21-opcoes-de-carregamento-de-ferramentas-dos-conectores.png)

### 22 — Itens disponíveis no conector

![Menu do conector com Pesquisar biblioteca, Estado do índice Lucene e PDF de exemplo](execucao/22-itens-do-conector-pesquisa-indice-lucene-e-pdf-de-exemplo.png)

### 23 — Resource PDF de exemplo aberto no Claude

![PDF de exemplo incluído na conversa e analisado pelo Claude](execucao/23-resource-pdf-de-exemplo-anexado-e-analisado.png)

Esta captura documenta o acesso ao recurso PDF de exemplo. A análise textual apresentada pelo Claude, isoladamente, não substitui a chamada de uma Tool.

### 24 — Solicitação de autorização para chamar a ferramenta PDF

![Claude solicitando permissão para executar extrair_metadados_pdf](execucao/24-solicitacao-de-autorizacao-para-extrair-metadados-pdf.png)

### 25 — Resultado da ferramenta de metadados PDF

![Resultado com metadados reais retornados para exemplo.pdf](execucao/25-resultado-da-ferramenta-extrair-metadados-pdf.png)

### 26 — Continuação da amostra de texto extraída

![Continuação do texto extraído do PDF exibida no Claude](execucao/26-continuacao-da-amostra-de-texto-extraida-do-pdf.png)

As capturas 25–26 mostram a resposta apresentada para a chamada da ferramenta `extrair_metadados_pdf` com `fileName=exemplo.pdf`. Para uma atribuição inequívoca ao método de conexão direta, recomenda-se que a extensão MCPB permaneça desativada durante qualquer repetição da chamada.

## Claude Desktop: Tools `processar_excel` e `buscar_livros`

### 27 — Solicitação de autorização para a ferramenta processar_excel

![Claude solicitando permissão para executar processar_excel com fileName teste.xlsx](execucao/27-solicitacao-de-autorizacao-para-processar-excel.png)

### 28 — Resultado da ferramenta processar_excel

![Resultado da ferramenta processar_excel com o caminho data\processed\teste.csv](execucao/28-resultado-da-ferramenta-processar-excel.png)

A ferramenta retornou o caminho do CSV gerado (`data\processed\teste.csv`). O Claude informa na própria resposta que recebeu apenas esse caminho e que não tem acesso ao arquivo local; portanto, o conteúdo do CSV não é comprovado por esta captura, apenas a sua geração e o caminho informado.

### 29 — Solicitação de autorização para buscar_livros

![Claude solicitando permissão para executar buscar_livros com a consulta programação Java](execucao/29-solicitacao-de-autorizacao-para-buscar-livros.png)

### 30 — Resultado de buscar_livros sem livros retornados

![Resultado da busca retornando apenas o rótulo Lucene sem nenhum livro](execucao/30-resultado-da-ferramenta-buscar-livros.png)

A ferramenta respondeu, mas sem nenhum livro (apenas o rótulo `Lucene:`). Esta captura é anterior à indexação feita nas capturas 47–48 e não deve ser lida como falha da ferramenta.

### 31 — Solicitação de autorização para buscar_livros (segunda tentativa, consulta mais simples)

![Claude solicitando permissão para executar buscar_livros com a consulta Java](execucao/31-solicitacao-de-autorizacao-para-buscar%20livros-segunda-tentativa-escrevendo-de-uma-forma-mais-simples.png)

### 32 — Resultado da segunda tentativa de buscar_livros

![Resultado da segunda busca, novamente sem livros retornados](execucao/32-resultado-da-ferramenta-buscar-livros-segunda-tentativa.png)

Com a consulta simplificada para `Java`, o retorno continuou vazio, o que é coerente com um índice Lucene ainda sem livros indexados.

## Bancos PostgreSQL e MySQL em Docker

### 33 — Pré-requisito 1: criação do arquivo .env

![PowerShell criando o arquivo .env a partir de .env.example](execucao/33-pre-requisito1-para-testar-as%20tools-metadados-postgresql-e-metadados-mysql.png)

### 34 — Pré-requisito 2: validação do docker-compose

![Comando docker compose config --quiet executado sem mensagens de erro](execucao/34-pre-requisito2-para-testar-as%20tools-metadados-postgresql-e-metadados-mysql.png)

### 35 — Pré-requisito 3: subida dos contêineres PostgreSQL e MySQL

![Comando docker compose up -d postgres mysql criando volumes, rede e contêineres](execucao/35-pre-requisito3-para-testar-as%20tools-metadados-postgresql-e-metadados-mysql.png)

### 36 — Pré-requisito 4: contêineres saudáveis

![Saída do docker compose ps com biblioteca-mysql na porta 3307 e biblioteca-postgres na porta 5432, ambos healthy](execucao/36-pre-requisito4-para-testar-as%20tools-metadados-postgresql-e-metadados-mysql.png)

### 37 — Pré-requisito 5: teste de conexão nas portas 5432 e 3307

![Test-NetConnection com TcpTestSucceeded True para as portas 5432 e 3307](execucao/37-pre-requisito5-para-testar-as%20tools-metadados-postgresql-e-metadados-mysql.png)

### 38 — Solicitação de autorização para metadados_postgresql

![Claude solicitando permissão para executar metadados_postgresql](execucao/38-solicitacao-de-autorizacao-para-metadados-postegresql.png)

### 39 — Resultado da ferramenta metadados_postgresql

![Metadados do PostgreSQL 17.11 com a tabela public.library_document e suas colunas](execucao/39-resultado-da-ferramenta-metadados-postegresql.png)

O retorno mostra o PostgreSQL 17.11, a URL `jdbc:postgresql://localhost:5432/library` e a tabela `public.library_document` com as colunas `id`, `gutenberg_id`, `title`, `authors`, `subjects`, `language`, `text_uri`, `content_path`, `created_at` e `updated_at`.

### 40 — Solicitação de autorização para metadados_mysql

![Claude solicitando permissão para executar metadados_mysql](execucao/40-solicitacao-de-autorizacao-para-metadados-mysql.png)

### 41 — Resultado da ferramenta metadados_mysql (banco sem tabelas)

![Metadados do MySQL 8.4.11 informando que nenhuma tabela foi encontrada](execucao/41-resultado-da-ferramenta-metadados-mysql.png)

Com o banco `library` ainda vazio, a ferramenta retornou o produto, a versão e a URL de conexão (`jdbc:mysql://localhost:3307/library`), sem esquemas ou tabelas.

### 42 — Acesso ao MySQL no contêiner

![Terminal com docker exec abrindo o cliente mysql no contêiner biblioteca-mysql](execucao/42-entrando-no-mysql.png)

### 43 — Criação de uma tabela de teste no MySQL

![CREATE TABLE mcp_metadata_test e DESCRIBE exibindo as quatro colunas](execucao/43-criando-uma-tabela-de-teste-no-mysql.png)

A tabela `mcp_metadata_test` foi criada manualmente apenas para verificar se a ferramenta passa a refletir uma tabela existente.

### 44 — Novo resultado da ferramenta metadados_mysql

![Metadados do MySQL listando a tabela library.mcp_metadata_test com suas colunas](execucao/44-novo-resultado-da-ferramenta-metadados-mysql.png)

### 45 — Novo acesso ao MySQL para limpeza

![Terminal com novo acesso ao cliente mysql no contêiner](execucao/45-entrando-no-mysql-novamente-para-limpar-a-tabela-de-teste.png)

### 46 — Remoção da tabela de teste

![Comando DROP TABLE mcp_metadata_test executado com sucesso](execucao/46-limpando-a-tabela-de-teste.png)

## Claude Desktop: indexação do Gutenberg e nova busca

### 47 — Solicitação de autorização para indexar_gutenberg

![Claude solicitando permissão para executar indexar_gutenberg com query Pride and Prejudice e limit 1](execucao/47-solicitacao-de-autorizacao-para-indexar-gutenberg.png)

### 48 — Execução de indexar_gutenberg em andamento

![Chamada de indexar_gutenberg em execução, com a requisição query Pride and Prejudice e limit 1](execucao/48-resultado-da-ferramenta-indexar-gutenberg.png)

Esta captura mostra a chamada ainda em andamento (cerca de 44 s) e os parâmetros enviados; o resultado da indexação é evidenciado indiretamente pela busca da captura 50.

### 49 — Solicitação de autorização para buscar_livros após a indexação

![Claude solicitando permissão para executar buscar_livros com query Pride and Prejudice](execucao/49-solicitacao-de-autorizacao-para-buscar-livros-depois-de-indexar-gutenberg.png)

### 50 — Resultado de buscar_livros após a indexação

![Resultado com um livro: ID 1342, Pride and Prejudice, Austen, Jane](execucao/50-resultado-da-ferramenta-buscar-livros-depois-de-indexar-gutenberg.png)

Após a indexação, a busca retornou um único resultado (ID 1342, *Pride and Prejudice*, de Jane Austen), em contraste com os retornos vazios das capturas 30 e 32.

## MCP Inspector

### 51 — Pré-requisito: versões do Node.js e do npm

![Terminal exibindo as versões do Node.js e do npm](execucao/51-pre-requisito1-para-rodar-o-mcp-inspector.png)

### 52 — Inicialização do MCP Inspector

![Terminal executando npx @modelcontextprotocol/inspector e exibindo o endereço local 127.0.0.1:6274](execucao/52-acessando-o-mcp-inspector.png)

### 53 — Tela inicial do MCP Inspector

![MCP Inspector aberto no navegador com os servidores de exemplo padrão desconectados](execucao/53-tela-do-mcp-inspector.png)

### 54 — Opções para adicionar um servidor

![Menu Add Servers com as opções Add manually, Import from client config e Import from registry config](execucao/54-opcoes-para-adicionar-um-servidor.png)

### 55 — Opção Add manually e primeiros campos preenchidos

![Formulário Add server com Server ID, transporte stdio, comando java.exe e argumento -jar](execucao/55-opcao-%27%2Badd-manually%27-selecionada-e-alguns-campos-preenchidos.png)

### 56 — Demais campos preenchidos

![Formulário Add server com o caminho do JAR do servidor nos argumentos e campo Environment](execucao/56-resto-dos-campos-campos-preenchidos.png)

### 57 — Servidor adicionado no MCP Inspector

![Servidor BibliotecaDigitalMCP listado no MCP Inspector, ainda desconectado](execucao/57-servidor-%27biblioteca-digital-mcp%27-adicionado-no-mcp-inspector.png)

### 58 — Acesso às configurações de variáveis de ambiente

![Server Settings com a seção Environment Variables expandida](execucao/58-acessando-as-configuracoes-das-variaveis-de-ambiente.png)

### 59 — Variáveis de ambiente configuradas

![Variáveis APP_DATA_DIR e SOLR_ENABLED=false configuradas para o processo STDIO](execucao/59-variaveis-de-ambiente-configuradas.png)

O Solr foi desabilitado (`SOLR_ENABLED=false`) neste teste; as buscas feitas pelo Inspector utilizam, portanto, apenas o índice Lucene.

### 60 — Servidor conectado

![MCP Inspector com o servidor BibliotecaDigitalMCP conectado via Standard I/O](execucao/60-mcp-inspector-servidor-conectado.png)

### 61 — Lista de Tools

![Aba Tools listando as seis ferramentas do servidor](execucao/61-mcp-inspector-lista-tools.png)

### 62 — Tool extrair_metadados_pdf: entrada

![Ferramenta extrair_metadados_pdf com o JSON fileName exemplo.pdf](execucao/62-mcp-inspector-extrair-metadados-pdf.png)

### 63 — Tool extrair_metadados_pdf: resultado

![Resultado com arquivo, número de páginas, título, autor, assunto e texto inicial do exemplo.pdf](execucao/63-resultado-mcp-inspector-extrair-metadados-pdf.png)

### 64 — Tool processar_excel: entrada

![Ferramenta processar_excel com o JSON fileName teste.xlsx](execucao/64-mcp-inspector-processar-excel.png)

### 65 — Tool processar_excel: resultado

![Resultado com o caminho do arquivo data\processed\teste.csv](execucao/65-resultado-mcp-inspector-processar-excel.png)

### 66 — Tool indexar_gutenberg: entrada

![Ferramenta indexar_gutenberg com query Pride and Prejudice e limit 1](execucao/66-mcp-inspector-indexar-gutenberg.png)

### 67 — Tool indexar_gutenberg: resultado

![Resultado informando um livro processado: 1342 - Pride and Prejudice](execucao/67-resultado-mcp-inspector-indexar-gutenberg.png)

### 68 — Tool buscar_livros: entrada

![Ferramenta buscar_livros com page 0, pageSize 5 e query title:"Pride and Prejudice"](execucao/68-mcp-inspector-buscar-livros.png)

### 69 — Tool buscar_livros: resultado

![Resultado do Lucene com o livro 1342, Pride and Prejudice, Austen, Jane, e o respectivo score](execucao/69-resultado-mcp-inspector-buscar-livros.png)

O valor de `score` difere do exibido na captura 50 porque a consulta usada aqui (`title:"Pride and Prejudice"`) é diferente da usada no Claude Desktop.

### 70 — Tool metadados_postgresql: entrada

![Ferramenta metadados_postgresql pronta para execução, sem argumentos](execucao/70-mcp-inspector-metadados-postegresql.png)

### 71 — Tool metadados_postgresql: resultado

![Resultado com PostgreSQL 17.11 e a tabela public.library_document](execucao/71-resultado-mcp-inspector-metadados-postegresql.png)

### 72 — Tool metadados_mysql: entrada

![Ferramenta metadados_mysql pronta para execução, sem argumentos](execucao/72-mcp-inspector-metadados-mysql.png)

### 73 — Tool metadados_mysql: resultado com a tabela de teste

![Resultado com MySQL 8.4.11 e a tabela library.mcp_metadata_test criada manualmente](execucao/73-resultado-mcp-inspector-metadados-mysql-ja-com-tabela-teste-criada-manualmente.png)

Esta captura foi feita com a tabela `mcp_metadata_test` ainda existente, criada manualmente conforme as capturas 42–43.

### 74 — Prompt pesquisar_biblioteca: entrada

![Aba Prompts com o prompt pesquisar_biblioteca e o argumento tema preenchido com Tecnologia](execucao/74-mcp-inspector-criando-um-prompt-a-partir-de-um-tema.png)

### 75 — Prompt pesquisar_biblioteca: resultado

![Mensagem de usuário gerada pelo prompt para o tema Tecnologia](execucao/75-resultado-mcp-inspector-prompt-criado.png)

### 76 — Resource: estado do índice Lucene

![Resource library://index/info exibindo o caminho data\lucene](execucao/76-mcp-inspector-resources1-lucene.png)

### 77 — Resource: PDF de exemplo

![Resource library://file/exemplo.pdf exibindo o PDF Sustentabilidade no dia a dia](execucao/77-mcp-inspector-resources2-pdf.png)

## Cliente Java Cliente 01 (STDIO)

### 78 — Confirmação dos artefatos dos builds

![Test-Path retornando True para os JARs e as pastas libs do servidor e do cliente](execucao/78-partindo-do-pressuposto-que-os-builds-do-servidor-e-do-cliente-foram-realizados-comandos-de-confirmacao-da-geracao-dos-artefato-necessarios-para-executar-cliente-01.png)

### 79 — Variáveis de ambiente e Solr desabilitado

![PowerShell definindo APP_DATA_DIR e SOLR_ENABLED como false](execucao/79-desabilitando%20o%20solr.png)

### 80 — Execução do Cliente 01

![PowerShell entrando em target\dist-client e executando java -jar mcp_server01_client.jar](execucao/80-executando-o-cliente-01.png)

### 81 — Cliente 01: lista de ferramentas

![Menu do Cliente 01 listando as seis ferramentas e os comandos listar e sair](execucao/81-cliente01-stdio-lista-de-ferramentas.png)

### 82 — Cliente 01: extração de metadados do PDF

![Cliente 01 chamando extrair_metadados_pdf com fileName exemplo.pdf e exibindo o resultado](execucao/82-cliente01-stdio-extracao-metadados-pdf.png)

### 83 — Cliente 01: encerramento

![Final do texto extraído, retorno ao menu e encerramento do cliente com o comando sair](execucao/83-cliente01-stdio-encerramento.png)

## Captura complementar

### Extra — Docker Desktop com os contêineres da aplicação

![Docker Desktop listando a pilha mcp-server01trab1 em execução](execucao/extra-docker-rodando-os-bancos-de-dados-da-aplicacao-em-um-container.png)

Mostra a pilha `mcp-server01trab1` (PostgreSQL e MySQL) em execução no Docker Desktop. A tela também lista contêineres de outros projetos, que não fazem parte desta aplicação.

## Observações

- As capturas 52–77 exibem o token de sessão do MCP Inspector no terminal e na barra de endereço. Ele é local e válido apenas enquanto o processo está em execução, mas convém ocultá-lo (tarja) caso o documento seja publicado.
- As capturas 30, 32 e 41 mostram resultados vazios que são esperados nas condições em que foram feitas (índice ainda sem livros e banco MySQL sem tabelas). Elas são mantidas como contraponto às capturas 50 e 44, respectivamente.
- Nas capturas 59, 79 e 82–83, o Solr está desabilitado (`SOLR_ENABLED=false`); os resultados de busca desses testes vêm do Lucene.

## Evidências adicionais

A execução do **cliente Java Cliente 01** (capturas 78–83) e do **MCP Inspector** (capturas 51–77) está documentada acima, seguindo `CLIENTE01_STDIO.md` e `MCP_INSPECTOR_PASSO_A_PASSO.md`. Novas capturas devem ser apenas autênticas e continuar a numeração a partir de 84.

As capturas antigas de configurações de transporte HTTP, certificados TLS, tokens e caminhos antigos de JAR não fazem parte desta sequência, pois não correspondem ao método STDIO utilizado na versão atual.
