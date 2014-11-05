package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.ArticuloBeanCompra;
import com.bo.openlogics.sales.beans.ComprasBean;
import com.bo.openlogics.sales.beans.VentasBean;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Compras;
import com.bo.openlogics.sales.model.Ventas;
import com.bo.openlogics.sales.repository.Clasif_BodegaRepository;
import com.bo.openlogics.sales.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osanchez on 28/10/14.
 */

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    Clasif_BodegaRepository clasif_bodegaRepository;

    @Override
    public JsonResult adicionarVentas(VentasBean ventasBean) {
        Ventas ventas=null;
        JsonResult jsonResult=null;
        List<Clasif_Articulo> clasif_articulos=null;
        Clasif_Articulo clasif_articulo=null;
        try{
            ventas= new Ventas();
            ventas.setCliente(ventasBean.getCliente());
            ventas.setClasif_bodega(clasif_bodegaRepository.findOne(ventasBean.getBodegaBean().getId()));

            clasif_articulos= new ArrayList<Clasif_Articulo>();

            /*for (ArticuloBeanCompra articuloBeanCompra : comprasBean.getArticuloBeanCompras()) {
                clasif_articulo=null;

                clasif_articulo=clasif_articuloRepository.findOne(articuloBeanCompra.getId());
                System.out.println("CANTIDAD:"+articuloBeanCompra.getCantidadExistente());
                clasif_articulo.setCantidad(articuloBeanCompra.getCantidadExistente());
                clasif_articulos.add(clasif_articulo);

            }

            for (Clasif_Articulo clasif_articulo1 : clasif_articulos) {
                compras.addDetalleComprasArticulo(clasif_articulo1);

            }

            comprasRepository.save(compras);*/

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
