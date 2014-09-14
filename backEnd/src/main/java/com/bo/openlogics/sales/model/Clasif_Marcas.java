package com.bo.openlogics.sales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by json on 2/09/14.
 */

@Entity
@Table(name = "CLASIF_MARCA", schema = "SALESFORCE_PARAM")
public class Clasif_Marcas extends EntidadBase {

    @Column(name = "SF_CODIGO", unique = true, nullable = false)
    private Long codigo;

    @Column(name = "SF_DESCRIPCION", length = 50, nullable = false)
    private String descripcion;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String toString() {
        return "codigo: " + this.codigo + " descripcion: " + this.descripcion;
    }
}
