package view;

import model.*;
import dao.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        while (true) {
            System.out.println("--- Menu Principal ---");
            System.out.println("1. Gerenciar Pessoas");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Projetos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarPessoas(scanner, pessoaDAO);
                    break;
                case 2:
                    gerenciarFuncionarios(scanner, funcionarioDAO);
                    break;
                case 3:
                    gerenciarProjetos(scanner, projetoDAO);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerenciarPessoas(Scanner scanner, PessoaDAO pessoaDAO) {
        System.out.println("--- Gerenciar Pessoas ---");
        System.out.println("1. Cadastrar Pessoa");
        System.out.println("2. Atualizar Pessoa");
        System.out.println("3. Consultar Pessoa");
        System.out.println("4. Excluir Pessoa");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o email: ");
                String email = scanner.nextLine();
                pessoaDAO.inserir(new Pessoa(nome, email));
                break;
            case 2:
                System.out.print("Digite o nome da pessoa: ");
                String nomeAtualizar = scanner.nextLine();
                System.out.print("Digite o novo email: ");
                String novoEmail = scanner.nextLine();
                pessoaDAO.atualizar(new Pessoa(0, nomeAtualizar, novoEmail));
                break;
            case 3:
                System.out.print("Digite o nome da pessoa: ");
                String nomeConsultar = scanner.nextLine();
                Pessoa pessoa = pessoaDAO.buscarPorNome(nomeConsultar);
                System.out.println(pessoa);
                break;
            case 4:
                System.out.print("Digite o nome da pessoa: ");
                String nomeExcluir = scanner.nextLine();
                pessoaDAO.excluirPorNome(nomeExcluir);
                break;
        }
    }

    private static void gerenciarFuncionarios(Scanner scanner, FuncionarioDAO funcionarioDAO) {
        System.out.println("--- Gerenciar Funcionários ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Atualizar Funcionário");
        System.out.println("3. Consultar Funcionário");
        System.out.println("4. Excluir Funcionário");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite a matrícula: ");
                String matricula = scanner.nextLine();
                System.out.print("Digite o departamento: ");
                String departamento = scanner.nextLine();
                funcionarioDAO.inserir(new Funcionario(0, matricula, departamento));
                break;
            case 2:
                System.out.print("Digite a matrícula do funcionário: ");
                String matriculaAtualizar = scanner.nextLine();
                System.out.print("Digite o novo departamento: ");
                String novoDepartamento = scanner.nextLine();
                funcionarioDAO.atualizar(new Funcionario(0, matriculaAtualizar, novoDepartamento));
                break;
            case 3:
                System.out.print("Digite a matrícula do funcionário: ");
                String matriculaConsultar = scanner.nextLine();
                Funcionario funcionario = funcionarioDAO.buscarPorMatricula(matriculaConsultar);
                System.out.println(funcionario);
                break;
            case 4:
                System.out.print("Digite a matrícula do funcionário: ");
                String matriculaExcluir = scanner.nextLine();
                funcionarioDAO.excluirPorMatricula(matriculaExcluir);
                break;
        }
    }

    private static void gerenciarProjetos(Scanner scanner, ProjetoDAO projetoDAO) {
        System.out.println("--- Gerenciar Projetos ---");
        System.out.println("1. Cadastrar Projeto");
        System.out.println("2. Atualizar Projeto");
        System.out.println("3. Consultar Projeto");
        System.out.println("4. Excluir Projeto");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do projeto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite a descrição do projeto: ");
                String descricao = scanner.nextLine();
                System.out.print("Digite o ID do funcionário responsável: ");
                int idFuncionario = scanner.nextInt();
                scanner.nextLine();
                projetoDAO.inserir(new Projeto(0, nome, descricao, idFuncionario));
                break;
            case 2:
                System.out.print("Digite o ID do projeto: ");
                int idAtualizar = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Digite a nova descrição: ");
                String novaDescricao = scanner.nextLine();
                System.out.print("Digite o ID do novo funcionario responsavel: ");
                Integer novoFuncionario = scanner.nextInt();
                projetoDAO.atualizar(new Projeto(idAtualizar, novoNome, novaDescricao, novoFuncionario));
                break;
            case 3:
                System.out.print("Digite o ID do projeto: ");
                Integer idConsultar = scanner.nextInt();
                Projeto projeto = projetoDAO.buscarPorId(idConsultar);
                System.out.println(projeto);
                break;
            case 4:
                System.out.print("Digite o ID do projeto: ");
                Integer idExcluir = scanner.nextInt();
                projetoDAO.excluirPorId(idExcluir);
                break;
        }
    }
}
