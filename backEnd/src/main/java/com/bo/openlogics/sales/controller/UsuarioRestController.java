package com.bo.openlogics.sales.controller;


import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 28/09/14
 * Time: 0:49
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/login/{nombre_usuario}/{password}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult findUserAndPass(@PathVariable String nombre_usuario, @PathVariable String password) {
        try {
            return new JsonResult(true,"",usuarioService.existUserAndPass(nombre_usuario, password));
        } catch (Exception e) {
            return new JsonResult(false, e.getMessage());
        }
    }
}
