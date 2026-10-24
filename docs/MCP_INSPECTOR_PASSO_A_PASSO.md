# Testar a Biblioteca Digital com o MCP Inspector — passo a passo (Windows)

## Por que fazer este teste?

O enunciado exige que o servidor esteja disponível para teste no MCP Inspector (itens `o` e `v.6`). A validação pelo Inspector é independente dos testes unitários/integração do Maven e da conexão com Claude Desktop. O Inspector deve iniciar o processo do servidor como um cliente local **STDIO**.

Este roteiro usa a interface Web oficial do MCP Inspector, iniciada por `npx`, sem instalar o pacote globalmente. Consulte também o [repositório/documentação oficial do MCP Inspector](https://github.com/modelcontextprotocol/inspector).

## 1. Conferir os pré-requisitos

Abra o PowerShell. Confira JDK, Maven, Node.js e npm:

```powershell
java -version
mvn -version
node --version
npm --version
```

Para versões atuais do MCP Inspector, use Node.js **22.19.0 ou superior**. Se `node` ou `npx` não for reconhecido, resolva a instalação/PATH do Node.js antes de continuar. A primeira execução de `npx` precisa de acesso à internet para baixar o Inspector.

## 2. Gerar o JAR do servidor

Use a pasta raiz do projeto (a que contém `pom.xml`). No ambiente Windows documentado, ela é:

```powershell
Set-Location 'C:\Users\PC\eclipse-workspace\mcp-server01Trab1'
mvn clean package -Pserver -DskipTests -DskipITs
```

Confirme a presença do JAR e da pasta `libs`:

```powershell
Test-Path '.\target\dist-server\mcp_server01_server.jar'
Test-Path '.\target\dist-server\libs'
```

Ambos devem retornar `True`. Não mova o JAR isoladamente.

## 3. Definir as variáveis necessárias para a sessão do Inspector

Ainda no PowerShell, defina a pasta de dados e desative o Solr para começar sem essa dependência:

```powershell
$env:APP_DATA_DIR = 'C:\Users\PC\eclipse-workspace\mcp-server01Trab1\data'
$env:SOLR_ENABLED = 'false'
```

O Inspector e o processo servidor iniciado por ele herdarão essas variáveis. Elas valem apenas para a janela atual do PowerShell; não ficam gravadas no Windows.

## 4. Abrir o MCP Inspector

Execute:

```powershell
npx -y @modelcontextprotocol/inspector
```

O terminal deverá informar o endereço local da interface Web e, normalmente, abrirá o navegador. Se a página não abrir automaticamente, copie o endereço local mostrado no terminal. Não publique a URL com token de sessão, caso ele apareça.

## 5. Cadastrar uma sessão STDIO do servidor

Na interface do Inspector, crie/adicionе uma conexão para um servidor local e selecione o transporte **STDIO**. Preencha os campos separados da seguinte forma:

**Command / Comando**

```text
C:\Program Files\Java\jdk-26.0.2\bin\java.exe
```

**Arguments / Argumentos** — informe cada item como argumento separado, nesta ordem:

```text
-jar
C:\Users\PC\eclipse-workspace\mcp-server01Trab1\target\dist-server\mcp_server01_server.jar
```

**Environment variables / Variáveis de ambiente**, se a tela permitir configurá-las no próprio Inspector:

```text
APP_DATA_DIR=C:\Users\PC\eclipse-workspace\mcp-server01Trab1\data
SOLR_ENABLED=false
```

Use o comando e os caminhos absolutos exatamente; não configure URL HTTP, porta de servidor, Bearer token ou certificado, pois o projeto usa STDIO. Salve a configuração e clique em **Connect/Conectar**, se a interface não iniciar a conexão automaticamente.

Alternativamente, a interface permite iniciar o Inspector com um comando-alvo diretamente pelo terminal; se optar por isso, use a ajuda e os campos de configuração da versão instalada caso a análise de argumentos do PowerShell seja diferente. O método pela interface, com comando e argumentos separados, evita ambiguidade com o argumento Java `-jar`.

## 6. O que verificar para comprovar o funcionamento

Após conectar, verifique estes itens na interface:

1. **Conexão/estado do servidor:** a conexão STDIO fica estabelecida e o Inspector apresenta informações do servidor.
2. **Tools:** solicite a listagem das ferramentas. Devem aparecer as seis ferramentas registradas pelo projeto: `indexar_gutenberg`, `buscar_livros`, `extrair_metadados_pdf`, `processar_excel`, `metadados_postgresql` e `metadados_mysql`.
3. **Chamada de ferramenta:** selecione `extrair_metadados_pdf` e informe o argumento `fileName` com valor `exemplo.pdf`. Execute e confira o resultado com os metadados e a amostra de texto. O arquivo de exemplo fica em `data\input\exemplo.pdf`.
4. **Resources:** consulte a lista e abra o recurso PDF de exemplo, quando disponível, e/ou `library://index/info`.
5. **Prompts:** confira a lista e consulte `pesquisar_biblioteca`, quando disponível.

Para a primeira validação, não use `indexar_gutenberg` nem as Tools JDBC: essas operações dependem de internet/serviços e credenciais externas. O teste de PDF é suficiente para demonstrar uma chamada local real; a listagem comprova a descoberta das Tools e os passos opcionais exercitam os demais recursos do protocolo.

## 7. Capturas para `docs/execucao/`

Depois de uma execução real, salve as capturas (não criar imagens simuladas) com nomes como:

- `27-mcp-inspector-servidor-stdio-conectado.png` — estado da conexão e informação do servidor.
- `28-mcp-inspector-lista-das-seis-ferramentas.png` — lista completa retornada por `tools/list`.
- `29-mcp-inspector-chamada-extrair-metadados-pdf.png` — argumentos utilizados e resultado da execução.
- `30-mcp-inspector-resources-e-prompt.png` — listagem/consulta de Resources ou Prompt, se for testada.

Atualize `docs/EVIDENCIAS_EXECUCAO.md` depois de incluir capturas autênticas.

## 8. Encerrar com segurança

Quando concluir, encerre ou desconecte a sessão na interface e volte ao terminal que executa `npx`; pressione `Ctrl+C` para encerrar o Inspector. Se houver falha, registre a mensagem e consulte o terminal. Não espere indefinidamente se o Windows congelar; um servidor pode ficar ativo aguardando mensagens, mas congelar o computador inteiro não é comportamento esperado.

## Referências

- [MCP Inspector — projeto oficial](https://github.com/modelcontextprotocol/inspector)
- [Documentação do Inspector](https://modelcontextprotocol.io/docs/tools/inspector)
