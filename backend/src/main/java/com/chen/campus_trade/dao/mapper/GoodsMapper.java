package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Goods;

public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}