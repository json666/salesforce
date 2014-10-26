package com.bo.openlogics.sales.beans.parametricas;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by json on 26/10/14.
 */
public class ClienteBean implements Serializable {

    private Long id;

    private String nombre;

    private String paterno;

    private String razonSocial;

    private String nroDocumento;

    public ClienteBean() {
    }

    public ClienteBean(Long id, String nombre, String paterno, String razonSocial) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.razonSocial = razonSocial;
    }

    public ClienteBean(Long id, String nombre, String paterno, String razonSocial, String nroDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.razonSocial = razonSocial;
        this.nroDocumento = nroDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPaterno(String paterno) {
        this.paterno = paterno;
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
}
