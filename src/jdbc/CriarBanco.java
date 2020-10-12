
package jdbc;

import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
       public static void main(String[] args) throws SQLException {
       final String STRINGDECONEXAO = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
       final String USUARIO = "root";
       final String SENHA = "system";
       
        Connection conexao = DriverManager.getConnection(STRINGDECONEXAO, USUARIO, SENHA);
           
           Statement stmt = conexao.createStatement();
           
           stmt.execute("CREATE DATABASE if not exists cursojava");
           
        conexao.close();
    }
}
