package com.chen.campus_trade.service;

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

    public List<User> selectByUserName(String username) {
        String likeName = "%" + username + "%";
        return userMapper.selectByLikeName(likeName);
    }

    public List<User> ListUser() {
        return userMapper.selectAll();

    }

    public User insertUser(User user) {
        User ifAlreadyExist = userMapper.selectByWechatName(user.getWechat_name());
        //如果已经存在就不用再插入了
        if (null != ifAlreadyExist) {
            return ifAlreadyExist;
        }
        user.setUsername(user.getWechat_name());
        userMapper.insertSelective(user);
        return user;
    }


    public int Update(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }
//
//    public int delete(int id) {
//        int a = userMapper.deleteByPrimaryKey(id);
//        return a;
//    }

    public PageResult findPage(PageRequest pageRequest) {
//        return PageUtils.getPageResult(pageRequest, g);
        return getPageInfo(pageRequest);
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
}





