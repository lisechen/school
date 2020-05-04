package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chencc on 2020/5/4.
 */
@RestController
@RequestMapping(value = "/manager", method = {RequestMethod.GET, RequestMethod.POST})
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    @ResponseBody
    public BaseResponse login(
          @RequestParam("name") String name,
          @RequestParam("pass")  String pass
    ) {
        return managerService.login(name, pass);
    }

}
