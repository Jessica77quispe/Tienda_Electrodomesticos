
package com.emergentes.modelo;

public class Detalle_compra {
    private int id_detalle;
    private int id_factura;
    private int id_producto;
    private int cantidad;
    private float precio;

    public Detalle_compra() {
        this.id_detalle = 0;
        this.id_factura = 0;
        this.id_producto = 0;
        this.cantidad = 0;
        this.precio = 0;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
        return "Detalle_compra{" + "id_detalle=" + id_detalle + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
