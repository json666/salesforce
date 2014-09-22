package com.bo.openlogics.sales.model;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by json on 21/09/14.
 */


@Entity
@Table(name = "BODEGA_DETALLE_MOVIMIENTO", schema = "SALESFORCE")
@AssociationOverrides({
        @AssociationOverride(name ="pk.bodega_articulo",
                joinColumns = @JoinColumn(name ="bodega_articulo_id")),
        @AssociationOverride(name ="pk.movimiento",
                joinColumns = @JoinColumn(name ="movimiento_id"))
})
public class BodegaDetalleMovimiento implements Serializable{

    @Column(name = "CANTIDAD")
    private String cantidad;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COSTO_TOTAL")
    private Double costoTotal;

    private BodegaDetalleMovimientoPK pk = new BodegaDetalleMovimientoPK();

    public BodegaDetalleMovimiento(){}

    @EmbeddedId
    public BodegaDetalleMovimientoPK getPk() {
        return pk;
    }

    public void setPk(BodegaDetalleMovimientoPK pk) {
        this.pk = pk;
    }

    @Transient
    public Bodega_articulo getBodega_articulo() {
        return getPk().getBodega_articulo();
    }

    public void setBodega_articulo(Bodega_articulo bodega_articulo) {
        getPk().setBodega_articulo(bodega_articulo);
    }

    @Transient
    public Movimiento getMovimiento() {
        return getPk().getMovimiento();
    }

    public void setMovimiento(Movimiento movimiento) {
        getPk().setMovimiento(movimiento);
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
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

    @Override
    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        BodegaDetalleMovimiento that = (BodegaDetalleMovimiento) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
