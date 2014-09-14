package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 5/09/14
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_CLASES", schema = "SALESFORCE")
public class Clasif_Clase extends EntidadBase {

    @Column(name = "DESCRIPCION_CLASE")
    private String descripcionClase ;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;

    @Column(name = "USUARIOA_ACT")
    private String usuarioAct ;

    @ManyToOne
    private Clasif_Categoria clasif_categoria;

    private Clasif_Clase (){

    }

    public Clasif_Clase(String descripcionClase, Date fechaDesde, Date fechaHasta, String usuarioAct, Clasif_Categoria clasif_categoria) {
        this.descripcionClase = descripcionClase;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
        this.clasif_categoria = clasif_categoria;
    }

    public String getDescripcionClase() {
        return descripcionClase;
    }

    public void setDescripcionClase(String descripcionClase) {
        this.descripcionClase = descripcionClase;
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

    public String getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(String usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Clasif_Categoria getClasif_categoria() {
        return clasif_categoria;
    }

    public void setClasif_categoria(Clasif_Categoria clasif_categoria) {
        this.clasif_categoria = clasif_categoria;
    }
}
