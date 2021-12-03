<%@page import="com.emergentes.modelo.Categoria"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Categoria cat= (Categoria) request.getAttribute("cat");
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
        <title>categoria</title>
    </head>
    
    <body >
        <jsp:include page="WEB-INF/menu.jsp"/>
        <h1 align  ="center"><c:if test="${cat.id_categoria==0}">
                Nueva Categoria
            </c:if>
            <c:if test="${cat.id_categoria!=0}">
                Editar Categoria
            </c:if>
        </h1>
        <form action="ControladorCategoria" name="frmCategoria" method="POST" enctype="multipart/form-data" id="frmCategoria" >
            <input type="hidden" name="id_categoria" >
            <table ALIGN="center">

                <tr>
                    <td><label for="">Descripcion:  </label></td>
                    <td><input type="text" name="descripcion" id="descripcion" >
                    </td>
                </tr>
                <tr>
                    <td><label for="">Imagen:  </label></td>
                    <td><input type="file" name="file[]" id="archivo" multiple ></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
