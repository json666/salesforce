package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 5/09/14
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_CATEGORIAS", schema = "SALESFORCE")
public class Clasif_Categoria extends EntidadBase {

    @Column(name = "DESCRIPCION_CATEGORIA")
    private String descripcionCategoria ;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;

    @Column(name = "USUARIOA_ACT")
    private String usuarioAct ;

    public Clasif_Categoria(){

    }

    public Clasif_Categoria(String descripcionCategoria, Date fechaDesde, Date fechaHasta, String usuarioAct) {
        this.descripcionCategoria = descripcionCategoria;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
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
