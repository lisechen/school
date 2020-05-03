package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Comment record);
    List<Comment> selectByGoods(@Param("goods_id") Integer id);
    int updateByPrimaryKey(Comment record);

}