package com.ryz2593.happy.adapter_pattern.step4;

import com.ryz2593.happy.adapter_pattern.step1.MediaEnum;
import com.ryz2593.happy.adapter_pattern.step1.MediaPlayer;
import com.ryz2593.happy.adapter_pattern.step3.MediaAdapter;

/**
 * 步骤 4
 创建实现了 MediaPlayer 接口的实体类。
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase(MediaEnum.MP3.getDesc())){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase(MediaEnum.VLC.getDesc())
                || audioType.equalsIgnoreCase(MediaEnum.MP4.getDesc())){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
