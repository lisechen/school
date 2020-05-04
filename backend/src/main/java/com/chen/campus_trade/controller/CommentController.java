package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.Comment;
import com.chen.campus_trade.service.CommentService;
import com.chen.campus_trade.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comment", method = {RequestMethod.GET, RequestMethod.POST})
public class CommentController {
    @Autowired
    private CommentService commentservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping("/selectbygoods")
    @ResponseBody
    public BaseResponse<List<CommentVo>> ListGoodsByBuyer(Integer goods_id)
    {
        List<CommentVo> goodsList = commentservice.findByGoods(goods_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Comment comment) {
        int result = commentservice.Update(comment);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Comment insert(Comment comment) {
        return commentservice.insertComment(comment);
    }


    @RequestMapping("/selectbyid")
    @ResponseBody
    public Comment ListCommentByname(int id ) {
        return commentservice.selectByPrimaryKey(id);
    }

    /*@RequestMapping("/selectbyuser")
    @ResponseBody
    public BaseResponse<List<CommentVo>> ListGoodsByUser(Integer goods_id)
    {
        List<CommentVo> goodsList = commentservice.findByUser(goods_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }*/
}

