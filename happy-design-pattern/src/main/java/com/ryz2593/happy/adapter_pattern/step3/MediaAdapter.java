package com.ryz2593.happy.adapter_pattern.step3;

import com.ryz2593.happy.adapter_pattern.step1.AdvancedMediaPlayer;
import com.ryz2593.happy.adapter_pattern.step1.MediaEnum;
import com.ryz2593.happy.adapter_pattern.step1.MediaPlayer;
import com.ryz2593.happy.adapter_pattern.step2.Mp4Player;
import com.ryz2593.happy.adapter_pattern.step2.VlcPlayer;

/**
 * 步骤 3
 创建实现了 MediaPlayer 接口的适配器类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase(MediaEnum.VLC.getDesc()) ){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase(MediaEnum.MP4.getDesc())){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase(MediaEnum.VLC.getDesc())){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase(MediaEnum.MP4.getDesc())){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
