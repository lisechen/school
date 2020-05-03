package com.chen.campus_trade.service;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.GoodsMapper;
import com.chen.campus_trade.dao.entity.Collect;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.mapper.CollectMapper;
import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.enums.CollectState;
import com.chen.campus_trade.vo.CollectVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Collect> selectByCollectName(String name) {
//        CollectExample example = new CollectExample();
//        CollectExample.Criteria criteria = example.createCriteria();
//        criteria.andNameLike("%" + name + "%");
        String likeCollect = "%" + name + "%";
//        return collectMapper.selectByExample(example);
        return collectMapper.selectLike(likeCollect);
    }

//    public List<Collect> ListCollect() {
//        CollectExample example = new CollectExample();
//        return collectMapper.selectByExample(example);
//
//    }

    public Collect insertCollect(Collect collect) {
        collectMapper.insertSelective(collect);
        return collect;
    }

    public List<CollectVo> findByUser(Integer id) {
        List<Collect> collects= collectMapper.selectByUser(id);
        List<CollectVo> collectVos = new ArrayList<>();
        for (Collect collect : collects) {
            CollectVo vo =  new CollectVo();
            BeanUtils.copyProperties(collect,vo);
            Goods goods =goodsMapper.selectByPrimaryKey(collect.getGoods_id());
            User user= userMapper.selectByPrimaryKey(goods.getUser_id());
            vo.setDesc(goods.getDesc());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
            vo.setCreate_data(goods.getCreate_time());
            vo.setName(goods.getName());
            vo.setImage(goods.getImage());
            vo.setPrice(goods.getPrice());
            collectVos.add(vo);

        }
        return collectVos;
    }

    public int Update(Collect collect) {

        return collectMapper.updateByPrimaryKeySelective(collect);
    }

    public int delete(int id) {
        int a = collectMapper.updateStatusByPrimaryKey(id,CollectState.DISABLE.getCode());
        return a;
    }

    public List<Collect> listAll() {
        return collectMapper.selectListAll(CollectState.ABLE.getCode());
    }
}
