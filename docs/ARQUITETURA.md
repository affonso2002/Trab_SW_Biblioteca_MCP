# Arquitetura da Biblioteca Digital MCP

O projeto entrega duas aplicacoes Java no mesmo repositorio: um servidor MCP e um cliente MCP de console. O servidor usa **STDIO**; o cliente inicia o processo servidor e troca mensagens MCP pelo `stdin` e `stdout`.

## Organizacao por responsabilidade

- `br.edu.ifpr.mcp_server.main`: pontos de entrada, composicao das dependencias e transporte STDIO do servidor e do cliente.
- `br.edu.ifpr.biblioteca.config`: leitura de propriedades e protecao dos caminhos usados para armazenar arquivos.
- `br.edu.ifpr.biblioteca.model`: modelos de livros e resultados de busca.
- `br.edu.ifpr.biblioteca.service`: acesso a arquivos, consulta ao Project Gutenberg, indexacao/pesquisa Lucene e Solr, processamento de PDF/Excel e leitura de metadados JDBC (esquemas, tabelas e colunas).
- `br.edu.ifpr.biblioteca.mcp`: registro das seis Tools, dos Resources e do Prompt MCP.
- `src/test/java`: testes unitarios e de integracao do protocolo MCP por STDIO.

O servidor compoe as dependencias explicitamente, sem Spring ou Lombok. As mensagens do protocolo JSON-RPC usam `stdout`; mensagens de diagnostico sao encaminhadas a `stderr` para nao corromper o transporte.

## Integracoes

Lucene e usado como indice local. Solr, PostgreSQL e MySQL sao integracoes configuraveis; as ferramentas que dependem desses servicos precisam de URLs e credenciais validas. A Tool `indexar_gutenberg` tambem depende de acesso a internet e de PostgreSQL disponivel.

## Pontos de entrada

- Servidor: `br.edu.ifpr.mcp_server.main.McpServer01SyncStdio`.
- Cliente: `br.edu.ifpr.mcp_server.main.McpClient01SyncStdio`.

Consulte o [README](../README.md) para ver parametros das Tools, comandos de build/teste e configuracao dos clientes compativeis.
