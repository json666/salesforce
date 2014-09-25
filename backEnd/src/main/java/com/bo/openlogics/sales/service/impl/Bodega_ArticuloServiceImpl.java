package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Bodega_articulo;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.model.Movimiento;
import com.bo.openlogics.sales.repository.Bodega_articuloRepository;
import com.bo.openlogics.sales.service.Bodega_ArticuloService;
import com.bo.openlogics.sales.service.MovimientoService;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult adicionarBodegaArticulo(Bodega_articulo bodega_articuloBean) {
        JsonResult jsonResult=null;
        Movimiento movimiento=null;

        Bodega_articulo bodegaArticulo= new Bodega_articulo();

        try{
            System.out.println("SERVICE BODEGA ARTICULO...");
            //bodegaArticulo.setMovimiento(bodega_articuloBean.getMovimiento());
            bodegaArticulo.setCantidad(bodega_articuloBean.getCantidad());
            bodegaArticulo.setMonto(bodega_articuloBean.getMonto());
            bodegaArticulo.setTipoBodega(bodega_articuloBean.getTipoBodega());
            bodegaArticulo.setCostoTotal(bodega_articuloBean.getMonto()*100);
            bodegaArticulo.setDescripcionBodega(bodega_articuloBean.getDescripcionBodega());
            bodegaArticulo.setClasif_articulos(bodega_articuloBean.getClasif_articulos());
            movimiento=bodega_articuloBean.getMovimiento();
            if(bodega_articuloBean!=null){
                movimiento=movimientoService.create(bodega_articuloBean.getMovimiento());
                bodegaArticulo.addBodegaDetalleMovimiento(movimiento);
                bodegaRepository.save(bodegaArticulo);
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
