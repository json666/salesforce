package com.bo.openlogics.sales.controller;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.ComprasBean;
import com.bo.openlogics.sales.model.Bodega_articulo;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Proveedor;

import com.bo.openlogics.sales.model.Cliente;
import com.bo.openlogics.sales.service.*;
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
@Transactional
public class SalesForceRESTController {
    @Autowired
    Clasif_ArticuloService clasif_articuloService;

    @Autowired
    Clasif_ProveedorService clasif_proveedorService;

    /*@Autowired
    Bodega_ArticuloService bodega_articuloService;*/

    @Autowired
    Clasif_BodegaService clasif_bodegaService;

    @Autowired
    ComprasService comprasService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    AlmacenService almacenService;


    private Logger logger = Logger.getLogger(SalesForceRESTController.class);

    /**
     * Descripcion: Registra una compra;
     */

    @RequestMapping(value = "/compra/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult adicionarCompras(@RequestBody ComprasBean comprasBean) {
        try {
            return comprasService.adicionarCompras(comprasBean);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    /**
     * Descripcion: Registra un Articulo;
     */

    @RequestMapping(value = "/articulo/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(@RequestBody Clasif_Articulo clasif_articulo) {
        try {
            return clasif_articuloService.save(clasif_articulo);
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

    @RequestMapping(value = "proveedor/get/{idProveedor}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getByIdProv(@PathVariable Long idProveedor) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_proveedorService.getByIdProv(idProveedor);
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
            System.out.println("JSON QUE VIENE DEL REST:" + jsonArt);
            JsonResult jsonResult = null;
            jsonResult = null;//bodega_articuloService.adicionarBodegaArticulo(bodega_articulo);
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
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_bodegaService.getClasif_Bodega();
            return jsonResult;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "bodega/buscar/{idBodega}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult buscarBodegaById(@PathVariable Long idBodega) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_bodegaService.buscarBodegaById(idBodega);
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

    @RequestMapping(value = "clientes/detalle", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listadoClientesDetalle() {
        try{
            return clienteService.listadoClientesGeneral();
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/cliente/guardar", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveCliente(@RequestBody Cliente cliente) {
        try {
            JsonResult jsonResult = null;
            if (cliente != null) {
                jsonResult = clienteService.saveCliente(cliente);
                return jsonResult;
            } else {
                return new JsonResult(false, "El objeto Cliente tiene problemas.", null);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "cliente/buscar/{numero}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult buscarClienteByNumero(@PathVariable String numero) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clienteService.buscarByNroDocumento(numero);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }
    }

    @RequestMapping(value = "articulo/buscar/{codigo}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getByCodigoArticuloCompra(@PathVariable String codigo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.buscarArticuloBeanCompraByCodigoArticulo(codigo);
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

    @RequestMapping(value = "articulo/edicion/{idArticulo}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getArticuloEdicionById(@PathVariable Long idArticulo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = clasif_articuloService.buscarArticuloEdit(idArticulo);
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

    @RequestMapping(value = "bodegaAlmacen/articulos/{idBodega}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getListadoBodega(@PathVariable Long idBodega) {
        try {
            JsonResult jsonResult = null;
            jsonResult = almacenService.listadoBodega(idBodega);
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

    @RequestMapping(value = "ventas/articulo/{idBodega}/{codArticulo}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getArticuloVentaStock(@PathVariable Long idBodega, @PathVariable String codArticulo) {
        try {
            JsonResult jsonResult = null;
            jsonResult = almacenService.articuloStock(idBodega,codArticulo);
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


}
