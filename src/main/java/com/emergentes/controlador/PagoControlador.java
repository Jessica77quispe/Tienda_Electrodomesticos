/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;


import com.emergentes.modelo.Modo_pago;
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


@WebServlet(name = "PagoControlador", urlPatterns = {"/PagoControlador"})
public class PagoControlador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id_pago;
        ArrayList<Modo_pago> lista = new ArrayList<Modo_pago>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        if (op.equals("list")) {
            //operacion para listar datos
            String sql = "select * from modo_pago";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Modo_pago pago = new Modo_pago();
                    pago.setId_pago(rs.getInt("id_pago"));
                    pago.setDescripcion(rs.getString("descripcion"));
                    

                    lista.add(pago);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("pago.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PagoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario

            Modo_pago pago = new Modo_pago();

            request.setAttribute("pago", pago);
            request.getRequestDispatcher("frmPago.jsp").forward(request, response);
        }

        if (op.equals("editar")) {
            id_pago = Integer.parseInt(request.getParameter("id_pago"));
            try {

                Modo_pago pago = new Modo_pago();

                ps = conn.prepareStatement("select * from modo_pago where id_pago= ?");
                ps.setInt(1, id_pago);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pago.setId_pago(rs.getInt("id_pago"));
                    pago.setDescripcion(rs.getString("descripcion"));
                    
                }
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("frmPago.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PagoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro
            id_pago = Integer.parseInt(request.getParameter("id_pago"));

            try {
                ps = conn.prepareStatement("delete from modo_pago where id_pago = ?");
                ps.setInt(1, id_pago);
                ps.executeUpdate();
                response.sendRedirect("PagoControlador");
            } catch (SQLException ex) {
                Logger.getLogger(PagoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pago = Integer.parseInt(request.getParameter("id_pago"));
        String descripcion = request.getParameter("descripcion");
        

        Modo_pago pago = new Modo_pago();
        pago.setId_pago(id_pago);
        pago.setDescripcion(descripcion);
       

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id_pago == 0) {
            //insertar registro
            String sql = "insert into modo_pago (descripcion)values(?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, pago.getDescripcion());
                

                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PagoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Update registro
            String sql1 = "update modo_pago set descripcion=? where id_pago=?";
            try {
                ps = conn.prepareStatement(sql1);
                ps.setString(1, pago.getDescripcion());
                ps.setInt(2, pago.getId_pago());

                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PagoControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("PagoControlador");
    }

        
    

  
}
