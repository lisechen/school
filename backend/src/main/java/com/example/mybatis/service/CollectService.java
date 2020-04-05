package com.example.mybatis.service;

import com.example.mybatis.dao.CollectMapper;
import com.example.mybatis.entity.Collect;
import com.example.mybatis.entity.CollectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;

    public List<Collect> selectByCollectName(String name) {
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return collectMapper.selectByExample(example);
    }

    public List<Collect> ListCollect() {
        CollectExample example = new CollectExample();
        return collectMapper.selectByExample(example);

    }

    public Collect insertCollect(Collect collect) {
        collectMapper.insert(collect);
        return collect;
    }


    public int Update(Collect collect) {

        return collectMapper.updateByPrimaryKeySelective(collect);
    }

    public int delete(int id) {
        int a = collectMapper.deleteByPrimaryKey(id);
        return a;
    }
}
