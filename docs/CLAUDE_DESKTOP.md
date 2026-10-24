# Integração com o Claude Desktop

Este guia registra os dois mecanismos que foram avaliados no ambiente Windows usado durante o desenvolvimento: a configuração direta em **Configurações → Desenvolvedor → Servidores MCP locais** e a extensão local `.mcpb`.

## 1. Método recomendado para uso atual: Desenvolvedor → Editar configuração

O método de configuração direta foi iniciado no Claude Desktop deste ambiente e os registros exibiram `Server started and connected successfully`, a resposta a `initialize` e as consultas `tools/list`, `prompts/list` e `resources/list`. A tela de Desenvolvedor também exibiu o servidor `biblioteca-digital` com estado **Em execução**. Há, ainda, capturas da chamada de `extrair_metadados_pdf` e do resultado apresentado pelo Claude.

Por isso, para uso e demonstração do trabalho, mantenha o servidor cadastrado em **Configurações → Desenvolvedor → Editar configuração**. A sequência detalhada de execução e verificação consta abaixo.

### Gerar o artefato do servidor

Na raiz do projeto, com JDK 21 (ou superior) e Maven 3.9 ou superior:

```powershell
mvn clean package -Pserver -DskipTests -DskipITs
```

O artefato esperado é `target\dist-server\mcp_server01_server.jar`, acompanhado da pasta `target\dist-server\libs\`. Não mova o JAR para fora dessa pasta.

### Configurar o servidor

1. Abra o Claude Desktop.
2. Acesse **Configurações → Desenvolvedor → Editar configuração**. Use o arquivo aberto pelo próprio aplicativo, em vez de presumir um caminho fixo.
3. Faça uma cópia de segurança do conteúdo atual.
4. Preserve as demais configurações e preferências que já existam. Acrescente `mcpServers` como propriedade de primeiro nível, no mesmo nível de `preferences` (não dentro de `preferences`).
5. Adicione a configuração abaixo, ajustando os caminhos à máquina onde o projeto for executado.

Exemplo correspondente ao ambiente Windows registrado neste projeto:

```json
{
  "mcpServers": {
    "biblioteca-digital": {
      "command": "C:\\Program Files\\Java\\jdk-26.0.2\\bin\\java.exe",
      "args": [
        "-jar",
        "C:\\Users\\PC\\eclipse-workspace\\mcp-server01Trab1\\target\\dist-server\\mcp_server01_server.jar"
      ],
      "env": {
        "APP_DATA_DIR": "C:\\Users\\PC\\eclipse-workspace\\mcp-server01Trab1\\data",
        "SOLR_ENABLED": "false"
      }
    }
  }
}
```

O arquivo isolado de exemplo `claude_desktop_config.windows.PC.example.json` fica em `docs/`. Ele contém somente a propriedade `mcpServers` para facilitar a cópia; não substitua um arquivo maior de preferências pelo fragmento isolado. A configuração no Claude deve ser um único JSON válido.

### Reiniciar e confirmar a conexão

1. Salve o arquivo.
2. Feche completamente o Claude Desktop e abra-o novamente.
3. Em **Configurações → Desenvolvedor**, confirme que `biblioteca-digital` aparece como **Em execução**.
4. Consulte os registros e procure a inicialização bem-sucedida, a resposta a `initialize` e as consultas de descoberta de Tools, Prompts e Resources.
5. Em uma conversa nova, use o botão `+` → **Conectores** para conferir a disponibilidade do conector e execute uma ferramenta real. Para um teste inicial, use `extrair_metadados_pdf` com `fileName` igual a `exemplo.pdf`.

O servidor utiliza transporte **STDIO**. Não configure URL HTTP, porta de serviço, token Bearer nem certificado TLS para esta configuração.

## 2. Estado da extensão `.mcpb` mantida no projeto

O pacote personalizado `biblioteca-digital.mcpb` foi mantido em `docs/claude-desktop-mcpb/` para referência e possível investigação posterior. Durante o teste local, o Claude Desktop exibiu a mensagem **“Não foi possível conectar ao servidor da extensão. Tente desativar e reativar a extensão.”**. A extensão fica, portanto, **mantida, porém desativada no ambiente usado para a validação**, enquanto se utiliza o cadastro direto em Desenvolvedor, que apresentou inicialização e descoberta MCP bem-sucedidas.

Essa decisão não significa que a extensão esteja corrigida nem que sua conexão tenha sido comprovada. Não habilite simultaneamente a extensão e o cadastro direto para iniciar o mesmo servidor durante testes de diagnóstico: isso pode abrir duas instâncias do processo Java e dificultar a interpretação dos resultados. Para testar a extensão futuramente, desative primeiro o cadastro direto, faça uma tentativa controlada e examine os registros específicos da extensão.

A extensão `.mcpb` não é uma exigência explícita do enunciado. O requisito é que o servidor seja testável no Claude Desktop e no MCP Inspector. A configuração direta atende ao método que foi confirmado neste ambiente.

## 3. Evidências registradas

As capturas autênticas ficam em `docs/execucao/` e estão catalogadas em [`EVIDENCIAS_EXECUCAO.md`](EVIDENCIAS_EXECUCAO.md). Elas distinguem a instalação/configuração da extensão, a mensagem de falha da extensão, o estado do servidor direto e a chamada de ferramenta apresentada no Claude.

Para uma evidência inequívoca de que a chamada de ferramenta ocorreu somente pelo método Desenvolvedor, mantenha a extensão desativada durante a chamada e, se necessário, capture novamente o resultado. Não apresente a tela de instalação da extensão nem o estado “Em execução” isoladamente como prova de execução bem-sucedida de uma ferramenta.

## 4. Diagnóstico sem tentativas repetidas

Se a conexão falhar:

- Confira o caminho do `java.exe`, do JAR e da pasta `data`.
- Confirme que a pasta `libs` fica ao lado do JAR.
- Use **Ver registros** na tela de Desenvolvedor para consultar o erro exato.
- Não espere indefinidamente se o Windows inteiro congelar. Um servidor STDIO pode permanecer ativo aguardando mensagens; congelamento completo do sistema não é comportamento normal.
- Consulte também [`MCP_INSPECTOR_PASSO_A_PASSO.md`](MCP_INSPECTOR_PASSO_A_PASSO.md) para verificar o servidor por um cliente independente.
