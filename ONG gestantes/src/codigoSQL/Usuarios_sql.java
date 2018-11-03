    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package codigoSQL;

    import conexao.Conexao;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import metodos_getset.Usuarios;

    /**
     *
     * @author TheSena
     */
    public class Usuarios_sql extends Conexao{
        public String CadastrarUsuario(Usuarios usuario)
        {
            try{
                String M;
                M = "INSERT INTO cadastrousuario VALUES (null,'" +usuario.getUsuario()+ "','"+usuario.getSenha()+"');";                return this.atualizarBanco(M);
            }
            catch (Exception e){
                return e.getMessage();
            }
        }

        public String excluirUsuario(int idusuario)
        {
            try{
                String M;
                M = "delete from cadastrousuario where idusuario = " + idusuario + ";";
                return this.atualizarBanco(M);
            }
            catch (Exception e){
                return e.getMessage();
            }
        }

        public String alterarUsuario (Usuarios usuario)
        {
            try{
                String M;
                M = "UPDATE cadastrousuario SET "
                    + "usuario ='" + usuario.getUsuario()+ "', "
                    + "senha ='" + usuario.getSenha()+ "'"

                    + "WHERE idusuario = '"+ usuario.getIdUsuario()+"';" ;

                return this.atualizarBanco(M);
            }
            catch (Exception e){
                return e.getMessage();
            }
        }


        //Terminar
        public ArrayList listarUsuarios(){
            try {
                ArrayList usuarios = new ArrayList();
                String texto = "select * from cadastrousuario order by idusuario";
                ResultSet rs = this.getResultSet(texto);
            while (rs.next())
            {
                Usuarios usuario = new Usuarios();

                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);

            }
                return usuarios;
            }


             catch (Exception e)
                {
                     System.out.println(e.getMessage());
                     return null;
                }


        }

    
    public String RetornarCategoria (String nome, String senha)
    {
        String aux = null ; 
        
        try
        {
            String sentenca = "select * from cadastrousuario where usuario ='"+nome+"' and senha = '"+senha+"';";
            ResultSet rs = this.getResultSet(sentenca);
            while (rs.next())
            {
                aux = rs.getString("Categoria");
            }
            return aux;
        }
        
        catch (Exception e)
        {
           System.out.println(e.getMessage());
           return "";
        }
    }

    
        
     public String JogarAcesso (String login)
    {
        String aux = null;
        try{
        String sentenca = "select usuario from cadastrousuario where usuario = '"+login+"';";
    
        ResultSet rs = this.getResultSet(sentenca);
        while (rs.next())
        {
            aux = rs.getString("usuario");
        }
        return aux;
    }
        
         catch (Exception e)
   {
           System.out.println(e.getMessage());
           return null;
                
   }
        
    }
    
    
    }
