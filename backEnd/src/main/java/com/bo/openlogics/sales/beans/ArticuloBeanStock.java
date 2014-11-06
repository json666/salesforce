package com.bo.openlogics.sales.beans;

/**
 * Created by osanchez on 27/10/14.
 */
public class ArticuloBeanStock {
    private Long idArticulo;
    private String descripcionArticulo;
    private String codigoArticulo;
    private Long stock;
    private Double precioVenta;
    private Integer cantidadVenta;



    public ArticuloBeanStock() {
    }

    public ArticuloBeanStock(Long idArticulo, String descripcionArticulo,
                             String codigoArticulo, Long stock,
                             Double precioVenta) {
        this.idArticulo = idArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.stock = stock;
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



    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Integer getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }
}
