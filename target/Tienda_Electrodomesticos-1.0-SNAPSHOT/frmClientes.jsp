
<%@page import="com.emergentes.modelo.Clientes"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Clientes cli= (Clientes) request.getAttribute("cli");
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
        <title>Clientes</title>
    </head>
  
    <body >
          <jsp:include page="WEB-INF/menu.jsp"/>
        <h1 align  ="center">
                Nuevo Cliente
            
            
        </h1>
        <form action="ClienteController" name="clientes" method="POST"  >
            <input type="hidden" name="id" value="${cli.id}">
            <table ALIGN="center">

                <tr>
                    <td><label for="">Nombre:  </label></td>
                    <td><input type="text" name="nombre" value="${cli.nombre}" required>
                    </td>
                </tr>
               <tr>
                    <td><label for="">Apellido:  </label></td>
                    <td><input type="text" name="apellido" value="${cli.apellido}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">CI:  </label></td>
                    <td><input type="text" name="ci" value="${cli.ci}" >
                    </td>
                </tr>
                <tr>
                    <td><label for="">Correo:  </label></td>
                    <td><input type="text" name="correo" value="${cli.correo}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Telefono:  </label></td>
                    <td><input type="text" name="telefono" value="${cli.telefono}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Direccion:  </label></td>
                    <td><input type="text" name="direccion" value="${cli.direccion}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Contraseña:  </label></td>
                    <td><input type="password" name="password" value="${cli.password}" required>
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
