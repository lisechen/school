package com.chen.campus_trade.controller;

import com.chen.campus_trade.dao.entity.Order;
import com.chen.campus_trade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order", method = {RequestMethod.GET, RequestMethod.POST})
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = orderService.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Order order) {
        int result = orderService.Update(order);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Order insert(Order order) {
        return orderService.insertOrder(order);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Order> ListOrder() {
        return orderService.ListOrder();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Order> ListOrderByname(String name) {
        return orderService.selectByOrderName(name);
    }

}
