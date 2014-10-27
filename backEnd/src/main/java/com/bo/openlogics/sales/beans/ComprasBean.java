package com.bo.openlogics.sales.beans;

import com.bo.openlogics.sales.beans.parametricas.BodegaBean;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Bodega;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by json on 25/10/14.
 */
public class ComprasBean implements Serializable {


    private Integer nroCompra;

    private BodegaBean bodegaBean;

    private Double precioCompra;

    private Date fechaRegistro;



    private List<ArticuloBeanCompra> articuloBeanCompras;

    public ComprasBean() {
    }



    public Integer getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(Integer nroCompra) {
        this.nroCompra = nroCompra;
    }

    public BodegaBean getBodegaBean() {
        return bodegaBean;
    }

    public void setBodegaBean(BodegaBean bodegaBean) {
        this.bodegaBean = bodegaBean;
    }

    public List<ArticuloBeanCompra> getArticuloBeanCompras() {
        return articuloBeanCompras;
    }

    public void setArticuloBeanCompras(List<ArticuloBeanCompra> articuloBeanCompras) {
        this.articuloBeanCompras = articuloBeanCompras;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
