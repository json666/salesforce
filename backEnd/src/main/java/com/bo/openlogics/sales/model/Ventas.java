package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by osanchez on 28/10/14.
 */


@Entity
@Table(name = "VENTAS", schema= "SALESFORCE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ventas extends EntidadBase implements Serializable {
    @Column(name = "NUMERO_VENTA")
    public Integer nroVenta;

    @Column(name = "FECHA_REGISTRO")
    public Date fechaRegistro;

    @Column(name = "PRECIO_VENTA")
    public Double precioVenta;

    @ManyToOne(fetch= FetchType.EAGER)
    private Clasif_Bodega clasif_bodega;

    @ManyToOne(fetch= FetchType.EAGER)
    private Cliente cliente;

    @Transient
    private List<Clasif_Articulo> clasif_articulos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.ventas", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<DetalleVentasArticulo> detalleVentasArticulos;

    public Ventas() {
    }


    public List<DetalleVentasArticulo> getDetalleVentasArticulos() {
        if (detalleVentasArticulos == null) {
            detalleVentasArticulos = new ArrayList<DetalleVentasArticulo>();
        }
        return detalleVentasArticulos;
    }

    public void setDetalleVentasArticulos(List<DetalleVentasArticulo> detalleVentasArticulos) {
        this.detalleVentasArticulos = detalleVentasArticulos;
    }

    @JsonIgnore
    public void addDetalleVentasArticulo(Clasif_Articulo clasif_articulo) {
        DetalleVentasArticulo detalleVentasArticulo = new DetalleVentasArticulo();
        detalleVentasArticulo.setVentas(this);
        detalleVentasArticulo.setClasif_articulo(clasif_articulo);
        detalleVentasArticulo.setCostoTotal(1000.0);
        detalleVentasArticulo.setCantidad(40);
        detalleVentasArticulo.setMonto(40.0);

        this.getDetalleVentasArticulos().add(detalleVentasArticulo);
    }

    public List<Clasif_Articulo> getClasif_articulos() {
        return clasif_articulos;
    }

    public void setClasif_articulos(List<Clasif_Articulo> clasif_articulos) {
        this.clasif_articulos = clasif_articulos;
    }

    public Clasif_Bodega getClasif_bodega() {
        return clasif_bodega;
    }

    public void setClasif_bodega(Clasif_Bodega clasif_bodega) {
        this.clasif_bodega = clasif_bodega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
