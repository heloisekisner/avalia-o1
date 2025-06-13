package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/empresa";
        String user = "devuser";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}
