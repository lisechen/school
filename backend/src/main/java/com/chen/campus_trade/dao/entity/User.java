package com.chen.campus_trade.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String wechatId;

    private String wechatName;

    private String avatarUrl;

    private String username;

    private String mobile;

    private String gender;

    private Date createTime;

    private Date updateTime;

    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", wechatId='" + wechatId + '\'' +
                ", wechatName='" + wechatName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", state='" + state + '\'' +
                '}';
    }

}