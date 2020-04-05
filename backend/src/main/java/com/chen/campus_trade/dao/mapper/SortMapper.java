package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Sort;
import com.chen.campus_trade.dao.entity.SortExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SortMapper {
    long countByExample(SortExample example);

    int deleteByExample(SortExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sort record);

    int insertSelective(Sort record);

    List<Sort> selectByExample(SortExample example);

    Sort selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sort record, @Param("example") SortExample example);

    int updateByExample(@Param("record") Sort record, @Param("example") SortExample example);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
}