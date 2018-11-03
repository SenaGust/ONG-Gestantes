/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TheSena
 */
public class ConexaoBanco {
    public ConexaoBanco() 
    {
        // CONSTRUTOR DA CLASSE
    }
    
    private static Connection conn = null;
    private static Statement db_statement = null;
    
    public static Connection getInstanceConn()
    {
        try 
        {
            if (conn == null ||conn.isClosed())
            {
                conn = null;
                Conexao conexao = new Conexao();
                conn = conexao.getConexao();
                conn.setAutoCommit(true);
                db_statement = (Statement) conn.createStatement();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, 
                                "Erro ao conectar com o banco. Erro:\n" + e.getMessage(),
                                "Suporte técnico...", JOptionPane.PLAIN_MESSAGE);
        }
        
        return conn;
        
    }
    
    public static Statement getInstanceStatement() throws Exception
    {
        if (db_statement == null)
        {
            getInstanceConn();
        }
        return db_statement;
    }
    
    public static void closeInstanceConn() throws Exception
    {
        if(conn != null)
            if(!conn.isClosed())
                conn.close();
        conn = null;
        db_statement = null;
    }
    
}
