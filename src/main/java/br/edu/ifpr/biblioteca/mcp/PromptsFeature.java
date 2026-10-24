/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.mcp` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.mcp;

/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;
/*
 * O que faz: Importa a classe SyncPromptSpecification da biblioteca `io.modelcontextprotocol.server.McpServerFeatures`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.server.McpServerFeatures.SyncPromptSpecification`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.server.McpServer.SyncSpecification;
import io.modelcontextprotocol.server.McpServerFeatures.SyncPromptSpecification;
/*
 * O que faz: Importa a classe GetPromptResult da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.GetPromptResult`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.GetPromptResult;
/*
 * O que faz: Importa a classe Prompt da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.Prompt`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.Prompt;
/*
 * O que faz: Importa a classe PromptArgument da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.PromptArgument`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.PromptArgument;
/*
 * O que faz: Importa a classe PromptMessage da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.PromptMessage`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.PromptMessage;
/*
 * O que faz: Importa a classe Role da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.Role`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.Role;
/*
 * O que faz: Importa a classe TextContent da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.TextContent`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.TextContent;


/*
 * O que faz: Declara a classe `PromptsFeature`, que registra os prompts MCP usados para orientar pesquisas bibliograficas.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class PromptsFeature implements McpFeature {
    /*
     * O que faz: Informa ao compilador que o metodo seguinte substitui uma implementacao herdada ou declarada em contrato.
     * Por que esta aqui: deixar explicito que a classe esta cumprindo um comportamento definido por uma classe-base ou interface.
     * Componentes: `@Override` verifica se realmente existe um metodo compativel para sobrescrever.
     */
    @Override
    /*
     * O que faz: Declara o metodo `register`; ele recebe `SyncSpecification<?> mcp` e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `register` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void register(SyncSpecification<?> mcp) throws Exception {
        /*
         * O que faz: Comeca a definir um Prompt MCP nomeado.
         * Por que esta aqui: permitir que Claude peca um roteiro de consulta reutilizavel sem repetir manualmente as mesmas instrucoes.
         * Componentes: `Prompt.builder` recebe o nome; os metodos seguintes definem descricao e argumentos.
         */
        Prompt prompt = Prompt.builder("pesquisar_biblioteca")
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Roteiro para uma pesquisa bibliografica reproduzivel com a biblioteca MCP."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Roteiro para uma pesquisa bibliografica reproduzivel com a biblioteca MCP.")
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                .arguments(List.of(PromptArgument.builder("tema")
                        /*
                         * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Tema que devera ser pesquisado."`.
                         * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                         * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                         */
                        .description("Tema que devera ser pesquisado.")
                        /*
                         * O que faz: marca um argumento do Prompt como obrigatorio, usando os argumentos `true`.
                         * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                         * Componentes: `.required` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                         */
                        .required(true)
                        /*
                         * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos `))`.
                         * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                         * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                         */
                        .build()))
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Registra o Prompt MCP construido pela classe.
         * Por que esta aqui: permitir que o cliente solicite um roteiro de instrucoes reutilizavel para orientar consultas a biblioteca.
         * Componentes: `prompts(...)` recebe a especificacao do prompt com seus argumentos e gerador de mensagens.
         */
        mcp.prompts(new SyncPromptSpecification(prompt, (exchange, request) -> {
            /*
             * O que faz: Converte o valor recebido para representacao textual segura.
             * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
             * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
             */
            String theme = String.valueOf(request.arguments().get("tema"));
            /*
             * O que faz: Inicia o texto do prompt com o tema recebido pelo cliente.
             * Por que esta aqui: O tema contextualiza a instrucao que sera devolvida para orientar a pesquisa.
             * Componentes: `theme` e interpolado na instrucao; o operador `+` concatena os trechos em uma unica String.
             */
            String text = "Voce e um bibliotecario digital. Pesquise na biblioteca MCP sobre: " + theme + ". " +
                    /*
                     * O que faz: Acrescenta criterios para executar a busca e apresentar os resultados.
                     * Por que esta aqui: O prompt orienta o assistente a usar a ferramenta apropriada e a explicar os dados recuperados.
                     * Componentes: O texto especifica a Tool `buscar_livros` e os campos esperados na resposta; `+` continua a concatenacao.
                     */
                    "Use buscar_livros, priorize relevancia, informe titulo, autor, identificador Gutenberg e origem do resultado. " +
                    /*
                     * O que faz: Executa a instrucao `"Nao invente dados que nao estejam disponiveis."`.
                     * Por que esta aqui: realizar neste momento a operacao necessaria para que o fluxo prossiga com o estado atualizado.
                     * Componentes: o nome do metodo ou objeto na instrucao identifica o recurso usado; os argumentos entre parenteses fornecem os dados; `;` encerra a instrucao.
                     */
                    "Nao invente dados que nao estejam disponiveis.";
            /*
             * O que faz: Obtem o resultado de `build` e o guarda em `PromptMessage message`.
             * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
             * Componentes: `PromptMessage.builder(Role.USER, TextContent.builder(text).build())` e o objeto ou expressao chamadora; `build` e o metodo; os argumentos `` fornecem suas entradas; `=` faz a atribuicao.
             */
            PromptMessage message = PromptMessage.builder(Role.USER, TextContent.builder(text).build()).build();
            /*
             * O que faz: Devolve ao chamador o resultado calculado por `GetPromptResult.builder(List.of(message))`.
             * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
             * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
             */
            return GetPromptResult.builder(List.of(message))
                    /*
                     * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Prompt padrao para pesquisa bibliografica."`.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .description("Prompt padrao para pesquisa bibliografica.")
                    /*
                     * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .build();
        /*
         * O que faz: Fecha o bloco de codigo aberto anteriormente.
         * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
         * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
         */
        }));
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
