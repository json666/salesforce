package com.bo.openlogics.sales.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 1/09/14
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MOVIMIENTOS", schema = "SALESFORCE")


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movimiento extends EntidadBase{

    @Column(name = "FECHA")
    private Date fecha ;

    @Column(name = "EXPERIENCIA")
    private String experiencia ;

    @Column(name = "ESTADO")
    private String estado ;

    @Column(name = "OBSERVACIONES")
    private String observacines ;

    @Column(name = "FECHA_ACT")
    private Date fechaAct ;

    @ManyToOne
    private Clasif_Movimiento clasif_movimiento;

    @ManyToOne
    private Clasif_Proveedor clasif_proveedor;





    public Movimiento(){

    }

    public Movimiento(Date fecha, String experiencia, String estado, String observacines, Date fechaAct, Clasif_Movimiento clasif_movimiento, Clasif_Proveedor clasif_proveedor) {
        this.fecha = fecha;
        this.experiencia = experiencia;
        this.estado = estado;
        this.observacines = observacines;
        this.fechaAct = fechaAct;
        this.clasif_movimiento = clasif_movimiento;
        this.clasif_proveedor = clasif_proveedor;
    }

    public Movimiento(Date fecha, String experiencia, String estado, String observacines, Date fechaAct) {
        this.fecha = fecha;
        this.experiencia = experiencia;
        this.estado = estado;
        this.observacines = observacines;
        this.fechaAct = fechaAct;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacines() {
        return observacines;
    }

    public void setObservacines(String observacines) {
        this.observacines = observacines;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public Clasif_Movimiento getClasif_movimiento() {
        return clasif_movimiento;
    }

    public void setClasif_movimiento(Clasif_Movimiento clasif_movimiento) {
        this.clasif_movimiento = clasif_movimiento;
    }

    public Clasif_Proveedor getClasif_proveedor() {
        return clasif_proveedor;
    }

    public void setClasif_proveedor(Clasif_Proveedor clasif_proveedor) {
        this.clasif_proveedor = clasif_proveedor;
    }
}
