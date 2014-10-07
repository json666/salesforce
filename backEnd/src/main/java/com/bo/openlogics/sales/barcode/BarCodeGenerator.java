package com.bo.openlogics.sales.barcode;

import java.io.ByteArrayOutputStream;


public interface BarCodeGenerator {

    /**
     * Dibuja el BarCode en el outputStream proporcionado
     *
     * @return Output Stream del Bar Code
     * @throws Exception
     */
    public ByteArrayOutputStream drawToOutputStream() throws Exception;

    /**
     * Dibuja el BarCode en un archivo de imagen
     *
     * @param fileName Nombre del archivo de imagen
     * @throws Exception
     */
    public void drawToFile(String fileName, String codigoArticulo) throws Exception;
}
