package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by json on 14/09/14.
 */
public interface Clasif_ProveedorRespository extends JpaRepository<Clasif_Proveedor, Long> {
    public Clasif_Proveedor findByNumeroDocumentoAndDisabled(String numero,Boolean status);
}
