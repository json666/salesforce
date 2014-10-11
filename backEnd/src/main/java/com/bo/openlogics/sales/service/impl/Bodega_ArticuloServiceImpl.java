package com.bo.openlogics.sales.service.impl;


import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.model.*;
import com.bo.openlogics.sales.repository.*;
import com.bo.openlogics.sales.service.Bodega_ArticuloService;
import com.bo.openlogics.sales.service.MovimientoService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by osanchez on 17/09/14.
 */

@Service
public class Bodega_ArticuloServiceImpl implements Bodega_ArticuloService {

    @Autowired
    Bodega_articuloRepository bodegaRepository;

    @Autowired
    MovimientoService movimientoService;

    @Autowired
    Clasif_MarcaRepository clasif_marcaRepository;

    @Autowired
    Clasif_UnidadRepository clasif_unidadRepository;

    @Autowired
    Clasif_CategoriaRepository clasif_categoriaRepository;

    @Autowired
    Clasif_ClaseRepository clasif_claseRepository;

    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;

    @Autowired
    Clasif_MovimientoRepository clasif_movimientoRepository;

    @Autowired
    Clasif_ProveedorRespository clasif_proveedorRespository;

    private Logger logger = Logger.getLogger(Clasif_ArticuloServiceImpl.class);

    @Override
    @Transactional
    public JsonResult adicionarBodegaArticulo(Bodega_articulo bodega_articuloBean) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        JsonResult jsonResult=null;
        Movimiento movimiento=null;
        Clasif_Articulo clasifArticulo=null;
        Clasif_Marca clasifMarca=null;
        Clasif_Unidad clasifUnidad=null;
        Clasif_Categoria clasifCategoria=null;
        Clasif_Clase clasifClase=null;
        Clasif_Movimiento clasifMovimiento=null;
        Clasif_Proveedor clasifProveedor=null;
        Bodega_articulo bodegaArticulo= new Bodega_articulo();

        try{
            //String jsonArt = ow.writeValueAsString(bodega_articuloBean);
            //System.out.println("LO QUE LLEGA:"+jsonArt);
            //System.out.println("SERVICE BODEGA ARTICULO...");
            //logger.info("******JSON INICIAL*******"+jsonArt);
            if(bodega_articuloBean.getClasif_articulo()!=null){
                clasifArticulo= clasif_articuloRepository.findOne(bodega_articuloBean.getClasif_articulo().getId());
                bodega_articuloBean.setClasif_articulo(clasifArticulo);
            }
            /*if(bodega_articuloBean.getMovimiento().getClasif_proveedor()!=null){
                clasifProveedor=clasif_proveedorRespository.findOne(bodega_articuloBean.getMovimiento().getClasif_proveedor().getId());
                bodega_articuloBean.getMovimiento().setClasif_proveedor(clasifProveedor);
            }
            if(bodega_articuloBean.getMovimiento().getClasif_movimiento()!=null){
                clasifMovimiento=clasif_movimientoRepository.findOne(bodega_articuloBean.getMovimiento().getClasif_movimiento().getId());
                bodega_articuloBean.getMovimiento().setClasif_movimiento(clasifMovimiento);

            } */
            //bodegaArticulo.setMovimiento(bodega_articuloBean.getMovimiento());
            bodegaArticulo.setCantidad(bodega_articuloBean.getCantidad());
            bodegaArticulo.setMonto(bodega_articuloBean.getMonto());
            bodegaArticulo.setCostoTotal(bodega_articuloBean.getMonto() * 100);
            //bodegaArticulo.setClasif_articulo(bodega_articuloBean.getClasif_articulo());
            bodegaArticulo.setClasif_bodega(bodega_articuloBean.getClasif_bodega());
            //bodegaArticulo.setMovimiento(bodega_articuloBean.getMovimiento());
            bodegaArticulo.setClasif_articulo(bodega_articuloBean.getClasif_articulo());
            //movimiento=bodega_articuloBean.getMovimiento();
            logger.info("******INICIANDO*******");
            logger.info("******MOV:"+movimiento);
            if(bodega_articuloBean!=null){
                //movimiento=movimientoService.create(bodega_articuloBean.getMovimiento());
                //bodegaArticulo.addBodegaDetalleMovimiento(movimiento);

                //String jsonArt = ow.writeValueAsString(bodegaArticulo);
                //System.out.println("JSON A GUARDAR:"+jsonArt);
                String jsonArt1 = ow.writeValueAsString(bodega_articuloBean);
                System.out.println("JSON A GUARDAR (1):"+jsonArt1);
                logger.info("******REGISTRANDO*******");
                logger.info("******OBJETO*******"+bodegaArticulo);
                //bodegaRepository.save(bodegaArticulo);
                jsonResult= new JsonResult(true,"Registro Exitoso",bodega_articuloBean);
            }else{
                jsonResult= new JsonResult(false,"No se pudo registrar la Bodega",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,e.getMessage(),null);
        }
    }
}
