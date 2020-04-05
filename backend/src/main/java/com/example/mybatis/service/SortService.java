package com.example.mybatis.service;

import com.example.mybatis.dao.SortMapper;
import com.example.mybatis.entity.Sort;
import com.example.mybatis.entity.SortExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SortService {
    @Autowired
    private SortMapper sortMapper;

    public List<Sort> ListSort() {
        SortExample example = new SortExample();
        return sortMapper.selectByExample(example);

    }

    public Sort insertSort(Sort order) {
        sortMapper.insert(order);
        return order;
    }


    public int Update(Sort sort) {

        return sortMapper.updateByPrimaryKeySelective(sort);
    }

    public int delete(int id) {
        int a = sortMapper.deleteByPrimaryKey(id);
        return a;

    }
}
