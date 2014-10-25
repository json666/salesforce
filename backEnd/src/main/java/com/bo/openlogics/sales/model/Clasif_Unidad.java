package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 4/09/14
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name = "CLASIF_UNIDADES", schema = "SALESFORCE")
public class Clasif_Unidad extends EntidadBase
{
    /*@Column(name = "CODIGO_UNIDAD")
    private String codigoUnidad;*/

    @Column(name = "DESCRIPCION_UNIDAD")
    private String descripcionUnidad;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta;

    @Column(name = "USUARIO_ACT")
    private String usuarioAct;

    public Clasif_Unidad(){}

    public Clasif_Unidad(String descripcionUnidad, Date fechaDesde, Date fechaHasta, String usuarioAct) {
        this.descripcionUnidad = descripcionUnidad;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
    }

    public String getDescripcionUnidad() {
        return descripcionUnidad;
    }

    public void setDescripcionUnidad(String descripcionUnidad) {
        this.descripcionUnidad = descripcionUnidad;
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


}
