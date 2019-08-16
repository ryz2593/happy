package com.ryz2593.happy.proxy_pattern.step2;

import com.ryz2593.happy.proxy_pattern.step1.Image;

/**
 * @author ryz2593
 * @date 2019/8/15
 * @desc
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading = " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
