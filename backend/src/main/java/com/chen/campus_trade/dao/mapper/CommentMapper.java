package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByLikeName(@Param("like_name") String likeName);

    int updateStateByPrimaryKey(@Param("id")int id, @Param("state") int code);

    List<Comment> selectAllByState(int code);
}