package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.MarcaBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Marca;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_MarcaRepository;
import com.bo.openlogics.sales.service.Clasif_MarcaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 7/09/14.
 */

@Service
public class Clasif_MarcaServiceImpl implements Clasif_MarcaService {
    @Autowired
    Clasif_MarcaRepository clasif_marcaRepository;

    @Autowired
    UtilTransport utilTransport;

    private Logger logger = Logger.getLogger(Clasif_MarcaServiceImpl.class);

    @Override
    public JsonResult saveMarca(Clasif_Marca clasif_marca) {
        try {
            JsonResult jsonResult=null;
            Clasif_Marca clasifMarca = null;
            System.out.println("COD_MARCA:"+clasif_marca.getCodigoMarca());
            System.out.println("ESTATUS:"+Boolean.FALSE);
            clasifMarca = clasif_marcaRepository.findByCodigoMarca(clasif_marca.getCodigoMarca());
            if (clasifMarca == null) {
                clasif_marcaRepository.save(clasif_marca);
                jsonResult= new JsonResult(true,"Registrado.",null);
            } else {
                logger.info("******La marca ya esta registrada*******");
                jsonResult= new JsonResult(true,"Error.",null);
            }
            return jsonResult;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public JsonResult listadoMarcas() {
        try{
            JsonResult jsonResult=null;
            List<Clasif_Marca> listadoMarcas=clasif_marcaRepository.findByDisabled(Boolean.FALSE);
            List<MarcaBean> marcaBeans= new ArrayList<MarcaBean>();
            if(listadoMarcas.size()>0){
                marcaBeans=utilTransport.convert(listadoMarcas,MarcaBean.class);

                jsonResult= new JsonResult(true,"Consulta Exitosa.",marcaBeans);
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
