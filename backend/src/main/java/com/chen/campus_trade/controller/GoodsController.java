package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goods", method = {RequestMethod.GET, RequestMethod.POST})
public class GoodsController {
    @Autowired
    private GoodsService goodsservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = goodsservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse<String> update(@RequestBody Goods goods) {
        int result = goodsservice.Update(goods);
        if (result >= 1) {
            return BaseResponse.success("修改成功");
        } else {
            return BaseResponse.fail("修改失败");
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public  BaseResponse<Goods>  insert(@RequestBody Goods goods) {
        Goods goodsRes = goodsservice.insertGoods(goods);
        return BaseResponse.success(goodsRes);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public BaseResponse<List<Goods>>  ListGoods() {
        List<Goods> goodsList = goodsservice.ListGoods();
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/select")
    @ResponseBody
    public BaseResponse<List<Goods>>  ListGoodsByname(String name)
    {
        List<Goods> goodsList = goodsservice.findByName(name);
        return BaseResponse.success(goodsList);
    }
    @RequestMapping("/selectbysort")
    @ResponseBody
    public List<Goods> ListGoodsBysort(String goodssort) {
        return goodsservice.findBySort(goodssort);
    }

    @RequestMapping(value = "/findpage")
    @ResponseBody
    public Object findPage(PageRequest pageQuery) {
        return goodsservice.findPage(pageQuery);
    }

}


