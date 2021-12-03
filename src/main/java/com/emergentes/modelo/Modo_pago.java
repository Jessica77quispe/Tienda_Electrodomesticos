
package com.emergentes.modelo;

public class Modo_pago {
    
    private int id_pago;
    private String descripcion;

    public Modo_pago() {
        this.id_pago = 0;
        this.descripcion="";
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Modo_pago{" + "id_pago=" + id_pago + ", descripcion=" + descripcion + '}';
    }

    
}
