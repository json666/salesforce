package com.bo.openlogics.sales.model;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 23/10/14
 * Time: 23:56
 * To change this template use File | Settings | File Templates.
 */
public class Compras_articuloId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private  Long compra;

    @Transient
    private  Long articulo;

    public Compras_articuloId(Long compra, Long articulo) {
        this.compra = compra;
        this.articulo = articulo;
    }

    public Long getCompra() {
        return compra;
    }

    public void setCompra(Long compra) {
        this.compra = compra;
    }

    public Long getArticulo() {
        return articulo;
    }

    public void setArticulo(Long articulo) {
        this.articulo = articulo;
    }
}
