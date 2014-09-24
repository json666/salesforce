package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Bodega_articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by json on 24/09/14.
 */
public interface BodegaRepository extends JpaRepository<Bodega_articulo,Long> {
}
