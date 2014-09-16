package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.ArticuloBean;
import com.bo.openlogics.sales.beans.parametricas.UnidadBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_ArticuloRepository;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 12/09/14.
 */

@Service
public class Clasif_ArticuloServiceImpl implements Clasif_ArticuloService {
    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;

    @Autowired
    UtilTransport utilTransport;


    private Logger logger = Logger.getLogger(Clasif_ArticuloServiceImpl.class);

    @Override
    public void save(Clasif_Articulo clasif_articulo) {
        try{
            Clasif_Articulo clasifArticulo=null;
            clasifArticulo=clasif_articuloRepository.findByCodigoArticulo(clasif_articulo.getCodigoArticulo());
            if(clasifArticulo==null){
                clasif_articuloRepository.save(clasif_articulo);
            } else{
                logger.info("******Articulo ya esta registrado*******");
            }

        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public JsonResult listadoArticulosHabilitados() {
        try{
            JsonResult jsonResult=null;
            List<Clasif_Articulo> listadoArticulos=clasif_articuloRepository.findByDisabled();
            List<ArticuloBean> articuloBeans= new ArrayList<ArticuloBean>();
            if(listadoArticulos.size()>0){
                articuloBeans=utilTransport.convert(listadoArticulos,ArticuloBean.class);

                jsonResult= new JsonResult(true,"Consulta Exitosa.",articuloBeans);
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
