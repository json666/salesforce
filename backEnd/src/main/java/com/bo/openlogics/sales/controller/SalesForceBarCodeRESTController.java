package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.barcode.BarCodeGenerator;
import com.bo.openlogics.sales.barcode.impl.BarCodeGeneratorImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
