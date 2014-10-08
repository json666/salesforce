package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ArticuloRepository extends JpaRepository<Clasif_Articulo, Long> {
    @Query(value="SELECT ca FROM Clasif_Articulo ca WHERE ca.codigoArticulo=:codigoArticulo and ca.disabled=FALSE")
    public Clasif_Articulo findByCodigoArticulo(@Param("codigoArticulo")String codigoArticulo);

    @Query(value="SELECT ca FROM Clasif_Articulo ca WHERE ca.disabled=FALSE")
    public List<Clasif_Articulo> findByDisabled();
}
