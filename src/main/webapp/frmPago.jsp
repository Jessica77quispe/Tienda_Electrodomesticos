<%@page import="com.emergentes.modelo.Modo_pago"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Modo_pago pago= (Modo_pago) request.getAttribute("pago");
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
        <title>Modo Pago</title>
    </head>
  
    <body >
          <jsp:include page="WEB-INF/menu.jsp"/>
        <h1 align  ="center"><c:if test="${pago.id_pago==0}">
                Nuevo Modo de Pago
            </c:if>
            <c:if test="${pago.id_pago!=0}">
                Editar Modo de Pago
            </c:if>
        </h1>
        <form action="PagoControlador" name="modoPago" method="POST"  >
            <input type="hidden" name="id_pago" value="${pago.id_pago}">
            <table ALIGN="center">

                <tr>
                    <td><label for="">Descripcion:  </label></td>
                    <td><input type="text" name="descripcion" value="${pago.descripcion}" required>
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
