Projeto Java - Sistema de Cadastro com JDBC

Esse projeto foi feito para a prova prática de Java Backend. Ele usa JDBC para conectar no banco de dados MySQL e faz o cadastro de pessoas, funcionários e projetos.

O que o sistema faz

- Cadastra, lista, atualiza e exclui:
  - Pessoas
  - Funcionários (ligados a uma pessoa)
  - Projetos (ligados a um funcionário)

- Tem regras de negócio, como:
  - Só pode cadastrar funcionário se a pessoa existir
  - Só pode criar projeto se tiver um funcionário
  - Mostra mensagens de erro se algo der errado
  - Mostra mensagens de sucesso quando dá certo

Como rodar

1. Crie o banco `empresa` no MySQL.
2. Execute o arquivo `empresa.sql` para criar as tabelas e inserir os dados.
3. Abra o projeto no VS Code ou Eclipse.
4. Verifique o arquivo `DBConnection.java` e veja se o usuário, senha e banco estão certos:
   ```java
   String url = "jdbc:mysql://localhost:3306/empresa";
   String user = "devuser";
   String password = "123456";
