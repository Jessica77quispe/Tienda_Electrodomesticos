
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import java.sql.SQLException;
import com.emergentes.dao.ModeloProductos;

public class ControladorProductos {
      
       public boolean crearProductos(Productos prod){
        ModeloProductos mc= new ModeloProductos();
        return mc.crear_productos(prod);
    }
       
        public String getViewProductos(){
        String htmlcode="";
        
        ModeloProductos mp= new ModeloProductos();
        int i=0;
        for(Productos p:mp.getAllProductos()){
            
       
            htmlcode+=" <div class=\"column is-half column-full\">\n" +
"                        <div class=\"card\">\n" +
"                            <span class=\"price\">"+p.getPrecio()+"</span>\n" +
"                            <a href=ProductosController?op=detalle&id="+p.getId()+"><img src=\'"+p.getImagen_1()+" 'alt=\"\">\n" +
"                            <div class=\"card-info\">\n" +
"                                <h4 class=\"has-text-black has-text-centered has-text-weight-bold\"> "+p.getNombre_producto()+"" +
"                                    "+p.getPrecio()+" </h4>\n" +
"                                <p class=\"has-text-centered\">"+p.getDescripcion()+"" +
"                                    " +
"                                    cotton.</p>\n" +
                    "<div class=\"column is-full is-marginless\">"+
                          "  <button class=\"btn btn-default btn-outline\"><i class=\"zmdi zmdi-shopping-cart\"></i>"+
                         "       Agregar al carrito</button>"+
                        "</div>"+
"                                <div class=\"card-buttons\">\n" +
"                                    <a href=\"#\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-shopping-cart\"></i></a>\n" +
"                                    <a href=\"#\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-favorite-outline\"></i></a>\n" +
"                                    <a href=\"producto.html\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-eye\"></i></a>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>";
           

        }
        return htmlcode;
    }
        
