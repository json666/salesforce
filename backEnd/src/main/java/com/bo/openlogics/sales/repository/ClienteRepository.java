package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 26/10/14.
 */
public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    @Query(value="SELECT cli FROM Cliente cli WHERE cli.nroDocumento=:nroDocumento and cli.disabled=FALSE")
    public Cliente findByNroDocumento(@Param("nroDocumento")String nroDocumento);

    @Query(value="SELECT cli FROM Cliente cli WHERE cli.disabled=FALSE")
    public List<Cliente> findByDisabled();
}
