/*
 * O que faz: Declara o pacote Java `br.edu.ifpr.biblioteca.model` como o endereco logico da classe.
 * Por que esta aqui: manter as classes organizadas por responsabilidade e evitar conflitos de nomes no projeto.
 * Componentes: `package` define o namespace; o restante da linha e o nome do pacote seguido de `;`.
 */
package br.edu.ifpr.biblioteca.model;

/*
 * O que faz: Declara o registro `SearchResult` para transportar dados de forma imutavel.
 * Por que esta aqui: representar um resultado ou entidade simples sem precisar criar manualmente getters, construtor e metodos basicos.
 * Componentes: `record` recebe os componentes `String id, String title, String author, float score, String source` e gera automaticamente acesso aos valores.
 */
public record SearchResult(String id, String title, String author, float score, String source) {}
