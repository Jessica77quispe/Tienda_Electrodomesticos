
<%@page import="com.emergentes.dao.ControladorProductos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Productos prod= (Productos) request.getAttribute("prod");
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
                    <c:forEach var="" items="">
                         <div class="column is-half column-full">
                        <div class="card">
                            <span class="price">${prod.precio}</span>
                            <img src="img/item-1.png" alt="">
                            <div class="card-info">
                                <h4 class="has-text-black has-text-centered has-text-weight-bold">${prod.nombre_producto} </h4>
                                <p class="has-text-centered">Classic casual t-shirt for women on the move.
                                    100%
                                    cotton.</p>
                                <div class="card-buttons">
                                    <a href="#" class="btn btn--mini-rounded"><i
                                            class="zmdi zmdi-shopping-cart"></i></a>
                                    <a href="#" class="btn btn--mini-rounded"><i
                                            class="zmdi zmdi-favorite-outline"></i></a>
                                    <a href="producto.html" class="btn btn--mini-rounded"><i
                                            class="zmdi zmdi-eye"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>



            </div>
        </div>

<a href="ProductosController?op=editar&id=9" class="nav-menu-link">editar</a>
<a href="ProductosController?op=eliminar&id=9" class="nav-menu-link">eliminar</a>
    </body>
</html>
