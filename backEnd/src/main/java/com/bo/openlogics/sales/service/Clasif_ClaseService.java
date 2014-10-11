package com.bo.openlogics.sales.service;

import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Clase;


/**
 * Created by json on 15/09/14.
 */
public interface Clasif_ClaseService {

    public JsonResult listadoClase(Long idCategoria);

    public JsonResult saveClase(Clasif_Clase clasif_clase);


}
