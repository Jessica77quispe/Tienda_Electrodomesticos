
<%@page import="com.emergentes.dao.ControladorCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="container" width="85%">
            <div class="columns is-multiline">
                <div class="columns is-multiline">
                    
                    <%
                        ControladorCategoria cc = new ControladorCategoria();
                    %>   
                    <%= cc.getViewCategoria()%>
                </div>
                
                

            </div>
        </div>


    </body>
</html>
