
package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        
        String sql = "CREATE TABLE if not exists pessoas ("
                + "codigo INT AUTO_INCREMENT primary key,"
                + "nome VARCHAR(80) not null"
                + ")";
        
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        
        System.out.println("Tabela Criada!");
        
        conexao.close();
    }
}
