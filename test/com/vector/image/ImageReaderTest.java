package com.vector.image;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;

/**
 * author: vector.huang
 * date：2016/3/21 16:12
 */
public class ImageReaderTest {

    private String src = "E:/1/1.png";
    private String out = "E:/1/2.png";
    private String empty = "E:/1/empty.png";
    private String gif = "E:/1/gif.gif";

    @Test
    public void printWH() throws IOException {
        int[] wh = ImageReader.getWH(empty);
        System.out.println("width = "+ wh[0] +", height = "+ wh[1]);
    }

    @Test
    public void printColorModel() throws IOException {
        ColorModel model = ImageReader.getColorModel(src);
        System.out.println("ColorModel = " + model);
    }

    @Test
    public void printFormatName() throws IOException {
        String formatName = ImageReader.getImageFormat(gif);
        System.out.println("formatName = " + formatName);
    }

}
