package com.example.mybatis.service;

import com.example.mybatis.dao.GoodsMapper;
import com.example.mybatis.entity.Goods;
import com.example.mybatis.entity.GoodsExample;
import com.example.mybatis.entity.User;
import com.example.mybatis.util.PageRequest;
import com.example.mybatis.util.PageResult;
import com.example.mybatis.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsService {

        @Autowired
        private GoodsMapper goodsMapper;

        public List<Goods> findByName(String name) {
        GoodsExample example = new GoodsExample();
                GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsnameLike("%" + name + "%");
        return goodsMapper.selectByExample(example);
    }
    public List<Goods> findBySort(String goodssort) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodssortLike(goodssort);
        return goodsMapper.selectByExample(example);
    }

        public Goods insertGoods(Goods goods) {
            goodsMapper.insert(goods);
            return goods;
        }
        public List<Goods> ListGoods(){
            GoodsExample example=new GoodsExample();
            return	goodsMapper.selectByExample(example);
        }

    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /*
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<Goods> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> sysMenus = goodsMapper.selectPage();
        return new PageInfo<Goods>(sysMenus);
    }
        public int Update(Goods goods){
            return goodsMapper.updateByPrimaryKeySelective(goods);
        }

        public int delete(int id){
            return goodsMapper.deleteByPrimaryKey(id);
        }

    }
