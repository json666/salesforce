package com.bo.openlogics.sales.model;

import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

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
    private Integer cantidad;

    @Id
    @ManyToOne
    private Compra compra;

    @Id
    @ManyToOne
    private Clasif_Articulo articulo;

    public Compras_articulo(){

    }

    public Compras_articulo(Integer cantidad, Compra compra, Clasif_Articulo articulo) {
        this.cantidad = cantidad;
        this.compra = compra;
        this.articulo = articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Clasif_Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Clasif_Articulo articulo) {
        this.articulo = articulo;
    }
}
