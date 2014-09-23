package com.bo.openogics.test;

import com.bo.openlogics.sales.beans.parametricas.ProveedoreBean;
import com.bo.openlogics.sales.beans.parametricas.TipoMovimientoBean;
import com.bo.openlogics.sales.model.*;
import com.bo.openlogics.sales.repository.*;
import com.bo.openlogics.sales.service.*;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by json on 7/09/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TestRespository {

    @Autowired
    Clasif_UnidadRepository clasif_unidadRepository;
    @Autowired
    Clasif_MarcaRepository clasif_marcaRepository;

    @Autowired
    Clasif_MarcaService clasif_marcaService;

    @Autowired
    Clasif_UnidadService clasif_unidadService;

    @Autowired
    Clasif_CategoriaService clasif_categoriaService;

    @Autowired
    Clasif_ArticuloService clasif_articuloService;

    @Autowired
    Clasif_ClaseRepository clasif_claseRepository;

    @Autowired
    Clasif_ProveedorService clasif_proveedorService;

    @Autowired
    Clasif_MovimientoRepository clasif_movimientoRepository;

    @Autowired
    Clasif_ProveedorRespository clasif_proveedorRespository;

    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;

    @Autowired
    Bodega_ArticuloService bodega_articuloService;

    private Logger logger = Logger.getLogger(TestRespository.class);

    @Test
    public void saveMarca() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Clasif_Marca clasifMarca = new Clasif_Marca();
            clasifMarca.setCodigoMarca("002");
            clasifMarca.setDescripcionMarca("SAMSUNG");
            clasifMarca.setUsuarioAct("");

            clasifMarca.setFechaDesde(formatter.parse("07/09/2014"));
            clasif_marcaRepository.save(clasifMarca);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void saveMarcaII() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Clasif_Marca clasifMarca = new Clasif_Marca();
            clasifMarca.setCodigoMarca("001");
            clasifMarca.setDescripcionMarca("COCA COLA");
            clasifMarca.setUsuarioAct("");

            clasifMarca.setFechaDesde(formatter.parse("06/09/2014"));
            //clasif_marcaRepository.save(clasifMarca);
            clasif_marcaService.save(clasifMarca);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveUnidad() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Clasif_Unidad clasifUnidad = new Clasif_Unidad();

            clasifUnidad.setCodigoUnidad("001");
            clasifUnidad.setDescripcionUnidad("KILO");
            clasifUnidad.setUsuarioAct("");
            clasifUnidad.setFechaDesde(formatter.parse("06/09/2014"));
            clasif_unidadService.save(clasifUnidad);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveCategoria() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Clasif_Categoria clasifCategoria = new Clasif_Categoria();

            clasifCategoria.setFechaDesde(formatter.parse("06/09/2014"));
            clasifCategoria.setDescripcionCategoria("JOYAS");
            clasifCategoria.setUsuarioAct("");
            clasif_categoriaService.save(clasifCategoria);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void saveArticulo() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Clasif_Articulo clasifArticulo = new Clasif_Articulo();
            Clasif_Marca clasifMarca = clasif_marcaRepository.findByCodigoMarca("0001");
            Clasif_Unidad clasifUnidad = clasif_unidadRepository.findByCodigoUnidad("1001");
            Clasif_Clase clasifClase = clasif_claseRepository.findById(1L);
            clasifArticulo.setUsuarioAct("JSON");
            clasifArticulo.setCodigoArticulo("JOAN0.0.2");
            clasifArticulo.setCantidadReorden(3);
            clasifArticulo.setPrecio(15000.0);
            clasifArticulo.setMetodoCosto("250.0");
            clasifArticulo.setClasif_marca(clasifMarca);
            clasifArticulo.setClasif_clase(clasifClase);
            clasifArticulo.setClasif_unidad(clasifUnidad);
            clasifArticulo.setDescripcionArticulo("ANILLO RECTANGULAR");
            clasifArticulo.setFechaDesde(formatter.parse("11/09/2014"));
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonArt = ow.writeValueAsString(clasifArticulo);
            logger.info("******Articulo JSON*******");
            logger.info(jsonArt);
            System.out.println("ARTICULO:" + jsonArt);
            clasif_articuloService.save(clasifArticulo);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveProveedor() throws IOException {
        Clasif_Proveedor clasifProveedor = new Clasif_Proveedor();
        clasifProveedor.setContacto("carlos sanchez");
        clasifProveedor.setEmail("carlos@gmail.com");
        clasifProveedor.setDireccion("Ave. los leones nro. 5898 Alto Obreajes");
        clasifProveedor.setFax("2454545");
        clasifProveedor.setNombre("YANAPAX SRL");
        clasifProveedor.setTelefono("244441225");
        clasifProveedor.setNumeroDocumento("48484850001");
        clasifProveedor.setCuenta_p("10003232325");
        JsonResult jsonResult = null;
        jsonResult = clasif_proveedorService.save(clasifProveedor);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonArt = ow.writeValueAsString(clasifProveedor);
        System.out.println("JSON:" + jsonArt);
    }

    @Test
    public void saveBodega() {
        try {
            System.out.println("PROCESANDO..........");
            Bodega_articulo bodegaArticulo = new Bodega_articulo();
            Movimiento movimiento = new Movimiento();
            Clasif_Movimiento clasif_movimiento = new Clasif_Movimiento();
            clasif_movimiento = clasif_movimientoRepository.findOne(1l);
            Clasif_Proveedor clasif_proveedor = new Clasif_Proveedor();
            clasif_proveedor = clasif_proveedorRespository.findOne(1L);
            Clasif_Articulo clasif_articulo = clasif_articuloRepository.findOne(1L);
            movimiento.setClasif_proveedor(clasif_proveedor);
            movimiento.setClasif_movimiento(clasif_movimiento);
            movimiento.setEstado("ACTIVO");
            movimiento.setFecha(new Date());
            bodegaArticulo.setMovimiento(movimiento);


            bodegaArticulo.setClasif_articulo(clasif_articulo);
            bodegaArticulo.setCantidad("100");
            bodegaArticulo.setCostoTotal(10000.0);
            bodegaArticulo.setMonto(100.0);
            bodegaArticulo.setDescripcionBodega("BODEGA INICIAL");
            bodegaArticulo.setTipoBodega("GENERAL");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonArt = ow.writeValueAsString(bodegaArticulo);
            System.out.println("JSON:" + jsonArt);
            bodega_articuloService.adicionarBodegaArticulo(bodegaArticulo);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



    }


}
