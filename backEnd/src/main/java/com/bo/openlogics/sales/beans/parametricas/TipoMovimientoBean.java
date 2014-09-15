package com.bo.openlogics.sales.beans.parametricas;

import java.io.Serializable;

/**
 * Created by json on 15/09/14.
 */
public class TipoMovimientoBean implements Serializable {

    private Long id;
    private String clasifMovimientos;
    private String descripcionMovimientos;

    public TipoMovimientoBean() {
    }

    public TipoMovimientoBean(Long id, String clasifMovimientos, String descripcionMovimientos) {
        this.id = id;
        this.clasifMovimientos = clasifMovimientos;
        this.descripcionMovimientos = descripcionMovimientos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasifMovimientos() {
        return clasifMovimientos;
    }

    public void setClasifMovimientos(String clasifMovimientos) {
        this.clasifMovimientos = clasifMovimientos;
    }

    public String getDescripcionMovimientos() {
        return descripcionMovimientos;
    }

    public void setDescripcionMovimientos(String descripcionMovimientos) {
        this.descripcionMovimientos = descripcionMovimientos;
    }
}
