
package com.emergentes.modelo;


public class Proveedores {
    private int id_proveedor;
    private String descripcion;
    private String telefono;
    private String  direccion;
    private int cantidad;
    private float precio;

    public Proveedores() {
        this.id_proveedor = 0;
        this.descripcion = "";
        this.telefono = "";
        this.direccion = "";
        this.cantidad = 0;
        this.precio = 0;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "id_proveedor=" + id_proveedor + ", descripcion=" + descripcion + ", telefono=" + telefono + ", direccion=" + direccion + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
    
    
    
}
