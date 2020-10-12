/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class novaPessoa {
    public static void main(String[] args) throws SQLException {
        
        String nome = JOptionPane.showInputDialog("Nome:");

        Connection conexao = FabricaConexao.getConexao();
        //String sql = "INSERT INTO pessoas (nome, codigo) VALUES (? , ?);";
        String sql = "INSERT INTO pessoas (nome) VALUES (?);";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        //stmt.setInt(2, 3);
        stmt.execute();
        
        conexao.close();
    }
}
