package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.Usuario;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 28/09/14
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
public interface UsuarioService {

    public Usuario existUserAndPass(String nombre_usuario, String password) throws Exception;
}
