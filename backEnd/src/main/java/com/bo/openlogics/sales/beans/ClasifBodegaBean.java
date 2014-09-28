package com.bo.openlogics.sales.beans;

import java.io.Serializable;

/**
 * Created by json on 27/09/14.
 */
public class ClasifBodegaBean implements Serializable {

    private Long id;

    private String descripcionBodega ;

    public ClasifBodegaBean(Long id, String descripcionBodega) {
        this.id = id;
        this.descripcionBodega = descripcionBodega;
    }

    public ClasifBodegaBean() {
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
