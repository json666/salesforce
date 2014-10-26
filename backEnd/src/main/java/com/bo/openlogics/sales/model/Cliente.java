package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by osanchez on 24/10/14.
 */

@Entity
@Table(name = "CLIENTE", schema = "SALESFORCE")
public class Cliente extends EntidadBase {

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PATERNO")
    private String paterno;

    @Column(name = "MATERNO")
    private String materno;

    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "NUMERO_DOCUMENTO")
    private String nroDocumento;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;


    public Cliente() {
    }

    public Cliente(String nombre, String paterno, String materno, String razonSocial, String nroDocumento, String direccion) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.razonSocial = razonSocial;
        this.nroDocumento = nroDocumento;
        this.direccion = direccion;
    }

    public Cliente(String nombre, String paterno, String materno, String razonSocial, String nroDocumento, String direccion, Date fechaDesde, Date fechaHasta) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.razonSocial = razonSocial;
        this.nroDocumento = nroDocumento;
        this.direccion = direccion;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPateno(String pateno) {
        this.paterno = pateno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
}
