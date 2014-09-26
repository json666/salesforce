package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.beans.ArticuloBean;
import com.bo.openlogics.sales.beans.parametricas.*;
import com.bo.openlogics.sales.dozer.UtilTransport;
import com.bo.openlogics.sales.model.*;
import com.bo.openlogics.sales.repository.*;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by json on 12/09/14.
 */

@Service
public class Clasif_ArticuloServiceImpl implements Clasif_ArticuloService {
    @Autowired
    Clasif_ArticuloRepository clasif_articuloRepository;

    @Autowired
    Clasif_UnidadRepository clasif_unidadRepository;

    @Autowired
    Clasif_MarcaRepository clasif_marcaRepository;

    @Autowired
    Clasif_ClaseRepository clasif_claseRepository;

    @Autowired
    Clasif_CategoriaRepository clasif_categoriaRepository;

    @Autowired
    UtilTransport utilTransport;


    private Logger logger = Logger.getLogger(Clasif_ArticuloServiceImpl.class);

    @Override
    public void save(Clasif_Articulo clasif_articulo) {
        try{
            Clasif_Articulo clasifArticulo=null;
            Clasif_Unidad clasifUnidad=null;
            Clasif_Clase clasifClase=null;
            Clasif_Categoria clasifCategoria=null;
            Clasif_Marca clasifMarca=null;

            clasifArticulo=clasif_articuloRepository.findByCodigoArticulo(clasif_articulo.getCodigoArticulo());
            if(clasifArticulo==null){
                if(clasif_articulo.getClasif_unidad()!=null){
                    System.out.println("ID UNIDAD:"+clasif_articulo.getClasif_unidad().getId());
                    clasifUnidad=clasif_unidadRepository.findOne(clasif_articulo.getClasif_unidad().getId());
                    clasif_articulo.setClasif_unidad(clasifUnidad);
                }

                if(clasif_articulo.getClasif_clase()!=null){
                    clasifClase=clasif_claseRepository.findById(clasif_articulo.getClasif_clase().getId());
                    clasif_articulo.setClasif_clase(clasifClase);
                }

                if(clasif_articulo.getClasif_marca()!=null){
                    clasifMarca=clasif_marcaRepository.findOne(clasif_articulo.getClasif_marca().getId());
                    clasif_articulo.setClasif_marca(clasifMarca);
                }

                if(clasif_articulo.getClasif_categoria()!=null){
                    clasifCategoria=clasif_categoriaRepository.findOne(clasif_articulo.getClasif_categoria().getId());
                    clasif_articulo.setClasif_categoria(clasifCategoria);
                }
                //clasif_articulo.setFechaDesde(new Date());
                clasif_articuloRepository.save(clasif_articulo);
            } else{
                logger.info("******Articulo ya esta registrado*******");
            }

        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public JsonResult listadoArticulosHabilitados() {
        try{
            JsonResult jsonResult=null;
            List<Clasif_Articulo> listadoArticulos=clasif_articuloRepository.findByDisabled();
            List<ArticuloHabilitadoBean> articuloBeans= new ArrayList<ArticuloHabilitadoBean>();
            if(listadoArticulos.size()>0){
                articuloBeans=utilTransport.convert(listadoArticulos,ArticuloHabilitadoBean.class);
                jsonResult= new JsonResult(true,"Consulta Exitosa.",articuloBeans);
            }else{
                jsonResult= new JsonResult(false,"No existen Datos.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @Override
    public JsonResult listadoArticulos() {
        ClaseBean claseBean=null;
        MarcaBean marcaBean=null;
        UnidadBean unidadBean=null;
        CategoriaBean categoriaBean=null;
        try{
            JsonResult jsonResult=null;
            List<Clasif_Articulo> listadoArticulos=clasif_articuloRepository.findByDisabled();
            List<ArticuloBean> articuloBeans= new ArrayList<ArticuloBean>();
            if(listadoArticulos.size()>0){
                ArticuloBean articuloBean=null;
                for (Clasif_Articulo articulo : listadoArticulos) {
                    claseBean= new ClaseBean(articulo.getClasif_clase().getId(),articulo.getClasif_clase().getDescripcionClase());
                    marcaBean=new MarcaBean(articulo.getClasif_marca().getId(),articulo.getClasif_marca().getDescripcionMarca());
                    unidadBean= new UnidadBean(articulo.getClasif_unidad().getId(),articulo.getClasif_unidad().getDescripcionUnidad());
                    logger.info("******Articulo2 *******");
                    categoriaBean=null;
                    categoriaBean= new CategoriaBean(articulo.getClasif_categoria().getId(),articulo.getClasif_categoria().getDescripcionCategoria());
                    logger.info("******Articulo 3*******");
                    articuloBean= new ArticuloBean(articulo.getId(),articulo.getDescripcionArticulo(),articulo.getCodigoArticulo(),
                            articulo.getMetodoCosto(),articulo.getPrecio(),articulo.getPrecioCosto(),
                            articulo.getUpc(),articulo.getNivelReorden(),articulo.getCantidadReorden(),
                            articulo.getnSerie(),articulo.getFotografia(),articulo.getFechaDesde(),articulo.getFechaHasta(),
                            articulo.getUsuarioAct(),claseBean,marcaBean,categoriaBean,unidadBean);
                    articuloBeans.add(articuloBean);
                    articuloBean=null;
                    marcaBean=null;
                    claseBean=null;
                    unidadBean= null;
                }
                //articuloBeans=utilTransport.convert(listadoArticulos,ArticuloBean.class);
                logger.info("******Articulo EXITOSA*******");
                jsonResult= new JsonResult(true,"Consulta Exitosa.",articuloBeans);
            }else{
                logger.info("******Articulo Error SIN DATOS*******");
                jsonResult= new JsonResult(false,"No existen Datos.",null);
            }
            return jsonResult;
        }catch(NullPointerException e){
            logger.info("******Articulo Error NULL*******");
            return new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            logger.info("******Articulo Error EXCEPTION*******");
            return new JsonResult(false,"Error: "+e.getMessage(),null);
        }
    }

    @Override
    public JsonResult editarArticulo(Clasif_Articulo clasif_articulo) {
        Clasif_Articulo clasifArticulo=null;
        Clasif_Unidad clasifUnidad=null;
        Clasif_Clase clasifClase=null;
        Clasif_Categoria clasifCategoria=null;
        Clasif_Marca clasifMarca=null;
        JsonResult jsonResult=null;
        try{
            clasifArticulo=clasif_articuloRepository.findOne(clasif_articulo.getId());
            if(clasifArticulo!=null){
                if(clasif_articulo.getClasif_unidad()!=null){
                    clasifUnidad=clasif_unidadRepository.findOne(clasif_articulo.getClasif_unidad().getId());
                    clasif_articulo.setClasif_unidad(clasifUnidad);
                }

                if(clasif_articulo.getClasif_clase()!=null){
                    clasifClase=clasif_claseRepository.findById(clasif_articulo.getClasif_clase().getId());
                    clasif_articulo.setClasif_clase(clasifClase);
                }

                if(clasif_articulo.getClasif_marca()!=null){
                    clasifMarca=clasif_marcaRepository.findOne(clasif_articulo.getClasif_marca().getId());
                    clasif_articulo.setClasif_marca(clasifMarca);
                }

                if(clasif_articulo.getClasif_categoria()!=null){
                    clasifCategoria=clasif_categoriaRepository.findOne(clasif_articulo.getClasif_categoria().getId());
                    clasif_articulo.setClasif_categoria(clasifCategoria);
                }
                //clasif_articulo.setFechaDesde(new Date());
                clasif_articuloRepository.save(clasif_articulo);
                jsonResult=new JsonResult(false,"El Articulo Seleccionado, fue actualizado satisfactoriamente.",null);
            } else{
                jsonResult=new JsonResult(false,"Articulo no Existe",null);
                logger.info("******Articulo no Existe*******");
            }

        }catch(NullPointerException e){
            e.printStackTrace();
            jsonResult=new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult(false,e.getMessage(),null);
        }
        return jsonResult;
    }

    @Override
    public JsonResult desabilitarArticulo(Long IdArticulo) {
        Clasif_Articulo clasifArticulo=null;
        Clasif_Unidad clasifUnidad=null;
        Clasif_Clase clasifClase=null;
        Clasif_Categoria clasifCategoria=null;
        Clasif_Marca clasifMarca=null;
        JsonResult jsonResult=null;
        Clasif_Articulo clasif_articulo=null;
        try{
            clasifArticulo=clasif_articuloRepository.findOne(IdArticulo);
            if(clasifArticulo!=null){
                clasifArticulo.setDisabled(true);
                clasifArticulo.setFechaHasta(new Date());
                clasif_articuloRepository.save(clasifArticulo);
                jsonResult=new JsonResult(false,"El Articulo Seleccionado, fue desabilitado satisfactoriamente.",null);
            } else{
                jsonResult=new JsonResult(false,"Articulo no Existe",null);
                logger.info("******Articulo no Existe*******");
            }

        }catch(NullPointerException e){
            e.printStackTrace();
            jsonResult=new JsonResult(false,e.getMessage(),null);
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult(false,e.getMessage(),null);
        }
        return jsonResult;
    }

    @Override
    public JsonResult getById(Long IdArticulo) throws Exception {
        JsonResult jsonResult = null;
        Clasif_Articulo clasifArticulo;
        try {
            /**
             * TODO: Logica de negocio para buscar Articulo por id
             */

            clasifArticulo = clasif_articuloRepository.findOne(IdArticulo);

            if (clasifArticulo != null){
                jsonResult=new JsonResult(true,"Articulo Seleccionado",clasifArticulo);
            }
            else{
                jsonResult=new JsonResult(false,"Articulo no Existe",null);
                logger.info("******Articulo no Existe*******");
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsonResult=new JsonResult(false,e.getMessage(),null);
        }
        return jsonResult;

    }
}
