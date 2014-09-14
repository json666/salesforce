package com.bo.openlogics.sales.repository;

import com.bo.openlogics.sales.model.Clasif_Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by json on 7/09/14.
 */
public interface Clasif_MarcaRepository extends JpaRepository<Clasif_Marca,Long> {

    public Clasif_Marca findByCodigoMarca(String codigoMarca);

    public List<Clasif_Marca> findByDisabled(Boolean status);
}
