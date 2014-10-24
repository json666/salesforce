package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Compra;
import com.bo.openlogics.sales.repository.ComprasRespository;
import com.bo.openlogics.sales.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by osanchez on 24/10/14.
 */

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    ComprasRespository comprasRespository;

    @Override
    public JsonResult save(Compra compras) {
        JsonResult jsonResult=null;
        Compra compraRegistro=null;
        try{
            compraRegistro=comprasRespository.save(compras);


         return new JsonResult(true,null,compraRegistro);
        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false, e.getMessage(), null);
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false, e.getMessage(), null);
        }
    }
}
