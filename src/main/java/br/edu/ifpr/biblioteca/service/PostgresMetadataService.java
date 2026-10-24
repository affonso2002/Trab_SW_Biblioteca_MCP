/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.service` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.service;

/*
 * O que faz: Importa a classe Connection da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.Connection`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.Connection;
/*
 * O que faz: Importa a classe DriverManager da biblioteca `java.sql`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.sql.DriverManager`; o ponto final do pacote identifica a classe importada.
 */
import java.sql.DriverManager;

/*
 * O que faz: Importa a classe AppProperties da biblioteca `br.edu.ifpr.biblioteca.config`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `br.edu.ifpr.biblioteca.config.AppProperties`; o ponto final do pacote identifica a classe importada.
 */
import br.edu.ifpr.biblioteca.config.AppProperties;


/*
 * O que faz: Declara a classe `PostgresMetadataService`, que acessa metadados estruturais do PostgreSQL por JDBC.
 * Por que esta aqui: criar o tipo Java responsavel por essa parte do fluxo e manter a responsabilidade separada das demais classes.
 * Componentes: `class` inicia a definicao; o nome identifica o tipo; a chave abre o bloco em que seus atributos e metodos serao definidos.
 */
public class PostgresMetadataService extends DatabaseMetadataService {
    /*
     * O que faz: Declara o atributo `p` do tipo `AppProperties` com visibilidade `private`.
     * Por que esta aqui: guardar no objeto uma informacao que sera usada por outros metodos da propria classe; o valor inicial ou estado vazio prepara o objeto para o uso seguinte.
     * Componentes: `private` controla acesso; `AppProperties` define o tipo de dado; `p` e o nome do atributo; a inicializacao, quando existe, vem depois de `=`.
     */
    private final AppProperties p;
    /*
     * O que faz: Declara o construtor de `PostgresMetadataService` e recebe `AppProperties p`.
     * Por que esta aqui: preparar o objeto no momento em que ele e criado, guardando as dependencias necessarias antes dos outros metodos serem usados.
     * Componentes: O nome `PostgresMetadataService` identifica o construtor; os valores entre parenteses sao as dependencias ou dados iniciais recebidos.
     */
    public PostgresMetadataService(AppProperties p){this.p=p;}
    /*
     * O que faz: Indica que o metodo `name` implementa ou substitui um metodo herdado e declara sua execucao, recebendo `` e retornando `String`.
     * Por que esta aqui: combinar a verificacao do `@Override` com a assinatura do metodo deixa claro, no mesmo ponto, qual contrato da classe-base esta sendo atendido.
     * Componentes: `@Override` marca a sobrescrita; `public` controla o acesso; `String` e o retorno; `name` e o metodo; os parametros ficam entre parenteses; `throws` declara excecoes quando presente.
     */
    @Override public String name(){return "PostgreSQL";}
    /*
     * O que faz: Indica que o metodo `connect` implementa ou substitui um metodo herdado e declara sua execucao, recebendo `` e retornando `Connection`.
     * Por que esta aqui: combinar a verificacao do `@Override` com a assinatura do metodo deixa claro, no mesmo ponto, qual contrato da classe-base esta sendo atendido.
     * Componentes: `@Override` marca a sobrescrita; `protected` controla o acesso; `Connection` e o retorno; `connect` e o metodo; os parametros ficam entre parenteses; `throws` declara excecoes quando presente.
     */
    @Override protected Connection connect() throws Exception{return DriverManager.getConnection(p.getPostgresUrl(),p.getPostgresUser(),p.getPostgresPassword());}
/*
 * O que faz: Fecha o bloco de codigo aberto anteriormente.
 * Por que esta aqui: delimitar com clareza o fim da classe, metodo, condicao, laco ou tratamento de excecao em andamento.
 * Componentes: `}` informa ao Java que o escopo iniciado por uma chave de abertura terminou.
 */
}
