

<%@page import="com.emergentes.modelo.Proveedores"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Proveedores> lista = (List<Proveedores>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bulma.min.css">
    <link rel="stylesheet" href="css/material-design-iconic-font.css">
    <link rel="stylesheet" href="css/styles.css">
        <title>Proveedores</title>
    </head>
    <body >
        <jsp:include page="WEB-INF/menu.jsp"/>
        <br><br>
        
         <h1 align="center">Lista de Proveedores</h1>
        <p>
            <a href="ProveedoresControlador?op=nuevo">Nuevo</a>
        </p>
        <table width="85%" align="center" border =1>
            
                <tr >
                    <th>Id_proveedor</th>
                    <th>Descripcion</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Cantidad</th>
                    <th>precio</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${lista}">
                    <tr >
                    <td>${item.id_proveedor}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.telefono}</td>
                    <td>${item.direccion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td><a href="ProveedoresControlador?op=editar&id_proveedor=${item.id_proveedor}">Editar</a></td>
                    <td><a href="ProveedoresControlador?op=eliminar&id_proveedor=${item.id_proveedor}"
                           onclick="return(confirm('Esta Seguro de eliminar?'))">Eliminar</a></td>
                </tr>
                </c:forEach>
                
        </table>
    </body>
</html>