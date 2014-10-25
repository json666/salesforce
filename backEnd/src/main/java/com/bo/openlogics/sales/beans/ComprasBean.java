package com.bo.openlogics.sales.beans;

import com.bo.openlogics.sales.beans.parametricas.BodegaBean;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Bodega;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by json on 25/10/14.
 */
public class ComprasBean implements Serializable {


    private Integer nroCompra;


    private Integer cantidadExistente;


    private BodegaBean bodegaBean;


    private List<ArticuloBeanCompra> articuloBeanCompras;

    public ComprasBean() {
    }

    public ComprasBean(Integer nroCompra, Integer cantidadExistente, BodegaBean bodegaBean, List<ArticuloBeanCompra> articuloBeanCompras) {
        this.nroCompra = nroCompra;
        this.cantidadExistente = cantidadExistente;
        this.bodegaBean = bodegaBean;
        this.articuloBeanCompras = articuloBeanCompras;
    }

    public Integer getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(Integer nroCompra) {
        this.nroCompra = nroCompra;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
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
}
