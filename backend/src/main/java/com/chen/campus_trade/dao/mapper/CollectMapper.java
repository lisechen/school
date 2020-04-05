package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Collect;

public interface CollectMapper {
    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}