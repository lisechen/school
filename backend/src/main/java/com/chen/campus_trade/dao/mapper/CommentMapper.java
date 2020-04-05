package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Comment;
import com.chen.campus_trade.dao.entity.CommentExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}