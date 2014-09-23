package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Clasif_Movimiento;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.model.Movimiento;
import com.bo.openlogics.sales.repository.Clasif_MovimientoRepository;
import com.bo.openlogics.sales.repository.Clasif_ProveedorRespository;
import com.bo.openlogics.sales.repository.MovimientoRepository;
import com.bo.openlogics.sales.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by osanchez on 23/09/14.
 */

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    Clasif_ProveedorRespository clasif_proveedorRespository;

    @Autowired
    Clasif_MovimientoRepository clasif_movimientoRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    @Override
    public Movimiento create(Movimiento movimiento) {
        Clasif_Movimiento clasif_movimiento=null;
        Clasif_Proveedor clasif_proveedor=null;
        try{
            if(movimiento.getClasif_movimiento()!=null){
                clasif_movimiento=clasif_movimientoRepository.findOne(movimiento.getClasif_movimiento().getId());
                movimiento.setClasif_movimiento(clasif_movimiento);
            }
            if(movimiento.getClasif_proveedor()!=null){
                clasif_proveedor=clasif_proveedorRespository.findOne(movimiento.getClasif_proveedor().getId());
                movimiento.setClasif_proveedor(clasif_proveedor);
            }
            return movimientoRepository.save(movimiento);

        }catch (NullPointerException e){
            return null;
        }
        catch (Exception e){
            return null;
        }

    }
}
