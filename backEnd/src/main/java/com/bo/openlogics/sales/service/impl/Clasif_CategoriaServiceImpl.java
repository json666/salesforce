package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Clasif_Categoria;
import com.bo.openlogics.sales.repository.Clasif_CategoriaRepository;
import com.bo.openlogics.sales.service.Clasif_CategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by json on 12/09/14.
 */

@Service
public class Clasif_CategoriaServiceImpl implements Clasif_CategoriaService {

    @Autowired
    Clasif_CategoriaRepository clasif_categoriaRepository;

    private Logger logger = Logger.getLogger(Clasif_CategoriaServiceImpl.class);

    @Override
    public void save(Clasif_Categoria clasif_categoria) {
        try{
            Clasif_Categoria clasifCategoria=null;
            clasifCategoria=clasif_categoriaRepository.findByDescripcionCategoria(clasif_categoria.getDescripcionCategoria());
            if(clasifCategoria==null){
                clasif_categoriaRepository.save(clasif_categoria);
            }else{
                logger.info("******El tipo categoria ya esta registrada*******");
            }

        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
