package com.chen.campus_trade.controller;

import com.chen.campus_trade.dao.entity.Category;
import com.chen.campus_trade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sort", method = {RequestMethod.GET, RequestMethod.POST})
public class CategoryController {

    @Autowired
    private CategoryService categoryservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Category sort) {
        int result = categoryservice.Update(sort);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Category insert(Category sort) {
        return categoryservice.insertSort(sort);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Category> ListSort(int id) {
        return categoryservice.ListCategory(id);
    }

       /* @RequestMapping("/select")
        @ResponseBody
        public List<Sort> ListGoodsByname(String name){
            return sortservice..findByName(name);*/
}



