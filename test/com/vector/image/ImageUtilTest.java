package com.vector.image;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.javafx.iio.ImageStorage;

import org.junit.Test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * author: vector.huang
 * date：2016/3/21 11:10
 */
public class ImageUtilTest {

    private String src = "E:/1/4.png";
    private String empty = "E:/1/empty.png";
    private String out = "E:/1/2.png";
    private String gif = "E:/1/gif.gif";

    @Test
    public void cropImage() throws IOException {
        ImageUtil.cropImage(src,out,400,300);
    }
    @Test
    public void saveImage() throws IOException {
        ImageUtil.saveImageToJpeg(new FileInputStream(src),out);
    }

}
