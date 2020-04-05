package com.example.mybatis.controller;

import com.example.mybatis.entity.Collect;
import com.example.mybatis.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/collect", method = {RequestMethod.GET, RequestMethod.POST})
public class CollectController {
    @Autowired
    private CollectService collectservice;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = collectservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Collect collect) {
        int result = collectservice.Update(collect);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Collect insert(Collect collect) {

        return collectservice.insertCollect(collect);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Collect> ListGoods() {
        return collectservice.ListCollect();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Collect> ListGoodsByname(String name) {
        return collectservice.selectByCollectName(name);
    }


}

