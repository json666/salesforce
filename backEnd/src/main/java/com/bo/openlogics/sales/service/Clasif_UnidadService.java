package com.bo.openlogics.sales.service;

import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Unidad;


/**
 * Created by json on 7/09/14.
 */
public interface Clasif_UnidadService {
    public void save(Clasif_Unidad clasif_unidad);
    public JsonResult listadoUnidad();
}
