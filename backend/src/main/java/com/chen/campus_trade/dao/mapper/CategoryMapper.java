package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Category;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dto.UserSearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);
    List<Category> selectListByStatus(@Param("state") int code);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getList(String name);

}