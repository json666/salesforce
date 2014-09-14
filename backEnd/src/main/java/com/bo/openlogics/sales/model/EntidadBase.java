package com.bo.openlogics.sales.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: esalamanca
 * Date: 13-06-14
 * Time: 03:18 PM
 * Entidad extendida y heredada por todas las demas entidades.
 */

@MappedSuperclass
public abstract class EntidadBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "DESABILITADO")
    private boolean disabled;


    public EntidadBase(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
