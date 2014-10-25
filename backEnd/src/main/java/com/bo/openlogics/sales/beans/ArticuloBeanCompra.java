package com.bo.openlogics.sales.beans;

import java.io.Serializable;

/**
 * Created by json on 25/10/14.
 */
public class ArticuloBeanCompra implements Serializable {

    private Long id;

    private String codigoArticulo ;

    private String nombreArticulo ;

    private Double precio ;


    public ArticuloBeanCompra() {
    }

    public ArticuloBeanCompra(Long id, String codigoArticulo, String nombreArticulo, Double precio) {
        this.id = id;
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
