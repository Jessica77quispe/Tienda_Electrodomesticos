

<%@page import="com.emergentes.modelo.Proveedores"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    Proveedores prov= (Proveedores) request.getAttribute("prov");
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
        <title>Proveedores</title>
    </head>
  
    <body >
          <jsp:include page="WEB-INF/menu.jsp"/>
        <h1 align  ="center"><c:if test="${prov.id_proveedor==0}">
                Nuevo Proveedor
            </c:if>
            <c:if test="${prov.id_proveedor!=0}">
                Editar proveedor
            </c:if>
        </h1>
        <form action="ProveedoresControlador" name="proveedores" method="POST"  >
            <input type="hidden" name="id_proveedor" value="${prov.id_proveedor}">
            <table ALIGN="center">

                <tr>
                    <td><label for="">Descripcion:  </label></td>
                    <td><input type="text" name="descripcion" value="${prov.descripcion}" required>
                    </td>
                </tr>
               <tr>
                    <td><label for="">Telefono:  </label></td>
                    <td><input type="text" name="telefono" value="${prov.telefono}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Direcion:  </label></td>
                    <td><input type="text" name="direccion" value="${prov.direccion}" >
                    </td>
                </tr>
                <tr>
                    <td><label for="">Cantidad:  </label></td>
                    <td><input type="text" name="cantidad" value="${prov.cantidad}" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="">Precio:  </label></td>
                    <td><input type="text" name="precio" value="${prov.precio}" required>
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
