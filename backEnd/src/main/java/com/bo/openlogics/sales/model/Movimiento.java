package com.bo.openlogics.sales.model;

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

    @ManyToOne
    private Detalle_Movimiento detalle_movimiento;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIMIENTOS_DETALLE_MOV", schema = "SALESFORCE",
            joinColumns = {@JoinColumn(name = "MOVIMIENTOS_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "DETALLE_MOVIMIENTO_ID", referencedColumnName = "id")})
    private List<Detalle_Movimiento> detalle_movimientos;

    public Movimiento(){

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
}
