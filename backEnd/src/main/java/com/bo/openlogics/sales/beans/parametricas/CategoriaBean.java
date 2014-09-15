package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 15/09/14.
 */
public class CategoriaBean implements Serializable {

    private Long id;
    private String descripcionCategoria;

    public CategoriaBean() {
    }

    public CategoriaBean(Long id, String descripcionCategoria) {
        this.id = id;
        this.descripcionCategoria = descripcionCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}
