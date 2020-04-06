package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByLikeName(@Param("like_name")String likeName);

    List<User> selectAll();

    int count();

    List<User> selectPage(@Param("offset")int offset,@Param("size") int pageSize);

    int updateStatusByPrimaryKey(@Param("id")int id,@Param("status") int code);

    User selectByWechatName(@Param("name") String name);

}