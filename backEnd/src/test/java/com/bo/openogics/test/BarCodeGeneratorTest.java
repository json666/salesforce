package com.bo.openogics.test;


import com.bo.openlogics.sales.barcode.BarCodeGenerator;
import com.bo.openlogics.sales.barcode.impl.BarCodeGeneratorImpl;
import com.bo.openlogics.sales.util.LectorArchivosProperties;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: esalamanca
 * Date: 28-03-14
 * Time: 12:26 PM
 * Test de creacion de QR codes.
 */
public class BarCodeGeneratorTest {

    @Test
    public void generarQRCode() {
        try {
            BarCodeGenerator BarCodeGenerator = new BarCodeGeneratorImpl("1ANILLO2014000001");

            BarCodeGenerator.drawToFile(LectorArchivosProperties.REPORTES_LOCAL_OUTPUT_FOLDER + "/barcode-qrcode-test.png","123456789KA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
