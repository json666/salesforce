package com.bo.openlogics.sales.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by osanchez on 28/10/14.
 */

@Entity
@Table(name = "DETALLE_VENTAS_ARTICULO", schema = "SALESFORCE")
@AssociationOverrides({
        @AssociationOverride(name ="pk.ventas", joinColumns = @JoinColumn(name ="ventas_id")),
        @AssociationOverride(name ="pk.clasif_articulo", joinColumns = @JoinColumn(name ="clasif_articulo_id"))
})
public class DetalleVentasArticulo implements Serializable {

    @Column(name="CANTIDAD")
    private Integer cantidad;

    @Column(name="MONTO")
    private Double monto;

    @Column(name="COSTO_TOTAL")
    private Double costoTotal;


    private DetalleVentasArticuloPK pk = new DetalleVentasArticuloPK();

    /*public Ventas ventas;

    public Clasif_Articulo clasif_articulo;*/

    public DetalleVentasArticulo() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @EmbeddedId
    public DetalleVentasArticuloPK getPk() {
        return pk;
    }


    public void setPk(DetalleVentasArticuloPK pk) {
        this.pk = pk;
    }

    @Transient
    public Ventas getVentas() {
        return getPk().getVentas();
    }

    public void setVentas(Ventas ventas) {
        getPk().setVentas(ventas);
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

        DetalleVentasArticulo that = (DetalleVentasArticulo) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public String toString() {
        return "DetalleVentasArticulo{" +
                "cantidad=" + cantidad +
                "monto=" + monto +
                "costoTotal=" + costoTotal +
                ", pk=" + pk +
                '}';
    }
}
