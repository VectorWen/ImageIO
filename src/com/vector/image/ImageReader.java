package com.vector.image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 * author: vector.huang
 * date：2016/3/21 16:32
 */
public class ImageReader {

    public static int[] getWH(String pathname) throws IOException {
        int[] wh = new int[2];
        BufferedImage bi = ImageIO.read(new File(pathname));
        wh[0] = bi.getWidth();
        wh[1] = bi.getHeight();
        return wh;
    }

    public static ColorModel getColorModel(String pathname) throws IOException {
        BufferedImage bi = ImageIO.read(new File(pathname));
        return bi.getColorModel();
    }

    public static String getImageFormat(String pathname) throws IOException {
        try (
                ImageInputStream inputStream = ImageIO.createImageInputStream(new File(pathname));
        ) {
            Iterator<javax.imageio.ImageReader> iterator =
                    ImageIO.getImageReaders(inputStream);
            javax.imageio.ImageReader reader = iterator.next();
            return reader.getFormatName();
        }
    }

}
