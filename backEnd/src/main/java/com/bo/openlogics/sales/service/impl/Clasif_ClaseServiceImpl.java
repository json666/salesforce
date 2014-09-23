package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.ClaseBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Clase;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_ClaseRepository;
import com.bo.openlogics.sales.service.Clasif_ClaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 15/09/14.
 */
@Service
public class Clasif_ClaseServiceImpl implements Clasif_ClaseService {

    @Autowired
    Clasif_ClaseRepository clasif_claseRepository;

    @Autowired
    UtilTransport utilTransport;

    private Logger logger = Logger.getLogger(Clasif_ClaseServiceImpl.class);

    @Override
    public JsonResult listadoClase(Long idCategoria) {
        try{
            JsonResult jsonResult= null;
            List<Clasif_Clase> listadoClase=clasif_claseRepository.findByCategoriaAndDisabled(idCategoria);
            List<ClaseBean> claseBeans= new ArrayList<ClaseBean>();
            if(listadoClase.size()>0){
                claseBeans=utilTransport.convert(listadoClase,ClaseBean.class);
                jsonResult= new JsonResult(true,"Consulta Exitosa.",claseBeans);
            }else{
                jsonResult= new JsonResult(false,"No se encontraron Datos.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,e.getMessage(),null);
        }
    }

    @Override
    public JsonResult saveClase(Clasif_Clase clasif_clase) {
        JsonResult jsonResult = null;
        try{
            Clasif_Clase clasifClase=null;
            clasifClase=clasif_claseRepository.findByDescripcionClase(clasif_clase.getDescripcionClase());
            if(clasifClase==null){
                clasifClase = clasif_claseRepository.save(clasif_clase);
                jsonResult = new JsonResult(true, "Se registro satisfactoriamente.", clasifClase);
            }else{
                jsonResult = new JsonResult(true, "Ya existe el registro.", null);
                logger.info("******El tipo categoria ya esta registrada*******");
            }
            return jsonResult;

        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false, e.getMessage(), null);
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }

    }
}
