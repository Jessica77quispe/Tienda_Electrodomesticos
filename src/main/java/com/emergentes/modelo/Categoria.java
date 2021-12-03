
package com.emergentes.modelo;


public class Categoria {
     private int id_categoria;
    private String descripcion;
    private String imagen;

    public Categoria(int id_categoria, String descripcion, String imagen) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
    
    public Categoria() {
        this.id_categoria = 0;
        this.descripcion = "";
        this.imagen = "";
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", descripcion=" + descripcion + ", imagen=" + imagen + '}';
    }
    
}
