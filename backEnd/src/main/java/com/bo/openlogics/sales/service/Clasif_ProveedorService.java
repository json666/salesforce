package com.bo.openlogics.sales.service;

import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Proveedor;


/**
 * Created by json on 14/09/14.
 */
public interface Clasif_ProveedorService {
    public JsonResult save(Clasif_Proveedor clasif_proveedor);

    public JsonResult listadoProveedores();

    public JsonResult listadoProveedoresHabilitados();

}
