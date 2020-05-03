package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.Collect;
import com.chen.campus_trade.service.CollectService;
import com.chen.campus_trade.vo.CollectVo;
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
    @RequestMapping("/selectbyuser")
    @ResponseBody
    public BaseResponse<List<CollectVo>> ListGoodsByUser(Integer user_id)
    {
        List<CollectVo> goodsList = collectservice.findByUser(user_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Collect> ListGoods() {
        return collectservice.listAll();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Collect> ListGoodsByname(String name) {
        return collectservice.selectByCollectName(name);
    }


}

