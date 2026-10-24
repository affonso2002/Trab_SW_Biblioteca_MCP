/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.mcp` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.mcp;

/*
 * O que faz: Importa a classe Base64 da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.Base64`; o ponto final do pacote identifica a classe importada.
 */
import java.io.IOException;
import java.util.Base64;
/*
 * O que faz: Importa a classe Files da biblioteca `java.nio.file`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.nio.file.Files`; o ponto final do pacote identifica a classe importada.
 */
import java.nio.file.Files;
/*
 * O que faz: Importa a classe Path da biblioteca `java.nio.file`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.nio.file.Path`; o ponto final do pacote identifica a classe importada.
 */
import java.nio.file.Path;
/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;
/*
 * O que faz: Importa a classe FileStorage da biblioteca `br.edu.ifpr.biblioteca.config`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.config.FileStorage`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.config.FileStorage;
/*
 * O que faz: Importa a especificacao sincrona do servidor MCP, usada para registrar os Resources.
 * Por que esta aqui: os Resources sao registrados nessa configuracao do servidor antes da construcao final.
 * Componentes: SyncSpecification e o tipo usado pelo codigo para registrar funcionalidades no servidor MCP.
 */
import io.modelcontextprotocol.server.McpServer.SyncSpecification;
/*
 * O que faz: Importa a classe SyncResourceSpecification da biblioteca `io.modelcontextprotocol.server.McpServerFeatures`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.server.McpServerFeatures.SyncResourceSpecification`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.server.McpServerFeatures.SyncResourceSpecification;
/*
 * O que faz: Importa a classe BlobResourceContents da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.BlobResourceContents`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.BlobResourceContents;
/*
 * O que faz: Importa a classe ReadResourceResult da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.ReadResourceResult`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.ReadResourceResult;
/*
 * O que faz: Importa a classe Resource da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.Resource`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.Resource;
/*
 * O que faz: Importa a classe TextResourceContents da biblioteca `io.modelcontextprotocol.spec.McpSchema`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `io.modelcontextprotocol.spec.McpSchema.TextResourceContents`; o ponto final do pacote identifica a classe importada.
 */
import io.modelcontextprotocol.spec.McpSchema.TextResourceContents;


