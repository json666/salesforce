package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.Usuario;
import com.bo.openlogics.sales.repository.UsuarioRepository;
import com.bo.openlogics.sales.service.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 28/09/14
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    private Logger logger = Logger.getLogger(UsuarioServiceImpl.class);
    @Override
//    public JsonResult existUserAndPass(String nombre_usuario, String password) throws SccException {
    public Usuario existUserAndPass(String nombre_usuario, String password) throws Exception {
        Usuario usuario = null;
        try {
            /**
             * TODO: Incluir logica de negocio
             */
            logger.info("******USUARIO******");
            logger.info(nombre_usuario);
            logger.info("*****PASSWORD******");
            logger.info(password);
            usuario = usuarioRepository.findUserAndPass(nombre_usuario, password);
            logger.info("*****USUARIO:"+usuario+"*******");
            logger.info("="+usuario.getPassword());
            if(usuario!= null && usuario.getPassword().equals(password)){
                return usuario;
            }
//                return new JsonResult(true,usuario);
            else{
                throw  new Exception("Nombre de Usuario y/o Passsword son incorrectos");
            }
//                return new JsonResult(false,"No Existe Usuario y Passsword");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}
