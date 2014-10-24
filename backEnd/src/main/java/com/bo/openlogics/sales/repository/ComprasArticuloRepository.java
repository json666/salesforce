package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Unidad;
import com.bo.openlogics.sales.model.Compras_articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by osanchez on 24/10/14.
 */
public interface ComprasArticuloRepository  extends JpaRepository<Compras_articulo,Long> {
}
