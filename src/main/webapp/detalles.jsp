
<%@page import="com.emergentes.modelo.Productos"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.dao.ControladorProductos"%>
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
        <div class="columns">
            <div class="column is-two-fifths-desktop">
                <div class="slider" id="slider">
                    <div class="slider-img-container">
                        <img src="${prod.imagen_1}" alt="imagen" class="active slider-item">
                    </div>
                    <div class="slider-img-container">
                        <img src="${prod.imagen_2}" alt="imagen" class="slider-item">
                    </div>
                    <div class="slider-button-left slider-buttons" onclick="previus()">
                        <i class="zmdi zmdi-chevron-left zmdi-hc-3x"></i>
                    </div>
                    <div class="slider-button-right slider-buttons" onclick="next()">
                        <i class="zmdi zmdi-chevron-right zmdi-hc-3x"></i>
                    </div>
                </div>
            </div>
            <div class="column">
                <h3 class="is-size-4">${prod.nombre_producto}</h3>
                <div class="course-rating-container">
                    <div class="rating-stars" style="--rating: 50%">
                    </div>
                </div>
                <p class="">  Compartir: <a class="icon-socials" href="#"><i
                            class="zmdi zmdi-facebook"></i></a>
                    <a class="icon-socials" href="#"><i class="zmdi zmdi-twitter"></i></a>
                    <a class="icon-socials" href="#"><i class="zmdi zmdi-instagram"></i></a>
                    <a class="icon-socials" href="#"><i class="zmdi zmdi-pinterest"></i></a>
                    <a class="icon-socials" href="#"><i class="zmdi zmdi-email"></i></a>
                </p>
                <h2 class="price is-size-4"><sup>$</sup>${prod.precio}</h2>
                <p class="has-text-grey"> <strong>Disponibilidad:</strong> ${prod.estado}</p>
                <p class="text-default">${prod.descripcion}</p>
                <form action="#" class="form-control">
                        <div class="column is-one-third">
                            <label for="quality">Cantidad</label>
                            <input class="form-control-field" type="number">
                        </div>
                        <div class="column is-full is-marginless">
                            <button class="btn btn-default btn-outline"><i class="zmdi zmdi-shopping-cart"></i>
                                Agregar al carrito</button>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
              
<jsp:include page="WEB-INF/footer.jsp"/>    <script src="js/main.js"></script>
            
                
                

            </div>
        </div>


    </body>
</html>
