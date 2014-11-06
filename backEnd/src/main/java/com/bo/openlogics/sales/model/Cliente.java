package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by osanchez on 24/10/14.
 */

@Entity
@Table(name = "CLIENTE", schema = "SALESFORCE")
public class Cliente extends EntidadBase {

    @Column(name = "NOMBRE_COMERCIAL")
    private String nombreComercial;

    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "NUMERO_DOCUMENTO")
    private String nroDocumento;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "NUMERO_TELEFONO")
    private String nroTelefono;

    @Column(name = "NUMERO_CELULAR")
    private String nroCelular;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "CIUDAD")
    public String ciudad;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;


    public Cliente() {
    }

    public Cliente(String nombreComercial, String razonSocial, String nroDocumento, String direccion, String nroTelefono, String nroCelular, String correo, String ciudad, Date fechaDesde, Date fechaHasta) {
        this.nombreComercial = nombreComercial;
        this.razonSocial = razonSocial;
        this.nroDocumento = nroDocumento;
        this.direccion = direccion;
        this.nroTelefono = nroTelefono;
        this.nroCelular = nroCelular;
        this.correo = correo;
        this.ciudad = ciudad;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
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

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
}
