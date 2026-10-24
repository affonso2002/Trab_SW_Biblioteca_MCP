/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.model` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.model;

/*
 * O que faz: Importa a classe List da biblioteca `java.util`.
 * Por que esta aqui: permitir que a classe use esse recurso sem escrever o nome completo do pacote em cada ocorrencia.
 * Componentes: `import` liga o codigo local ao tipo `java.util.List`; o ponto final do pacote identifica a classe importada.
 */
import java.util.List;

/*
 * O que faz: Declara o registro `Book` para transportar dados de forma imutavel.
 * Por que esta aqui: representar um resultado ou entidade simples sem precisar criar manualmente getters, construtor e metodos basicos.
 * Componentes: `record` recebe os componentes `long gutenbergId, String title, List<String> authors, List<String> subjects, String language, String textUri, String content` e gera automaticamente acesso aos valores.
 */
public record Book(long gutenbergId, String title, List<String> authors, List<String> subjects, String language, String textUri, String content) {}
