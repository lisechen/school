package com.chen.campus_trade.controller.admin;


import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dto.UserSearchDTO;
import com.chen.campus_trade.service.UserService;
import com.chen.campus_trade.util.PageDataResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: UserController
 * @Description: 系统用户管理
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/20 15:17
 */
@Controller
@RequestMapping("userManager")
public class UserManagerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userservice;


    /**
     * 功能描述: 登入系统
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/22 15:47
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpSession session) {
        logger.info("进行登陆");
        Map<String, Object> data = new HashMap();


        session.setAttribute("user", "name");
        data.put("code", 1);
        data.put("url", "/home");
        //data.put("message","登陆成功");
        logger.info("name" + "登陆成功");


        return data;
    }

    /**
     * 功能描述: 修改密码
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/22 17:26
     */
    @RequestMapping("setPwd")
    @ResponseBody
    public Map<String, Object> setP(String pwd, String isPwd) {
        logger.info("进行密码重置");
        Map<String, Object> data = new HashMap();
        if (!pwd.equals(isPwd)) {
            data.put("code", 0);
            data.put("message", "两次输入的密码不一致!");
            logger.error("两次输入的密码不一致!");
            return data;
        }

        data.put("code", 1);
        data.put("msg", "修改密码成功！");
        logger.info("用户修改密码成功！");
        return data;
    }

    /**
     * 功能描述: 跳到系统用户列表
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/21 13:50
     */
    @RequestMapping("/userManage")
    public String userManage() {
        return "/user/userManage";
    }

    /**
     * 功能描述: 分页查询用户列表
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getUserList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                      UserSearchDTO userSearch) {

        PageDataResult pdr = new PageDataResult();
        try {
            if (null == pageNum) {
                pageNum = 1;
            }
            if (null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = userservice.getUserList(userSearch, pageNum, pageSize);
            logger.info("用户列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return pdr;
    }


    /**
     * 功能描述: 新增和更新系统用户
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/22 10:14
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setUser(User user) {
        logger.info("设置用户[新增或更新]！user:" + user);
        Map<String, Object> data = new HashMap();
        if (user.getId() == null) {
//            data = userservice.addUser(user);
        } else {

            data.put("code", 1);
            data.put("msg", "修改成功！");
            logger.info("用户[新增]，结果=新增成功！");
            userservice.Update(user);
        }
        return data;
    }


    /**
     * 功能描述: 删除/恢复 用户
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/22 11:59
     */
    @RequestMapping(value = "/updateUserStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        logger.info("删除/恢复用户！id:" + id + " status:" + status);
        Map<String, Object> data = new HashMap<>();
        User user = new User();
        user.setId(id);
        user.setState(status);

        //删除用户
        userservice.Update(user);

        data.put("code", 1);
        if (status == 1) {
            data.put("msg", "恢复成功！");

        } else {
            data.put("msg", "删除成功！");

        }
        return data;
    }


}
