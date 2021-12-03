
package com.emergentes.controlador;

import com.emergentes.dao.ControladorProductos;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Clientes;
import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionBD;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id,id_categoria;
        
        ArrayList<Productos> lista = new ArrayList<Productos>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        if (op.equals("list")) {
            //operacion para listar datos
            String sql = "select * from productos";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Productos prod = new Productos();
                     prod.setId(rs.getInt("id"));
                    prod.setNombre_producto(rs.getString("nombre_producto"));
                    prod.setImagen_1(rs.getString("imagen_1"));
                    prod.setImagen_2(rs.getString("imagen_2"));
                    prod.setPrecio(rs.getDouble("precio"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setMarca(rs.getString("marca"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setId_proveedores(rs.getInt("id_proveedores"));
                    prod.setId_categoria(rs.getInt("id_categoria"));

                    lista.add(prod);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("productos.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        if (op.equals("detalle")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {

                Productos prod = new Productos();

                ps = conn.prepareStatement("select * from productos where id= ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    prod.setId(rs.getInt("id"));
                    prod.setNombre_producto(rs.getString("nombre_producto"));
                    prod.setImagen_1(rs.getString("imagen_1"));
                    prod.setImagen_2(rs.getString("imagen_2"));
                    prod.setPrecio(rs.getDouble("precio"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setMarca(rs.getString("marca"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setId_proveedores(rs.getInt("id_proveedores"));
                    prod.setId_categoria(rs.getInt("id_categoria"));

                }
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("detalles.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if (op.equals("promociones")) {
            String estado= request.getParameter("estado");
            if(estado.equals("promocion")){
            try {

                Productos prod = new Productos();

                ps = conn.prepareStatement("select * from productos where estado='promocion'");
                ps.setString(1, estado);
                rs = ps.executeQuery();
                if (rs.next()) {
                    prod.setId(rs.getInt("id"));
                    prod.setNombre_producto(rs.getString("nombre_producto"));
                    prod.setImagen_1(rs.getString("imagen_1"));
                    prod.setImagen_2(rs.getString("imagen_2"));
                    prod.setPrecio(rs.getDouble("precio"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setMarca(rs.getString("marca"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setId_proveedores(rs.getInt("id_proveedores"));
                    prod.setId_categoria(rs.getInt("id_categoria"));

                }
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("promociones.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }}
            
        }
        
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario

            ControladorProductos prod= new ControladorProductos();

            request.setAttribute("prod", prod);
            request.getRequestDispatcher("frmProductos.jsp").forward(request, response);
        }

        if (op.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {

                Productos prod = new Productos();

                ps = conn.prepareStatement("select * from productos where id= ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    prod.setId(rs.getInt("id"));
                    prod.setNombre_producto(rs.getString("nombre_producto"));
                    prod.setImagen_1(rs.getString("imagen_1"));
                    prod.setImagen_2(rs.getString("imagen_2"));
                    prod.setPrecio(rs.getDouble("precio"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setMarca(rs.getString("marca"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setEstado(rs.getString("estado"));
                    prod.setId_proveedores(rs.getInt("id_proveedores"));
                    prod.setId_categoria(rs.getInt("id_categoria"));

                }
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("editarProductos.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro
            id = Integer.parseInt(request.getParameter("id"));

            try {
                ps = conn.prepareStatement("delete from productos where id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("ProductosController");
            } catch (SQLException ex) {
                Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            FileItemFactory file_factory=new DiskFileItemFactory();
        ServletFileUpload sfu= new ServletFileUpload(file_factory);
        
        ArrayList<String> campos=new ArrayList<String>();
        ArrayList<String> imgs=new ArrayList<>();
        
       try{
           List items=sfu.parseRequest(request);
           for(int i = 0; i < items.size(); i++){
               FileItem item=(FileItem) items.get(i);
               if(!item.isFormField()){
                   File archivo =new File("C:\\Users\\PC\\Documents\\NetBeansProjects\\Tienda_Electrodomesticos\\src\\main\\webapp\\img\\"+item.getName());
                   item.write(archivo);
                   imgs.add("img/"+item.getName());
               }else{
                   campos.add(item.getString());
               }
             
           }
        }catch (Exception ex) {
          
        }
       
        Productos prod=new Productos(0,campos.get(1),imgs.get(0),imgs.get(1),Double.parseDouble(campos.get(2)),campos.get(3),campos.get(4),Integer.parseInt(campos.get(5)),campos.get(6),Integer.parseInt(campos.get(7)),Integer.parseInt(campos.get(8)));
       com.emergentes.dao.ControladorProductos cp=new com.emergentes.dao.ControladorProductos();
       response.getWriter().println(cp.crearProductos(prod));
    
    }




    

   
}
