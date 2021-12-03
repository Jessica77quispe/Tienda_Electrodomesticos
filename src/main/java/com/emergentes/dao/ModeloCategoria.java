
package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModeloCategoria extends ConexionBD{
   public boolean  crear_categoria(Categoria cat){
       PreparedStatement ps=null;
       
       boolean flag = false;
       try{
           String sql=" call insertCategoria(?,?); ";
           ps=getConnection().prepareStatement(sql);
           ps.setString(1, cat.getDescripcion());
           ps.setString(2, cat.getImagen());
           
           if(ps.executeUpdate()==1){
               flag =true;
           }
       }catch(Exception e){
           
       }finally{
           try{
               if(getConnection()!= null) getConnection().close();
               if(ps!= null)ps.close();
           }catch(Exception e){
               
           }
       }
       return flag;
   }
   
  
   
   public ArrayList<Categoria> getAllCategoria(){
    ArrayList<Categoria> lista = new ArrayList();
        try {
            this.conectar();
            String sql = "SELECT * FROM categoria";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setImagen(rs.getString ("imagen"));

                lista.add(categoria);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return lista; 
    }
   
   
}
