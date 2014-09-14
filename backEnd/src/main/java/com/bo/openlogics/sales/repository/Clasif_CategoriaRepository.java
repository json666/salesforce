package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by json on 12/09/14.
 */
public interface Clasif_CategoriaRepository extends JpaRepository<Clasif_Categoria,Long> {

    public Clasif_Categoria findByDescripcionCategoria(String descripcion);
}
