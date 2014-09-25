package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by osanchez on 25/09/14.
 */

@Entity
@Table(name = "CLASIF_BODEGA", schema = "SALESFORCE")
public class Clasif_Bodega  extends EntidadBase{

    @Column(name = "TIPO_BODEGA")
    private String tipoBodega ;

    @Column(name = "DESCRIPCION_BODEGA")
    private String descripcionBodega ;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;

    @Column(name = "USUARIOA_ACT")
    private String usuarioAct ;

    public Clasif_Bodega(String tipoBodega, String descripcionBodega, Date fechaDesde, Date fechaHasta, String usuarioAct) {
        this.tipoBodega = tipoBodega;
        this.descripcionBodega = descripcionBodega;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
    }

    public Clasif_Bodega() {
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
