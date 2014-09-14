package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Clase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ClaseRepository extends JpaRepository<Clasif_Clase, Long> {
    public Clasif_Clase findById(Long id);
}
