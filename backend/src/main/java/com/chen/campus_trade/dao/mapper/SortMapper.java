package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);

    List<Sort> selectList();

    int updateStatusByPrimaryKey(@Param("id") int id,@Param("state") int state);

}