<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.emergentes.utiles.ConexionBD"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Productos> lista = (List<Productos>)request.getAttribute("lista");
%>

<%
    Productos prod= (Productos) request.getAttribute("prod");
    PreparedStatement ps;
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bulma.min.css">
    <link rel="stylesheet" href="css/material-design-iconic-font.css">
    <link rel="stylesheet" href="css/styles.css">
        <title>Productos</title>
    </head>
    
    <body >
        <jsp:include page="WEB-INF/menu.jsp"/><br><br>
        <h1 align  ="center">
                Editar Productos
           
        </h1><br>
        <form action="ProductosController" name="frmProductos" method="POST"  id="frmProductos" >
            <input type="hidden" name="id" value="${prod.id}">
            <table ALIGN="center">

                <tr>
                    <td><label for="">Nombre del Producto:  </label></td>
                    <td><input type="text" name="nombre_producto" id="nombre_producto" value="${prod.nombre_producto}">
                    </td>
                </tr>
                <tr>
                    <td><label for="">precio :  </label></td>
                    <td><input type="text" name="precio" id="precio" value="${prod.precio}">
                    </td>
                </tr>
                
                <tr>
                    <td><label for="">Descripcion:  </label></td>
                    <td><textarea name="descripcion" rows="6" cols="30" id="descripcion" value="${prod.descripcion}"></textarea>
                    </td>
                
                </tr>
                
                <tr>
                    <td><label for="">Marca:  </label></td>
                    <td><input type="text" name="marca" id="marca" value="${prod.marca}" >
                    </td>
                </tr>
                <tr>
                    <td><label for="">Stock:  </label></td>
                    <td><input type="text" name="stock" id="stock" value="${prod.stock}">
                    </td>
                </tr>
                <tr>
                    <td><label for="">Estado:  </label></td>
                    <td>
                       <select name="estado" id="estado" name="estado" value="${prod.estado}">
                        <option value="promocion" >Promocion</option>
                        <option value="disponible"  selected>Disponible</option>
                        <option value="agotado" >Agotado</option>
                      </select> 
                    </td>
                </tr>
                <tr>
                    <td><label for="">Proveedor:  </label></td>
                    <td>
                        <select id="proveedores" name="proveedores" value="${prod.id_proveedores}">
                          <% String sql="select * from proveedores";
                               ps = conn.prepareStatement(sql);
                                rs = ps.executeQuery();  
                                while(rs.next()){%>
                                <option value= '<%=rs.getString(1)%>' id='proveedores'><%=rs.getString(2)%></option>
                             <% }%>
                                 
                          %> 
                    </td>
                </tr>
                <tr>
                    <td><label for="">Categoria:  </label></td>
                    <td><select id="categoria" name="categoria" value="${prod.id_categoria}">
                        <% String sql1="select * from categoria";
                               ps = conn.prepareStatement(sql1);
                                rs = ps.executeQuery();  
                                while(rs.next()){%>
                                <option value= '<%=rs.getString(1)%>' id='proveedores'><%=rs.getString(2)%></option>
                             <% }%>
                                 
                          %> 
                        </select>
                    </td>
                </tr>
               
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>

        </form>
                             
                             
    </body>
</html>
