
package com.emergentes.modelo;


public class Facturacion {
    private int id_factura;
    private int id_cliente;
    private String fecha;
    private String direccion;
    private String localidad;
    private String region;
    private String codigo_postal;
    private String observaciones;
    private int modo_pago;

    public Facturacion() {
        this.id_factura = 0;
        this.id_cliente = 0;
        this.fecha = "";
        this.direccion = "";
        this.localidad = "";
        this.region = "";
        this.codigo_postal = "";
        this.observaciones = "";
        this.modo_pago = 0;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getModo_pago() {
        return modo_pago;
    }

    public void setModo_pago(int modo_pago) {
        this.modo_pago = modo_pago;
    }

    @Override
    public String toString() {
        return "Facturacion{" + "id_factura=" + id_factura + ", id_cliente=" + id_cliente + ", fecha=" + fecha + ", direccion=" + direccion + ", localidad=" + localidad + ", region=" + region + ", codigo_postal=" + codigo_postal + ", observaciones=" + observaciones + ", modo_pago=" + modo_pago + '}';
    }
    
    
    
}
