package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ExcluirPessoas  {
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
        String update = "delete from pessoas where codigo = ?";
        PreparedStatement stm = conexao.prepareStatement(update);
        stm.setInt(1, codigo);
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
