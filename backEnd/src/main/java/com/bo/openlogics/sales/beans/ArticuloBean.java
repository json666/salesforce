package com.bo.openlogics.sales.beans;

import com.bo.openlogics.sales.beans.parametricas.CategoriaBean;
import com.bo.openlogics.sales.beans.parametricas.ClaseBean;
import com.bo.openlogics.sales.beans.parametricas.MarcaBean;
import com.bo.openlogics.sales.beans.parametricas.UnidadBean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by json on 16/09/14.
 */
public class ArticuloBean implements Serializable {

    private Long id;

    private String descripcionArticulo ;


    private String codigoArticulo ;

    private String nombreArticulo ;


    private Double margenGanancia;


    private Double precio ;


    private Double precioCosto ;


    private byte[] upc ;


    private int nivelReorden ;


    private int cantidadReorden ;




    private byte[] fotografia ;


    private Date fechaDesde;


    private Date fechaHasta ;


    private String usuarioAct ;

    private ClaseBean claseBean;

    private MarcaBean marcaBean;

    private CategoriaBean categoriaBean;

    private UnidadBean unidadBean;

    public ArticuloBean() {}

    public ArticuloBean(Long id, String descripcionArticulo, String codigoArticulo, String nombreArticulo, Double margenGanancia, Double precio, Double precioCosto, byte[] upc, int nivelReorden, int cantidadReorden,byte[] fotografia, Date fechaDesde, Date fechaHasta, String usuarioAct, ClaseBean claseBean, MarcaBean marcaBean, CategoriaBean categoriaBean, UnidadBean unidadBean) {
        this.id = id;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.setMargenGanancia(margenGanancia);
        this.precio = precio;
        this.precioCosto = precioCosto;
        this.upc = upc;
        this.nivelReorden = nivelReorden;
        this.cantidadReorden = cantidadReorden;
        this.fotografia = fotografia;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
        this.claseBean = claseBean;
        this.marcaBean = marcaBean;
        this.categoriaBean = categoriaBean;
        this.unidadBean = unidadBean;
    }

    public ArticuloBean(Long id, String descripcionArticulo, String codigoArticulo,
                        Double margenGanancia, Double precio, Double precioCosto,
                        byte[] upc, int nivelReorden, int cantidadReorden,
                        byte[] fotografia, Date fechaDesde,
                        Date fechaHasta, String usuarioAct, ClaseBean claseBean,
                        MarcaBean marcaBean, CategoriaBean categoriaBean, UnidadBean unidadBean) {
        this.id = id;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.setMargenGanancia(margenGanancia);
        this.precio = precio;
        this.precioCosto = precioCosto;
        this.upc = upc;
        this.nivelReorden = nivelReorden;
        this.cantidadReorden = cantidadReorden;
        this.fotografia = fotografia;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
        this.claseBean = claseBean;
        this.marcaBean = marcaBean;
        this.categoriaBean = categoriaBean;
        this.unidadBean = unidadBean;
    }

    public ArticuloBean(Long id, String descripcionArticulo, String codigoArticulo,
                        Double margenGanancia, Double precio, Double precioCosto,
                        byte[] upc, int nivelReorden, int cantidadReorden,
                        byte[] fotografia, Date fechaDesde,
                        Date fechaHasta, String usuarioAct, ClaseBean claseBean) {
        this.id = id;
        this.descripcionArticulo = descripcionArticulo;
        this.codigoArticulo = codigoArticulo;
        this.setMargenGanancia(margenGanancia);
        this.precio = precio;
        this.precioCosto = precioCosto;
        this.upc = upc;
        this.nivelReorden = nivelReorden;
        this.cantidadReorden = cantidadReorden;
        this.fotografia = fotografia;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.usuarioAct = usuarioAct;
        this.claseBean = claseBean;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
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

    public byte[] getUpc() {
        return upc;
    }

    public void setUpc(byte[] upc) {
        this.upc = upc;
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


    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
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

    public ClaseBean getClaseBean() {
        return claseBean;
    }

    public void setClaseBean(ClaseBean claseBean) {
        this.claseBean = claseBean;
    }

    public MarcaBean getMarcaBean() {
        return marcaBean;
    }

    public void setMarcaBean(MarcaBean marcaBean) {
        this.marcaBean = marcaBean;
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public UnidadBean getUnidadBean() {
        return unidadBean;
    }

    public void setUnidadBean(UnidadBean unidadBean) {
        this.unidadBean = unidadBean;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public Double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(Double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }
}