/*
 * O que faz: Declara a classe `ResourcesFeature`, que registra recursos MCP que expoem arquivos e informacoes do indice.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class ResourcesFeature implements McpFeature {
    /*
     * O que faz: Declara o atributo `storage` do tipo `FileStorage` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `FileStorage` define o tipo de dado; `storage` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final FileStorage storage;
    /*
     * O que faz: Declara o construtor de `ResourcesFeature` e recebe `FileStorage storage`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `ResourcesFeature` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public ResourcesFeature(FileStorage storage) { this.storage = storage; }

    /*
     * O que faz: Le o PDF indicado e transforma seus bytes em Base64.
     * Por que esta aqui: concentra a leitura do arquivo e o tratamento da IOException no mesmo ponto.
     * Componentes: Path identifica o arquivo; Files le os bytes; Base64 cria a representacao textual.
     */
    private String readPdfAsBase64(Path path) {
        /*
         * O que faz: Inicia o bloco protegido para a leitura do arquivo.
         * Por que esta aqui: a operacao pode gerar IOException e precisa ser tratada antes de voltar ao handler MCP.
         * Componentes: try delimita a operacao que pode falhar.
         */
        try {
            /*
             * O que faz: Le todos os bytes do PDF e converte o conteudo para Base64.
             * Por que esta aqui: permite transportar um arquivo binario em uma representacao textual.
             * Componentes: Files.readAllBytes le o arquivo e encodeToString converte os bytes.
             */
            return Base64.getEncoder().encodeToString(Files.readAllBytes(path));
        /*
         * O que faz: Captura uma falha de entrada ou saida.
         * Por que esta aqui: garante que o erro de arquivo seja transformado em uma excecao de aplicacao compreensivel.
         * Componentes: catch intercepta IOException e exception guarda a causa.
         */
        } catch (IOException exception) {
            /*
             * O que faz: Cria uma excecao de estado contendo o arquivo e a causa original.
             * Por que esta aqui: o handler do Resource nao precisa declarar IOException.
             * Componentes: IllegalStateException representa a falha operacional e recebe a causa original.
             */
            throw new IllegalStateException(
                    "Nao foi possivel ler o PDF do recurso MCP: " + path,
                    exception);
        }
    }

    @Override
    /*
     * O que faz: Declara o metodo `register`; ele recebe a especificacao sincrona do servidor MCP e nao devolve um valor.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `void` e o retorno; `register` identifica a operacao; os parametros ficam entre parenteses.
     */
    public void register(SyncSpecification<?> mcp) throws Exception {
        /*
         * O que faz: Comeca a definir um Resource MCP identificado por uma URI.
         * Por que esta aqui: tornar um arquivo ou informacao legivel por clientes MCP por meio de um endereco estavel.
         * Componentes: `Resource.builder` recebe uma URI e um nome legivel; descricao e MIME completam a definicao.
         */
        Resource indexResource = Resource.builder("library://index/info", "Estado do indice Lucene")
                /*
                 * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"Local fisico do indice de busca embutido."`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .description("Local fisico do indice de busca embutido.")
                /*
                 * O que faz: informa o tipo MIME do recurso, usando os argumentos `"text/plain"`.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.mimeType` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .mimeType("text/plain")
                /*
                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                 */
                .build();
        /*
         * O que faz: Registra no servidor MCP o Resource criado naquele ponto.
         * Por que esta aqui: permitir que o cliente leia dados ou arquivos identificados por uma URI de recurso.
         * Componentes: `resources(...)` recebe a especificacao do recurso e associa sua leitura ao manipulador definido.
         */
        mcp.resources(new SyncResourceSpecification(indexResource,
                /*
                 * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                 * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                 * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                 */
                (exchange, request) -> ReadResourceResult.builder(List.of(
                        /*
                         * O que faz: Monta o conteudo textual do Resource com o caminho absoluto do indice Lucene.
                         * Por que esta aqui: O Resource fornece ao cliente uma forma de descobrir onde o indice local esta armazenado.
                         * Componentes: `request.uri()` preserva a URI solicitada; `storage.lucene()` localiza o indice; `toAbsolutePath()` produz um caminho absoluto.
                         */
                        TextResourceContents.builder(request.uri(), storage.lucene().toAbsolutePath().toString())
                                /*
                                 * O que faz: informa o tipo MIME do recurso, usando os argumentos `"text/plain"`.
                                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                                 * Componentes: `.mimeType` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                                 */
                                .mimeType("text/plain")
                                /*
                                 * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos `))`.
                                 * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                                 * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                                 */
                                .build()))
                        /*
                         * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos `))`.
                         * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                         * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                         */
                        .build()));

        /*
         * O que faz: Monta ou normaliza um caminho de arquivo a partir do caminho configurado e do trecho indicado na linha.
         * Por que esta aqui: garantir que a operacao de armazenamento use a pasta correta e um caminho previsivel para os arquivos da biblioteca.
         * Componentes: `Path.of` cria um caminho; `resolve` acrescenta um nome; `normalize` remove segmentos redundantes quando aplicavel.
         */
        Path examplePdf = storage.input().resolve("exemplo.pdf");
        /*
         * O que faz: Testa a condicao `Files.exists(examplePdf)` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if (Files.exists(examplePdf)) {
            /*
             * O que faz: Comeca a definir um Resource MCP identificado por uma URI.
             * Por que esta aqui: tornar um arquivo ou informacao legivel por clientes MCP por meio de um endereco estavel.
             * Componentes: `Resource.builder` recebe uma URI e um nome legivel; descricao e MIME completam a definicao.
             */
            Resource pdfResource = Resource.builder("library://file/exemplo.pdf", "PDF de exemplo")
                    /*
                     * O que faz: define a descricao apresentada ao cliente MCP, usando os argumentos `"PDF de exemplo disponivel como recurso MCP."`.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.description` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .description("PDF de exemplo disponivel como recurso MCP.")
                    /*
                     * O que faz: informa o tipo MIME do recurso, usando os argumentos `"application/pdf"`.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.mimeType` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .mimeType("application/pdf")
                    /*
                     * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos ``.
                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                     * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                     */
                    .build();
            /*
             * O que faz: Registra no servidor MCP o Resource criado naquele ponto.
             * Por que esta aqui: permitir que o cliente leia dados ou arquivos identificados por uma URI de recurso.
             * Componentes: `resources(...)` recebe a especificacao do recurso e associa sua leitura ao manipulador definido.
             */
            mcp.resources(new SyncResourceSpecification(pdfResource,
                    /*
                     * O que faz: Cria uma lista imutavel contendo os elementos indicados.
                     * Por que esta aqui: fornecer uma colecao fixa quando o codigo nao precisa adicionar ou remover elementos depois da criacao.
                     * Componentes: `List.of` recebe os elementos diretamente e devolve a lista pronta para uso.
                     */
                    (exchange, request) -> ReadResourceResult.builder(List.of(
                            /*
                             * O que faz: Inicia a construcao do conteudo binario do Resource do PDF.
                             * Por que esta aqui: O PDF deve ser oferecido como conteudo binario com seu tipo MIME, nao como texto simples.
                             * Componentes: `request.uri()` identifica o Resource lido e `BlobResourceContents.builder` cria o conteudo binario.
                             */
                            BlobResourceContents.builder(request.uri(),
                                    /*
                                     * O que faz: Fornece o PDF convertido para Base64 ao conteudo binario do Resource.
                                     * Por que esta aqui: A conversao permite transportar os bytes do PDF na representacao esperada pelo SDK MCP.
                                     * Componentes: `readPdfAsBase64` le o arquivo e codifica seus bytes; `examplePdf` e o caminho do arquivo de demonstracao.
                                     */
                                    readPdfAsBase64(examplePdf))
                                    /*
                                     * O que faz: informa o tipo MIME do recurso, usando os argumentos `"application/pdf"`.
                                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                                     * Componentes: `.mimeType` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                                     */
                                    .mimeType("application/pdf")
                                    /*
                                     * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos `))`.
                                     * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                                     * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                                     */
                                    .build()))
                            /*
                             * O que faz: finaliza o objeto configurado pelo builder, usando os argumentos `))`.
                             * Por que esta aqui: configurar o componente nesta etapa antes de entrega-lo ou registra-lo no restante da aplicacao.
                             * Componentes: `.build` e a chamada encadeada; os valores entre parenteses sao seus argumentos; a chamada participa do mesmo objeto que esta sendo configurado.
                             */
                            .build()));
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
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
