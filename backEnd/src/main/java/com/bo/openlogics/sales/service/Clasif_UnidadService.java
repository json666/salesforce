package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.model.JsonResult;

/**
 * Created by json on 7/09/14.
 */
public interface Clasif_UnidadService {
    public void save(Clasif_Unidad clasif_unidad);
    public JsonResult listadoUnidad();
}
