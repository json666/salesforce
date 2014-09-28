package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.Clasif_Marca;
import com.bo.openlogics.sales.model.JsonResult;

import java.util.List;

/**
 * Created by json on 7/09/14.
 */
public interface Clasif_MarcaService {
    public JsonResult  saveMarca(Clasif_Marca clasif_marca);
    public JsonResult listadoMarcas();
}
