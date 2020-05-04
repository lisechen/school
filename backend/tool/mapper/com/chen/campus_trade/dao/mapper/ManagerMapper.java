package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Manager;

public interface ManagerMapper {
    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}