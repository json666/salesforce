package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.Bodega_articulo;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.Bodega_ArticuloService;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import com.bo.openlogics.sales.service.Clasif_BodegaService;
import com.bo.openlogics.sales.service.Clasif_ProveedorService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by json on 12/09/14.
 */

@Controller
@RequestMapping(value = "/rest")
@Transactional(readOnly = true)
public class SalesForceRESTController {
    @Autowired
    Clasif_ArticuloService clasif_articuloService;

    @Autowired
    Clasif_ProveedorService clasif_proveedorService;

    @Autowired
    Bodega_ArticuloService bodega_articuloService;

    @Autowired
    Clasif_BodegaService clasif_bodegaService;


    private Logger logger = Logger.getLogger(SalesForceRESTController.class);

    /**
     * Descripcion: Registra un Articulo;
     */

    @RequestMapping(value = "/articulo/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@RequestBody Clasif_Articulo clasif_articulo) {
        try {
            JsonResult jsonResult = null;
            if (clasif_articulo != null) {
                clasif_articuloService.save(clasif_articulo);
                jsonResult = new JsonResult(true, "Se registro el articulo satisfatoriamente.", null);
                return jsonResult;

            } else {
                return new JsonResult(false, "El objeto Articulo tiene problemas.", null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    /*
    PROCESOS PROVEEDORES
     */
    @RequestMapping(value = "/proveedor/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveProveedor(@RequestBody Clasif_Proveedor clasif_proveedor) {
        try {
            JsonResult jsonResult = null;
            if (clasif_proveedor != null) {

                jsonResult = clasif_proveedorService.save(clasif_proveedor);
                return jsonResult;

            } else {
                return new JsonResult(false, "El objeto Proveedor tiene problemas.", null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/proveedores", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoProveedores() {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_proveedorService.listadoProveedores();
            if (jsonResult != null) {
                return jsonResult;
            } else {
                return jsonResult;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/articulosHabilitados", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoAriculosHabilitados() {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.listadoArticulos();
            return jsonResult;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/proveedorMovimiento", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoProveedoresHabilitados() {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_proveedorService.listadoProveedoresHabilitados();
            return jsonResult;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/articuloMovimiento", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoArticulo() {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.listadoArticulosHabilitados();
            return jsonResult;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    /**
     * Descripcion: Actualizacion del articulo
     */

    @RequestMapping(value = "/articulo/editar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult editarArticulo(@RequestBody Clasif_Articulo clasif_articulo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.editarArticulo(clasif_articulo);
            if (jsonResult.getSuccess()) {
                return jsonResult;
            } else {
                return new JsonResult(false, jsonResult.getMessage(), null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    /**
     * *
     * Descripcion: Desabilitar Articulo
     *
     * @param idArticulo
     * @return
     */
    @RequestMapping(value = "/articulo/desabilitar/{idArticulo}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult desabilitarArticulo(@PathVariable Long idArticulo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.desabilitarArticulo(idArticulo);
            if (jsonResult.getSuccess()) {
                return jsonResult;
            } else {
                return new JsonResult(false, jsonResult.getMessage(), null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "articulo/get/{idArticulo}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getById(@PathVariable Long idArticulo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.getById(idArticulo);
//            return new JsonResult(true, Clasif_ArticuloService.getById(idArticulo));
            if (jsonResult.getSuccess()) {
                return jsonResult;
            } else {
                return new JsonResult(false, jsonResult.getMessage(), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }


    /**
     * *
     * Descripcion: Desabilitar Articulo
     *
     * @param bodega_articulo
     * @return
     */
    @RequestMapping(value = "/bodega/articulos/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult adicionarBodegaArticulos(@RequestBody Bodega_articulo bodega_articulo) {
        System.out.println("....................INGRESANDO AL SERVICIO...................");
        Bodega_articulo bodegaArticulo = null;
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String jsonArt = ow.writeValueAsString(bodega_articulo);
            System.out.println("JSON QUE VIENE DEL REST:"+jsonArt);
            JsonResult jsonResult = null;
            jsonResult=bodega_articuloService.adicionarBodegaArticulo(bodega_articulo);
            logger.info("Se adiciono una bodega con id: "
                    + bodega_articulo.getId() + ".");
            if (jsonResult.getSuccess()) {
                return jsonResult;
            } else {
                return new JsonResult(false, jsonResult.getMessage(), null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "/clasificador_bodega", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getClasifBodega() {
        try{
            JsonResult jsonResult=null;
            jsonResult=clasif_bodegaService.getClasif_Bodega();
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
