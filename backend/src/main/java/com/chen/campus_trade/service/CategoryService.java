package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Category;
import com.chen.campus_trade.dao.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> ListCategory(int id) {
        return categoryMapper.selectListByStatus(id);
    }

    public Category insertSort(Category order) {
        categoryMapper.insertSelective(order);
        return order;
    }


    public int Update(Category sort) {

        return categoryMapper.updateByPrimaryKeySelective(sort);
    }

}
