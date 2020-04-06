package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Collect;
import com.chen.campus_trade.dao.mapper.CollectMapper;
import com.chen.campus_trade.enums.CollectState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;

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
        collectMapper.insert(collect);
        return collect;
    }


    public int Update(Collect collect) {

        return collectMapper.updateByPrimaryKeySelective(collect);
    }

    public int delete(int id) {
        int a = collectMapper.updateStatusByPrimaryKey(id);
        return a;
    }

    public List<Collect> listAll() {
        return collectMapper.selectListAll(CollectState.ABLE.getCode());
    }
}
