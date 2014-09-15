package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.Clasif_CategoriaService;
import com.bo.openlogics.sales.service.Clasif_ClaseService;
import com.bo.openlogics.sales.service.Clasif_MarcaService;
import com.bo.openlogics.sales.service.Clasif_UnidadService;
import com.bo.openlogics.sales.service.impl.Clasif_ClaseServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    Clasif_CategoriaService clasif_categoriaService;

    @Autowired
    Clasif_ClaseService clasif_claseService;

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

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByCategoria() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_categoriaService.listadoCategoria();
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

    @RequestMapping(value = "/categoria/{idCategoria}/clase", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByClase(@PathVariable Long idCategoria) {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_claseService.listadoClase(idCategoria);
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

