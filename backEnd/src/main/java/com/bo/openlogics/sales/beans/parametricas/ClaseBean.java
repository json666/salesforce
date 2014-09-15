package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 15/09/14.
 */
public class ClaseBean implements Serializable {

    private Long id;
    private String descripcionClase;

    public ClaseBean() {
    }

    public ClaseBean(Long id, String descripcionClase) {
        this.id = id;
        this.descripcionClase = descripcionClase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionClase() {
        return descripcionClase;
    }

    public void setDescripcionClase(String descripcionClase) {
        this.descripcionClase = descripcionClase;
    }
}
