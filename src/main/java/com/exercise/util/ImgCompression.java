package com.exercise.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

/**
 * @PROJECT_NAME: water_chivalry
 * @AUTHOR: Hanson-Hsc
 * @DATE: 2020-07-20 09:24
 * @DESCRIPTION: 图片压缩工具
 * @VERSION:
 */
public class ImgCompression {

    public static InputStream getImageCom(File file) throws Exception {
        //获取文件输入流
        InputStream inputStream = Files.newInputStream(file.toPath());
        try {
            // 把图片读入到内存中
            BufferedImage bufImg = ImageIO.read(inputStream);
            // 压缩代码,存储图片文件byte数组
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //防止图片变红,这一步非常重要
            BufferedImage bufferedImage = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics().drawImage(bufImg,0,0, Color.WHITE,null);
            //先转成jpg格式来压缩,然后在通过OSS来修改成源文件本来的后缀格式
            ImageIO.write(bufferedImage,"jpg",bos);
            //获取输出流
            inputStream = new ByteArrayInputStream(bos.toByteArray());
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("");
        }finally {
            inputStream.close();
        }
    }
}