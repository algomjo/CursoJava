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
public class AlterarPessoas {

    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();

        String select = "SELECT * from pessoas";
        
        Statement stmt = conexao.createStatement();
        int codigo;
        ResultSet resultado = stmt.executeQuery(select);

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()) {
            codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }
        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " -> " + p.getNome());
        }

        codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo:"));
        String novoNome = JOptionPane.showInputDialog("Novo nome:");
        String update = "update pessoas set nome = ? where codigo = ?";
        PreparedStatement stm = conexao.prepareStatement(update);
        stm.setString(1, novoNome);
        stm.setInt(2, codigo);
        stm.execute();
        
        resultado = stmt.executeQuery(select);
        ArrayList<Pessoa> pessoa = new ArrayList<>();

        while (resultado.next()) {
            codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoa.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoa) {
            System.out.println(p.getCodigo() + " -> " + p.getNome());
        }

        stm.close();
        stmt.close();
        conexao.close();
    }
}
