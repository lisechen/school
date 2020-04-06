package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Sort;
import com.chen.campus_trade.dao.mapper.SortMapper;
import com.chen.campus_trade.enums.SortState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SortService {
    @Autowired
    private SortMapper sortMapper;

    public List<Sort> ListSort() {
        return sortMapper.selectList();

    }

    public Sort insertSort(Sort order) {
        sortMapper.insert(order);
        return order;
    }


    public int Update(Sort sort) {

        return sortMapper.updateByPrimaryKeySelective(sort);
    }

    public int delete(int id) {
        int a = sortMapper.updateStatusByPrimaryKey(id, SortState.DISABLE.getCode());
        return a;

    }
}
