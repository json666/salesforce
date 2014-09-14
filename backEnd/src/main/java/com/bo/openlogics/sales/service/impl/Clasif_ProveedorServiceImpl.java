package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_ProveedorRespository;
import com.bo.openlogics.sales.service.Clasif_ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by json on 14/09/14.
 */

@Service
public class Clasif_ProveedorServiceImpl implements Clasif_ProveedorService {
    @Autowired
    Clasif_ProveedorRespository clasif_proveedorRespository;

    @Override
    public JsonResult save(Clasif_Proveedor clasif_proveedor) {
        JsonResult jsonResult=null;
        try{
            Clasif_Proveedor clasifProveedor=null;
            clasifProveedor=clasif_proveedorRespository.findByNumeroDocumentoAndDisabled(clasif_proveedor.getnumeroDocumento(),Boolean.FALSE);
            if(clasifProveedor==null){
                clasifProveedor=clasif_proveedorRespository.save(clasif_proveedor);
                jsonResult= new JsonResult(true,"Se registro satisfactoriamente.",clasifProveedor);
            } else{
                jsonResult= new JsonResult(true,"Ya existe el registro.",null);
            }
            return jsonResult;

        }catch(NullPointerException e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }

    }
}
