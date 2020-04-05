package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Order;
import com.chen.campus_trade.dao.entity.OrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}