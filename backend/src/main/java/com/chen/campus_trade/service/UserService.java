package com.chen.campus_trade.service;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.enums.UserStatus;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.util.PageResult;
import com.chen.campus_trade.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public BaseResponse<List<User>> selectByUserName(String username) {
        String likeName = "%" + username + "%";
        List<User> uList = userMapper.selectByLikeName(likeName);
        return BaseResponse.success(uList);
    }

    public List<User> ListUser() {
        return userMapper.selectAll();

    }

    public User insertUser(User user) {
        User ifAlreadyExist = userMapper.selectByWechatId(user.getWechat_id());
        //如果已经存在就不用再插入了
        if (null != ifAlreadyExist) {
            return ifAlreadyExist;
        }
        user.setWechat_id(user.getWechat_id());
        userMapper.insertSelective(user);
        return user;
    }


    public int Update(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }

    public BaseResponse disableByPk(Integer uid) {

      int result=  userMapper.updateStatusByPrimaryKey(uid, UserStatus.DISABLE.getCode());
        if (result >= 1) {
            return BaseResponse.success(null) ;
        } else {
            return BaseResponse.failMsg("禁用失败");
        }
    }

    public BaseResponse enableByPk(Integer uid) {

        int result=  userMapper.updateStatusByPrimaryKey(uid, UserStatus.ABLE.getCode());
        if (result >= 1) {
            return BaseResponse.success(null) ;
        } else {
            return BaseResponse.failMsg("解禁失败");
        }
    }
//
//    public int delete(int id) {
//        int a = userMapper.deleteByPrimaryKey(id);
//        return a;
//    }

    public BaseResponse<List<User>> findPage(Integer pageNum, Integer pageSize) {
        int offset = (pageNum-1)*pageSize;
        List<User> userList = userMapper.selectPage(offset, pageSize);
        int total = userMapper.count();
        BaseResponse<List<User>> res = BaseResponse.success(userList);
        res.setTotal(total);
        return  res;
    }

    /*
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageResult getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        int offset = (pageNum - 1) * pageSize;
        List<User> result = userMapper.selectPage(offset, pageSize);
        int total = userMapper.count();
        int totalPages = total / pageSize;
        return PageUtils.getPageResult(pageRequest, pageNum, pageSize, total, totalPages, result);
    }


    /**
     * 软删除
     * @param id
     * @return
     */
    public int delete(int id) {
      return   userMapper.updateStatusByPrimaryKey(id, UserStatus.DISABLE.getCode());
    }

    public User selectByUserWeChatName(String name) {
        return userMapper.selectByWechatName(name);
    }

    public User selectByUserWeChatId(String name) {
        return userMapper.selectByWechatId(name);
    }

    public User  selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}





