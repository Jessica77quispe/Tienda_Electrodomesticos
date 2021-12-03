
package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.dao.ModeloCategoria;


public class ControladorCategoria {
    public boolean crearCategoria(Categoria cat){
        ModeloCategoria mc= new ModeloCategoria();
        return mc.crear_categoria(cat);
    }
    
    public String getViewCategoria(){
        String htmlcode="";
        
        ModeloCategoria mc= new ModeloCategoria();
        int i=0;
        for(Categoria c:mc.getAllCategoria()){
            
          
       htmlcode+="<div class=\"column is-half column-full\">\n" +
"                        <div class=\"card\">\n" +
"                            <span class=\"price\"></span>\n<a href=\"ProductosController?id_categoria="+c.getId_categoria()+"\"   >  " +
"                            <img src="+ c.getImagen()+" >\n" +
"                            </a><div class=\"card-info\">\n" +
"                                <h4 class=\"has-text-black has-text-centered has-text-weight-bold\"><a href=\"productos.jsp?id_categoria="+c.getId_categoria()+"\"   >   "+c.getDescripcion() +"\n</a>" +
"                                   </h4>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>";
        }
        return htmlcode;
    }
    
   
    
    
}
    