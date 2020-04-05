package com.chen.campus_trade.controller;

import com.chen.campus_trade.dao.entity.Comment;
import com.chen.campus_trade.service.CommentService;
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
    private CommentService commentService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = commentService.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Comment comment) {
        int result = commentService.Update(comment);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Comment insert(Comment comment) {
        return commentService.insertComment(comment);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<Comment> ListComment() {
        return commentService.ListComment();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Comment> ListCommentByname(String name) {
        return commentService.selectByName(name);
    }


}

