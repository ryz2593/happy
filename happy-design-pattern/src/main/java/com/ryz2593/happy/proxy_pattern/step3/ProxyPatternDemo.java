package com.ryz2593.happy.proxy_pattern.step3;

import com.ryz2593.happy.proxy_pattern.step1.Image;
import com.ryz2593.happy.proxy_pattern.step2.ProxyImage;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.png");

        //图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
