package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 25/10/14.
 */

@Entity
@Table(name = "COMPRAS", schema= "SALESFORCE")

@JsonIgnoreProperties(ignoreUnknown = true)
public class Compras extends EntidadBase implements Serializable {

    @Column(name="NUMERO_COMPRA")
    private Integer nroCompra;

    @Column(name="CANTIDAD_EXISTENTE")
    private Integer cantidadExistente;

    @ManyToOne(fetch= FetchType.LAZY)
    private Clasif_Bodega clasif_bodega;

    @Transient
    private List<Clasif_Articulo> clasif_articulos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.compras", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<DetalleComprasArticulo> detalleComprasArticulos;

    public Compras() {
    }

    public Integer getNroCompra() {
        return nroCompra;
    }

    public void setNroCompra(Integer nroCompra) {
        this.nroCompra = nroCompra;
    }

    public List<DetalleComprasArticulo> getDetalleComprasArticulos() {
        if (detalleComprasArticulos == null) {
            detalleComprasArticulos = new ArrayList<DetalleComprasArticulo>();
        }
        return detalleComprasArticulos;
    }

    public void setDetalleComprasArticulos(List<DetalleComprasArticulo> detalleComprasArticulos) {
        this.detalleComprasArticulos = detalleComprasArticulos;
    }

    @JsonIgnore
    public void addDetalleComprasArticulo(Clasif_Articulo clasif_articulo) {
        DetalleComprasArticulo detalleComprasArticulo = new DetalleComprasArticulo();
        detalleComprasArticulo.setCompras(this);
        detalleComprasArticulo.setClasif_articulo(clasif_articulo);
        detalleComprasArticulo.setCantidadExistente(clasif_articulo.getCantidad());
        this.getDetalleComprasArticulos().add(detalleComprasArticulo);
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

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

    public Clasif_Bodega getClasif_bodega() {
        return clasif_bodega;
    }

    public void setClasif_bodega(Clasif_Bodega clasif_bodega) {
        this.clasif_bodega = clasif_bodega;
    }
}
