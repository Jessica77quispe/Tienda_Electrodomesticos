
<%@page import="com.emergentes.modelo.Productos"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.dao.ControladorProductos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Productos> lista = (List<Productos>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="css/bulma.min.css">
        <link rel="stylesheet" href="css/material-design-iconic-font.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp"/>
        <br><br><br><br>
        <div class="container">
            <div class="columns is-multiline">
                <div class="columns is-multiline">
                    <%ControladorProductos cp=new ControladorProductos();%>
                    <%=cp.getViewProductos()%>
                </div>



            </div>
        </div>

<a href="ProductosController?op=editar&id=9" class="nav-menu-link">editar</a>
<a href="ProductosController?op=eliminar&id=9" class="nav-menu-link">eliminar</a>
    </body>
</html>

