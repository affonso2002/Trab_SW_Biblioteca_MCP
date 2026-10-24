/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.mcp` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.mcp;

/*
 * O que faz: Importa a especificacao sincrona-base do servidor MCP.
 * Por que esta aqui: Tools, Resources e Prompts podem ser registrados no transporte STDIO do cliente MCP.
 * Componentes: SyncSpecification<?> e o tipo-base comum aos servidores sincronos do MCP Java SDK 2.0.1.
 */
import io.modelcontextprotocol.server.McpServer.SyncSpecification;

/*
 * O que faz: Declara a interface `McpFeature`, que funciona como contrato de comportamento.
 * Por que esta aqui: permitir que diferentes componentes implementem o mesmo conjunto de operacoes sem depender de uma classe concreta.
 * Componentes: `interface` define metodos que implementadores devem fornecer; o nome identifica o contrato.
 */
public interface McpFeature {
        /*
     * O que faz: Declara o metodo que registra uma Feature no servidor MCP sincrono.
     * Por que esta aqui: a mesma Feature precisa funcionar em qualquer cliente que utilize o servidor MCP por STDIO.
     * Componentes: SyncSpecification<?> representa o tipo-base de configuracao; register adiciona Tools, Resources ou Prompts; throws Exception permite relatar falhas durante o registro.
     */
    void register(SyncSpecification<?> mcp) throws Exception;
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
