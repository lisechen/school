package com.chen.campus_trade.controller.admin;


import com.chen.campus_trade.dao.entity.Category;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dto.UserSearchDTO;
import com.chen.campus_trade.service.CategoryService;
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
@RequestMapping("categoryManager")
public class CategoryManagerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private CategoryService categoryService;


    /**
     * 功能描述: 跳到系统用户列表
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/21 13:50
     */
    @RequestMapping("/categoryManage")
    public String userManage() {
        return "/category/manage";
    }

    /**
     * 功能描述: 分页查询用户列表
     *
     * @param:
     * @return:
     * @auther: youqing
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getCategoryList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getCategoryList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
                                      String name) {

        PageDataResult pdr = new PageDataResult();
        try {

            // 获取用户列表
            pdr = categoryService.getUserList(name, pageNum, pageSize);
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
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setUser(Category category) {
        logger.info("设置分类[新增或更新]！:category"+ category);
        Map<String, Object> data = new HashMap();
        data.put("code", 1);
        if (category.getId() == null) {
            categoryService.insertSort(category);
            data.put("msg", "添加成功！");
        } else {
            categoryService.Update(category);
            data.put("msg", "修改成功！");
            logger.info("分类[新增]，结果=新增成功！");

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
    @RequestMapping(value = "/updateCategoryStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        logger.info("删除/恢复用户！id:" + id + " status:" + status);
        Map<String, Object> data = new HashMap<>();
        User user = new User();
        user.setId(id);
        user.setState(status);

        //删除用户
//        userservice.Update(user);

        data.put("code", 1);
        if (status == 1) {
            data.put("msg", "恢复成功！");

        } else {
            data.put("msg", "删除成功！");

        }
        return data;
    }


}
