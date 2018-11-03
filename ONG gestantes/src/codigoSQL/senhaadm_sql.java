/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoSQL;

    import conexao.Conexao;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import metodos_getset.SenhaAdm;

/**
 *
 * @author TheSena
 */
public class senhaadm_sql extends Conexao {
    public ArrayList mostrarSenha (){
        try{
                ArrayList senhaArray = new ArrayList();
                String texto = "select * from senhaadm";
                ResultSet rs = this.getResultSet(texto);
                
                while (rs.next()){
                    SenhaAdm senha = new SenhaAdm();
                    
                    senha.setSenha(rs.getString("senha"));
                    
                    senhaArray.add(senha);
                }
                return senhaArray;
        }
        catch (Exception e){
            e.getMessage();
            return null;
        }
    }
}
