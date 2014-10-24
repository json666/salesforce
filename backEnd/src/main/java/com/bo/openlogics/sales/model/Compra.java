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

    @Column(name = "CANTIDAD_EXISTENTE")
    private String cantidadExistente;

    @ManyToOne
    private Clasif_Articulo clasif_articulo;

    @OneToMany(mappedBy="compra")
    private List<Compras_articulo> articulos;

    public Compra(){

    }

    public Compra(String cantidadExistente, Clasif_Articulo clasif_articulo, List<Compras_articulo> articulos) {
        this.cantidadExistente = cantidadExistente;
        this.clasif_articulo = clasif_articulo;
        this.articulos = articulos;
    }

    public String getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(String cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    }

    public List<Compras_articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Compras_articulo> articulos) {
        this.articulos = articulos;
    }
}
