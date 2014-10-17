package com.bo.openlogics.sales.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 17/10/14
 * Time: 9:30
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "ARTICULO_BODEGA", schema = "SALESFORCE")
public class Articulo_Bodega extends EntidadBase{

    @Column(name = "CANTIDAD_EXISTENTE")
    private String cantidadExistente;

    @ManyToOne
    private Clasif_Articulo clasif_articulo;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "BODEGA_ARTICULOLIST", schema = "SALESFORCE", joinColumns = @JoinColumn(name = "BODEGA_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ARTICULO_ID", referencedColumnName = "ID"))
    private List<Clasif_Articulo> clasif_articulos;

    public Articulo_Bodega(){}

    public Articulo_Bodega(String cantidadExistente, Clasif_Articulo clasif_articulo, List<Clasif_Articulo> clasif_articulos) {
        this.cantidadExistente = cantidadExistente;
        this.clasif_articulo = clasif_articulo;
        this.clasif_articulos = clasif_articulos;
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

    public List<Clasif_Articulo> getClasif_articulos() {
        return clasif_articulos;
    }

    public void setClasif_articulos(List<Clasif_Articulo> clasif_articulos) {
        this.clasif_articulos = clasif_articulos;
    }
}
