package com.bo.openlogics.sales.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 23/10/14
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "COMPRAS_ARTICULO", schema = "SALESFORCE")
//@IdClass(Compras_articuloId.class)
public class Compras_articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Compras_articuloId compras_articuloId;


    @Column(name = "CANTIDAD")
    private String cantidad;

    @Id
    @ManyToOne
    private Compra compra;

    @Id
    @ManyToOne
    private Articulo articulo;

    public Compras_articulo(){

    }

    public Compras_articulo(String cantidad, Compra compra, Articulo articulo) {
        this.cantidad = cantidad;
        this.compra = compra;
        this.articulo = articulo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
