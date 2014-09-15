package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.CategoriaBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Categoria;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_CategoriaRepository;
import com.bo.openlogics.sales.service.Clasif_CategoriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 12/09/14.
 */

@Service
public class Clasif_CategoriaServiceImpl implements Clasif_CategoriaService {

    @Autowired
    Clasif_CategoriaRepository clasif_categoriaRepository;

    @Autowired
    UtilTransport utilTransport;

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

    @Override
    public JsonResult listadoCategoria() {
        try {
            JsonResult jsonResult = null;
            List<Clasif_Categoria> listadoCategorias = clasif_categoriaRepository.findByDisabled(Boolean.FALSE);
            List<CategoriaBean> categoriaBeans= new ArrayList<CategoriaBean>();
            if (listadoCategorias.size() > 0) {
                categoriaBeans=utilTransport.convert(listadoCategorias,CategoriaBean.class);
                jsonResult = new JsonResult(true, "Consulta exitosa.", categoriaBeans);
            } else {
                jsonResult = new JsonResult(true, "No existen proveedores.", null);
            }

            return jsonResult;
        } catch (NullPointerException e) {
            return new JsonResult(false, e.getMessage(), null);
        } catch (Exception e) {
            return new JsonResult(false, e.getMessage(), null);
        }
    }
}
