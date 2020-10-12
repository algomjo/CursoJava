package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
    
    

    public static Connection getConexao() {
        try {
            final String STRINGDECONEXAO = "jdbc:mysql://localhost:3306/cursojava?verifyServerCertificate=false&useSSL=true";
            final String USUARIO = "root";
            final String SENHA = "system";

            return DriverManager.getConnection(STRINGDECONEXAO, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
