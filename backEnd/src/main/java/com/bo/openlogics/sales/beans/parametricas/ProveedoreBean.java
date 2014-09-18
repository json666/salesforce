package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 18/09/14.
 */
public class ProveedoreBean implements Serializable {
    private Long id;
    private String nombre;
    private String numeroDocumento;

    public ProveedoreBean(String nombre, String numeroDocumento, Long id) {
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.id = id;
    }

    public ProveedoreBean() {
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
