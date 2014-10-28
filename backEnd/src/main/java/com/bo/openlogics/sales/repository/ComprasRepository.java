package com.bo.openlogics.sales.repository;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.AlmacenBean;
import com.bo.openlogics.sales.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 25/10/14.
 */
public interface ComprasRepository extends JpaRepository<Compras,Long> {

    /*@Query("SELECT new com.bo.openlogics.sales.beans.AlmacenBean(ar.id, ar.codigoArticulo,ar.descripcionArticulo,de.cantidadExistente)" +
            "FROM Clasif_Articulo ar," +
            " DetalleComprasArticulo de," +
            " Compras co" +
            " WHERE ar.id IN (" +
            " SELECT DISTINCT de.Clasif_Articulo.id" +
            " FROM Compras co," +
            " DetalleComprasArticulo de" +
            " WHERE co.id=de.Compras" +
            " AND co.clasif_bodega.id=:idBodega)" +
            " AND de.Clasif_Articulo=ar.id" +
            " AND co.id=de.Compras" +
            " AND co.clasif_bodega.id=:idBodega")*/

    /*@Query("SELECT new com.bo.openlogics.sales.beans.AlmacenBean(ar.id, ar.codigoArticulo,ar.descripcionArticulo,de.cantidadExistente)" +
            "FROM Clasif_Articulo ar," +
            " DetalleComprasArticulo de," +
            " Compras co" +
            " WHERE ar.id IN (" +
            " SELECT DISTINCT de.Clasif_Articulo.id" +
            " FROM DetalleComprasArticulo de JOIN de.compras co" +
            " WHERE co.clasif_bodega.id=:idBodega)" +
            " AND de.Clasif_Articulo=ar.id" +
            " AND co.id=de.Compras" +
            " AND co.clasif_bodega.id=:idBodega")
    public List<AlmacenBean> listaInventarioByBodega(@Param("idBodega") Long idBodega);*/
}
