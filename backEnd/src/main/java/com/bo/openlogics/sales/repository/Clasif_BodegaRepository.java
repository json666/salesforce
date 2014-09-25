package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by osanchez on 25/09/14.
 */
public interface Clasif_BodegaRepository extends JpaRepository<Clasif_Bodega,Long> {

    @Query(value="SELECT cb FROM Clasif_Bodega cb WHERE cb.disabled=false ")
    List<Clasif_Bodega> findByDisabled();

}
