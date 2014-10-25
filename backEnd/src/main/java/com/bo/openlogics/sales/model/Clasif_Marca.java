package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 4/09/14
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_MARCAS", schema = "SALESFORCE")
public class Clasif_Marca extends EntidadBase{

    /*@Column(name = "CODIGO_MARCA")
    private String codigoMarca;*/

    @Column(name = "DESCRIPCION_MARCA")
    private String descripcionMarca;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta;

    @Column(name = "USUARIO_ACT")
    private String usuarioAct;

    public Clasif_Marca(){}

    public Clasif_Marca(String descripcionMarca, Date fechaDesde, Date fechaHasta, String usuarioAct) {
        this.descripcionMarca = descripcionMarca;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
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
