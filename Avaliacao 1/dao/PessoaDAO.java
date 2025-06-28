package dao;

import java.sql.*;
import model.Pessoa;
import util.ConnectionFactory;

public class PessoaDAO {

    // Método para inserir uma nova pessoa no banco
    public void inserir(Pessoa pessoa) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    // Atualiza o e-mail de uma pessoa com base no nome
    public void atualizar(Pessoa pessoa) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "UPDATE pessoa SET email = ? WHERE nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pessoa.getEmail());
            stmt.setString(2, pessoa.getNome());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pessoa atualizada com sucesso.");
            } else {
                System.out.println("Erro: Pessoa não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    // Busca uma pessoa pelo nome e retorna o objeto Pessoa
    public Pessoa buscarPorNome(String nome) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM pessoa WHERE nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar pessoa: " + e.getMessage());
        }
        return null;
    }

    // Exclui uma pessoa se ela não estiver vinculada como funcionário
    public void excluirPorNome(String nome) {
        try (Connection con = ConnectionFactory.getConnection()) {
            Pessoa pessoa = buscarPorNome(nome);
            if (pessoa == null) {
                System.out.println("Pessoa não encontrada.");
                return;
            }

            // Verifica se a pessoa está vinculada a um funcionário
            String sqlCheck = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement checkStmt = con.prepareStatement(sqlCheck);
            checkStmt.setInt(1, pessoa.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Erro: Pessoa vinculada como funcionário. Não pode ser excluída.");
                return;
            }

            // Exclui a pessoa
            String sql = "DELETE FROM pessoa WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pessoa.getId());
            stmt.executeUpdate();
            System.out.println("Pessoa excluída com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir pessoa: " + e.getMessage());
        }
    }
}
