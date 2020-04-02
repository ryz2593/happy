package com.ryz2593.happy.enums;

/**
 * @author ryz2593
 * @date 2020/4/2 16:42
 */
public enum ErrorCodeEnum {
    SUCCESS(0,"success");

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
