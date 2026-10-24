/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.service` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.service;

/*
 * O que faz: Importa a classe URI da biblioteca `java.net`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.net.URI`; o ponto final do pacote identifica a classe importada.
 */
import java.net.URI;
/*
 * O que faz: Importa a classe HttpClient da biblioteca `java.net.http`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.net.http.HttpClient`; o ponto final do pacote identifica a classe importada.
 */
import java.net.http.HttpClient;
/*
 * O que faz: Importa a classe HttpRequest da biblioteca `java.net.http`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.net.http.HttpRequest`; o ponto final do pacote identifica a classe importada.
 */
import java.net.http.HttpRequest;
/*
 * O que faz: Importa a classe HttpResponse da biblioteca `java.net.http`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.net.http.HttpResponse`; o ponto final do pacote identifica a classe importada.
 */
import java.net.http.HttpResponse;
/*
 * O que faz: Importa a classe Duration da biblioteca `java.time`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.time.Duration`; o ponto final do pacote identifica a classe importada.
 */
import java.time.Duration;
/*
 * O que faz: Importa a classe ArrayList da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.ArrayList`; o ponto final do pacote identifica a classe importada.
 */
import java.util.ArrayList;
/*
 * O que faz: Importa a classe Collections da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.Collections`; o ponto final do pacote identifica a classe importada.
 */
import java.util.Collections;
/*
 * O que faz: Importa a classe LinkedHashMap da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.LinkedHashMap`; o ponto final do pacote identifica a classe importada.
 */
import java.util.LinkedHashMap;
/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;
/*
 * O que faz: Importa a classe Map da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.Map`; o ponto final do pacote identifica a classe importada.
 */
import java.util.Map;
/*
 * O que faz: Importa a classe Pattern da biblioteca `java.util.regex`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.regex.Pattern`; o ponto final do pacote identifica a classe importada.
 */
import java.util.regex.Pattern;

/*
 * O que faz: Importa a classe Logger da biblioteca `org.slf4j`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.slf4j.Logger`; o ponto final do pacote identifica a classe importada.
 */
import org.slf4j.Logger;
/*
 * O que faz: Importa a classe LoggerFactory da biblioteca `org.slf4j`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `org.slf4j.LoggerFactory`; o ponto final do pacote identifica a classe importada.
 */
import org.slf4j.LoggerFactory;
/*
 * O que faz: Importa a classe AppProperties da biblioteca `br.edu.ifpr.biblioteca.config`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.config.AppProperties`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.config.AppProperties;
/*
 * O que faz: Importa a classe Book da biblioteca `br.edu.ifpr.biblioteca.model`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.model.Book`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.model.Book;
/*
 * O que faz: Importa a classe TypeReference da biblioteca `tools.jackson.core.type`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `tools.jackson.core.type.TypeReference`; o ponto final do pacote identifica a classe importada.
 */
import tools.jackson.core.type.TypeReference;
/*
 * O que faz: Importa a classe JsonMapper da biblioteca `tools.jackson.databind.json`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `tools.jackson.databind.json.JsonMapper`; o ponto final do pacote identifica a classe importada.
 */
import tools.jackson.databind.json.JsonMapper;


