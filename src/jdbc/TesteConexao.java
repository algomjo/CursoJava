
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TesteConexao {

    public static void main(String[] args) throws SQLException {
       final String STRINGDECONEXAO = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
       final String USUARIO = "root";
       final String SENHA = "system";
       
        Connection conexao = DriverManager.getConnection(STRINGDECONEXAO, USUARIO, SENHA);
        conexao.close();
    }
    
}
