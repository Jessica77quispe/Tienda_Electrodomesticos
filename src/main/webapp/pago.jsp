
<%@page import="com.emergentes.modelo.Modo_pago"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Modo_pago> lista = (List<Modo_pago>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bulma.min.css">
    <link rel="stylesheet" href="css/material-design-iconic-font.css">
    <link rel="stylesheet" href="css/styles.css">
        <title>Modo Pago</title>
    </head>
    <body >
        <jsp:include page="WEB-INF/menu.jsp"/>
        <br><br>
        
         <h1 align="center">Modos de Pago</h1>
        <p>
            <a href="PagoControlador?op=nuevo">Nuevo</a>
        </p>
        <table width="85%"align="center" border =1>
            
                <tr >
                    <th>Id_pago</th>
                    <th>Descripcion</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="item" items="${lista}">
                    <tr >
                    <td>${item.id_pago}</td>
                    <td>${item.descripcion}</td>
                   
                    <td><a href="PagoControlador?op=editar&id_pago=${item.id_pago}">Editar</a></td>
                    <td><a href="PagoControlador?op=eliminar&id_pago=${item.id_pago}"
                           onclick="return(confirm('Esta Seguro de eliminar?'))">Eliminar</a></td>
                </tr>
                </c:forEach>
                
        </table>
    </body>
</html>