package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Marca;

/**
 * Created by json on 7/09/14.
 */
public interface Clasif_MarcaService {
    public JsonResult saveMarca(Clasif_Marca clasif_marca);
    public JsonResult listadoMarcas();
}
