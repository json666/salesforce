package com.bo.openlogics.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rloza
 * Date: 4/09/14
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CLASIF_ARTICULOS", schema = "SALESFORCE")

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clasif_Articulo extends EntidadBase {

    @Column(name = "NOMBRE_ARTICULO")
    private String nombreArticulo ;

    @Column(name = "DESCRIPCION_ARTICULO")
    private String descripcionArticulo ;

    @Column(name = "CODIGO_ARTICULO")
    private String codigoArticulo ;

    @Column(name = "MARGEN_GANANCIA")
    private Double margenGanancia;

    @Column(name = "PRECIO")
    private Double precio ;

    @Column(name = "PRECIO_COSTO")
    private Double precioCosto ;

    @Lob
    @Column(name = "UPC")
    private byte[] upc ;

    @Column(name = "NIVEL_REORDEN")
    private int nivelReorden ;

    @Column(name = "CANTIDAD_REORDEN")
    private int cantidadReorden ;

    @Column(name = "N_SERIE")
    private int nSerie ;
    @Lob
    @Column(name = "FOTOGRAFIA")
    private byte[] fotografia ;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta ;

    @Column(name = "USUARIOA_ACT")
    private String usuarioAct ;

    @ManyToOne
    private Clasif_Marca clasif_marca;

    @ManyToOne
    private Clasif_Unidad clasif_unidad;

    @ManyToOne
    private Clasif_Categoria clasif_categoria;

    @ManyToOne
    private Clasif_Clase clasif_clase;

    public Clasif_Articulo(){

    }

    public Clasif_Articulo(String nombreArticulo, String descripcionArticulo, String codigoArticulo, Double margenGanancia, Double precio, Double precioCosto, byte[] upc, int nivelReorden, int cantidadReorden, int nSerie, byte[] fotografia, Date fechaDesde, Date fechaHasta, String usuarioAct, Clasif_Marca clasif_marca, Clasif_Unidad clasif_unidad, Clasif_Categoria clasif_categoria, Clasif_Clase clasif_clase) {
        this.nombreArticulo = nombreArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.margenGanancia=margenGanancia;
        this.precio = precio;
        this.precioCosto = precioCosto;
        this.upc = upc;
        this.nivelReorden = nivelReorden;
        this.cantidadReorden = cantidadReorden;
        this.nSerie = nSerie;
        this.fotografia = fotografia;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
        this.clasif_marca = clasif_marca;
        this.clasif_unidad = clasif_unidad;
        this.clasif_categoria = clasif_categoria;
        this.clasif_clase = clasif_clase;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }



    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getNivelReorden() {
        return nivelReorden;
    }

    public void setNivelReorden(int nivelReorden) {
        this.nivelReorden = nivelReorden;
    }

    public int getCantidadReorden() {
        return cantidadReorden;
    }

    public void setCantidadReorden(int cantidadReorden) {
        this.cantidadReorden = cantidadReorden;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }



    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(String usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Clasif_Marca getClasif_marca() {
        return clasif_marca;
    }

    public void setClasif_marca(Clasif_Marca clasif_marca) {
        this.clasif_marca = clasif_marca;
    }

    public Clasif_Unidad getClasif_unidad() {
        return clasif_unidad;
    }

    public void setClasif_unidad(Clasif_Unidad clasif_unidad) {
        this.clasif_unidad = clasif_unidad;
    }

    public Clasif_Clase getClasif_clase() {
        return clasif_clase;
    }

    public void setClasif_clase(Clasif_Clase clasif_clase) {
        this.clasif_clase = clasif_clase;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public Clasif_Categoria getClasif_categoria() {
        return clasif_categoria;
    }

    public void setClasif_categoria(Clasif_Categoria clasif_categoria) {
        this.clasif_categoria = clasif_categoria;
    }

    public byte[] getUpc() {
        return upc;
    }

    public void setUpc(byte[] upc) {
        this.upc = upc;
    }

    public Double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(Double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }
}
