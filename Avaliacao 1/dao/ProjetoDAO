// ProjetoDAO atualizado para trabalhar corretamente
package dao;

import java.sql.*;
import model.Projeto;
import util.ConnectionFactory;

public class ProjetoDAO {

    public void inserir(Projeto projeto) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO projeto (nome, descricao, id_funcionario) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getIdFuncionario());
            stmt.executeUpdate();
            System.out.println("Projeto cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar projeto, Id do Funcionario nao exite");
        }
    }

    public void atualizar(Projeto projeto) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "UPDATE projeto SET nome = ?, descricao = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Projeto atualizado com sucesso.");
            } else {
                System.out.println("Erro: Projeto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar projeto: " + e.getMessage());
        }
    }

    public Projeto buscarPorId(int id) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM projeto WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Projeto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"),
                        rs.getInt("id_funcionario"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar projeto: " + e.getMessage());
        }
        return null;
    }

    public void excluirPorId(int id) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM projeto WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Projeto excluído com sucesso.");
            } else {
                System.out.println("Erro: Projeto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir projeto: " + e.getMessage());
        }
    }
}
