/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TheSena
 */
public class Conexao {
    String driver = "com.mysql.jdbc.Driver"; //Driver para conexao com o Banco - NAO ALTERAR
    String banco = "onggestantes"; //Nome do Banco de Dados - INFORME O NOME DO SEU BANCO
    String host = "localhost"; //Servidor de Banco de Dados - NAO ALTERAR
    String stringDeConexao = "jdbc:mysql://" + host + ":3306/" + banco; //String de Conexao com o Banco de Dados - NAO ALTERAR
    String usuario = "root"; //Usuario do Banco de Dados - INFORME USUARIO
    String senha = ""; //Senha do Usuario - INFORME A SENHA

    public Connection conexao;
    
    /** Creates a new instance of Conexao */
    public Conexao()
    {
        // CONSTRUTOR DA CLASSE
    }
    
    public Connection getConexao()
    {
        try
        {
            Class.forName(driver); //Carrega o driver
            return DriverManager.getConnection(this.stringDeConexao,usuario, senha);
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, 
                "Erro ao conectar com o banco. arriba Erro:\n" + erro.getMessage(),
                "Suporte técnico...", JOptionPane.PLAIN_MESSAGE);
        }
        return conexao;
    }
    
    public ResultSet getResultSet(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            ResultSet rs = stm.executeQuery(sentenca);
            return rs;
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null, 
                "Erro ao conectar com o banco. Erro:\n" + erro.getMessage(),
                "Suporte técnico...", JOptionPane.PLAIN_MESSAGE);
            return null;
        }
    }
    
    public String atualizarBanco(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            stm.executeUpdate(sentenca);
            return "1";
        }
        catch (SQLException erro)
        {
            return erro.getMessage();
        }
        catch (Exception erro)
        {
            return erro.getMessage();
        }
    } 
    
}
