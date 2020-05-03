package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.service.GoodsService;
import com.chen.campus_trade.vo.GoodsDto;
import com.chen.campus_trade.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/goods", method = {RequestMethod.GET, RequestMethod.POST})
public class GoodsController {

    @Autowired
    private GoodsService goodsservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = goodsservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse<String> update(@RequestBody Goods goods) {
        int result = goodsservice.Update(goods);
        if (result >= 1) {
            return BaseResponse.success("修改成功");
        } else {
            return BaseResponse.fail("修改失败");
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public  BaseResponse<GoodsDto>  insert(@RequestBody GoodsDto goods) {
        Goods goodsRes = goodsservice.insertGoods(goods);
        return BaseResponse.success(goodsRes);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public BaseResponse<List<GoodsVo>>   ListGoods() {
        List<GoodsVo>   goodsList = goodsservice.ListGoods();
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/select")
    @ResponseBody
    public BaseResponse<List<GoodsVo>>  ListGoodsByname(String name)
    {
        List<GoodsVo> goodsList = goodsservice.findByName(name);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }
    @RequestMapping("/selectbyuser")
    @ResponseBody
    public BaseResponse<List<GoodsVo>>  ListGoodsByuser(Integer user_id)
    {
        List<GoodsVo> goodsList = goodsservice.findByUser(user_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/selectbysort")
    @ResponseBody
    public BaseResponse<List<GoodsVo>>  ListGoodsBysort(String goodssort) {
        List<GoodsVo> goodsList = goodsservice.findBySort(goodssort);
         return BaseResponse.success(goodsList);

    }



    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public BaseResponse<GoodsVo>  selectByid(Integer id) {
        GoodsVo goods = goodsservice.selectByPrimaryKey(id);
        return BaseResponse.success(goods);

    }

    @RequestMapping(value = "/findpage")
    @ResponseBody
    public Object findPage(PageRequest pageQuery) {
        return goodsservice.findPage(pageQuery);
    }


    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, IOException {
        //String path = request.getSession().getServletContext().getRealPath("upload");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
       // String path = "G:/cll/learn/school/backend/src/main/resources/static/picture/goodsimg"+"/";
        String path = "G:/cll/learn/school/backend/target/classes/static/picture/goodsimg"+"/";
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        // String fileName = uuid.toString() + originalFilename;
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(path, fileName);
        File filepath = new File(path);
        if(!filepath.exists()){
            filepath.mkdirs();
        }
        file.transferTo(dir);

        Map<String, String> map = new HashMap<>();
        map.put("fileName", fileName);

        return fileName;

    }



}


