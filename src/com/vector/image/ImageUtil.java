package com.vector.image;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.imageio.plugins.png.PNGImageWriter;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * author: vector.huang
 * date：2016/3/21 10:41
 */
public class ImageUtil {

    /**
     * 无变形裁剪图片
     * 图片的比例 = maxWidth:maxHeight
     *
     * @param srcImagePath 读取图片路径
     * @param toImagePath  写入图片路径
     * @param maxWidth     最大的宽度
     * @param maxHeight    最大的高度
     * @throws IOException
     */
    public static void cropImage(String srcImagePath, //待处理的图片
                                 String toImagePath, //处理后保存的位置
                                 int maxWidth, //最大的宽度
                                 int maxHeight //最大的高度
    ) throws IOException {

        //读入文件
        File file = new File(srcImagePath);
        // 构造Image对象
        BufferedImage src = ImageIO.read(file);
        int width = src.getWidth();
        int height = src.getHeight();

        float expectRatio = (float) maxWidth / (float) maxHeight;//期望的比例
        float srcRatio = (float) width / (float) height;//资源的比例
        int cropX = 0, cropY = 0;
        int resultWidth = width, resultHeight = height;
        if (srcRatio > expectRatio) {
            //裁剪width
            resultWidth = (int) (height * expectRatio);
            cropX = (width - resultWidth) / 2;
        } else {
            //裁剪height
            resultHeight = (int) (width / expectRatio);
            cropY = (height - resultHeight) / 2;
        }

        //裁剪图片
        //①定义一个矩形
        Rectangle rect = new Rectangle(cropX, cropY, resultWidth, resultHeight);
        //②读取图片
        try (
                ImageInputStream inputStream =
                        ImageIO.createImageInputStream(new FileInputStream(srcImagePath));
        ) {
            Iterator<javax.imageio.ImageReader> iterator =
                    ImageIO.getImageReaders(inputStream);
            ImageReader reader = iterator.next();
            reader.setInput(inputStream, true);
            //③裁剪
            ImageReadParam param = reader.getDefaultReadParam();
            param.setSourceRegion(rect);
            BufferedImage cropSrc = reader.read(0, param);

            if (resultHeight > maxHeight) {
                resultHeight = maxHeight;
                resultWidth = maxWidth;
            }
            //创建一个空图片
            BufferedImage resultImage = new BufferedImage(resultWidth, resultHeight, BufferedImage.TYPE_INT_RGB);
            //写图片
            resultImage.getGraphics().drawImage(cropSrc, 0, 0, resultWidth, resultHeight, null);
            //保存图片
            ImageIO.write(resultImage, "jpeg", new File(toImagePath));
        }
    }

    /**
     * 按1:1 、jpeg格式保存图片
     *
     * @param srcInput    图片输入流
     * @param toImagePath 写入图片路径
     * @throws IOException
     */
    public static void saveImageToJpeg(InputStream srcInput,
                                       String toImagePath) throws IOException {
        // 构造Image对象
        BufferedImage src = ImageIO.read(srcInput);
        int width = src.getWidth();
        int height = src.getHeight();
        // 缩小边长
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 绘制 缩小  后的图片
        tag.getGraphics().drawImage(src, 0, 0, width, height, null);
        ImageIO.write(tag, "jpeg", new File(toImagePath));
    }

}