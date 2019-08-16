package com.ryz2593.happy.proxy_pattern.step2;

import com.ryz2593.happy.proxy_pattern.step1.Image;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
