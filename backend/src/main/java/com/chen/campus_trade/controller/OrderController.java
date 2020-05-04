package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.Order;
import com.chen.campus_trade.service.OrderService;
import com.chen.campus_trade.vo.OrderDto;
import com.chen.campus_trade.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/selectbybuyer")
    @ResponseBody
    public BaseResponse<List<OrderVo>> ListGoodsByBuyer(Integer buyer_id)
    {
        List<OrderVo> goodsList = orderService.findByBuyer(buyer_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/selectbyseller")
    @ResponseBody
    public BaseResponse<List<OrderVo>> ListGoodsByseller(Integer seller_id)
    {
        List<OrderVo> goodsList = orderService.findBySeller(seller_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public  BaseResponse<OrderDto>  insert(@RequestBody OrderDto order) {
        Order orderRes = orderService.insertOrder(order);
        return BaseResponse.success(orderRes);
    }
    @RequestMapping("/selectall")
    @ResponseBody
    public List<Order> ListOrder(){
        return orderService.listAll();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Order> ListOrderByname(String name) {
        return orderService.selectByOrderName(name);
    }

}
