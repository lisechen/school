package com.example.mybatis.controller;

import java.util.List;

import com.example.mybatis.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
@RestController
@RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController{
    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userservice.insertUser(user);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public List<User> ListUser(){
        return userservice.ListUser();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<User> selectByname(String name){
        return userservice.selectByUserName(name);
    }

    @RequestMapping(value="/findpage")
    @ResponseBody
    public Object findPage( PageRequest pageQuery) {
        return userservice.findPage(pageQuery);
    }
}


