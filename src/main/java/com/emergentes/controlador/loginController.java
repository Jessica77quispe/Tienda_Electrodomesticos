
package com.emergentes.controlador;

import com.emergentes.utiles.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "loginController", urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.sendRedirect("login.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo=request.getParameter("correo");
         String password=request.getParameter("password");
        
         System.out.println("Datos..."+correo+" "+password);
   
         
         Validate v=new Validate();
         
    
            if(v.chekUser(correo, password)){
                HttpSession ses=request.getSession();
                ses.setAttribute("login","OK");
                response.sendRedirect("ControladorCategoria");
                System.out.println("login ok");
            }else{
                //System.out.println("Incorrecto");
                response.sendRedirect("login.jsp");
            }
       
    }

   
}
