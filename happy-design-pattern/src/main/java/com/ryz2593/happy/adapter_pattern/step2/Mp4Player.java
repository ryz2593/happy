package com.ryz2593.happy.adapter_pattern.step2;

import com.ryz2593.happy.adapter_pattern.step1.AdvancedMediaPlayer;

/**
 * 步骤 2
 创建实现了 AdvancedMediaPlayer 接口的实体类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
