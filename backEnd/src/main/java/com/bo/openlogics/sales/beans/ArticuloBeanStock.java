package com.bo.openlogics.sales.beans;

/**
 * Created by osanchez on 27/10/14.
 */
public class ArticuloBeanStock {
    private Long idArticulo;
    private String descripcionArticulo;
    private String codigoArticulo;
    private Long cantidadExistente;

    private Double precioVenta;

    public ArticuloBeanStock(Long idArticulo, String descripcionArticulo, String codigoArticulo, Long cantidadExistente, Double precioVenta) {
        this.idArticulo = idArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.cantidadExistente = cantidadExistente;
        this.precioVenta = precioVenta;
    }

    public ArticuloBeanStock() {
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public Long getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Long cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
