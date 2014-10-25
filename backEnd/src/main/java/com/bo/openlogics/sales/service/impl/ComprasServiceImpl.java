package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.ArticuloBeanCompra;
import com.bo.openlogics.sales.beans.ComprasBean;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Compras;
import com.bo.openlogics.sales.repository.Clasif_ArticuloRepository;
import com.bo.openlogics.sales.repository.Clasif_BodegaRepository;
import com.bo.openlogics.sales.repository.ComprasRepository;
import com.bo.openlogics.sales.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 25/10/14.
 */

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    Clasif_BodegaRepository clasif_bodegaRepository;

    @Autowired
    ComprasRepository comprasRepository;
    
    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;
    

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult adicionarCompras(ComprasBean comprasBean) {
        Compras compras=null;
        JsonResult jsonResult=null;
        List<Clasif_Articulo> clasif_articulos=null;
        Clasif_Articulo clasif_articulo=null;
        try{
            compras= new Compras();
            compras.setNroCompra(comprasBean.getNroCompra());
            compras.setCantidadExistente(comprasBean.getCantidadExistente());
            compras.setClasif_bodega(clasif_bodegaRepository.findOne(comprasBean.getBodegaBean().getId()));
            clasif_articulos= new ArrayList<Clasif_Articulo>();
            
            for (ArticuloBeanCompra articuloBeanCompra : comprasBean.getArticuloBeanCompras()) {
                clasif_articulo=null;
                clasif_articulo=clasif_articuloRepository.findOne(articuloBeanCompra.getId());
                clasif_articulos.add(clasif_articulo);
            }

            for (Clasif_Articulo clasif_articulo1 : clasif_articulos) {
                compras.addDetalleComprasArticulo(clasif_articulo1);
            }

            comprasRepository.save(compras);

            jsonResult= new JsonResult(true,"La compra fue registrada Satisfactoriamente.",null);

            

        }catch(NullPointerException e){
            e.getMessage();
            e.printStackTrace();
            jsonResult= new JsonResult(false,e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            jsonResult= new JsonResult(false,e.getMessage(),null);
        }
        return jsonResult;
    }
}
