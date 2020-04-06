package com.chen.campus_trade.enums;

/**
 * Created by chencc on 2020/4/6.
 */
public enum UserStatus {
    ABLE(1),
    DISABLE(0)
    ;

    int code;

    UserStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
