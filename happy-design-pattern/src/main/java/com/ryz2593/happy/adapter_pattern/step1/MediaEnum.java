package com.ryz2593.happy.adapter_pattern.step1;

/**
 * @author ryz2593
 * @date 2019/8/14
 * @desc
 */
public enum MediaEnum {
    MP3(1, "mp3"),
    MP4(2, "mp4"),
    VLC(3, "vlc");

    private int code;
    private String desc;

    MediaEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MediaEnum getMediaEnum(int code) {
        MediaEnum[] values = values();
        MediaEnum[] var2 = values;
        int var3 = values.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            MediaEnum mediaEnum = var2[var4];
            if (mediaEnum.getCode() == code) {
                return mediaEnum;
            }
        }
        return null;
    }

    public static String getDesc(int code) {
        MediaEnum[] values = values();
        MediaEnum[] var2 = values;
        int var3 = values.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            MediaEnum mediaEnum = var2[var4];
            if (mediaEnum.getCode() == code) {
                return mediaEnum.getDesc();
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
