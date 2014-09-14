package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 14/09/14.
 */
public class MarcaBean implements Serializable {


    private Long id;
    private String descripcionMarca;

    public MarcaBean() {
    }

    public MarcaBean(Long id, String descripcionMarca) {
        this.id = id;
        this.descripcionMarca = descripcionMarca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
    }
}
