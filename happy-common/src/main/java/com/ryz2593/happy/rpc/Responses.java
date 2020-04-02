package com.ryz2593.happy.rpc;

/**
 * @author ryz2593
 * @date 2020/4/2 16:32
 */
public class Responses<T> {
    private int code = 0;
    private String msg = "success";
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
