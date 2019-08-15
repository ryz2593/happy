package com.ryz2593.happy.adapter_pattern.step5;

import com.ryz2593.happy.adapter_pattern.step4.AudioPlayer;

/**
 * 步骤 5
 使用 AudioPlayer 来播放不同类型的音频格式。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
