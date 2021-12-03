
package com.emergentes.modelo;

public class Pedidos {
   
    private int id_pedidos;
    private int  num_facturas;

    public Pedidos() {
        this.id_pedidos = 0;
        this.num_facturas = 0;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public int getNum_facturas() {
        return num_facturas;
    }

    public void setNum_facturas(int num_facturas) {
        this.num_facturas = num_facturas;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "id_pedidos=" + id_pedidos + ", num_facturas=" + num_facturas + '}';
    }
    
    
}
