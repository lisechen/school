package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> selectLike(@Param("like_name") String likeCollect);

    int updateStatusByPrimaryKey(int id);

    List<Collect> selectListAll(@Param("state") int state);
}