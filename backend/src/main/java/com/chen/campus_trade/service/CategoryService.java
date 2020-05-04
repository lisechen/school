package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Category;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.CategoryMapper;
import com.chen.campus_trade.dto.UserSearchDTO;
import com.chen.campus_trade.util.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public PageDataResult getUserList(String name, Integer pageNum, Integer pageSize){

        PageDataResult pageDataResult = new PageDataResult();
        List<Category> categories = categoryMapper.getList(name);

        PageHelper.startPage(pageNum, pageSize);

        if(categories.size() != 0){
            PageInfo<Category> pageInfo = new PageInfo<>();
            pageDataResult.setList(categories);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;

    };

}
