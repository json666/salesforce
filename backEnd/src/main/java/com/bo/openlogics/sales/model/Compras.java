package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by osanchez on 22/10/14.
 */

@Entity
@Table(name = "COMPRAS", schema = "SALESFORCE")

@JsonIgnoreProperties(ignoreUnknown = true)
public class Compras  extends EntidadBase {
/*

    @Column(name="NRO_COMPRA")
    private Integer nroCompra;

    public Compras() {
    }


    @ManyToOne
    public Clasif_Bodega clasif_bodega;

    @Transient
    private List<Clasif_Articulo> clasif_articulos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.compras", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<DetalleComprasArticulos> detalleComprasArticulos;

    @JsonCreator
    public static Compras ToObject(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Compras compras = null;
        try {
            compras = mapper.readValue(jsonString, Compras.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return compras;
    }

    public List<Clasif_Articulo> getClasif_articulos() {
        if (clasif_articulos == null)
            clasif_articulos = new ArrayList<Clasif_Articulo>();

        return clasif_articulos;
    }

    public void setClasif_articulos(List<Clasif_Articulo> clasif_articulos) {
        this.clasif_articulos = clasif_articulos;
    }

    public void addClasif_Articulo(Clasif_Articulo clasif_Articulo) {
        if (!getClasif_articulos().contains(clasif_Articulo)) {
            getClasif_articulos().add(clasif_Articulo);
        }
    }




    public List<DetalleComprasArticulos> getDetalleComprasArticulos() {
        if (detalleComprasArticulos == null) {
            detalleComprasArticulos = new ArrayList<DetalleComprasArticulos>();
        }

        return detalleComprasArticulos;
    }

    public void setDetalleComprasArticulos(List<DetalleComprasArticulos> detalleComprasArticulos) {
        this.detalleComprasArticulos = detalleComprasArticulos;
    }

    public void addDetalleComprasArticulos(Clasif_Articulo clasif_articulo) {
        DetalleComprasArticulos detalleComprasArticulos = new DetalleComprasArticulos();
        detalleComprasArticulos.setCompras(this);
        detalleComprasArticulos.setClasif_Articulo(clasif_articulo);

        detalleComprasArticulos.setCantidadExistente(100);
        detalleComprasArticulos.setFechaRegistro(new Date());


        this.getDetalleComprasArticulos().add(detalleComprasArticulos);
    }

    public Integer getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(Integer nroCompra) {
        this.nroCompra = nroCompra;
    }
    */
}
