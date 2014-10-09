package com.bo.openlogics.sales.service;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by osanchez on 9/10/14.
 */
public interface ReportesService {
    public void reporteEtiquetasArticulo(HttpServletResponse response,String tipoReporte,String idArticulo,String formato);
}
