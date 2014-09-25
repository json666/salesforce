package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.UnidadBean;
import com.bo.openlogics.sales.model.Clasif_Bodega;
import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_BodegaRepository;
import com.bo.openlogics.sales.service.Clasif_BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osanchez on 25/09/14.
 */
@Service
public class Clasif_BodegaServiceImpl implements Clasif_BodegaService {

    @Autowired
    Clasif_BodegaRepository clasif_bodegaRepository;

    @Override
    public JsonResult saveClasifBodega(Clasif_Bodega clasif_bodega) {
        JsonResult jsonResult = null;
        Clasif_Bodega clasifBodega = null;
        try {
            clasifBodega = clasif_bodegaRepository.findOne(clasif_bodega.getId());
            if (clasifBodega == null) {
                clasifBodega = clasif_bodegaRepository.save(clasif_bodega);
                jsonResult = new JsonResult(true, "El Clasificador Bodega registrado satisfactoriamente.", null);
            } else {
                jsonResult = new JsonResult(false, "El Clasificador Bodega ya existe.", null);
            }
        } catch (NullPointerException e) {
            jsonResult = new JsonResult(false, e.getMessage(), null);
        } catch (Exception e) {
            jsonResult = new JsonResult(false, e.getMessage(), null);
        }
        return jsonResult;
    }

    @Override
    public JsonResult listadoClasifBodega() {
        try{
            JsonResult jsonResult=null;
            List<Clasif_Bodega> listadoBodega=clasif_bodegaRepository.findByDisabled();
            if(listadoBodega.size()>0){
                jsonResult= new JsonResult(true,"Consulta Exitosa.",listadoBodega);
            }else{
                jsonResult= new JsonResult(false,"No existen Datos.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }
}
