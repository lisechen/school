package com.chen.campus_trade.controller;

import java.util.List;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chen.campus_trade.service.UserService;

@RestController
@RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
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

    /**
     * update 接口，按照用户的id进行update
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse<String> update(@RequestBody User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return BaseResponse.success("修改成功");
        } else {
            return BaseResponse.fail("修改失败");
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)

    public BaseResponse<User> insert(@RequestBody User user) {
        User userWithID = userservice.insertUser(user);
        return BaseResponse.success(userWithID);
    }

    /**
     * 查找所有的商品
     * @return
     */
    @RequestMapping("/selectall")
    @ResponseBody
    public BaseResponse<List<User>> ListUser() {

        List<User> userList = userservice.ListUser();
        return BaseResponse.success(userList);
    }

    /**
     * 判断某个用户是否存在，这里使用微信的nickname,理论上来讲是存在重复的风险的，实际开发中应该使用openId
     *
     * @param wechat_name
     * @return
     */
    @RequestMapping("/find")
    @ResponseBody
    public BaseResponse<User> selectByName(String wechat_name) {
        User user = userservice.selectByUserWeChatName(wechat_name);
        if (null == user) {
            return new BaseResponse<>(-1, "用户不存在", null);
        }
        return BaseResponse.success(user);
    }

    @RequestMapping(value = "/findpage")
    @ResponseBody
    public Object findPage(PageRequest pageQuery) {
        return userservice.findPage(pageQuery);
    }
}


