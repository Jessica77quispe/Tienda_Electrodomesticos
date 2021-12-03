

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bulma.min.css">
    <link rel="stylesheet" href="css/material-design-iconic-font.css">
    <link rel="stylesheet" href="css/styles.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp"/><br><br>
         <div class="container">
        <div class="columns">
            <div class="column">
                <h2 class="is-size-4" align="center">Iniciar seción</h2>
                <form action="loginController" class="form-control" method="post">

                    <input type="email" name="correo"placeholder="email" class="form-control-field error">

                    <input type="password" placeholder="Password" name="password" class="form-control-field">

                    <button class="btn btn-default btn-primary">Iniciar seción</button>
                </form>
            </div>
           
        </div>
    </div>

    </body>
</html>
