package com.bo.openlogics.sales.model;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by json on 21/09/14.
 */
public class BodegaDetalleMovimientoPK implements Serializable {
    private Bodega_articulo bodega_articulo;

    private Movimiento movimiento;

    public BodegaDetalleMovimientoPK() {
    }

    //@ManyToOne
    public Bodega_articulo getBodega_articulo() {
        return bodega_articulo;
    }

    public void setBodega_articulo(Bodega_articulo bodega_articulo) {
        this.bodega_articulo = bodega_articulo;
    }
    //@ManyToOne
    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
}
