package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 3/09/14
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DETALLE_MOVIMIENTOS", schema = "SALESFORCE")
public class Detalle_Movimiento extends EntidadBase {

    @Column(name = "CANTIDAD")
    private String cantida;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COSTO_TOTAL")
    private Double costoTotal;


    private Detalle_Movimiento(){

    }

    public Detalle_Movimiento(String cantida, Double monto, Double costoTotal) {
        this.cantida = cantida;
        this.monto = monto;
        this.costoTotal = costoTotal;
    }

    public String getCantida() {
        return cantida;
    }

    public void setCantida(String cantida) {
        this.cantida = cantida;
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
}
