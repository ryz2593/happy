package com.ryz2593.happy.exception;

import com.ryz2593.happy.enums.ErrorCodeEnum;

/**
 * @author ryz2593
 * @date 2020/4/2 17:28
 */
public class BusinessException extends RuntimeException {
    private ErrorCodeEnum errorCodeEnum;
    private String msg;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String msg) {
        super(errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
        this.msg = msg;
    }

    public BusinessException(Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(cause);
        this.errorCodeEnum = errorCodeEnum;
    }

    public BusinessException(Throwable cause, ErrorCodeEnum errorCodeEnum, String msg) {
        super(cause);
        this.errorCodeEnum = errorCodeEnum;
        this.msg = msg;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
