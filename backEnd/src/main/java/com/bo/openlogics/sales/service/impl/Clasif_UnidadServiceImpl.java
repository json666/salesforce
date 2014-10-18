package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.parametricas.UnidadBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.repository.Clasif_UnidadRepository;
import com.bo.openlogics.sales.service.Clasif_UnidadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 8/09/14.
 */

@Service
public class Clasif_UnidadServiceImpl implements Clasif_UnidadService {

    private Logger logger = Logger.getLogger(Clasif_UnidadServiceImpl.class);

    @Autowired
    Clasif_UnidadRepository clasif_unidadRepository;

    @Autowired
    UtilTransport utilTransport;

    @Override
    public JsonResult save(Clasif_Unidad clasif_unidad) {
        JsonResult jsonResult=null;
        try{
            Clasif_Unidad clasifUnidad=null;
            //clasifUnidad= clasif_unidadRepository.findByCodigoUnidad(clasif_unidad.getCodigoUnidad().toUpperCase());
            if(clasif_unidad!=null){
                clasifUnidad=clasif_unidadRepository.save(clasif_unidad);
                jsonResult= new JsonResult(true,"El tipo Unidad se registro Satisfactoriamente.",null);
            }else{
                jsonResult= new JsonResult(false,"Error, con el registro.",null);
                logger.info("******La unidad ya esta registrada*******");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            jsonResult= new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            jsonResult= new JsonResult(false,e.getMessage(),null);
        }
        return jsonResult;
    }

    @Override
    public JsonResult listadoUnidad() {
        try{
            JsonResult jsonResult=null;
            List<Clasif_Unidad> listadoUnidad=clasif_unidadRepository.findByDisabled(Boolean.FALSE);
            List<UnidadBean> unidadBeans= new ArrayList<UnidadBean>();
            if(listadoUnidad.size()>0){
                unidadBeans=utilTransport.convert(listadoUnidad,UnidadBean.class);

                jsonResult= new JsonResult(true,"Consulta Exitosa.",unidadBeans);
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
