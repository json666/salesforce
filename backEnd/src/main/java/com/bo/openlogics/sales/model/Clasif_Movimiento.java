package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 1/09/14
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_MOVIMIENTOS", schema = "SALESFORCE")
public class Clasif_Movimiento extends EntidadBase {

    @Column(name = "CLASIF_MOVIMIENTOS")
    private String clasifMovimientos ;

    @Column(name = "DESCRIPCION_MOVIMIENTO")
    private String descripcionMovimientos ;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde ;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;

    @Column(name = "USUARIO_ACT")
    private String usuarioActual;



    public Clasif_Movimiento(){

    }

    public Clasif_Movimiento(String clasifMovimientos, String descripcionMovimientos, Date fechaDesde, Date fechaHasta, String usuarioActual) {
        this.clasifMovimientos = clasifMovimientos;
        this.descripcionMovimientos = descripcionMovimientos;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioActual = usuarioActual;
    }

    public String getClasifMovimientos() {
        return clasifMovimientos;
    }

    public void setClasifMovimientos(String clasifMovimientos) {
        this.clasifMovimientos = clasifMovimientos;
    }

    public String getDescripcionMovimientos() {
        return descripcionMovimientos;
    }

    public void setDescripcionMovimientos(String descripcionMovimientos) {
        this.descripcionMovimientos = descripcionMovimientos;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
