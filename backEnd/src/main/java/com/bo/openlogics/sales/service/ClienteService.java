package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.model.Cliente;

/**
 * Created by json on 26/10/14.
 */
public interface ClienteService {
    public JsonResult saveCliente(Cliente cliente);
    public JsonResult buscarByNroDocumento(String numero);
    public JsonResult listadoClientesGeneral();
    public JsonResult listadoCliente();
}
