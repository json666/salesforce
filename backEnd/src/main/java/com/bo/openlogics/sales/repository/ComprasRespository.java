package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by osanchez on 24/10/14.
 */
public interface ComprasRespository extends JpaRepository<Compra, Long> {
}
