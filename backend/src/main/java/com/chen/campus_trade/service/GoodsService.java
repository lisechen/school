package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.mapper.GoodsMapper;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.entity.GoodsExample;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.util.PageResult;
import com.chen.campus_trade.util.PageUtils;
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
