package com.chen.campus_trade.vo;

import com.chen.campus_trade.dao.entity.Collect;

import java.util.Date;

public class  CollectVo extends Collect {
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
    private String name;

    private String desc;

    private String image;

    private Double price;

    private Date create_data;

    private Integer seller_id;

    private Date update_time;

    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreate_data() {
        return create_data;
    }

    public void setCreate_data(Date create_data) {
        this.create_data = create_data;
    }

    public Integer getseller_id() {
        return seller_id;
    }

    public void setUser_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
