package com.bo.openlogics.sales.beans;

/**
 * Created by osanchez on 28/10/14.
 */
public class ArticuloBeanVenta {

    private Long id;

    private String codigoArticulo ;

    private String nombreArticulo ;

    private Double precioCosto ;

    private Integer cantidad;

    private Double monto;

    private Double costoTotal;

    public ArticuloBeanVenta() {
    }

    public ArticuloBeanVenta(Long id, String codigoArticulo, String nombreArticulo, Double precioCosto, Integer cantidad, Double monto, Double costoTotal) {
        this.setId(id);
        this.setCodigoArticulo(codigoArticulo);
        this.setNombreArticulo(nombreArticulo);
        this.setPrecioCosto(precioCosto);
        this.setCantidad(cantidad);
        this.setMonto(monto);
        this.setCostoTotal(costoTotal);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
