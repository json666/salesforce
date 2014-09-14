package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 14/09/14.
 */
public class UnidadBean implements Serializable {
    private Long id;
    private String descripcionUnidad;

    public UnidadBean() {
    }

    public UnidadBean(Long id, String descripcionUnidad) {
        this.id = id;
        this.descripcionUnidad = descripcionUnidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionUnidad() {
        return descripcionUnidad;
    }

    public void setDescripcionUnidad(String descripcionUnidad) {
        this.descripcionUnidad = descripcionUnidad;
    }
}
