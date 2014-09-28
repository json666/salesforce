package com.bo.openlogics.sales.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Bodega_articulo extends EntidadBase {

    /**
     * To do Adicionar Clasificador Bodega
     */

    @Column(name = "CANTIDAD")
    private String cantidad;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COSTO_TOTAL")
    private Double costoTotal;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.bodega_articulo", cascade = CascadeType.ALL)
    //@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    @JsonIgnore
    private List<BodegaDetalleMovimiento> bodegaDetalleMovimientos;



    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    @JoinTable(name = "BODEGA_CLASIF_ARTICULOS", schema = "SALESFORCE",
            joinColumns = {@JoinColumn(name = "BODEGA_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "CLASFARTICULO_ID", referencedColumnName = "id")})
    private List<Clasif_Articulo> clasif_articulos;*/

    @ManyToOne
    private Clasif_Articulo clasif_articulo;


    @Transient
    private Movimiento movimiento;

    @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    //@JoinColumn(name="CLASIF_BODEGA_ID")
    private Clasif_Bodega clasif_bodega;

    public Bodega_articulo() {}

    public Bodega_articulo(String cantidad, Double monto, Double costoTotal, List<BodegaDetalleMovimiento> bodegaDetalleMovimientos,
                           Clasif_Articulo clasif_articulo, Movimiento movimiento, Clasif_Bodega clasif_bodega) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.costoTotal = costoTotal;
        this.bodegaDetalleMovimientos = bodegaDetalleMovimientos;
        this.setClasif_articulo(clasif_articulo);
        this.movimiento = movimiento;
        this.clasif_bodega = clasif_bodega;
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
        System.out.println("MONTO:"+this.getMonto());
        System.out.println("ABDM 1");
        bodegaDetalleMovimiento.setCostoTotal(this.getCostoTotal());
        System.out.println("ABDM 2");
        bodegaDetalleMovimiento.setMonto(this.getMonto());
        System.out.println("ABDM 3");
        bodegaDetalleMovimiento.setCantidad(this.getCantidad());
        System.out.println("ABDM 4");
        this.getBodegaDetalleMovimientos().add(bodegaDetalleMovimiento);
        System.out.println("ABDM 5");

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

    public Clasif_Bodega getClasif_bodega() {
        return clasif_bodega;
    }

    public void setClasif_bodega(Clasif_Bodega clasif_bodega) {
        this.clasif_bodega = clasif_bodega;
    }

    public Clasif_Articulo getClasif_articulo() {
        return clasif_articulo;
    }

    public void setClasif_articulo(Clasif_Articulo clasif_articulo) {
        this.clasif_articulo = clasif_articulo;
    }
}
