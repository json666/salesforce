package com.bo.openlogics.sales.barcode.impl;


import com.bo.openlogics.sales.barcode.BarCodeGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.*;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;


public class BarCodeGeneratorImpl implements BarCodeGenerator {

    private String data = "";//LectorArchivosProperties.APPLICATION_URL_SPF_SERVICE + "saludo/usuario";

    private Integer width = 200;

    private Integer height = 180;

    /**
     * Constructor generico
     */
    public BarCodeGeneratorImpl() {
    }

    /**
     * Constructor parametrico
     *
     * @param data Datos contenidos en el QRCode
     */
    public BarCodeGeneratorImpl(String data) {
        this.data = data;
    }

    /**
     * Constructor parametrico
     *
     * @param data   Datos contenidos en el QRCode
     * @param width  Ancho del BarCode
     * @param height Alto del BarCode
     */
    public BarCodeGeneratorImpl(String data, Integer width, Integer height) {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    /**
     * Dibuja el BarCode en el outputStream proporcionado
     *
     * @return Output Stream del Bar Code
     * @throws Exception
     */
    @Override
    public ByteArrayOutputStream drawToOutputStream() throws Exception {
        return QRCode.from(data).to(ImageType.PNG).withSize(width, height).stream();
    }

    /**
     * Dibuja el BarCode en un archivo de imagen
     *
     * @param fileName Nombre del archivo de imagen
     * @throws Exception
     */
    @Override
    public void drawToFile(String fileName) throws Exception {
        generateBarCode(new File(fileName), data, width, height);
    }

    /**
     * Generar archivo con Bar Code
     *
     * @param imageFile Archivo de imagen
     * @param input     Data del Bar Code
     */
    private void generateBarCode(File imageFile, String input, Integer width, Integer height) {

        BitMatrix mtx;
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Code128Writer writer= new Code128Writer();
        try {
            mtx = writer.encode(input, BarcodeFormat.CODE_128, width, height,hints);
        } catch (WriterException e) {
            return;
        }

        if (mtx != null) {
            BufferedImage image = MatrixToImageWriter.toBufferedImage(mtx);
            try {

                ImageIO.write(image, "png", imageFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
