/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoSQL;


import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metodos_getset.Gestantes;

/**
 *
 * @author TheSena
 */
public class Gestantes_sql extends Conexao {
    public String cadastrarGestante (Gestantes gestante)
    {
            try {
            String M;
            M = "Insert into cadastrogestantes values (null, '"+ gestante.getNome()+"','"+ gestante.getEndereco()+
                    "','" + gestante.getQtdefilhos()+ 
                    "','" + gestante.getIdade() +
                    "','" + gestante.getTempogestacao()+
                    "','" + gestante.getSexocrianca()+
                    "','" + gestante.getConvenio()+
                    "','" + gestante.getEstadocivil()+
                    "','" + gestante.getTempovisita()+
                    "','" + gestante.getHospital()+
                    "','" + gestante.getNecessidade()+
                    "','" + gestante.getNomecrianca()+
                    "')" ;
                    
            return this.atualizarBanco(M);
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String atualizarGestante (Gestantes gestante)
    {
        try {
        String M;
            M = "UPDATE cadastrargestantes SET "
                    + "nome ='" + gestante.getNome() + "', "
                    + "endereco = '" +gestante.getEndereco()+ "', "
                    + "qtdefilhos = '"+ gestante.getQtdefilhos() +"', "
                    + "idade = '" + gestante.getIdade() +"', "
                    + "tempogestacao ='" + gestante.getTempogestacao()+ "', "
                    + "sexocrianca ='" + gestante.getSexocrianca()+ "', "
                    + "convenio ='" + gestante.getConvenio()+ "', "
                    + "estadocivil ='" + gestante.getEstadocivil()+ "', "
                    + "tempovisita ='" + gestante.getTempovisita()+ "', "
                    + "hospital ='" + gestante.getHospital()+ "', "
                    + "necessidade ='" + gestante.getNecessidade()+ "', "
                    + "nomecrianca ='" + gestante.getNomecrianca()+ "', "

                    + "WHERE idgestante = '"+ gestante.getIdgestante()+"';" ;

        
        return this.atualizarBanco(M);
            }
    catch (Exception e)
            {
            return e.getMessage();
            }
    
    }
    
    public String excluirGestante (int idgestante)
    {
        try{
            String M;
            M = "delete from cadastrogestantes where idgestante = " +idgestante+ ";";
            return this.atualizarBanco(M);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    
    public ArrayList listarGestantes() 
    {
        try {
            ArrayList gestantes = new ArrayList();
            String texto = "select * from cadastrogestantes order by idgestante";
            ResultSet rs = this.getResultSet(texto);
        while (rs.next())
        {
            Gestantes gestante = new Gestantes();
            
            gestante.setIdgestante(rs.getInt("idgestante"));
            gestante.setNome(rs.getString("nome"));
            gestante.setEndereco(rs.getString("endereco"));
            gestante.setQtdefilhos(rs.getInt("qtdefilhos"));
            gestante.setIdade(rs.getInt("idade"));
            gestante.setTempogestacao(rs.getInt("tempogestacao"));
            gestante.setSexocrianca(rs.getString("sexocrianca"));
            gestante.setConvenio(rs.getString("convenio"));
            gestante.setEstadocivil(rs.getString("estadocivil"));
            gestante.setTempovisita(rs.getString("tempovisita"));
            gestante.setHospital(rs.getString("hospital"));
            gestante.setNecessidade(rs.getString("necessidade"));
            gestante.setNomecrianca(rs.getString("nomecrianca"));
            gestantes.add(gestante);
            
        }
            return gestantes;
        }
    
        
         catch (Exception e)
            {
                 System.out.println(e.getMessage());
                 return null;
            }
        
        }
    
    
    }