/*
 * O que faz: Declara a classe `GutenbergService`, que consulta a API Gutendex e transforma os dados em livros usados pelo indexador.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class GutenbergService {
    /*
     * O que faz: Declara o atributo `LOG` do tipo `Logger` com visibilidade `private`. Ela comeca com LoggerFactory.getLogger(GutenbergService.class).
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `Logger` define o tipo de dado; `LOG` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private static final Logger LOG = LoggerFactory.getLogger(GutenbergService.class);
    /*
     * O que faz: Declara o atributo `client` do tipo `HttpClient` com visibilidade `private`. Ela comeca com HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).build().
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `HttpClient` define o tipo de dado; `client` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).followRedirects(HttpClient.Redirect.ALWAYS).build();
    /*
     * O que faz: Declara o atributo `mapper` do tipo `JsonMapper` com visibilidade `private`. Ela comeca com new JsonMapper().
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `JsonMapper` define o tipo de dado; `mapper` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final JsonMapper mapper = new JsonMapper();
    /*
     * O que faz: Declara o atributo `properties` do tipo `AppProperties` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `AppProperties` define o tipo de dado; `properties` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final AppProperties properties;
    /*
     * O que faz: Declara o construtor de `GutenbergService` e recebe `AppProperties properties`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `GutenbergService` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public GutenbergService(AppProperties properties){ this.properties=properties; }
    /*
     * O que faz: Declara o metodo `search`; ele recebe `String query, int limit` e produz o tipo `List<Book>`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `public` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `List<Book>` e o retorno; `search` identifica a operacao; os parametros ficam entre parenteses.
     */
    public List<Book> search(String query, int limit) throws Exception {
        /*
         * O que faz: Limita o valor usado pela rotina dentro de uma faixa segura.
         * Por que esta aqui: evitar paginacoes, quantidades ou indices negativos ou grandes demais.
         * Componentes: `Math.max` e `Math.min` comparam os valores e escolhem o limite adequado.
         */
        int bounded = Math.max(1, Math.min(limit, 20));
        /*
         * O que faz: Codifica ou converte texto para que ele possa ser colocado com seguranca na URL da requisicao.
         * Por que esta aqui: evitar que espacos e caracteres especiais de uma pesquisa quebrem o endereco HTTP.
         * Componentes: a classe utilitaria de URL transforma o texto entre o formato usado pela aplicacao e o formato usado na web.
         */
        String url = properties.getGutenbergUrl() + "?search=" + java.net.URLEncoder.encode(query == null ? "" : query, java.nio.charset.StandardCharsets.UTF_8) + "&page=1";
        /*
         * O que faz: Comeca a montagem de uma requisicao HTTP para o endereco indicado.
         * Por que esta aqui: definir como a aplicacao vai acessar a API externa, incluindo tempo limite, cabecalhos e metodo HTTP.
         * Componentes: `newBuilder` cria o construtor; `URI.create` define o destino; metodos encadeados configuram a requisicao.
         */
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).timeout(Duration.ofSeconds(30)).header("Accept","application/json").GET().build();
        /*
         * O que faz: Envia a requisicao HTTP construida anteriormente e recebe a resposta do servico remoto.
         * Por que esta aqui: obter dados reais do Project Gutenberg ou de outro endpoint necessario ao processamento.
         * Componentes: `send` recebe a requisicao e o `BodyHandler` que define como o corpo sera entregue ao programa.
         */
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        /*
         * O que faz: Testa a condicao `response.statusCode()!=200` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(response.statusCode()!=200) throw new IllegalStateException("Project Gutenberg API retornou HTTP " + response.statusCode());
        /*
         * O que faz: Obtem o resultado de `body` e o guarda em `Map<String,Object> root`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `mapper.readValue(response` e o objeto ou expressao chamadora; `body` e o metodo; os argumentos `), new TypeReference<Map<String,Object>>(){}` fornecem suas entradas; `=` faz a atribuicao.
         */
        Map<String,Object> root = mapper.readValue(response.body(), new TypeReference<Map<String,Object>>(){});
        /*
         * O que faz: Cria uma lista mutavel para armazenar resultados que serao acrescentados durante o processamento.
         * Por que esta aqui: ter uma colecao vazia pronta para receber itens na ordem em que forem encontrados.
         * Componentes: `ArrayList` oferece insercao sequencial e cresce conforme novos elementos sao adicionados.
         */
        List<Book> result = new ArrayList<>();
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `Object results`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `root` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"results"` fornecem suas entradas; `=` faz a atribuicao.
         */
        Object results = root.get("results");
        /*
         * O que faz: Testa a condicao `results instanceof List<?> list` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(results instanceof List<?> list){
            /*
             * O que faz: Percorre cada elemento usando a forma for-each definida por `Object raw : list`.
             * Por que esta aqui: processar todos os itens da colecao sem controlar manualmente o indice, como cada planilha, linha ou livro encontrado.
             * Componentes: `for` inicia o laco; `:` separa a variavel que recebe o item da colecao percorrida; a chave abre o bloco repetido.
             */
            for(Object raw : list){
                /*
                 * O que faz: Testa a condicao `result.size()>=bounded` e so executa o bloco seguinte quando ela for verdadeira.
                 * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
                 * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
                 */
                if(result.size()>=bounded) break;
                /*
                 * O que faz: Testa a condicao `raw instanceof Map<?,?> map` e so executa o bloco seguinte quando ela for verdadeira.
                 * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
                 * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
                 */
                if(raw instanceof Map<?,?> map) result.add(toBook(map));
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
         * O que faz: Devolve ao chamador o resultado calculado por `result`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return result;
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `toBook`; ele recebe `Map<?,?> map` e produz o tipo `Book`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `Book` e o retorno; `toBook` identifica a operacao; os parametros ficam entre parenteses.
     */
    private Book toBook(Map<?,?> map) throws Exception {
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `Object idValue`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"id"` fornecem suas entradas; `=` faz a atribuicao.
         */
        Object idValue = map.get("id");
        /*
         * O que faz: Atribui a expressao `long id` o valor `idValue instanceof Number n ? n.longValue() : 0L`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        long id = idValue instanceof Number n ? n.longValue() : 0L;
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `Object titleValue`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"title"` fornecem suas entradas; `=` faz a atribuicao.
         */
        Object titleValue = map.get("title");
        /*
         * O que faz: Converte o valor recebido para representacao textual segura.
         * Por que esta aqui: garantir que dados vindos de mapas, banco ou APIs possam ser concatenados ou retornados como texto.
         * Componentes: `String.valueOf` transforma o objeto indicado em `String` sem exigir conhecer sua classe concreta.
         */
        String title = titleValue == null ? "Sem titulo" : String.valueOf(titleValue);
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `List<String> authors`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `extractNames(map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"authors")` fornecem suas entradas; `=` faz a atribuicao.
         */
        List<String> authors = extractNames(map.get("authors"));
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `List<String> subjects`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `extractNames(map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"subjects")` fornecem suas entradas; `=` faz a atribuicao.
         */
        List<String> subjects = extractNames(map.get("subjects"));
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `List<String> languages`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `extractNames(map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"languages")` fornecem suas entradas; `=` faz a atribuicao.
         */
        List<String> languages = extractNames(map.get("languages"));
        /*
         * O que faz: Verifica se a colecao ou texto nao contem nenhum elemento ou caractere.
         * Por que esta aqui: evitar acessar o primeiro item de uma colecao ou processar um resultado inexistente.
         * Componentes: `isEmpty()` devolve `true` quando nao ha conteudo.
         */
        String language = languages.isEmpty()?"und":languages.get(0);
        /*
         * O que faz: Cria um objeto de `LinkedHashMap<>` e guarda essa instancia em `Map<String,String> formats`.
         * Por que esta aqui: preparar o componente que sera usado nas proximas etapas do fluxo.
         * Componentes: `new` cria o objeto; `LinkedHashMap<>` identifica a classe; os argumentos de construcao ficam apos o nome; `=` guarda a referencia em `Map<String,String> formats`.
         */
        Map<String,String> formats = new LinkedHashMap<>();
        /*
         * O que faz: Obtem o resultado de `get` e o guarda em `Object fm`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `map` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"formats"` fornecem suas entradas; `=` faz a atribuicao.
         */
        Object fm = map.get("formats");
        /*
         * O que faz: Testa a condicao `fm instanceof Map<?,?> m` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(fm instanceof Map<?,?> m){ for(Map.Entry<?,?> e:m.entrySet()) formats.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())); }
        /*
         * O que faz: Converte o texto para letras minusculas.
         * Por que esta aqui: permitir comparacao sem depender de diferencas de maiusculas e minusculas.
         * Componentes: `toLowerCase()` devolve uma nova `String` normalizada para comparacao.
         */
        String textUri = formats.entrySet().stream().filter(e->e.getKey().toLowerCase().contains("text/plain") && !e.getKey().toLowerCase().contains("zip")).map(Map.Entry::getValue).findFirst().orElse("");
        /*
         * O que faz: Verifica se o texto esta vazio ou contem apenas espacos em branco.
         * Por que esta aqui: tratar entradas sem conteudo como ausencia de informacao antes de executar a operacao principal.
         * Componentes: `isBlank()` cobre string vazia e texto formado apenas por espacos.
         */
        String content = textUri.isBlank()?"":downloadText(textUri);
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `new Book(id,title,authors,subjects,language,textUri,content)`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return new Book(id,title,authors,subjects,language,textUri,content);
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `extractNames`; ele recebe `Object value` e produz o tipo `List<String>`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `List<String>` e o retorno; `extractNames` identifica a operacao; os parametros ficam entre parenteses.
     */
    private List<String> extractNames(Object value){
        /*
         * O que faz: Testa a condicao `!(value instanceof List<?> list)` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(!(value instanceof List<?> list)) return Collections.emptyList();
        /*
         * O que faz: Cria uma lista mutavel para armazenar resultados que serao acrescentados durante o processamento.
         * Por que esta aqui: ter uma colecao vazia pronta para receber itens na ordem em que forem encontrados.
         * Componentes: `ArrayList` oferece insercao sequencial e cresce conforme novos elementos sao adicionados.
         */
        List<String> out=new ArrayList<>();
        /*
         * O que faz: Percorre cada elemento usando a forma for-each definida por `Object o:list`.
         * Por que esta aqui: processar todos os itens da colecao sem controlar manualmente o indice, como cada planilha, linha ou livro encontrado.
         * Componentes: `for` inicia o laco; `:` separa a variavel que recebe o item da colecao percorrida; a chave abre o bloco repetido.
         */
        for(Object o:list){
            /*
             * O que faz: Testa a condicao `o instanceof Map<?,?> m` e so executa o bloco seguinte quando ela for verdadeira.
             * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
             * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
             */
            if(o instanceof Map<?,?> m){
                /*
                 * O que faz: Obtem o resultado de `get` e o guarda em `Object name`.
                 * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
                 * Componentes: `m` e o objeto ou expressao chamadora; `get` e o metodo; os argumentos `"name"` fornecem suas entradas; `=` faz a atribuicao.
                 */
                Object name=m.get("name");
                /*
                 * O que faz: Testa a condicao `name!=null` e so executa o bloco seguinte quando ela for verdadeira.
                 * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
                 * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
                 */
                if(name!=null) out.add(String.valueOf(name));
            /*
             * O que faz: Fecha o bloco condicional anterior e inicia o caminho alternativo.
             * Por que esta aqui: continuar a decisao da rotina quando a condicao anterior nao foi satisfeita.
             * Componentes: `}` fecha o bloco anterior e `else` abre o caso alternativo; a chave final fecha o novo bloco.
             */
            } else { out.add(String.valueOf(o)); }
        /*
         * O que faz: Fecha o bloco de codigo aberto anteriormente.
         * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
         * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
         */
        }
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `out`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return out;
    /*
     * O que faz: Fecha o bloco de codigo aberto anteriormente.
     * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
     * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
     */
    }
    /*
     * O que faz: Declara o metodo `downloadText`; ele recebe `String url` e produz o tipo `String`.
     * Por que esta aqui: encapsular uma operacao especifica para que ela possa ser chamada no ponto correto do fluxo da aplicacao.
     * Componentes: `private` controla o acesso; `sem static` informa se o metodo pertence a classe ou ao objeto; `String` e o retorno; `downloadText` identifica a operacao; os parametros ficam entre parenteses.
     */
    private String downloadText(String url) throws Exception {
        /*
         * O que faz: Comeca a montagem de uma requisicao HTTP para o endereco indicado.
         * Por que esta aqui: definir como a aplicacao vai acessar a API externa, incluindo tempo limite, cabecalhos e metodo HTTP.
         * Componentes: `newBuilder` cria o construtor; `URI.create` define o destino; metodos encadeados configuram a requisicao.
         */
        HttpRequest req=HttpRequest.newBuilder(URI.create(url)).timeout(Duration.ofSeconds(60)).header("Accept","text/plain").GET().build();
        /*
         * O que faz: Envia a requisicao HTTP construida anteriormente e recebe a resposta do servico remoto.
         * Por que esta aqui: obter dados reais do Project Gutenberg ou de outro endpoint necessario ao processamento.
         * Componentes: `send` recebe a requisicao e o `BodyHandler` que define como o corpo sera entregue ao programa.
         */
        HttpResponse<String> resp=client.send(req,HttpResponse.BodyHandlers.ofString());
        /*
         * O que faz: Testa a condicao `resp.statusCode()!=200` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(resp.statusCode()!=200) throw new IllegalStateException("Nao foi possivel baixar o texto: HTTP "+resp.statusCode());
        /*
         * O que faz: Obtem o resultado de `body` e o guarda em `String body`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `resp` e o objeto ou expressao chamadora; `body` e o metodo; os argumentos `` fornecem suas entradas; `=` faz a atribuicao.
         */
        String body=resp.body();
        /*
         * O que faz: Atribui a expressao `String marker` o valor `"*** START OF THE PROJECT GUTENBERG EBOOK"`.
         * Por que esta aqui: manter em uma variavel o valor necessario para a proxima etapa do fluxo.
         * Componentes: `=` faz a atribuicao; o lado esquerdo recebe o valor calculado no lado direito; `;` encerra a instrucao.
         */
        String marker="*** START OF THE PROJECT GUTENBERG EBOOK";
        /*
         * O que faz: Obtem o resultado de `indexOf` e o guarda em `int start`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `body` e o objeto ou expressao chamadora; `indexOf` e o metodo; os argumentos `marker` fornecem suas entradas; `=` faz a atribuicao.
         */
        int start=body.indexOf(marker);
        /*
         * O que faz: Testa a condicao `start>=0` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(start>=0){ int firstBreak=body.indexOf('\n',start); if(firstBreak>=0) body=body.substring(firstBreak+1); }
        /*
         * O que faz: Obtem o resultado de `indexOf` e o guarda em `int end`.
         * Por que esta aqui: guardar o dado produzido pela etapa atual para que a proxima instrucao consiga utiliza-lo.
         * Componentes: `body` e o objeto ou expressao chamadora; `indexOf` e o metodo; os argumentos `"*** END OF THE PROJECT GUTENBERG EBOOK"` fornecem suas entradas; `=` faz a atribuicao.
         */
        int end=body.indexOf("*** END OF THE PROJECT GUTENBERG EBOOK");
        /*
         * O que faz: Testa a condicao `end>0` e so executa o bloco seguinte quando ela for verdadeira.
         * Por que esta aqui: validar uma situacao antes de continuar e proteger o restante da rotina contra dados invalidos ou estados indevidos.
         * Componentes: `if` inicia a decisao; a expressao entre parenteses e a condicao; a chave delimita o trecho condicional.
         */
        if(end>0) body=body.substring(0,end);
        /*
         * O que faz: Devolve ao chamador o resultado calculado por `body.strip()`.
         * Por que esta aqui: encerrar o metodo entregando exatamente a informacao prometida na assinatura.
         * Componentes: `return` termina a execucao daquele caminho do metodo e a expressao seguinte e o valor retornado.
         */
        return body.strip();
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
