package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.entity.Order;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.GoodsMapper;
import com.chen.campus_trade.dao.mapper.OrderMapper;
import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.enums.OrderState;
import com.chen.campus_trade.vo.OrderDto;
import com.chen.campus_trade.vo.OrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Order> selectByOrderName(String name) {
//        OrderExample example = new OrderExample();
//        OrderExample.Criteria criteria = example.createCriteria();
//        criteria.andNameLike("%" + name + "%");
//        return orderMapper.selectByExample(example);
        String likeName = "%"+name+"%";
        return orderMapper.selectByLikeName(likeName);
    }

//    public List<Order> ListOrder() {
//        OrderExample example = new OrderExample();
//        return orderMapper.selectByExample(example);
//
//    }

    public List<OrderVo> findBySeller(Integer id) {
        List<Order> orders= orderMapper.selectBySeller(id);
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            OrderVo vo =  new OrderVo();
            BeanUtils.copyProperties(order,vo);
            Goods goods =goodsMapper.selectByPrimaryKey(order.getGoods_id());
            User user =userMapper.selectByPrimaryKey(order.getBuyer_id());
            vo.setImage(goods.getImage());
            vo.setMobile(user.getMobile());
            vo.setName(goods.getName());
            vo.setPrice(goods.getPrice());
            orderVos.add(vo);
        }
        return orderVos;
    }

    public List<OrderVo> findByBuyer(Integer id) {
        List<Order> orders= orderMapper.selectByBuyer(id);
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            OrderVo vo =  new OrderVo();
            BeanUtils.copyProperties(order,vo);
            Goods goods =goodsMapper.selectByPrimaryKey(order.getGoods_id());
            User user =userMapper.selectByPrimaryKey(order.getSeller_id());
            vo.setImage(goods.getImage());
            vo.setMobile(user.getMobile());
            vo.setName(goods.getName());
            vo.setPrice(goods.getPrice());
            orderVos.add(vo);

        }
        return orderVos;
    }


    public OrderDto insertOrder(OrderDto order) {
        User user= order.getUser();
        User old= userMapper.selectByPrimaryKey(user.getId());
        if (StringUtils.isBlank(old.getMobile())){
            userMapper.updateByPrimaryKeySelective(user);
        }
        orderMapper.insertSelective(order);
        return order;
    }

    public int Update(Order order) {

        return orderMapper.updateByPrimaryKeySelective(order);
    }
//
    public int delete(int id) {
        int a = orderMapper.updateStateByPrimaryKey(id, OrderState.DISABLE.getCode());

        return a;

    }

    public List<Order> listAll() {
        return orderMapper.selectAllByStatus(OrderState.ABLE.getCode());
    }
}
