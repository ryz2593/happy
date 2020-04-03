package com.ryz2593.happy.qrcode;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 二维码 添加 logo图标 处理的方法,
 * 模仿微信自动生成二维码效果，有圆角边框，logo和二维码间有空白区，logo带有灰色边框
 *
 * @author Administrator sangwenhao
 */
public class LogoConfig {

    /**
     * 设置 logo
     *
     * @param matrixImage 源二维码图片
     * @return 返回带有logo的二维码图片
     * @throws IOException
     * @author Administrator sangwenhao
     */
    public static BufferedImage LogoMatrix(BufferedImage matrixImage, URL url, int x, int y, int w, int h) throws IOException {
        /**
         * 读取二维码图片，并构建绘图对象
         */
        Graphics2D g2 = matrixImage.createGraphics();

//        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /**
         * 读取Logo图片
         */
        BufferedImage logo = ImageIO.read(url);

        Image image = logo.getScaledInstance(w, h,BufferedImage.SCALE_SMOOTH);
        //开始绘制图片
        g2.drawImage(image, x, y, w, h, null);//绘制

//        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
//        g2.setStroke(stroke);// 设置笔画对象
//        //指定弧度的圆角矩形
//        RoundRectangle2D.Float round = new RoundRectangle2D.Float(x, y, w, h, 10, 10);
//        Rectangle rectangle=new Rectangle(x, y, w, h);
//        g2.setColor(java.awt.Color.white);
//        g2.fillRect(x, y, w, h);// 绘制圆弧矩形
//
//        String lineOne = "什么鬼";
//
//        Color color = new Color(131,118,109);
//        g2.setColor(color);//设定文字颜色
//        g2.setFont(new Font("宋体", Font.BOLD, 30));
//        g2.drawString(lineOne, (int)245, (int)251);

//        g2.drawString("suqqu",x,y);
//
//        //设置logo 有一道灰色边框
//        BasicStroke stroke2 = new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
//        g2.setStroke(stroke2);// 设置笔画对象
//        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth/5*2+2, 0, matrixWidth/5-4, matrixHeigh/5-4,20,20);
//        g2.setColor(new Color(128,128,128));
//        g2.draw(round2);// 绘制圆弧矩形

        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }

}