
<%@page import="com.emergentes.modelo.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Usuarios usu= (Usuarios) request.getAttribute("usu");
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
        <title>Usuarios</title>
    </head>
  
    <body >
          <jsp:include page="WEB-INF/menu.jsp"/>
        <h1 align  ="center"><c:if test="${usu.id==0}">
                Nuevo Usuario
            </c:if>
            <c:if test="${usu.id!=0}">
                Editar Usuario
            </c:if>
        </h1>
        <form action="UsuarioControlador" name="usuario" method="POST"  >
            <input type="hidden" name="id" value="${usu.id}">
            <table ALIGN="center">

                <tr>
                    <td><label for="">Nombre:  </label></td>
                    <td><input type="text" name="nombre" value="${usu.nombre}" required>
                    </td>
                </tr>
               <tr>
                    <td><label for="">Apellido:  </label></td>
                    <td><input type="text" name="apellido" value="${usu.apellido}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">CI:  </label></td>
                    <td><input type="text" name="ci" value="${usu.ci}" >
                    </td>
                </tr>
                <tr>
                    <td><label for="">Correo:  </label></td>
                    <td><input type="text" name="correo" value="${usu.correo}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Telefono:  </label></td>
                    <td><input type="text" name="telefono" value="${usu.telefono}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Contraseña:  </label></td>
                    <td><input type="password" name="password" value="${usu.password}" required>
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
