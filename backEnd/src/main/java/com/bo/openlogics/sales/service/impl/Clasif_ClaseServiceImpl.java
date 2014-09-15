package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.ClaseBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Clase;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_ClaseRepository;
import com.bo.openlogics.sales.service.Clasif_ClaseService;
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
}
