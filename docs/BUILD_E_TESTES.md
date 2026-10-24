# Builds e testes Maven

Pre-requisitos: JDK 21 (ou superior) e Maven 3.9 ou superior. Execute todos os comandos a partir da raiz do projeto.

## Validar o projeto

```bash
mvn clean verify
```

O comando compila o projeto, executa testes unitarios (`*Test.java`) pelo Surefire e testes de integracao (`*IT.java`) pelo Failsafe. A integracao inicia o servidor como processo Java e negocia o protocolo MCP por STDIO.

## Executar os testes separadamente

```bash
mvn test
mvn -Dtest=FileStorageTest test
mvn -Dtest=GutenbergServiceTest,IndexingServiceTest,LibraryRepositoryTest,SolrIndexServiceTest test
mvn -Dit.test=McpProtocolIT verify
```

`mvn test` executa os testes unitarios. O ultimo comando executa especificamente a integracao do protocolo MCP; o Failsafe roda no ciclo `verify`.

## Gerar os artefatos

Os comandos de geração abaixo não executam a suíte de testes; execute `mvn clean verify` separadamente para validar testes unitários e de integração antes de gerar os artefatos de demonstração.

```bash
mvn clean package -Pserver -DskipTests -DskipITs
mvn package -Pclient -DskipTests -DskipITs
```

Artefatos esperados:

- Servidor: `target/dist-server/mcp_server01_server.jar` e `target/dist-server/libs/`.
- Cliente: `target/dist-client/mcp_server01_client.jar` e `target/dist-client/libs/`.

Não mova os JARs para fora das respectivas pastas: os manifestos usam a pasta `libs/` e o cliente localiza o servidor em `../dist-server/`. **Não use `clean` no segundo comando de build**, pois ele apagaria o servidor gerado pelo primeiro comando. Para comprovar a execução do Cliente 01 e do MCP Inspector, siga `CLIENTE01_STDIO.md` e `MCP_INSPECTOR_PASSO_A_PASSO.md` depois de gerar os artefatos.
