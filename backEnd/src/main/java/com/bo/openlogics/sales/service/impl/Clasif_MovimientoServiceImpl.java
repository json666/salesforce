package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.parametricas.CategoriaBean;
import com.bo.openlogics.sales.beans.parametricas.TipoMovimientoBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Categoria;
import com.bo.openlogics.sales.model.Clasif_Movimiento;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.repository.Clasif_MovimientoRepository;
import com.bo.openlogics.sales.service.Clasif_MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 15/09/14.
 */

@Service
public class Clasif_MovimientoServiceImpl implements Clasif_MovimientoService {

    @Autowired
    Clasif_MovimientoRepository clasif_movimientoRepository;

    @Autowired
    UtilTransport utilTransport;
    @Override
    public JsonResult listaTipoMovimiento() {
        try {
            JsonResult jsonResult = null;
            List<Clasif_Movimiento> listadoTipoMovimiento = clasif_movimientoRepository.findBydisabled();
            List<TipoMovimientoBean> tipoMovimientoBeans= new ArrayList<TipoMovimientoBean>();
            if (listadoTipoMovimiento.size() > 0) {
                tipoMovimientoBeans=utilTransport.convert(listadoTipoMovimiento,TipoMovimientoBean.class);
                jsonResult = new JsonResult(true, "Consulta exitosa.", tipoMovimientoBeans);
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
