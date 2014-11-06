package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.AlmacenBean;
import com.bo.openlogics.sales.beans.ArticuloBeanStock;
import com.bo.openlogics.sales.model.Clasif_Bodega;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.repository.Clasif_BodegaRepository;
import com.bo.openlogics.sales.repository.ComprasRepository;
import com.bo.openlogics.sales.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osanchez on 6/11/14.
 */

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    ComprasRepository comprasRepository;

    @Autowired
    Clasif_BodegaRepository clasif_bodegaRepository;

    @Override
    public JsonResult listadoBodega(Long idBodega) {
        JsonResult jsonResult = null;
        List<AlmacenBean> almacenBeans;
        try {

            if (clasif_bodegaRepository.exists(idBodega)) {
                almacenBeans = new ArrayList<AlmacenBean>();

                almacenBeans = comprasRepository.listaInventarioByBodega(idBodega);
                if (almacenBeans.size() > 0) {
                    jsonResult = new JsonResult(true, "cargando listado de articulos.", almacenBeans);
                } else {
                    jsonResult = new JsonResult(false, "No existe articulos para la Bodega Almacen seleccionada.", null);
                }

            } else {
                jsonResult = new JsonResult(false, "Error. verifique que la Bodega Almacen exista.", null);
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
    public JsonResult articuloStock(Long idBodega, String codArticulo) {
        JsonResult jsonResult = null;
        ArticuloBeanStock articuloBeanStock = null;
        try {

            if (idBodega != null) {
                articuloBeanStock = new ArticuloBeanStock();
                articuloBeanStock = comprasRepository.listaArticuloCompraStock(idBodega, codArticulo);
                jsonResult = new JsonResult(true, "cargando articulo.", articuloBeanStock);
            } else {
                jsonResult = new JsonResult(false, "Error. verifique los codigos Bodega y Articulo.", null);
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
}
