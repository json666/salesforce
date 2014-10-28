package com.bo.openlogics.sales.beans;

import com.bo.openlogics.sales.beans.parametricas.BodegaBean;
import com.bo.openlogics.sales.beans.parametricas.ProveedoreBean;
import com.bo.openlogics.sales.model.Cliente;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by osanchez on 28/10/14.
 */
public class VentasBean implements Serializable {


    private Integer nroVenta;

    private BodegaBean bodegaBean;

    private Double precioVenta;

    private Date fechaRegistro;

    private Cliente cliente;

    private List<ArticuloBeanVenta> articuloBeanVentas;

    public VentasBean() {
    }

    public VentasBean(Integer nroVenta, BodegaBean bodegaBean, Double precioVenta, Date fechaRegistro, Cliente cliente, List<ArticuloBeanVenta> articuloBeanVentas) {
        this.nroVenta = nroVenta;
        this.bodegaBean = bodegaBean;
        this.precioVenta = precioVenta;
        this.fechaRegistro = fechaRegistro;
        this.cliente = cliente;
        this.articuloBeanVentas = articuloBeanVentas;
    }

    public Integer getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(Integer nroVenta) {
        this.nroVenta = nroVenta;
    }

    public BodegaBean getBodegaBean() {
        return bodegaBean;
    }

    public void setBodegaBean(BodegaBean bodegaBean) {
        this.bodegaBean = bodegaBean;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ArticuloBeanVenta> getArticuloBeanVentas() {
        return articuloBeanVentas;
    }

    public void setArticuloBeanVentas(List<ArticuloBeanVenta> articuloBeanVentas) {
        this.articuloBeanVentas = articuloBeanVentas;
    }
}
