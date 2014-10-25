package com.bo.openlogics.sales.model;



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
@IdClass(Compras_articuloId.class)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Embeddable
public class Compras_articulo implements Serializable {

    private static final long serialVersionUID = 1L;


    //@EmbeddedId
    private Compras_articuloId compras_articuloId;


    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Compra compra;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clasif_Articulo clasif_articulo;

    public Compras_articulo(){

    }

    public Compras_articulo(Integer cantidad, Compra compra, Clasif_Articulo clasif_articulo) {
        this.cantidad = cantidad;
        this.compra = compra;
        this.clasif_articulo = clasif_articulo;
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

    public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    }


    public Compras_articuloId getCompras_articuloId() {
        return compras_articuloId;
    }

    public void setCompras_articuloId(Compras_articuloId compras_articuloId) {
        this.compras_articuloId = compras_articuloId;
    }
}
