package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by json on 25/10/14.
 */
public class DetalleComprasArticuloPK implements Serializable{

    private Compras compras;

    private Clasif_Articulo clasif_articulo;


    @ManyToOne
    @JsonIgnore
    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
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

        DetalleComprasArticuloPK that = (DetalleComprasArticuloPK) o;

        if (compras !=null ? !compras.equals(that.compras) : that.compras !=null)
            return false;

        if (clasif_articulo != null ?
                !clasif_articulo.equals(that.clasif_articulo) : that.clasif_articulo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (compras !=null ? compras.hashCode() : 0);
        result = 31 * result + (clasif_articulo != null ? clasif_articulo.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "DetalleComprasArticuloPK{" +
                "compras=" + compras +
                ", clasif_articulo=" + clasif_articulo +
                '}';
    }
}
