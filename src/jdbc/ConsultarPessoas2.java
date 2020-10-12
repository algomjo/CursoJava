/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ConsultarPessoas2 {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        String busca = JOptionPane.showInputDialog("Busca:");
        String sql = "SELECT * from pessoas where nome like ?";
        
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%"+busca+"%");
        
        ResultSet resultado = stmt.executeQuery();
        
        ArrayList<Pessoa> pessoas = new  ArrayList<>();
        
        while(resultado.next())
        {
            int codigo= resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }
        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() +" -> "+ p.getNome());
        }
        
        
        stmt.close();
        conexao.close();
    }
}
