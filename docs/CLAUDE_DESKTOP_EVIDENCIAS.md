# Evidências de configuração e teste no Claude Desktop

As capturas **11–26** documentam a sequência de configuração e tentativa de uso do Claude Desktop. Elas distinguem explicitamente o estado inicial, a extensão `.mcpb`, o erro de conexão da extensão, a configuração direta em Desenvolvedor e as chamadas observadas no conector.

| Captura | O que documenta |
|---|---|
| `11-claude-desktop-extensoes-avancadas.png` | Tela de configurações avançadas de extensões. |
| `12-instalacao-extensao-mcpb-aviso-de-seguranca.png` | Tela de instalação do pacote `.mcpb` e aviso de segurança. |
| `13-confirmacao-de-instalacao-da-extensao-mcpb.png` | Diálogo de confirmação de instalação. |
| `14-configuracao-dos-caminhos-java-jar-e-data-da-extensao.png` | Parâmetros editáveis da extensão (Java, JAR e pasta de dados). |
| `15-extensao-biblioteca-digital-listada-como-instalada.png` | Extensão na lista de extensões instaladas. |
| `16-desenvolvedor-sem-servidores-mcp-cadastrados-inicialmente.png` | Estado inicial sem servidores MCP locais cadastrados. |
| `17-extensao-mcpb-mensagem-de-falha-de-conexao.png` | Erro reportado pela extensão personalizada. |
| `18-servidor-biblioteca-digital-em-execucao-no-desenvolvedor.png` | Estado “Em execução” do método direto em Desenvolvedor. |
| `19-configuracoes-avancadas-de-extensoes-do-claude.png` | Opções gerais de extensões e Node.js integrado. |
| `20-menu-conectores-com-biblioteca-digital-habilitada.png` | Conector `biblioteca-digital` visível no menu. |
| `21-opcoes-de-carregamento-de-ferramentas-dos-conectores.png` | Preferência de carregamento de ferramentas. |
| `22-itens-do-conector-pesquisa-indice-lucene-e-pdf-de-exemplo.png` | Itens disponíveis para adicionar pelo conector. |
| `23-resource-pdf-de-exemplo-anexado-e-analisado.png` | Acesso ao Resource PDF e análise do documento. |
| `24-solicitacao-de-autorizacao-para-extrair-metadados-pdf.png` | Pedido de autorização para a ferramenta PDF. |
| `25-resultado-da-ferramenta-extrair-metadados-pdf.png` | Resultado apresentado para a extração de metadados. |
| `26-continuacao-da-amostra-de-texto-extraida-do-pdf.png` | Continuação da amostra de texto retornada. |

**Estado documentado:** a extensão `.mcpb` foi mantida no projeto, mas apresentou uma mensagem de falha de conexão e deve ficar desativada no ambiente atual. O método direto configurado em **Desenvolvedor → Editar configuração** exibiu o servidor como “Em execução” e seus registros confirmaram inicialização e descoberta de Tools/Prompts/Resources. Para eliminar qualquer ambiguidade sobre a origem de uma chamada, a extensão deve permanecer desativada durante a validação do método direto.

As capturas 25–26 registram o resultado apresentado após a solicitação a `extrair_metadados_pdf` com `fileName=exemplo.pdf`. Para a entrega, acrescente capturas 27 em diante após validar Cliente 01 e MCP Inspector. Todas as imagens devem continuar sendo capturas reais do ambiente.
