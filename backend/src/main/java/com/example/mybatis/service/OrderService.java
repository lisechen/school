package com.example.mybatis.service;

import com.example.mybatis.dao.OrderMapper;
import com.example.mybatis.entity.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mybatis.entity.Order;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> selectByOrderName(String name) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return orderMapper.selectByExample(example);
    }

    public List<Order> ListOrder() {
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);

    }

    public Order insertOrder(Order order) {
        orderMapper.insert(order);
        return order;
    }


    public int Update(Order order) {

        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public int delete(int id) {
        int a = orderMapper.deleteByPrimaryKey(id);
        return a;


    }

}
