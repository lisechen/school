package com.chen.campus_trade.dao.mapper;

import com.chen.campus_trade.dao.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int insert(Goods record);
    int insertSelective(Goods record);


    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectByLikeName(@Param("like_name") String likeName);
    List<Goods> selectByUser(@Param("user_id") Integer id);
    List<Goods> selectByCategory(@Param("category") String category);

    List<Goods> selectListByStatus(@Param("status") int code);

    List<Goods> selectPage( @Param("offset") int offset, @Param("size") int pageSize);

    int selectCount();

    int updateStatusByPrimaryKey(@Param("id")int id,@Param("status") int code);

}