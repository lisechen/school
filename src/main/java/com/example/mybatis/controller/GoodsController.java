package com.example.mybatis.controller;

import com.example.mybatis.entity.Goods;
import com.example.mybatis.service.GoodsService;
import com.example.mybatis.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String update(Goods goods) {
        int result = goodsservice.Update(goods);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Goods insert(Goods goods) {
        return goodsservice.insertGoods(goods);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Goods> ListGoods() {
        return goodsservice.ListGoods();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Goods> ListGoodsByname(String name) {
        return goodsservice.findByName(name);
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


