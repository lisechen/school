package com.example.mybatis.controller;

import com.example.mybatis.entity.Sort;
import com.example.mybatis.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sort", method = {RequestMethod.GET, RequestMethod.POST})
public class SortController {

    @Autowired
    private SortService sortservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = sortservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Sort sort) {
        int result = sortservice.Update(sort);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Sort insert(Sort sort) {
        return sortservice.insertSort(sort);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Sort> ListSort() {
        return sortservice.ListSort();
    }

       /* @RequestMapping("/select")
        @ResponseBody
        public List<Sort> ListGoodsByname(String name){
            return sortservice..findByName(name);*/
}



