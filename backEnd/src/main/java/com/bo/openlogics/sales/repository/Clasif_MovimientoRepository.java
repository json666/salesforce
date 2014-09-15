package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by json on 15/09/14.
 */
public interface Clasif_MovimientoRepository extends JpaRepository<Clasif_Movimiento,Long> {

    @Query(value="SELECT cm FROM Clasif_Movimiento cm WHERE cm.disabled=false" )
    public List<Clasif_Movimiento> findBydisabled ();
}
