/*
 *    ImageOperations.java
 *
 *    Created on 15-nov-2011
 *
 *    Clase con algunas operacones con imagenes
 *
 *    (C) 2003 - 2011
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 */
package com.bo.openlogics.sales.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author kenji
 */
public class ImageOperations {

    private double scale_rate;

    public ImageOperations() {
        scale_rate = 0.7;
    }

    public ImageOperations(float scale_rate) {
        this.scale_rate = scale_rate;
    }

    /*A partir de un byte[] obtiene el java.awt.Image correspondiente 
     * @param byte[]  image_bytes bytes del imagen
     * @param String imageFormat el formato de imagen
     * @return int con el id del registro
     */
    public Image getImage(byte[] image_bytes, String imageFormat) throws IOException, Exception {

        ByteArrayInputStream bis = new ByteArrayInputStream(image_bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName(imageFormat);
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        Image img = reader.read(0, param);
        return img;
    }

    /*A partir de un byte[] obtiene el java.awt.Image correspondiente 
     * @param byte[]  image_bytes bytes del imagen
     * @param boolean  isThumbnail si se quiere obrener la versi�n reducida del imagen
     * @param String imageFormat el formato de imagen
     * @return int con el id del registro
     */
    public BufferedImage getImage(byte[] imageInByte, boolean isThumbnail) throws IOException {
        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        if (isThumbnail) {
            bImageFromConvert = scale(bImageFromConvert, scale_rate);
        }
        return bImageFromConvert;
    }

    /* partir de un byte[] obtiene el java.awt.Image correspondiente 
     * @param byte[]  image_bytes bytes del imagen
     * @param boolean  isThumbnail si se quiere obrener la versi�n reducida del imagen
     * @param String imageFormat el formato de imagen
     * @return int con el id del registro
     */
    public BufferedImage getImage(BufferedImage bufferedImage, boolean isThumbnail) throws IOException {
        BufferedImage bImageFromConvert = null;

        if (isThumbnail) {
            bImageFromConvert = scale(bufferedImage, scale_rate);
        }
        return bImageFromConvert;
    }

    /*Crea una version reducida de un imagen
     * @param BufferedImage source imagen
     * @param int thumbWidth ancho de la version reducida
     * @param int thumbHeight altura de la version reducida
     * @return Image imagen reducida
     */
    private BufferedImage scale(BufferedImage source, double ratio) {
        int w = (int) (source.getWidth() * ratio);
        int h = (int) (source.getHeight() * ratio);
        BufferedImage bi = getCompatibleImage(w, h);
        Graphics2D g2d = bi.createGraphics();
        double xScale = (double) w / source.getWidth();
        double yScale = (double) h / source.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
        g2d.drawRenderedImage(source, at);
        g2d.dispose();
        return bi;
    }

    public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(
                image,
                new BufferedImage(width, height, image.getType()));
    }

    public static BufferedImage getScaledImage(byte[] imageInByte, int width, int height) throws IOException {

        InputStream in = new ByteArrayInputStream(imageInByte);
        try {
            BufferedImage bImageFromConvert = ImageIO.read(in);

            int imageWidth = bImageFromConvert.getWidth();
            int imageHeight = bImageFromConvert.getHeight();

            double scaleX = (double) width / imageWidth;
            double scaleY = (double) height / imageHeight;
            AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
            AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

            return bilinearScaleOp.filter(
                    bImageFromConvert,
                    new BufferedImage(width, height, bImageFromConvert.getType()));
        } finally {
            in.close();
        }
    }

    private BufferedImage getCompatibleImage(int w, int h) {
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //GraphicsDevice gd = ge.getDefaultScreenDevice();
        //GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        //BufferedImage image = gc.createCompatibleImage(w, h);
        return image;
    }
}
