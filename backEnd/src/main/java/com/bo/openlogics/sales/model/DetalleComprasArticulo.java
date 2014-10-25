package com.bo.openlogics.sales.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by json on 25/10/14.
 */


@Entity
@Table(name = "DETALLE_COMPRAS_ARTICULO", schema = "SALESFORCE")
@AssociationOverrides({
        @AssociationOverride(name ="pk.compras", joinColumns = @JoinColumn(name ="compras_id")),
        @AssociationOverride(name ="pk.clasif_articulo", joinColumns = @JoinColumn(name ="clasif_articulo_id"))
})
public class DetalleComprasArticulo implements Serializable {

    @Column(name="CANTIDAD_EXISTENTE")
    private Integer cantidadExistente;



    private DetalleComprasArticuloPK pk = new DetalleComprasArticuloPK();



    public DetalleComprasArticulo() {
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    @EmbeddedId
    public DetalleComprasArticuloPK getPk() {
        return pk;
    }

    public void setPk(DetalleComprasArticuloPK pk) {
        this.pk = pk;
    }

    @Transient
    public Compras getCompras() {
        return getPk().getCompras();
    }

    public void setCompras(Compras compras) {
        getPk().setCompras(compras);
    }

    @Transient
    public Clasif_Articulo getClasif_articulo() {
        return getPk().getClasif_articulo();
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        getPk().setClasif_articulo(clasif_articulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        DetalleComprasArticulo that = (DetalleComprasArticulo) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public String toString() {
        return "DetalleComprasArticulo{" +
                "cantidadExistente=" + cantidadExistente +
                ", pk=" + pk +
                '}';
    }
}
