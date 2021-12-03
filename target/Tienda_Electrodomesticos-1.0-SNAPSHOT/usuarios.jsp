

<%@page import="com.emergentes.modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Usuarios> lista = (List<Usuarios>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bulma.min.css">
    <link rel="stylesheet" href="css/material-design-iconic-font.css">
    <link rel="stylesheet" href="css/styles.css">
        <title>Usuarios</title>
    </head>
    <body >
        <jsp:include page="WEB-INF/menu.jsp"/>
        <br><br>
        
         <h1 align="center">Lista de Usuarios - Administradores</h1>
        <p>
            <a href="UsuarioControlador?op=nuevo">Nuevo</a>
        </p>
        <table width="85%" align="center" border =1>
            
                <tr >
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>CI</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Contraseña</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${lista}">
                    <tr >
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.ci}</td>
                    <td>${item.correo}</td>
                    <td>${item.telefono}</td>
                    <td>${item.password}</td>
                    <td><a href="UsuarioControlador?op=editar&id=${item.id}">Editar</a></td>
                    <td><a href="UsuarioControlador?op=eliminar&id=${item.id}"
                           onclick="return(confirm('Esta Seguro de eliminar?'))">Eliminar</a></td>
                </tr>
                </c:forEach>
                
        </table>
    </body>
</html>