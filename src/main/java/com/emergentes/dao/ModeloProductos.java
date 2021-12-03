
package com.emergentes.dao;


import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ModeloProductos extends ConexionBD{
    public boolean  crear_productos(Productos prod){
       PreparedStatement ps=null;
       
       boolean flag = false;
       try{
           String sql=" call insertProductos(?,?,?,?,?,?,?,?,?,?); ";
           ps=getConnection().prepareStatement(sql);
           ps.setString(1, prod.getNombre_producto());
           ps.setString(2, prod.getImagen_1());
           ps.setString(3, prod.getImagen_2());
           ps.setDouble(4, prod.getPrecio());
           ps.setString(5, prod.getDescripcion());
           ps.setString(6, prod.getMarca());
           ps.setInt(7, prod.getStock());
           ps.setString(8, prod.getEstado());
           ps.setInt(9, prod.getId_proveedores());
           ps.setInt(10, prod.getId_categoria());
           
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
   
    
    public ArrayList<Productos> getAllProductos(){
    ArrayList<Productos> lista = new ArrayList();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productos prod = new Productos();
                prod.setId(rs.getInt("id"));
                prod.setNombre_producto(rs.getString("nombre_producto"));
                prod.setImagen_1(rs.getString ("imagen_1"));
                prod.setImagen_2(rs.getString ("imagen_2"));
                prod.setPrecio(rs.getDouble ("precio"));
                prod.setDescripcion(rs.getString ("descripcion"));
                prod.setMarca(rs.getString ("marca"));
                prod.setStock(rs.getInt("stock"));
                prod.setEstado(rs.getString ("estado"));
                prod.setId_proveedores(rs.getInt("id_proveedores"));
                prod.setId_categoria(rs.getInt("id_categoria"));

                lista.add(prod);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return lista; 
    }
    
    public Productos getProductos(int id){
        
  Productos producto= null;
  PreparedStatement ps = null;
   ResultSet rs=null;
        try {
            
            this.conectar();
            String sql = "SELECT * FROM productos WHERE id = ?";
            ps=getConnection().prepareCall(sql);
            ps.setInt(0,id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                producto = new Productos(rs.getInt("id"),
                        rs.getString("nombre_producto"),
                        rs.getString ("imagen_1"),
                        rs.getString ("imagen_2"),
                        rs.getDouble ("precio"),
                        rs.getString ("descripcion"),
                        rs.getString ("marca"),
                        rs.getInt("stock"),
                        rs.getString ("estado"),
                        rs.getInt("id_proveedores"),
                        rs.getInt("id_categoria"));
            }
        } catch (Exception e) {
        } finally {
           try{
               if(getConnection()!=null)getConnection().close();
               if(ps!=null)ps.close();
               if(rs !=null)rs.close();
           }catch(Exception e){
               
           }
        }
        return producto; 
    }
    

   
}
