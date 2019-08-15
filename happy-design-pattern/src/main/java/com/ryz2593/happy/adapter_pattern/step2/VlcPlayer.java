package com.ryz2593.happy.adapter_pattern.step2;

import com.ryz2593.happy.adapter_pattern.step1.AdvancedMediaPlayer;

/**
 * 步骤 2
 创建实现了 AdvancedMediaPlayer 接口的实体类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
