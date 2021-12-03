
package com.emergentes.modelo;

public class Productos {
    private int id;
    private String nombre_producto;
    private String imagen_1;
    private String imagen_2;
    private double precio;
    private String descripcion;
    private String marca;
    private int stock;
    private String estado;
    private int id_proveedores;
    private int id_categoria;

    public Productos() {
        this.id = 0;
        this.nombre_producto = "";
        this.imagen_1 = "";
        this.imagen_2 = "";
        this.precio = 0;
        this.descripcion = "";
        this.marca = "";
        this.stock = 0;
        this.estado = "";
        this.id_proveedores = 0;
        this.id_categoria = 0;
    }

    public Productos(int id, String nombre_producto, String imagen_1, String imagen_2, double precio, String descripcion,  String marca, int stock, String estado, int id_proveedores, int id_categoria) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.imagen_1 = imagen_1;
        this.imagen_2 = imagen_2;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.stock = stock;
        this.estado = estado;
        this.id_proveedores = id_proveedores;
        this.id_categoria = id_categoria;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getImagen_1() {
        return imagen_1;
    }

    public void setImagen_1(String imagen_1) {
        this.imagen_1 = imagen_1;
    }

    public String getImagen_2() {
        return imagen_2;
    }

    public void setImagen_2(String imagen_2) {
        this.imagen_2 = imagen_2;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    

   
    
}