  /*       public String getViewCategoria(int id_categoria){
        String htmlcode="";
        
        ModeloProductos mp= new ModeloProductos();
        int i=0;
        for(Productos p:mp.getViewCat(id_categoria)){
        htmlcode+=" <div class=\"column is-half column-full\">\n" +
"                        <div class=\"card\">\n" +
"                            <span class=\"price\">"+p.getPrecio()+"</span>\n" +
"                            <img src='"+p.getImagen_1()+"'>\n" +
"                            <div class=\"card-info\">\n" +
"                                <h4 class=\"has-text-black has-text-centered has-text-weight-bold\"> "+p.getNombre_producto()+"" +
"                                    "+p.getPrecio()+" </h4>\n" +
"                                <p class=\"has-text-centered\">Classic casual t-shirt for women on the move.\n" +
"                                    100%\n" +
"                                    cotton.</p>\n" +
"                                <div class=\"card-buttons\">\n" +
"                                    <a href=\"#\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-shopping-cart\"></i></a>\n" +
"                                    <a href=\"#\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-favorite-outline\"></i></a>\n" +
"                                    <a href=\"producto.html\" class=\"btn btn--mini-rounded\"><i\n" +
"                                            class=\"zmdi zmdi-eye\"></i></a>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>";
         }return null;
         }
         
         
        public String getDetallesProductos(int id){
            ModeloProductos modpro= new ModeloProductos();
            Productos p= modpro.getProductos(id);
            String htmlcode="";
            
           htmlcode="<div class=\"container\">\n" +
"        <div class=\"columns\">\n" +
"            <div class=\"column is-two-fifths-desktop\">\n" +
"                <div class=\"slider\" id=\"slider\">\n" +
"                    <div class=\"slider-img-container\">\n" +
"                        <img src=\"img/item-1.png\" alt=\"camiseta\" class=\"active slider-item\">\n" +
"                    </div>\n" +
"                    <div class=\"slider-img-container\">\n" +
"                        <img src=\"img/item-2.png\" alt=\"camiseta\" class=\"slider-item\">\n" +
"                    </div>\n" +
"                    <div class=\"slider-img-container\">\n" +
"                        <img src=\"img/item-5.png\" alt=\"camiseta\" class=\"slider-item\">\n" +
"                    </div>\n" +
"                    <div class=\"slider-button-left slider-buttons\" onclick=\"previus()\">\n" +
"                        <i class=\"zmdi zmdi-chevron-left zmdi-hc-3x\"></i>\n" +
"                    </div>\n" +
"                    <div class=\"slider-button-right slider-buttons\" onclick=\"next()\">\n" +
"                        <i class=\"zmdi zmdi-chevron-right zmdi-hc-3x\"></i>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"column\">\n" +
"                <h3 class=\"is-size-4\"></h3>\n" +
"                <div class=\"course-rating-container\">\n" +
"                    <div class=\"rating-stars\" style=\"--rating: 86%\">\n" +
"                    </div>\n" +
"                </div>\n" +
"                <p class=\"\"> 3 comentarios | Compartir: <a class=\"icon-socials\" href=\"#\"><i\n" +
"                            class=\"zmdi zmdi-facebook\"></i></a>\n" +
"                    <a class=\"icon-socials\" href=\"#\"><i class=\"zmdi zmdi-twitter\"></i></a>\n" +
"                    <a class=\"icon-socials\" href=\"#\"><i class=\"zmdi zmdi-instagram\"></i></a>\n" +
"                    <a class=\"icon-socials\" href=\"#\"><i class=\"zmdi zmdi-pinterest\"></i></a>\n" +
"                    <a class=\"icon-socials\" href=\"#\"><i class=\"zmdi zmdi-email\"></i></a>\n" +
"                </p>\n" +
"                <h2 class=\"price is-size-4\"><sup>$</sup>89.99</h2>\n" +
"                <p class=\"has-text-grey\"> <strong>Disponibilidad:</strong> En stock</p>\n" +
"                <p class=\"has-text-grey\"><strong></strong>#56843265</p>\n" +
"                <p class=\"text-default\">Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure\n" +
"                    repellat,\n" +
"                    sequi doloremque accusamus, voluptates nihil commodi necessitatibus, ullam\n" +
"                    fugit ea a illo maxime repudiandae. Iusto totam nemo nam ullam officiis?</p>\n" +
"                <form action=\"#\" class=\"form-control\">\n" +
"                    <div class=\"columns is-multiline\">\n" +
"                        <div class=\"column is-one-third\">\n" +
"                            <label for=\"color\">Color</label>\n" +
"                            <select class=\"form-control-field\" id=\"color\">\n" +
"                                <option value=\"#\">Color 1</option>\n" +
"                                <option value=\"#\">Color 2</option>\n" +
"                                <option value=\"#\">Color 3</option>\n" +
"                            </select>\n" +
"\n" +
"                        </div>\n" +
"                        <div class=\"column is-one-third\">\n" +
"\n" +
"                            <label for=\"size\">Tamaño</label>\n" +
"                            <select class=\"form-control-field\" id=\"size\">\n" +
"                                <option value=\"#\">Tamaño 1</option>\n" +
"                                <option value=\"#\">Tamaño 2</option>\n" +
"                                <option value=\"#\">Tamaño 3</option>\n" +
"                            </select>\n" +
"                        </div>\n" +
"                        <div class=\"column is-one-third\">\n" +
"                            <label for=\"quality\">Cantidad</label>\n" +
"                            <input class=\"form-control-field\" type=\"number\">\n" +
"                        </div>\n" +
"                        <div class=\"column is-full is-marginless\">\n" +
"                            <button class=\"btn btn-default btn-outline\"><i class=\"zmdi zmdi-shopping-cart\"></i>\n" +
"                                Agregar al carrito</button>\n" +
"                        </div>\n" +
"                    </div>\n" +
"\n" +
"                </form>\n" +
"            </div>\n" +
"\n" +
"        </div>\n" +
"    </div>";
            
            
            return htmlcode;
        }*/
    
  //  "<div class=\"column is-half column-full\">\n" +
    
}
