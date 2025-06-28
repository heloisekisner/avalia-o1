package util;

import java.sql.Connection;
import java.sql.DriverManager;

// Classe responsável por criar conexões com o banco de dados
public class ConnectionFactory {

    // Método estático para obter uma conexão
    public static Connection getConnection() throws Exception {
        // URL do banco (ajuste se seu banco não estiver na porta 3306 ou tiver outro nome)
        String url = "jdbc:mysql://localhost:3306/empresa";

        // Usuário e senha do MySQL
        String user = "devuser";
        String password = "1234";

        // Retorna uma conexão JDBC
        return DriverManager.getConnection(url, user, password);
    }
}
