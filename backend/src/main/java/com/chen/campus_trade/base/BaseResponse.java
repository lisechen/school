package com.chen.campus_trade.base;

/**
 * Created by chencc on 2020/4/6.
 */
public class BaseResponse<T> {
    int code;
    String msg;
    T data;
    int total;

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static BaseResponse success(Object data){
        return new BaseResponse(0, "SUCCESS", data);
    }
    public static BaseResponse fail(Object data){
        return new BaseResponse(-1, "FAIL", data);
    }

    public static BaseResponse failMsg(String msg){
        return new BaseResponse(-1, msg, null);
    }
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
