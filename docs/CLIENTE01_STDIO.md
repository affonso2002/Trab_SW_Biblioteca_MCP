# Executar e testar o Cliente 01 MCP por STDIO

## O enunciado exige este teste?

**Sim.** O item `v.4` do enunciado prevê o “Teste do servidor MCP com o cliente MCP”. O projeto deve disponibilizar servidor e cliente no mesmo trabalho; portanto, é necessário executar o `McpClient01SyncStdio` e verificar que ele descobre e chama Tools do servidor, não apenas gerar o JAR.

## Pré-requisitos

- JDK 21 (ou superior) e Maven 3.9 ou superior.
- Estar na raiz do projeto, na pasta que contém `pom.xml`.
- Não é preciso iniciar o Claude Desktop para testar este cliente. O cliente Java inicia seu próprio processo do servidor via STDIO.

No PowerShell, confira:

```powershell
java -version
mvn -version
```

## 1. Gerar servidor e cliente na ordem correta

Execute na raiz do projeto:

```powershell
mvn clean package -Pserver -DskipTests -DskipITs
mvn package -Pclient -DskipTests -DskipITs
```

O primeiro comando gera o servidor em `target\dist-server`. O segundo gera o cliente em `target\dist-client`. **Não acrescente `clean` ao segundo comando**, pois `clean` apagaria o servidor gerado anteriormente.

Confirme que os arquivos existem:

```powershell
Test-Path '.\target\dist-server\mcp_server01_server.jar'
Test-Path '.\target\dist-server\libs'
Test-Path '.\target\dist-client\mcp_server01_client.jar'
Test-Path '.\target\dist-client\libs'
```

Os quatro resultados devem ser `True`. Mantenha o JAR de cada aplicação junto da pasta `libs` correspondente e preserve a estrutura `target\dist-server` e `target\dist-client`.

## 2. Iniciar o Cliente 01

No mesmo PowerShell, a partir da raiz:

```powershell
Set-Location '.\target\dist-client'
java -jar '.\mcp_server01_client.jar'
```

O cliente inicia automaticamente o processo servidor indicado pelo caminho relativo `..\dist-server\mcp_server01_server.jar`. Ele também define `APP_DATA_DIR` para a pasta `data` da raiz do projeto quando não foi fornecida uma configuração explícita.

Ao iniciar corretamente, o console deve exibir o cabeçalho **CLIENTE 01 - BIBLIOTECA DIGITAL MCP** e a lista de ferramentas que o servidor anunciou por `tools/list`. Essa lista é montada dinamicamente; não é uma lista fixa separada no cliente.

## 3. Fazer um teste funcional

Para um teste inicial sem depender de internet, PostgreSQL ou Solr:

1. No menu exibido no console, localize a ferramenta `extrair_metadados_pdf`.
2. Digite o número que aparece à esquerda dessa ferramenta.
3. Quando solicitado o argumento `fileName`, digite `exemplo.pdf`.
4. Confira a seção de resultado: deve indicar a ferramenta chamada, os argumentos utilizados e o retorno do servidor. O arquivo de entrada esperado fica em `data\input\exemplo.pdf`.

Outro teste local é `processar_excel`, informando `teste.xlsx`. Essa ferramenta deverá informar o caminho do CSV produzido em `data\processed`. Evite selecionar `indexar_gutenberg` durante o teste inicial: ela depende de internet e de PostgreSQL acessível.

Durante a sessão, o comando `listar` solicita uma nova listagem de ferramentas. O comando `sair` encerra o cliente de forma controlada. Para finalizar, digite `sair`; se necessário, use `Ctrl+C` apenas como interrupção de emergência.

## 4. Variáveis e serviços opcionais

O arquivo `.env` não é carregado automaticamente pelo Java. Se for preciso configurar bancos ou Solr, defina as variáveis no terminal antes de iniciar o cliente ou configure-as na IDE. Para a verificação inicial sem Solr, pode-se usar:

```powershell
$env:SOLR_ENABLED = 'false'
```

As ferramentas `metadados_postgresql` e `metadados_mysql` dependem dos respectivos bancos e credenciais. `indexar_gutenberg` depende de internet e PostgreSQL. Isso não é necessário para comprovar a chamada da ferramenta local de PDF.

## 5. Evidências sugeridas

Guarde capturas reais em `docs/execucao/`, por exemplo:

- `27-cliente01-stdio-lista-de-ferramentas.png` — cabeçalho do cliente e lista recebida do servidor.
- `28-cliente01-stdio-extracao-metadados-pdf.png` — chamada de `extrair_metadados_pdf` com `exemplo.pdf` e resultado.
- `29-cliente01-stdio-processamento-excel.png` — chamada de `processar_excel` e caminho de saída, se também testar Excel.

Essas capturas são evidências complementares; não invente resultados nem adicione imagens ilustrativas como se fossem execuções reais.
