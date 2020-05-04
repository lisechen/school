package com.chen.campus_trade.service;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.dao.entity.User;
import com.chen.campus_trade.dao.mapper.GoodsMapper;
import com.chen.campus_trade.dao.mapper.UserMapper;
import com.chen.campus_trade.enums.GoodsStatus;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.util.PageResult;
import com.chen.campus_trade.util.PageUtils;
import com.chen.campus_trade.vo.GoodsDto;
import com.chen.campus_trade.vo.GoodsVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    public List<GoodsVo> findByName(String name) {

        String likeName = "%" + name + "%";
        List<Goods> goods= goodsMapper.selectByLikeName(likeName);
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (Goods good : goods) {
          GoodsVo vo =  new GoodsVo();
            BeanUtils.copyProperties(good,vo);
            User user= userMapper.selectByPrimaryKey(good.getUser_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
            goodsVos.add(vo);

        }
        return goodsVos;
    }

    public List<GoodsVo> findBySort(String category) {
        List<Goods> goods=  goodsMapper.selectByCategory(category);
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (Goods good : goods) {
            GoodsVo vo =  new GoodsVo();
            BeanUtils.copyProperties(good,vo);
            User user= userMapper.selectByPrimaryKey(good.getUser_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
            goodsVos.add(vo);

        }
        return goodsVos;
    }
    public List<GoodsVo> findByUser(Integer id) {
        List<Goods> goods=  goodsMapper.selectByUser(id);
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (Goods good : goods) {
            GoodsVo vo =  new GoodsVo();
            BeanUtils.copyProperties(good,vo);
            User user= userMapper.selectByPrimaryKey(good.getUser_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
            goodsVos.add(vo);

        }
        return goodsVos;
    }

    public GoodsVo  selectByPrimaryKey(Integer id) {
        Goods goods=  goodsMapper.selectByPrimaryKey(id);

            GoodsVo vo =  new GoodsVo();
            BeanUtils.copyProperties(goods,vo);
            User user= userMapper.selectByPrimaryKey(goods.getUser_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
        return vo;
    }

    public GoodsDto insertGoods(GoodsDto goods) {
       User user= goods.getUser();
      User old= userMapper.selectByPrimaryKey(user.getId());
      if (StringUtils.isBlank(old.getMobile())){
          userMapper.updateByPrimaryKeySelective(user);
      }
        goodsMapper.insertSelective(goods);
        return goods;
    }

    public List<GoodsVo> ListGoods() {
//        GoodsExample example = new GoodsExample();
        List<Goods> goods =goodsMapper.selectListByStatus(GoodsStatus.ABLE.getCode());
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (Goods good : goods) {
            GoodsVo vo =  new GoodsVo();
            BeanUtils.copyProperties(good,vo);
            User user= userMapper.selectByPrimaryKey(good.getUser_id());
            vo.setAvatar_url(user.getAvatar_url());
            vo.setUsername(user.getUsername());
            vo.setWechat_name(user.getWechat_name());
            goodsVos.add(vo);

        }
        return goodsVos;
    }

    public BaseResponse<List<Goods>> findPage(Integer pageNum , Integer pageSize) {
        int offset = (pageNum-1)*pageSize;
        List<Goods> goodsList = goodsMapper.selectPage(offset, pageSize);
        int total = goodsMapper.selectCount();
        int totalPage= (total+pageSize-1)/pageSize;
        BaseResponse<List<Goods>> res = BaseResponse.success(goodsList);
        res.setTotal(total);
        return  res;
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

    public BaseResponse<String> updateStatusByPk(Integer goodsId, Integer status) {
        int num = goodsMapper.updateStatusByPrimaryKey(goodsId, status);
        return BaseResponse.success(null);
    }
}
