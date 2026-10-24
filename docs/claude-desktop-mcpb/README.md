# Extensão MCPB — Biblioteca Digital MCP (Windows)

Este diretório preserva uma extensão local `.mcpb` de caráter opcional, criada para iniciar o servidor Java compilado localmente. O pacote não inclui o JAR nem as dependências do projeto; usa `target/dist-server/mcp_server01_server.jar` e a pasta `libs` ao lado.

## Estado e método recomendado

Durante os testes no Windows, a extensão instalada apresentou a mensagem **“Não foi possível conectar ao servidor da extensão. Tente desativar e reativar a extensão.”**. Por esse motivo, a extensão foi mantida no repositório para referência, mas deve permanecer desativada no ambiente de validação enquanto se utiliza o método de configuração direta em **Configurações → Desenvolvedor → Editar configuração**. Os registros desse método mostraram inicialização bem-sucedida, consulta de Tools/Prompts/Resources e o servidor em execução.

O enunciado exige que o servidor possa ser testado no Claude Desktop e não exige uma extensão `.mcpb`. Portanto, a extensão não é o método principal de demonstração no estado atual. Consulte `../CLAUDE_DESKTOP.md` para o procedimento recomendado.

Não inicie ao mesmo tempo a extensão e o cadastro direto para o mesmo servidor durante diagnósticos, para evitar duas instâncias do processo Java e confundir a origem das chamadas.

## Conteúdo

- `manifest.json`: metadados, comando e configurações editáveis.
- `server/launcher.js`: encaminhador STDIO entre o Claude Desktop e o processo Java.
- `biblioteca-digital.mcpb`: pacote instalável correspondente.

## Se a extensão for testada novamente

1. Gere o servidor pela raiz: `mvn clean package -Pserver -DskipTests -DskipITs`.
2. Confirme que `java.exe`, o JAR, `target/dist-server/libs/` e `data/` existem.
3. Desative o cadastro direto em **Desenvolvedor** temporariamente, para não iniciar o mesmo servidor por dois métodos.
4. Em **Configurações → Extensões → Configurações avançadas → Instalar extensão**, selecione `biblioteca-digital.mcpb` e confira os três caminhos.
5. Se a conexão falhar, consulte os registros da própria extensão antes de repetir tentativas.

O pacote foi preparado para os caminhos de uma máquina Windows específica; atualize os valores antes de usá-lo em outra máquina. Se o Windows congelar, não repita tentativas nem espere indefinidamente: interrompa a execução se for possível e investigue o registro da extensão.
