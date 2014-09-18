package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 18/09/14.
 */
public class ArticuloHabilitadoBean implements Serializable {
    private Long id;
    private String descripcionArticulo;

    public ArticuloHabilitadoBean() {
    }

    public ArticuloHabilitadoBean(Long id, String descripcionArticulo) {
        this.id = id;
        this.descripcionArticulo = descripcionArticulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }
}
