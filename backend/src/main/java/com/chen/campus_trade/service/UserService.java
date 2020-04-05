package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.entity.UserExample;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.util.PageResult;

import java.util.List;

import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectByUserName(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike("%" + username + "%");
        return userMapper.selectByExample(example);
    }

    public List<User> ListUser() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);

    }

    public User insertUser(User user) {
        userMapper.insert(user);
        return user;
    }


    public int Update(User user) {

        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int delete(int id) {
        int a = userMapper.deleteByPrimaryKey(id);
        return a;
    }

    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /*
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.selectPage();
        return new PageInfo<User>(sysMenus);
    }
        /*public List<User> selectByUserId(int id) {
            RcCustomerTagItemQuery query = new RcCustomerTagItemQuery();
            RcCustomerTagItemQuery.Criteria criteria = query.createCriteria();
            criteria.andTagIdEqualTo(tagId);
            List<RcCustomerTagItem> rcCustomerTagItems = rcCustomerTagItemMapper.selectByExample(query);
            return rcCustomerTagItems;
            public List<User> selectByUserId(int id) {
                UserExample example = new UserExample();
                UserExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(id);
                List<User> users = userMapper.selectByExample(example);
                return user;*/

}





