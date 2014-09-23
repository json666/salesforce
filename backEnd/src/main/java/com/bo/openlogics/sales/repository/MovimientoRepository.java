package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by osanchez on 23/09/14.
 */
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
