package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 28/09/14
 * Time: 0:42
 * To change this template use File | Settings | File Templates.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("select u from Usuario u where u.nombreUsuario = :nombre_usuario and u.password = :password and u.estado='AC'")
    public Usuario findUserAndPass(@Param("nombre_usuario") String nombre_usuario, @Param("password") String password);

}
