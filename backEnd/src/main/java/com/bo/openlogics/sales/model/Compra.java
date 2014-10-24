package com.bo.openlogics.sales.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 23/10/14
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "COMPRAS", schema = "SALESFORCE")
public class Compra extends EntidadBase implements Serializable{

    //@OneToOne(optional = false, fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    //@OneToOne(optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
    @ManyToOne
    private Clasif_Bodega clasif_bodega;

    @Column(name = "NUMERO_COMPRA")
    private Integer nroCompra;

    /*@ManyToOne
    private Clasif_Articulo clasif_articulo;*/


    @OneToMany(mappedBy="compra")
    private List<Compras_articulo> articulos;

    public Compra(){
    }

    public Compra(Integer nroCompra, List<Compras_articulo> articulos) {
        this.nroCompra = nroCompra;
        this.articulos = articulos;
    }

    public Compra(Clasif_Bodega clasif_bodega, Integer nroCompra, List<Compras_articulo> articulos) {
        this.setClasif_bodega(clasif_bodega);
        this.nroCompra = nroCompra;
        this.articulos = articulos;
    }

    /*public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    } */

    public void addComprasArticulos(Compras_articulo compras_articulo){
        if(!getArticulos().contains(compras_articulo)){
            getArticulos().add(compras_articulo);
        }
    }

    public List<Compras_articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Compras_articulo> articulos) {
        this.articulos = articulos;
    }

    public Integer getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(Integer nroCompra) {
        this.nroCompra = nroCompra;
    }

    public Clasif_Bodega getClasif_bodega() {
        return clasif_bodega;
    }

    public void setClasif_bodega(Clasif_Bodega clasif_bodega) {
        this.clasif_bodega = clasif_bodega;
    }
}
