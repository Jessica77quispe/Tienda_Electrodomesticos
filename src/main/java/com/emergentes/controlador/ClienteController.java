
package com.emergentes.controlador;

import com.emergentes.modelo.Clientes;
import com.emergentes.utiles.ConexionBD;
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


@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id;
        ArrayList<Clientes> lista = new ArrayList<Clientes>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        if (op.equals("list")) {
            //operacion para listar datos
            String sql = "select * from clientes";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Clientes cli = new Clientes();
                    cli.setId(rs.getInt("id"));
                    cli.setNombre(rs.getString("nombre"));
                    cli.setApellido(rs.getString("apellido"));
                    cli.setCi(rs.getString("ci"));
                    cli.setCorreo(rs.getString("correo"));
                    cli.setTelefono(rs.getString("telefono"));
                    cli.setDireccion(rs.getString("direccion"));
                    cli.setPassword(rs.getString("password"));

                    lista.add(cli);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario

            Clientes cli= new Clientes();

            request.setAttribute("cli", cli);
            request.getRequestDispatcher("frmClientes.jsp").forward(request, response);
        }

        if (op.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {

                Clientes cli = new Clientes();

                ps = conn.prepareStatement("select * from clientes where id= ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    cli.setId(rs.getInt("id"));
                    cli.setNombre(rs.getString("nombre"));
                    cli.setApellido(rs.getString("apellido"));
                    cli.setCi(rs.getString("ci"));
                    cli.setCorreo(rs.getString("correo"));
                    cli.setTelefono(rs.getString("telefono"));
                    cli.setDireccion(rs.getString("direccion"));
                    cli.setPassword(rs.getString("password"));
                    

                }
                request.setAttribute("cli", cli);
                request.getRequestDispatcher("frmClientes.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro
            id = Integer.parseInt(request.getParameter("id"));

            try {
                ps = conn.prepareStatement("delete from clientes where id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("ClienteController");
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ci = request.getParameter("ci");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String password = request.getParameter("password");
       

        Clientes cli = new Clientes();
        cli.setId(id);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setCi(ci);
        cli.setCorreo(correo);
        cli.setTelefono(telefono);
        cli.setDireccion(direccion);
        cli.setPassword(password);

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            //insertar registro
            String sql = "insert into clientes (nombre,apellido,ci,correo,telefono,direccion,password)values(?,?,?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, cli.getNombre());
                ps.setString(2, cli.getApellido());
                ps.setString(3, cli.getCi());
                ps.setString(4, cli.getCorreo());
                ps.setString(5, cli.getTelefono());
                 ps.setString(6, cli.getDireccion());
                ps.setString(7, cli.getPassword());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Update registro
            String sql1 = "update clientes set nombre=?,apellido=?,ci=?,correo=?,telefono=?,direccion=?, password=? where id=?";
            try {
                 ps = conn.prepareStatement(sql1);
                ps.setString(1, cli.getNombre());
                ps.setString(2, cli.getApellido());
                ps.setString(3, cli.getCi());
                ps.setString(4, cli.getCorreo());
                ps.setString(5, cli.getTelefono());
                ps.setString(6, cli.getDireccion());
                ps.setString(7, cli.getPassword());
                ps.setInt(8, cli.getId());


                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("ClienteController");
    }
 
}
