package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.ComprasBean;
import com.bo.openlogics.sales.beans.VentasBean;

/**
 * Created by osanchez on 28/10/14.
 */
public interface VentasService {

    public JsonResult adicionarVentas(VentasBean ventasBean);
}
