package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Comment;
import com.chen.campus_trade.dao.mapper.CommentMapper;
import com.chen.campus_trade.enums.CommentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> selectByName(String name) {
//        CommentExample example = new CommentExample();
//        CommentExample.Criteria criteria = example.createCriteria();
//        criteria.andContentLike("%" + name + "%");
        String likeName = "%"+name+"%";
//        return commentMapper.selectByExample(example);
        return commentMapper.selectByLikeName(likeName);
    }
//
//    public List<Comment> ListComment() {
//        CommentExample example = new CommentExample();
//        return commentMapper.selectByExample(example);
//
//    }

    public Comment insertComment(Comment comment) {
        commentMapper.insert(comment);
        return comment;
    }


    public int Update(Comment comment) {

        return commentMapper.updateByPrimaryKeySelective(comment);
    }


    public int delete(int id) {
        int a = commentMapper.updateStateByPrimaryKey(id, CommentState.DISABLE.getCode());
        return a;
    }

    public List<Comment> listAll() {
        return commentMapper.selectAllByState(CommentState.ABLE.getCode());
    }
}
