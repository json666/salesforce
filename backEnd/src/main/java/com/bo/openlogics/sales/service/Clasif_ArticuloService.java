package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.JsonResult;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ArticuloService {
    public void save(Clasif_Articulo clasif_articulo);

    public JsonResult listadoArticulosHabilitados();

    public JsonResult listadoArticulos();

    public JsonResult editarArticulo(Clasif_Articulo clasif_articulo);

    public JsonResult desabilitarArticulo(Long IdArticulo);

    public JsonResult getById(Long IdArticulo) throws Exception;

}
