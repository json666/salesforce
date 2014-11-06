package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;

/**
 * Created by osanchez on 6/11/14.
 */
public interface AlmacenService {
    public JsonResult listadoBodega(Long idBodega);

    public JsonResult articuloStock(Long idBodega, String codArticulo);
}
