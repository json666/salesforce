package com.bo.openlogics.sales.repository;

import com.bo.openlogics.core.bean.JsonResult;
import com.bo.openlogics.sales.beans.AlmacenBean;
import com.bo.openlogics.sales.beans.ArticuloBeanStock;
import com.bo.openlogics.sales.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by json on 25/10/14.
 */
public interface ComprasRepository extends JpaRepository<Compras,Long> {


    @Query("SELECT new com.bo.openlogics.sales.beans.AlmacenBean(de.pk.clasif_articulo.id, de.pk.clasif_articulo.codigoArticulo,de.pk.clasif_articulo.descripcionArticulo,de.cantidadExistente,co.fechaRegistro,de.pk.clasif_articulo.precioCosto)" +
            "FROM DetalleComprasArticulo de JOIN de.pk.compras co" +
            " WHERE co.clasif_bodega.id=:idBodega")
    public List<AlmacenBean> listaInventarioByBodega(@Param("idBodega") Long idBodega);


    @Query("SELECT new com.bo.openlogics.sales.beans.ArticuloBeanStock(de.pk.clasif_articulo.id,de.pk.clasif_articulo.descripcionArticulo, de.pk.clasif_articulo.codigoArticulo, SUM(de.cantidadExistente), de.pk.clasif_articulo.precioCosto)" +
            "FROM DetalleComprasArticulo de JOIN de.pk.compras co" +
            " WHERE co.clasif_bodega.id=:idBodega" +
            " AND de.pk.clasif_articulo.codigoArticulo=:codArticulo" +
            " GROUP BY de.pk.clasif_articulo.id, de.pk.clasif_articulo.codigoArticulo, de.pk.clasif_articulo.descripcionArticulo,de.cantidadExistente, de.pk.clasif_articulo.descripcionArticulo,de.pk.clasif_articulo.precioCosto ")
    public ArticuloBeanStock listaArticuloCompraStock(@Param("idBodega") Long idBodega, @Param("codArticulo") String idArticulo );
}
