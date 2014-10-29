package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Articulo;


/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ArticuloService {
    public JsonResult save(Clasif_Articulo clasif_articulo);

    public JsonResult listadoArticulosHabilitados();

    public JsonResult listadoArticulos();

    public JsonResult editarArticulo(Clasif_Articulo clasif_articulo);

    public JsonResult desabilitarArticulo(Long IdArticulo);

    public JsonResult getById(Long IdArticulo) throws Exception;

    public JsonResult getByIdArticuloReporte(Long id);

    public JsonResult buscarArticuloBeanCompraByCodigoArticulo(String codigoArticulo) throws Exception;

    public JsonResult buscarArticuloEdit(Long idArticulo);




}
