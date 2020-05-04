package com.chen.campus_trade.vo;

import com.chen.campus_trade.dao.entity.Comment;

public class CommentVo extends Comment {
    private String avatar_url;

    private String username;
    private String reply_avatar_url;

    private String reply_username;
    public String getAvatar_url() {
        return avatar_url;
    }

    public void setReply_Avatar_url(String reply_avatar_url) {
        this.reply_avatar_url = reply_avatar_url == null ? null : reply_avatar_url.trim();
    }

    public String getReply_Username() {
        return reply_username;
    }

    public void setReply_username(String reply_username) {
        this.reply_username = reply_username == null ? null: reply_username.trim();
    }

    public String getReply_Avatar_url() {
        return reply_avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url == null ? null : avatar_url.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null: username.trim();
    }
}
