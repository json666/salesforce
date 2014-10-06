package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.barcode.BarCodeGenerator;
import com.bo.openlogics.sales.barcode.impl.BarCodeGeneratorImpl;
import com.bo.openlogics.sales.model.Bodega_articulo;
import com.bo.openlogics.sales.model.Clasif_Articulo;
import com.bo.openlogics.sales.model.Clasif_Proveedor;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.Bodega_ArticuloService;
import com.bo.openlogics.sales.service.Clasif_ArticuloService;
import com.bo.openlogics.sales.service.Clasif_ProveedorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by json on 12/09/14.
 */

@Controller
@Transactional
public class SalesForceBarCodeRESTController {


    private Logger logger = Logger.getLogger(SalesForceBarCodeRESTController.class);

    /**
     *  Descripcion: Servicio que genera el codigo de Barras;
     */

    @RequestMapping(value = "/barCodeFromData/{data}", method = RequestMethod.GET)
    @ResponseBody
    public void getQRCodeFromData(HttpServletResponse response, @PathVariable String data) {
        try {

            //Generar el BarCode
            BarCodeGenerator barCodeGenerator = new BarCodeGeneratorImpl(data);
            ByteArrayOutputStream barCodeStream = barCodeGenerator.drawToOutputStream();

            response.setContentType("image/png");
            response.setContentLength(barCodeStream.size());
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            OutputStream outputStream = response.getOutputStream();
            outputStream.write(barCodeStream.toByteArray());
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
