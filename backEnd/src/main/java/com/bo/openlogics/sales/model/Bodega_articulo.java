package com.bo.openlogics.sales.model;

import javax.persistence.*;
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
public class Bodega_articulo extends EntidadBase{

    /**
     * To do Adicionar Clasificador Bodega
     */
    @Column(name = "TIPO_BODEGA")
    private String tipoBodega ;

    @Column(name = "DESCRIPCION_BODEGA")
    private String descripcionBodega ;

    @Column(name = "CANTIDAD")
    private String cantidad ;

    @Column(name = "MONTO")
    private  Double monto ;

    @ManyToOne
    private Clasif_Articulo clasif_articulo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "BODEGA_ART_DETALLE_MOV", schema = "SALESFORCE",
            joinColumns = {@JoinColumn(name = "BODEGA_ART_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "DETALLE_MOV_ID", referencedColumnName = "id")})
    private List<Detalle_Movimiento> detalle_movimientos;

    private Bodega_articulo(){

    }

    public Bodega_articulo(String tipoBodega, String descripcionBodega, String cantidad, Double monto, Clasif_Articulo clasif_articulo, List<Detalle_Movimiento> detalle_movimientos) {
        this.tipoBodega = tipoBodega;
        this.descripcionBodega = descripcionBodega;
        this.cantidad = cantidad;
        this.monto = monto;
        this.clasif_articulo = clasif_articulo;
        this.detalle_movimientos = detalle_movimientos;
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

    public List<Detalle_Movimiento> getDetalle_movimientos() {
        return detalle_movimientos;
    }

    public void setDetalle_movimientos(List<Detalle_Movimiento> detalle_movimientos) {
        this.detalle_movimientos = detalle_movimientos;
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
}
