package com.chen.campus_trade.vo;

import com.chen.campus_trade.dao.entity.Goods;

public class GoodsVo  extends Goods {


    private String wechat_name;

    private String avatar_url;

    private String username;

    public String getWechat_name() {
        return wechat_name;
    }

    public void setWechat_name(String wechat_name) {
        this.wechat_name = wechat_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
