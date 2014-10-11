package com.bo.openlogics.sales.controller;


import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import com.bo.openlogics.sales.service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by json on 9/10/14.
 */

@Controller
public class SalesForceReportRESTController {

    @Autowired
    Clasif_ArticuloService clasif_articuloService;

    @Autowired
    ReportesService reporteService;

    /**
     * Servicio REST para obtener formulario de la declaracion de exportacion
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/etiqueta/articulo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getReporteArticulo(@PathVariable Long id) {
        JsonResult jsonResult;
        try {
            jsonResult = clasif_articuloService.getByIdArticuloReporte(id);
            return jsonResult;
        } catch (Exception e) {
            jsonResult = new JsonResult(false, e.getMessage(), null);
        }
        return jsonResult;
    }

    @RequestMapping(value = "reportes/{tipoReporte}/{idArticulo}", method = RequestMethod.GET)
    @ResponseBody public void reporteEtiquetaArticulo(HttpServletResponse response,@PathVariable String tipoReporte,@PathVariable String idArticulo){
        if (tipoReporte!=null) {
            reporteService.reporteEtiquetasArticulo(response, tipoReporte, idArticulo, "pdf");
        } else {
            try {
                // Status code (401) indicating that the request requires HTTP
                // authentication.
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Valor no valido");
                // response.sendRedirect("http://www.google.com");
                System.out.println("no se puede mostrar los datos no existe*********");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
