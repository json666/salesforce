package com.bo.openlogics.sales.beans;

/**
 * Created by osanchez on 27/10/14.
 */
public class AlmacenBean {
    private Long idArticulo;
    private String descripcionArticulo;
    private String codigoArticulo;
    private Integer cantidadExistente;

    private Double precioVenta;



    public AlmacenBean() {
    }

    public AlmacenBean(Long idArticulo, String descripcionArticulo, String codigoArticulo, Integer cantidadExistente, Double precioVenta) {
        this.idArticulo = idArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.cantidadExistente = cantidadExistente;
        this.precioVenta = precioVenta;
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

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
