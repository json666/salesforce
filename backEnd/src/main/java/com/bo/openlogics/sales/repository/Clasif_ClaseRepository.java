package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_ClaseRepository extends JpaRepository<Clasif_Clase, Long> {
    public Clasif_Clase findById(Long id);

        @Query(value="SELECT cl FROM Clasif_Clase cl WHERE cl.disabled=false AND  cl.clasif_categoria.id=:idCategoria" )
    public List<Clasif_Clase> findByCategoriaAndDisabled(@Param("idCategoria") Long idCategoria);

    public Clasif_Clase findByDescripcionClase(String descripcion);
}