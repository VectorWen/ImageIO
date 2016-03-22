package com.vector.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * author: vector.huang
 * date：2016/3/21 16:07
 */
public class ImageCreator {

    /**
     * 创建一些图片来玩玩
     */

    public static void createdEmpty(String pathname, int width, int height) throws IOException {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(bi, "png", new File(pathname));
    }

    public static void createdRed(String pathname, int width, int height) throws IOException {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = bi.getGraphics();
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,width-1,height-1);
        ImageIO.write(bi, "png", new File(pathname));
    }




}
