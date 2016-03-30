package com.vector.image;

import java.awt.Color;
import java.awt.Font;
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

    public static void createdChar(String pathname,int num, int width, int height) throws IOException {

        char[] nums = new char[]{'0','1','2','3','4','5','6','7','8','9'};

        for(int i=0;i<num;i++){
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics graphics = bi.getGraphics();
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("微软雅黑",Font.BOLD,30));
            graphics.drawChars(nums,(i/10)%10,1,35,62);
            graphics.drawChars(nums,i%10,1,55,62);
            graphics.drawRect(0,0,width-1,height-1);
            ImageIO.write(bi, "png", new File(pathname+i+".png"));
        }

    }


}
