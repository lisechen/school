package com.chen.campus_trade.vo;

import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.entity.User;

public class GoodsDto extends Goods {
    private String mobile;
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile == null ? null : mobile.trim();
    }
    public User getUser(){
       User user= new User();
       user.setId(this.getUser_id());
       user.setMobile(this.getMobile());
       return  user;

    }
}
