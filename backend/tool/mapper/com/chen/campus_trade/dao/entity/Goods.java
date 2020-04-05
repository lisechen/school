package com.chen.campus_trade.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String goodsname;

    private String textdesc;

    private String goodsLmg;

    private BigDecimal goodsPrice;

    private String goodsState;

    private String means;

    private Date create_time;

    private Integer user_id;

    private Date update_time;

    private String goodssort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getTextdesc() {
        return textdesc;
    }

    public void setTextdesc(String textdesc) {
        this.textdesc = textdesc == null ? null : textdesc.trim();
    }

    public String getGoodsLmg() {
        return goodsLmg;
    }

    public void setGoodsLmg(String goodsLmg) {
        this.goodsLmg = goodsLmg == null ? null : goodsLmg.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState == null ? null : goodsState.trim();
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means == null ? null : means.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getGoodssort() {
        return goodssort;
    }

    public void setGoodssort(String goodssort) {
        this.goodssort = goodssort == null ? null : goodssort.trim();
    }
}