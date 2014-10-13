package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Categoria;


/**
 * Created by json on 12/09/14.
 */
public interface Clasif_CategoriaService {

    public JsonResult save(Clasif_Categoria clasif_categoria);

    public JsonResult listadoCategoria();
}
