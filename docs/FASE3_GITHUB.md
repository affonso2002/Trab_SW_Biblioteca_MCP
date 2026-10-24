# Entrega pelo GitHub

1. Instale o JDK 21 (ou superior) e Maven 3.9 ou superior e confirme que `mvn clean verify` termina sem falhas.
2. Gere os artefatos de servidor e cliente conforme `BUILD_E_TESTES.md` e confira `target/dist-server/` e `target/dist-client/`.
3. **Execute o Cliente 01** conforme `CLIENTE01_STDIO.md`: confirme que ele descobre as Tools do servidor e conclua pelo menos uma chamada real (o teste inicial recomendado é `extrair_metadados_pdf` com `exemplo.pdf`).
4. **Teste o servidor no Claude Desktop** conforme `CLAUDE_DESKTOP.md`. O método direto em **Desenvolvedor → Editar configuração** foi o método confirmado neste ambiente. A extensão `.mcpb` fica preservada em `docs/`, mas deve permanecer desativada enquanto apresenta falha de conexão.
5. **Teste o MCP Inspector** conforme `MCP_INSPECTOR_PASSO_A_PASSO.md`: conecte por STDIO, liste as seis Tools e, de preferência, execute `extrair_metadados_pdf` com `exemplo.pdf`.
6. Guarde capturas autênticas em `docs/execucao/` e mantenha `EVIDENCIAS_EXECUCAO.md` atualizado. Não descreva teste pendente como concluído e não invente resultados.
7. Revise `git status`. Não envie `.env`, credenciais, chaves/certificados, `.git`, `target/`, índice Lucene nem arquivos gerados em `data/processed` ou `data/documents`.
8. Versione o código-fonte, `pom.xml`, testes, `README.md`, guias em `docs/` e `.env.example`.
9. Envie para um repositório GitHub público ou privado. Se for privado, adicione `romualdo.freitas@ifpr.edu.br` como colaborador para o professor visualizar e baixar o projeto.

O prazo indicado no enunciado é **22 de novembro de 2026**.
