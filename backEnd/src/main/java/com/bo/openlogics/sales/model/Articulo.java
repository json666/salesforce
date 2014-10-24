package com.bo.openlogics.sales.model;

import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 23/10/14
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "ARTICULOS", schema = "SALESFORCE")
public class Articulo extends EntidadBase {

    @Column(name = "NOMBRE_ARTICULO")
    private String nombreArticulo ;

    @Column(name = "DESCRIPCION_ARTICULO")
    private String descripcionArticulo ;

    @Column(name = "CODIGO_ARTICULO")
    private String codigoArticulo ;

    @Transient
    @OneToMany(mappedBy="articulo")
    private List<Compras_articulo> compras;

    public Articulo(){}

    public Articulo(String nombreArticulo, String descripcionArticulo, String codigoArticulo, List<Compras_articulo> compras) {
        this.nombreArticulo = nombreArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.compras = compras;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public List<Compras_articulo> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras_articulo> compras) {
        this.compras = compras;
    }
}
