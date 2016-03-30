package com.vector.image;

import org.junit.Test;

import java.io.IOException;

/**
 * author: vector.huang
 * date：2016/3/21 16:12
 */
public class ImageCreatorTest {


    private String src = "E:/1/1.png";
    private String out = "E:/1/2.png";
    private String empty = "E:/1/messages.properties";

    private String path = "e:/1/1/";

    @Test
    public void createdEmpty() throws IOException {
        ImageCreator.createdEmpty(out,100,100);
    }

    @Test
    public void createdRed() throws IOException {
        ImageCreator.createdRed(out,100,100);
    }
    @Test
    public void createdChar() throws IOException {
        ImageCreator.createdChar(path,100,100,100);
    }

}
