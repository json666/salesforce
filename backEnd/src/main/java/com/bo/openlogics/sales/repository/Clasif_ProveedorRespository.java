package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by json on 14/09/14.
 */
public interface Clasif_ProveedorRespository extends JpaRepository<Clasif_Proveedor, Long> {
    public Clasif_Proveedor findByNumeroDocumentoAndDisabled(String numero,Boolean status);

    public List<Clasif_Proveedor> findByDisabled(Boolean status);
}
