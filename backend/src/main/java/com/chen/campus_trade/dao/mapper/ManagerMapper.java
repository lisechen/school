package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    Manager selectByName(@Param("name") String name );

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}