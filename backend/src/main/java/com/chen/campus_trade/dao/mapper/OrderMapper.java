package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}