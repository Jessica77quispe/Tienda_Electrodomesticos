
package com.emergentes.controlador;

import com.emergentes.modelo.Proveedores;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProveedoresControlador", urlPatterns = {"/ProveedoresControlador"})
public class ProveedoresControlador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id_proveedor;
        ArrayList<Proveedores> lista = new ArrayList<Proveedores>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        if (op.equals("list")) {
            //operacion para listar datos
            String sql = "select * from proveedores";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Proveedores prov = new Proveedores();
                    prov.setId_proveedor(rs.getInt("id_proveedor"));
                    prov.setDescripcion(rs.getString("descripcion"));
                    prov.setTelefono(rs.getString("telefono"));
                    prov.setDireccion(rs.getString("direccion"));
                    prov.setCantidad(rs.getInt("cantidad"));
                    prov.setPrecio(rs.getFloat("precio"));

                    lista.add(prov);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("proveedores.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario

            Proveedores prov = new Proveedores();

            request.setAttribute("prov", prov);
            request.getRequestDispatcher("frmProveedores.jsp").forward(request, response);
        }

        if (op.equals("editar")) {
            id_proveedor = Integer.parseInt(request.getParameter("id_proveedor"));
            try {

                Proveedores prov = new Proveedores();

                ps = conn.prepareStatement("select * from proveedores where id_proveedor= ?");
                ps.setInt(1, id_proveedor);
                rs = ps.executeQuery();
                if (rs.next()) {
                    prov.setId_proveedor(rs.getInt("id_proveedor"));
                    prov.setDescripcion(rs.getString("descripcion"));
                    prov.setTelefono(rs.getString("telefono"));
                    prov.setDireccion(rs.getString("direccion"));
                    prov.setCantidad(rs.getInt("cantidad"));
                    prov.setPrecio(rs.getFloat("precio"));
                    

                }
                request.setAttribute("prov", prov);
                request.getRequestDispatcher("frmProveedores.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro
            id_proveedor = Integer.parseInt(request.getParameter("id_proveedor"));

            try {
                ps = conn.prepareStatement("delete from proveedores where id_proveedor = ?");
                ps.setInt(1, id_proveedor);
                ps.executeUpdate();
                response.sendRedirect("ProveedoresControlador");
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_proveedores = Integer.parseInt(request.getParameter("id_proveedor"));
        String descripcion = request.getParameter("descripcion");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        int cantidad= Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.valueOf(request.getParameter("precio"));

        Proveedores prov = new Proveedores();
        prov.setId_proveedor(id_proveedores);
        prov.setDescripcion(descripcion);
        prov.setTelefono(telefono);
        prov.setDireccion(direccion);
        prov.setCantidad(cantidad);
        prov.setPrecio(precio);

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id_proveedores == 0) {
            //insertar registro
            String sql = "INSERT INTO proveedores (descripcion,telefono,direccion,cantidad,precio) VALUES (?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, prov.getDescripcion());
                ps.setString(2, prov.getTelefono());
                ps.setString(3, prov.getDireccion());
                ps.setInt(4, prov.getCantidad());
                ps.setFloat(5, prov.getPrecio());

                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Update registro
            String sql1 = "update proveedores set descripcion=? ,telefono=? ,direccion=? ,cantidad=? ,precio=? where id_proveedor=?";
            try {
                ps = conn.prepareStatement(sql1);
                ps.setString(1, prov.getDescripcion());
                ps.setString(2, prov.getTelefono());
                ps.setString(3, prov.getDireccion());
                ps.setInt(4, prov.getCantidad());
                ps.setFloat(5, prov.getPrecio());
                ps.setInt(6, prov.getId_proveedor());

                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("ProveedoresControlador");
    }

    

  
}
