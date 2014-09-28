package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.Clasif_Bodega;
import com.bo.openlogics.sales.model.JsonResult;

/**
 * Created by osanchez on 25/09/14.
 */
public interface Clasif_BodegaService {
    public JsonResult saveClasifBodega(Clasif_Bodega clasif_bodega);
    public JsonResult listadoClasifBodega();
    public JsonResult getClasif_Bodega();
}
