package com.ryz2593.happy.enums;

/**
 * @author ryz2593
 * @date 2020/4/2 16:42
 */
public enum ErrorCodeEnum {
    SUCCESS(0, "success"),
    FAIL(-1,"fail");

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ErrorCodeEnum getErrorCodeEnum(int code) {
        ErrorCodeEnum[] values = ErrorCodeEnum.values();
        for (ErrorCodeEnum errorCodeEnum : values) {
            if (errorCodeEnum.getCode() == code) {
                return errorCodeEnum;
            }
        }
        return null;
    }

    public static String getMsg(int code) {
        ErrorCodeEnum[] values = ErrorCodeEnum.values();
        for (ErrorCodeEnum errorCodeEnum : values) {
            if (errorCodeEnum.getCode() == code) {
                return errorCodeEnum.getMsg();
            }
        }
        return null;
    }

}
