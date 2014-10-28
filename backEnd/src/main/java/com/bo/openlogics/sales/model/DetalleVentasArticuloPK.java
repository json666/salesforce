package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by osanchez on 28/10/14.
 */
public class DetalleVentasArticuloPK implements Serializable{

    private Ventas ventas;

    private Clasif_Articulo clasif_articulo;

    @ManyToOne
    @JsonIgnore
    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @ManyToOne
    @JsonIgnore
    public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleVentasArticuloPK that = (DetalleVentasArticuloPK) o;

        if (ventas !=null ? !ventas.equals(that.ventas) : that.ventas !=null)
            return false;

        if (clasif_articulo != null ?
                !clasif_articulo.equals(that.clasif_articulo) : that.clasif_articulo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (ventas !=null ? ventas.hashCode() : 0);
        result = 31 * result + (clasif_articulo != null ? clasif_articulo.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "DetalleVentasArticuloPK{" +
                "ventas=" + ventas +
                ", clasif_articulo=" + clasif_articulo +
                '}';
    }
}
