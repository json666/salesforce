package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.repository.Clasif_ArticuloRepository;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by json on 12/09/14.
 */

@Service
public class Clasif_ArticuloServiceImpl implements Clasif_ArticuloService {
    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;

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
}
