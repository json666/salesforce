package com.bo.openlogics.sales.controller;


import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Clasif_Bodega;
import com.bo.openlogics.sales.model.Clasif_Categoria;
import com.bo.openlogics.sales.model.Clasif_Clase;
import com.bo.openlogics.sales.model.Clasif_Marca;
import com.bo.openlogics.sales.service.*;
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
public class SalesForceParamRESTController {
    @Autowired
    Clasif_MarcaService clasif_marcaService;

    @Autowired
    Clasif_UnidadService clasif_unidadService;

    @Autowired
    Clasif_CategoriaService clasif_categoriaService;

    @Autowired
    Clasif_ClaseService clasif_claseService;

    @Autowired
    Clasif_MovimientoService clasif_movimientoService;

    @Autowired
    Clasif_BodegaService clasif_bodegaService;

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

    @RequestMapping(value = "/marcas/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveMarca(@RequestBody Clasif_Marca clasif_marca) {
        try{
            JsonResult jsonResult=null;
            if(clasif_marca!=null){

                jsonResult= clasif_marcaService.saveMarca(clasif_marca);
                return jsonResult;

            }else{
                return new JsonResult(false,"El objeto Marcas tiene problemas.",null);
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

    //CATEGORIAS

    @RequestMapping(value = "/categoria/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@RequestBody Clasif_Categoria clasif_categoria) {
        try{
            JsonResult jsonResult=null;
            if(clasif_categoria!=null){

                jsonResult= clasif_categoriaService.save(clasif_categoria);
                return jsonResult;

            }else{
                return new JsonResult(false,"El objeto Categoria tiene problemas.",null);
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

    @RequestMapping(value = "/clases", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByClases() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_claseService.listadoClases();
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

    //CLASES
    @RequestMapping(value = "/clases/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveClase(@RequestBody Clasif_Clase clasif_clase) {
        try{
            JsonResult jsonResult=null;
            if(clasif_clase!=null){

                jsonResult= clasif_claseService.saveClase(clasif_clase);
                return jsonResult;

            }else{
                return new JsonResult(false,"El objeto Categoria tiene problemas.",null);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/tipoMovimiento", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult findByTipoMovimiento() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_movimientoService.listaTipoMovimiento();
            return jsonResult;
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    /**
     * Descripcion: Registro Clasificador Bodega
     * @param clasif_bodega
     * @return
     */
    @RequestMapping(value = "/clasificadorBodega/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult guardarClasifBodega(@RequestBody Clasif_Bodega clasif_bodega) {
        try{
            JsonResult jsonResult=null;
            if(clasif_bodega!=null){
                jsonResult= clasif_bodegaService.saveClasifBodega(clasif_bodega);
                return jsonResult;
            }else{
                return new JsonResult(false,"El objeto Categoria tiene problemas.",null);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/clasif_Bodega", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoClasifBodega() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_bodegaService.listadoClasifBodega();
            return jsonResult;
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }
}

