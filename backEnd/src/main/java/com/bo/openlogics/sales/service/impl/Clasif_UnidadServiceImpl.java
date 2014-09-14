package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.MarcaBean;
import com.bo.openlogics.sales.beans.parametricas.UnidadBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Marca;
import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.model.JsonResult;
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
    public void save(Clasif_Unidad clasif_unidad) {
        try{
            Clasif_Unidad clasifUnidad=null;
            clasifUnidad= clasif_unidadRepository.findByCodigoUnidad(clasif_unidad.getCodigoUnidad());
            if(clasifUnidad==null){
                clasif_unidadRepository.save(clasif_unidad);
            }else{
                logger.info("******La unidad ya esta registrada*******");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
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
