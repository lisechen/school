package com.chen.campus_trade.service;

import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.mapper.GoodsMapper;
import com.chen.campus_trade.enums.GoodsStatus;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.util.PageResult;
import com.chen.campus_trade.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> findByName(String name) {
//        GoodsExample example = new GoodsExample();
//                GoodsExample.Criteria criteria = example.createCriteria();

//        criteria.andGoodsnameLike("%" + name + "%");
//            return goodsMapper.selectByExample(example);
        String likeName = "%" + name + "%";
        return goodsMapper.selectByLikeName(likeName);
    }

    public List<Goods> findBySort(String category) {
//        GoodsExample example = new GoodsExample();
//        GoodsExample.Criteria criteria = example.createCriteria();
//        criteria.andGoodssortLike(goodssort);

        return goodsMapper.selectByCategory(category);
    }

    public Goods insertGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
        return goods;
    }

    public List<Goods> ListGoods() {
//        GoodsExample example = new GoodsExample();
        return goodsMapper.selectListByStatus(GoodsStatus.ABLE.getCode());
    }

    public PageResult findPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        int offset = (pageNum-1)*pageSize;
        List<Goods> goodsList = goodsMapper.selectPage(offset, pageSize);
        int total = goodsMapper.selectCount();
        int totalPage= (total+pageSize-1)/pageSize;

        return PageUtils.getPageResult(pageRequest, pageNum, pageSize, total, totalPage,goodsList);
    }

    /*
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
//    private PageInfo<Goods> getPageInfo(PageRequest pageRequest) {
//        int pageNum = pageRequest.getPageNum();
//        int pageSize = pageRequest.getPageSize();
//        PageHelper.startPage(pageNum, pageSize);
//        List<Goods> sysMenus = goodsMapper.selectPage(of);
//        return new PageInfo<Goods>(sysMenus);
//    }

    public int Update(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public int delete(int id) {
        return goodsMapper.updateStatusByPrimaryKey(id, GoodsStatus.DISABLE.getCode());
    }

}
