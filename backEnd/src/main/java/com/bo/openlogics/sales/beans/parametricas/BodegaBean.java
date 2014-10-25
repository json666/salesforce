package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 25/10/14.
 */
public class BodegaBean implements Serializable{

    private Long id;

    private String descripcionBodega ;

    public BodegaBean() {
    }

    public BodegaBean(Long id, String descripcionBodega) {
        this.setId(id);
        this.setDescripcionBodega(descripcionBodega);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionBodega() {
        return descripcionBodega;
    }

    public void setDescripcionBodega(String descripcionBodega) {
        this.descripcionBodega = descripcionBodega;
    }
}
