package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.parametricas.ProveedoreBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.repository.Clasif_ProveedorRespository;
import com.bo.openlogics.sales.service.Clasif_ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 14/09/14.
 */

@Service
public class Clasif_ProveedorServiceImpl implements Clasif_ProveedorService {



    @Autowired
    Clasif_ProveedorRespository clasif_proveedorRespository;

    @Autowired
    UtilTransport utilTransport;

    @Override
    public JsonResult save(Clasif_Proveedor clasif_proveedor) {
        JsonResult jsonResult = null;
        try {
            Clasif_Proveedor clasifProveedor = null;
            clasifProveedor = clasif_proveedorRespository.findByNumeroDocumentoAndDisabled(clasif_proveedor.getnumeroDocumento(), Boolean.FALSE);
            if (clasifProveedor == null) {
                clasifProveedor = clasif_proveedorRespository.save(clasif_proveedor);
                jsonResult = new JsonResult(true, "Se registro satisfactoriamente.", clasifProveedor);
            } else {
                jsonResult = new JsonResult(true, "Ya existe el registro.", null);
            }
            return jsonResult;

        } catch (NullPointerException e) {
            e.printStackTrace();
            return new JsonResult(false, e.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "Error: " + e.getMessage(), null);
        }

    }

    @Override
    public JsonResult listadoProveedores() {
        try {
            JsonResult jsonResult = null;
            List<Clasif_Proveedor> listadoProveedores = clasif_proveedorRespository.findByDisabled(Boolean.FALSE);

            if (listadoProveedores.size() > 0) {

                jsonResult = new JsonResult(true, "Consulta exitosa.", listadoProveedores);
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

    @Override
    public JsonResult listadoProveedoresHabilitados() {
        try {
            JsonResult jsonResult = null;
            List<Clasif_Proveedor> listadoProveedores = clasif_proveedorRespository.findByDisabled(Boolean.FALSE);
            List<ProveedoreBean> proveedoreBeans= new ArrayList<ProveedoreBean>();
            if (listadoProveedores.size() > 0) {
                proveedoreBeans=utilTransport.convert(listadoProveedores,ProveedoreBean.class);
                jsonResult = new JsonResult(true, "Consulta exitosa.", proveedoreBeans);
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
