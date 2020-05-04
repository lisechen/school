package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByLikeName(@Param("like_name") String likeName);
    List<Order> selectBySeller(@Param("seller_id") Integer id);
    List<Order> selectByBuyer(@Param("buyer_id") Integer id);

    int updateStateByPrimaryKey(@Param("id") int id,@Param("status") int code);

    List<Order> selectAllByStatus(@Param("status") int code);

}