// FuncionarioDAO atualizado para trabalhar com matricula e departamento
package dao;

import java.sql.*;
import model.Funcionario;
import util.ConnectionFactory;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO funcionario (matricula, departamento) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getDepartamento());
            stmt.executeUpdate();
            System.out.println("Funcionário cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    public void atualizar(Funcionario funcionario) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "UPDATE funcionario SET departamento = ? WHERE matricula = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getDepartamento());
            stmt.setString(2, funcionario.getMatricula());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionário atualizado com sucesso.");
            } else {
                System.out.println("Erro: Funcionário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public Funcionario buscarPorMatricula(String matricula) {
        try (Connection con = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM funcionario WHERE matricula = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(rs.getInt("id"), rs.getString("matricula"), rs.getString("departamento"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
        return null;
    }

    public void excluirPorMatricula(String matricula) {
        try (Connection con = ConnectionFactory.getConnection()) {
            Funcionario funcionario = buscarPorMatricula(matricula);
            if (funcionario == null) {
                System.out.println("Funcionário não encontrado.");
                return;
            }

            String sqlCheck = "SELECT * FROM projeto WHERE id_funcionario = ?";
            PreparedStatement checkStmt = con.prepareStatement(sqlCheck);
            checkStmt.setInt(1, funcionario.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Erro: Funcionário vinculado a projetos. Não pode ser excluído.");
                return;
            }

            String sql = "DELETE FROM funcionario WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.executeUpdate();
            System.out.println("Funcionário excluído com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }
}
