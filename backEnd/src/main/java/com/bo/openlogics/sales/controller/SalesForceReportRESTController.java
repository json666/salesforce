package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by json on 9/10/14.
 */

@Controller
public class SalesForceReportRESTController {

    @Autowired
    Clasif_ArticuloService clasif_articuloService;

    /**
     * Servicio REST para obtener formulario de la declaracion de exportacion
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/etiqueta/articulo/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
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
}
