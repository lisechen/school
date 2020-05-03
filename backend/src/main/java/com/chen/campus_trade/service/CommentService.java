package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Comment;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.CommentMapper;
import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.enums.CommentState;
import com.chen.campus_trade.vo.CommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    public Comment selectByPrimaryKey(Integer id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment;
    }
    public List<CommentVo> findByGoods(Integer id) {
        List<Comment> comments= commentMapper.selectByGoods(id);
        List<CommentVo> commentVos = new ArrayList<>();
        for (Comment comment :comments) {
            CommentVo vo =  new CommentVo();
            BeanUtils.copyProperties(comment,vo);
            User user= userMapper.selectByPrimaryKey(comment.getUser_id());
            User reply= userMapper.selectByPrimaryKey(comment.getReply_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            if(reply!=null){
                vo.setReply_Avatar_url(reply.getAvatar_url());
                vo.setReply_username(reply.getUsername());
            }
            commentVos.add(vo);

        }
        return commentVos;
    }

  /*  public List<CommentVo> findByUser(Integer id) {
        List<Comment> comments= commentMapper.selectByBuyer(id);
        List<CommentVo> commentVos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentVo vo =  new CommentVo();
            BeanUtils.copyProperties(comment,vo);
            User user= userMapper.selectByPrimaryKey(comment.getSeller_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
        }
        return commentVos;
    }*/


    public Comment insertComment(Comment comment) {
        commentMapper.insertSelective(comment);
        return comment;
    }


    public int Update(Comment comment) {

        return commentMapper.updateByPrimaryKeySelective(comment);
    }


}
