package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Sort;

public interface SortMapper {
    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
}