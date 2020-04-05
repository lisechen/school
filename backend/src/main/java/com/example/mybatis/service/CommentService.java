package com.example.mybatis.service;

import com.example.mybatis.dao.CommentMapper;
import com.example.mybatis.entity.Comment;
import com.example.mybatis.entity.CommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> selectByName(String name) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andContentLike("%" + name + "%");
        return commentMapper.selectByExample(example);
    }

    public List<Comment> ListComment() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);

    }

    public Comment insertComment(Comment comment) {
        commentMapper.insert(comment);
        return comment;
    }


    public int Update(Comment comment) {

        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    public int delete(int id) {
        int a = commentMapper.deleteByPrimaryKey(id);
        return a;


    }
}
