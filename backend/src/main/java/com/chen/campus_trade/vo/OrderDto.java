package com.chen.campus_trade.vo;

import com.chen.campus_trade.dao.entity.Order;
import com.chen.campus_trade.dao.entity.User;

public class OrderDto extends Order {

        private String mobile;
        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {

            this.mobile = mobile == null ? null : mobile.trim();
        }
        public User getUser(){
            User user= new User();
            user.setId(this.getBuyer_id());
            user.setMobile(this.getMobile());
            return  user;

        }
    }

