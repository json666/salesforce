package com.bo.openlogics.sales.model;

import javax.persistence.*;
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
public class Compra extends EntidadBase{

    @OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
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
        this.clasif_bodega = clasif_bodega;
        this.nroCompra = nroCompra;
        this.articulos = articulos;
    }

    /*public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    } */

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
}
