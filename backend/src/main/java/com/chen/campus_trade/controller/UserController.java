package com.chen.campus_trade.controller;

import java.util.*;

import com.chen.campus_trade.base.AjaxResult;
import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.util.Configure;
import com.chen.campus_trade.util.HttpUtil;
import com.chen.campus_trade.util.PageRequest;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chen.campus_trade.service.UserService;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/findid")
    @ResponseBody
    public BaseResponse<User> selectById(String id) {
        User user = userservice.selectByUserWeChatId(id);
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

    @PostMapping("/getopen")
    @ResponseBody
    public AjaxResult mini_Login(HttpServletRequest request, @Param("code") String code)
    {
        //String c=request.getParameter("code");//也可以通过此语句获取code值
        //System.out.println(code);
        AjaxResult res=new AjaxResult();///这里是自定义类，用于封装返回的数据，你可以用map替代
        String result="";
        try{//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + Configure.mini_appID + "&secret="
                            + Configure.mini_secret + "&js_code="
                            + code
                            + "&grant_type=authorization_code", null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(result);
        JSONObject jsonObj = JSONObject.fromObject(result);//解析从微信服务器上获取到的json字符串
        System.out.println("用户的openid为："+jsonObj.get("openid"));//此处也可以得到session_key的值
        res.put("session_key",jsonObj.get("session_key").toString());
        res.put("openid",jsonObj.get("openid").toString());
        User miniuser=userservice.selectByUserWeChatId(jsonObj.get("openid").toString());
//这里Miniuser类是自己的业务类，你可以根据自己需要自行定义
       //去数据库判断用户是否存在该用户

        //如果是新用户，就添加用户到数据库中
            return res;
    }
}


