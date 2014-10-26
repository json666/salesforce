package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.parametricas.ArticuloHabilitadoBean;
import com.bo.openlogics.sales.beans.parametricas.ClienteBean;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Cliente;
import com.bo.openlogics.sales.repository.ClienteRepository;
import com.bo.openlogics.sales.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by json on 26/10/14.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UtilTransport utilTransport;

    @Override
    public JsonResult saveCliente(Cliente cliente) {
        JsonResult jsonResult=null;
        Cliente cli=null;
        try{
            if(cliente!=null){
                cli=clienteRepository.findByNroDocumento(cliente.getNroDocumento());
                if(cli==null){
                    clienteRepository.save(cliente);
                    jsonResult= new JsonResult(true,"Cliente Guardado Satisfactoriamente.",null);
                }else{
                    jsonResult= new JsonResult(false,"El Cliente ya se encuentra Registrado.",null);
                }

            }else{
                jsonResult= new JsonResult(false,"No se puede Guardar al Cliente, hay errores.", null);
            }
            return jsonResult;

        }catch(NullPointerException e){
            e.printStackTrace();
            e.getMessage();
            return  new JsonResult(false,e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return  new JsonResult(false,e.getMessage(),null);
        }

    }

    @Override
    public JsonResult buscarByNroDocumento(String numero) {
        JsonResult jsonResult=null;
        Cliente cliente=null;
        try{
            if(numero!=null){
                cliente=clienteRepository.findByNroDocumento(numero);
                if(cliente!=null){
                    jsonResult= new JsonResult(true,"Consulta Exitosa.",cliente);
                }else{
                    jsonResult= new JsonResult(false,"Cliente con numero "+numero+" no se encuentra registrado.",null);
                }
            }else{
                jsonResult= new JsonResult(false,"Existen problemas para realizar la busqueda, dato probablemente vacio.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            e.printStackTrace();
            e.getMessage();
            return  new JsonResult(false,e.getMessage(),null);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return  new JsonResult(false,e.getMessage(),null);
        }
    }

    @Override
    public JsonResult listadoClientesGeneral() {
        try{
            JsonResult jsonResult=null;
            List<Cliente> listadoClienteHabilitados=clienteRepository.findByDisabled();

            if(listadoClienteHabilitados.size()>0){
                jsonResult= new JsonResult(true,"Consulta Exitosa.",listadoClienteHabilitados);
            }else{
                jsonResult= new JsonResult(false,"No existen Datos Habilitados.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @Override
    public JsonResult listadoCliente() {
        try{
            JsonResult jsonResult=null;
            List<Cliente> listadoClientes=clienteRepository.findByDisabled();
            List<ClienteBean> clienteBeans= new ArrayList<ClienteBean>();
            if(listadoClientes.size()>0){
                clienteBeans=utilTransport.convert(listadoClientes,ClienteBean.class);
                jsonResult= new JsonResult(true,"Consulta Exitosa.",clienteBeans);
            }else{
                jsonResult= new JsonResult(false,"No existen Datos.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }
}
