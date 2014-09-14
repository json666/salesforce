package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.Clasif_MarcaService;
import com.bo.openlogics.sales.service.Clasif_UnidadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by json on 14/09/14.
 */

@Controller
@Transactional
@RequestMapping(value = "/rest")
public class SalesForceParamRESTController {
    @Autowired
    Clasif_MarcaService clasif_marcaService;

    @Autowired
    Clasif_UnidadService clasif_unidadService;

    private Logger logger = Logger.getLogger(SalesForceParamRESTController.class);

    @RequestMapping(value = "/marcas_producto", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByMarcas() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_marcaService.listadoMarcas();
            if(jsonResult!=null){
                return jsonResult;
            }else{
                return jsonResult;
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/unidad_medida", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByUnidadMedida() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_unidadService.listadoUnidad();
            if(jsonResult!=null){
                return jsonResult;
            }else{
                return jsonResult;
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }
}

