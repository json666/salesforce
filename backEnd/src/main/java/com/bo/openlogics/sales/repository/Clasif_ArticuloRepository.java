package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ArticuloRepository extends JpaRepository<Clasif_Articulo, Long> {

    public Clasif_Articulo findByCodigoArticulo(String codigoArticulo);
}
