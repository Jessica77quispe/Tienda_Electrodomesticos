
package com.emergentes.controlador;


import com.emergentes.modelo.Usuarios;
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


@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id;
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        if (op.equals("list")) {
            //operacion para listar datos
            String sql = "select * from usuarios";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuarios usu = new Usuarios();
                    usu.setId(rs.getInt("id"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setApellido(rs.getString("apellido"));
                    usu.setCi(rs.getString("ci"));
                    usu.setCorreo(rs.getString("correo"));
                    usu.setTelefono(rs.getString("telefono"));
                    usu.setPassword(rs.getString("password"));

                    lista.add(usu);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario

            Usuarios usu= new Usuarios();

            request.setAttribute("usu", usu);
            request.getRequestDispatcher("frmUsuarios.jsp").forward(request, response);
        }

        if (op.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {

                Usuarios usu = new Usuarios();

                ps = conn.prepareStatement("select * from usuarios where id= ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    usu.setId(rs.getInt("id"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setApellido(rs.getString("apellido"));
                    usu.setCi(rs.getString("ci"));
                    usu.setCorreo(rs.getString("correo"));
                    usu.setTelefono(rs.getString("telefono"));
                    usu.setPassword(rs.getString("password"));
                    

                }
                request.setAttribute("usu", usu);
                request.getRequestDispatcher("frmUsuarios.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro
            id = Integer.parseInt(request.getParameter("id"));

            try {
                ps = conn.prepareStatement("delete from usuarios where id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("UsuarioControlador");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
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
        String password = request.getParameter("password");
       

        Usuarios usu = new Usuarios();
        usu.setId(id);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setCi(ci);
        usu.setCorreo(correo);
        usu.setTelefono(telefono);
        usu.setPassword(password);

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            //insertar registro
            String sql = "insert into usuarios (nombre,apellido,ci,correo,telefono,password)values(?,?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, usu.getNombre());
                ps.setString(2, usu.getApellido());
                ps.setString(3, usu.getCi());
                ps.setString(4, usu.getCorreo());
                ps.setString(5, usu.getTelefono());
                ps.setString(6, usu.getPassword());

                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Update registro
            String sql1 = "update usuarios set nombre=?,apellido=?,ci=?,correo=?,telefono=?,password=? where id=?";
            try {
                 ps = conn.prepareStatement(sql1);
                ps.setString(1, usu.getNombre());
                ps.setString(2, usu.getApellido());
                ps.setString(3, usu.getCi());
                ps.setString(4, usu.getCorreo());
                ps.setString(5, usu.getTelefono());
                ps.setString(6, usu.getPassword());
                ps.setInt(7, usu.getId());


                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("UsuarioControlador");
    }

    }


    
 

