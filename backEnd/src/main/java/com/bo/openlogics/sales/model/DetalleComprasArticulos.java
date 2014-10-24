package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by osanchez on 22/10/14.
 */


@Entity
@Table(name = "DETALLE_COMPRAS_ARTICULOS", schema = "SALESFORCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)

/*@AssociationOverrides({
        @AssociationOverride(name = "pk.compras", joinColumns = @JoinColumn(name = "compras_id")),
        @AssociationOverride(name = "pk.clasif_articulo", joinColumns = @JoinColumn(name = "clasif_articulo_id"))
})*/
//@IdClass(DetalleComprasArticulosPK.class)
public class DetalleComprasArticulos extends EntidadBase {



    /*@Column(name = "CANTIDAD_EXISTENTE")
    private Integer cantidadExistente;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;

    @OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    private Clasif_Bodega clasif_bodega;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "DETALLE_ARTICULOS", schema = "SALESFORCE",
            joinColumns = {@JoinColumn(name = "DETALLE_COMPRAS_ARTICULOS_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "CLASIF_ARTICULOS_ID", referencedColumnName = "id")})
    private List<Clasif_Articulo> clasif_articulos;

    public DetalleComprasArticulos() {
    }

    public DetalleComprasArticulos(Integer cantidadExistente, Date fechaRegistro, Clasif_Bodega clasif_bodega, List<Clasif_Articulo> clasif_articulos) {
        this.cantidadExistente = cantidadExistente;
        this.fechaRegistro = fechaRegistro;
        this.clasif_bodega = clasif_bodega;
        this.clasif_articulos = clasif_articulos;
    }

    public void addArticulos(Clasif_Articulo clasif_articulo){
        if (clasif_articulos == null) {
            clasif_articulos = new ArrayList<Clasif_Articulo>();
        }
        clasif_articulos.add(clasif_articulo);
    }


    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Clasif_Bodega getClasif_bodega() {
        return clasif_bodega;
    }

    public void setClasif_bodega(Clasif_Bodega clasif_bodega) {
        this.clasif_bodega = clasif_bodega;
    }

    public List<Clasif_Articulo> getClasif_articulos() {
        return clasif_articulos;
    }

    public void setClasif_articulos(List<Clasif_Articulo> clasif_articulos) {
        this.clasif_articulos = clasif_articulos;
    }   */
}
