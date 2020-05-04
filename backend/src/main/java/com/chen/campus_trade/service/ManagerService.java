package com.chen.campus_trade.service;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.Manager;
import com.chen.campus_trade.dao.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chencc on 2020/5/4.
 */
@Service
public class ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    public BaseResponse login(String name, String pass) {

        Manager manager = managerMapper.selectByName(name);
        if (null == manager) {
            return BaseResponse.failMsg("无相关用户");
        } else {
            String storePass = manager.getPassword();
            if (!storePass.equals(pass)) {
                return BaseResponse.failMsg("请输入正确的密码");
            } else {
                return BaseResponse.success("");
            }
        }
    }
}
