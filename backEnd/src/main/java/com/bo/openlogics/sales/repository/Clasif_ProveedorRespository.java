package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 14/09/14.
 */
public interface Clasif_ProveedorRespository extends JpaRepository<Clasif_Proveedor, Long> {
    public Clasif_Proveedor findByNumeroDocumentoAndDisabled(String numero,Boolean status);

    public List<Clasif_Proveedor> findByDisabled(Boolean status);

    @Query(value="SELECT cp FROM Clasif_Proveedor cp WHERE cp.numeroDocumento=:numeroDocumento and cp.disabled=FALSE")
    public Clasif_Proveedor findByCodigoProveedor(@Param("numeroDocumento")String numeroDocumento);
}
