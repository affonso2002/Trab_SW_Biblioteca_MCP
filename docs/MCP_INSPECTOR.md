# MCP Inspector — integração STDIO

O trabalho exige teste do servidor no MCP Inspector. O procedimento detalhado para Windows, incluindo pré-requisitos, build, variáveis de ambiente, configuração STDIO, chamada da ferramenta PDF, Resources/Prompt e capturas de evidência, está em [`MCP_INSPECTOR_PASSO_A_PASSO.md`](MCP_INSPECTOR_PASSO_A_PASSO.md).

Resumo dos comandos na raiz do projeto:

```powershell
mvn clean package -Pserver -DskipTests -DskipITs
$env:APP_DATA_DIR = 'C:\Users\PC\eclipse-workspace\mcp-server01Trab1\data'
$env:SOLR_ENABLED = 'false'
npx -y @modelcontextprotocol/inspector
```

No navegador, configure o transporte **STDIO** com `C:\Program Files\Java\jdk-26.0.2\bin\java.exe`, argumentos `-jar` e o caminho absoluto para `target\dist-server\mcp_server01_server.jar`, além das variáveis de ambiente acima. Não use HTTP para este projeto.
