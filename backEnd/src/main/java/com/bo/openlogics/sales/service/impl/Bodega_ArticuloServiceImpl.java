package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Bodega_articulo;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.BodegaRepository;
import com.bo.openlogics.sales.service.Bodega_ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by osanchez on 17/09/14.
 */

@Service
public class Bodega_ArticuloServiceImpl implements Bodega_ArticuloService {

    @Autowired
    BodegaRepository bodegaRepository;

    @Override
    public JsonResult save(Bodega_articulo bodega_articulo) {
        JsonResult jsonResult=null;
        try{
            if(bodega_articulo!=null){
                Bodega_articulo bodegaArticulo=bodegaRepository.save(bodega_articulo);
                jsonResult= new JsonResult(true,"Registro Exitoso",bodegaArticulo);
            }else{
                jsonResult= new JsonResult(false,"No se pudo registrar la Bodega",null);
            }
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,e.getMessage(),null);
        }
        return null;
    }
}
