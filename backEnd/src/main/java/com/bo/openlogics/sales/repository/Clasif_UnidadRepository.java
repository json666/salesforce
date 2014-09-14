package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by json on 7/09/14.
 */
public interface Clasif_UnidadRepository extends JpaRepository<Clasif_Unidad,Long> {
    public Clasif_Unidad findByCodigoUnidad(String codigoUnidad);
    public List<Clasif_Unidad> findByDisabled(Boolean status);
}
