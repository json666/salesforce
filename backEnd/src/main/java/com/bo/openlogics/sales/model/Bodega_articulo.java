package com.bo.openlogics.sales.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 8/09/14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "BODEGA_ARTICULO", schema = "SALESFORCE")
public class Bodega_articulo extends EntidadBase {

    /**
     * To do Adicionar Clasificador Bodega
     */
    @Column(name = "TIPO_BODEGA")
    private String tipoBodega;

    @Column(name = "DESCRIPCION_BODEGA")
    private String descripcionBodega;

    @Column(name = "CANTIDAD")
    private String cantidad;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COSTO_TOTAL")
    private Double costoTotal;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.bodega_articulo", cascade = CascadeType.ALL)
    //@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<BodegaDetalleMovimiento> bodegaDetalleMovimientos;

    @ManyToOne
    private Clasif_Articulo clasif_articulo;

    @Transient
    private Movimiento movimiento;


    public Bodega_articulo() {

    }

    public Bodega_articulo(String tipoBodega, String descripcionBodega, String cantidad, Double monto, Clasif_Articulo clasif_articulo) {
        this.tipoBodega = tipoBodega;
        this.descripcionBodega = descripcionBodega;
        this.cantidad = cantidad;
        this.monto = monto;
        this.clasif_articulo = clasif_articulo;

    }

    public Bodega_articulo(String tipoBodega, String descripcionBodega, String cantidad, Double monto, List<BodegaDetalleMovimiento> bodegaDetalleMovimientos, Clasif_Articulo clasif_articulo, Movimiento movimiento) {
        this.tipoBodega = tipoBodega;
        this.descripcionBodega = descripcionBodega;
        this.cantidad = cantidad;
        this.monto = monto;
        this.bodegaDetalleMovimientos = bodegaDetalleMovimientos;
        this.clasif_articulo = clasif_articulo;
        this.movimiento = movimiento;
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

    public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    }


    public String getTipoBodega() {
        return tipoBodega;
    }

    public void setTipoBodega(String tipoBodega) {
        this.tipoBodega = tipoBodega;
    }

    public String getDescripcionBodega() {
        return descripcionBodega;
    }

    public void setDescripcionBodega(String descripcionBodega) {
        this.descripcionBodega = descripcionBodega;
    }

    public List<BodegaDetalleMovimiento> getBodegaDetalleMovimientos() {
        if (bodegaDetalleMovimientos == null) {
            bodegaDetalleMovimientos = new ArrayList<BodegaDetalleMovimiento>();
        }

        return bodegaDetalleMovimientos;
    }

    public void setBodegaDetalleMovimientos(List<BodegaDetalleMovimiento> bodegaDetalleMovimientos) {
        this.bodegaDetalleMovimientos = bodegaDetalleMovimientos;
    }

    public void addBodegaDetalleMovimiento(Movimiento movimiento) {
        BodegaDetalleMovimiento bodegaDetalleMovimiento = new BodegaDetalleMovimiento();
        bodegaDetalleMovimiento.setBodega_articulo(this);
        bodegaDetalleMovimiento.setMovimiento(movimiento);
        bodegaDetalleMovimiento.setCostoTotal(this.getCostoTotal());
        bodegaDetalleMovimiento.setMonto(this.getMonto());
        bodegaDetalleMovimiento.setCantidad(this.getCantidad());
        this.getBodegaDetalleMovimientos().add(bodegaDetalleMovimiento);

    }


    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
