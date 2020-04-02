package com.ryz2593.happy.util;

import com.ryz2593.happy.enums.ErrorCodeEnum;
import com.ryz2593.happy.rpc.Responses;

/**
 * @author ryz2593
 * @date 2020/4/2 16:31
 */
public class ResponseUtil {

    public static Responses genSuccessResponse(Object data) {
        Responses responses = new Responses();
        responses.setData(data);
        return responses;
    }

    public static Responses genErrorResponse(int code, String msg) {
        Responses responses = new Responses();
        responses.setCode(code);
        responses.setMsg(msg);
        return responses;
    }

    public static Responses genErrorResponse(ErrorCodeEnum errorCodeEnum) {
        Responses responses = new Responses();
        responses.setCode(errorCodeEnum.getCode());
        responses.setMsg(errorCodeEnum.getMsg());
        return responses;
    }

    public static Responses genErrorResponse(ErrorCodeEnum errorCodeEnum, String message) {
        Responses responses = new Responses();
        responses.setCode(errorCodeEnum.getCode());
        responses.setMsg(errorCodeEnum.getMsg());
        if (message != null) {
            responses.setMsg(message);
        }
        return responses;
    }

}
