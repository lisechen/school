package com.chen.campus_trade.controller;

import com.chen.campus_trade.base.BaseResponse;
import com.chen.campus_trade.enums.GoodsStatus;
import com.chen.campus_trade.util.PageRequest;
import com.chen.campus_trade.dao.entity.Goods;
import com.chen.campus_trade.service.GoodsService;
import com.chen.campus_trade.vo.GoodsDto;
import com.chen.campus_trade.vo.GoodsVo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    @RequestMapping(value = "/find_page")
    @ResponseBody
    public BaseResponse<List<Goods>> findPage(
            @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "size", defaultValue = "10") Integer size

    ) {
        return goodsservice.findPage(pageNum, size);
    }


    @RequestMapping(value = "/disable")
    public BaseResponse<String> disable(@RequestParam("id") Integer goodsId) {
        return goodsservice.updateStatusByPk(goodsId, GoodsStatus.DISABLE.getCode());
    }

    @RequestMapping(value = "/enable")
    public BaseResponse<String> enable(@RequestParam("id") Integer goodsId) {
        return goodsservice.updateStatusByPk(goodsId, GoodsStatus.ABLE.getCode());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse<GoodsDto> insert(@RequestBody GoodsDto goods) {
        Goods goodsRes = goodsservice.insertGoods(goods);
        return BaseResponse.success(goodsRes);
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public BaseResponse<List<GoodsVo>> ListGoods() {
        List<GoodsVo> goodsList = goodsservice.ListGoods();
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/select")
    @ResponseBody
    public BaseResponse<List<GoodsVo>> ListGoodsByname(String name) {
        List<GoodsVo> goodsList = goodsservice.findByName(name);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/selectbyuser")
    @ResponseBody
    public BaseResponse<List<GoodsVo>> ListGoodsByuser(Integer user_id) {
        List<GoodsVo> goodsList = goodsservice.findByUser(user_id);
        if (null == goodsList) {
            return new BaseResponse<>(-1, "商品不存在", null);
        }
        return BaseResponse.success(goodsList);
    }

    @RequestMapping("/selectbysort")
    @ResponseBody
    public BaseResponse<List<GoodsVo>> ListGoodsBysort(String goodssort) {
        List<GoodsVo> goodsList = goodsservice.findBySort(goodssort);
        return BaseResponse.success(goodsList);

    }


    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public BaseResponse<GoodsVo> selectByid(Integer id) {
        GoodsVo goods = goodsservice.selectByPrimaryKey(id);
        return BaseResponse.success(goods);

    }


    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, IOException {
        //String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = getString(file);

        Map<String, String> map = new HashMap<>();
        map.put("fileName", fileName);

        return fileName;

    }

    @ResponseBody
    @PostMapping("/uploadWeb")
    public Map uploadWeb(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, IOException {
        //String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = getString(file);

        Map<String, String> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        map.put("src", fileName);
        data.put("code", 0);
        data.put("data", map);


        return data;

    }

    private String getString(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        // String path = "G:/cll/learn/school/backend/src/main/resources/static/picture/goodsimg"+"/";
//        String path = "G:/cll/learn/school/backend/target/classes/static/picture/goodsimg"+"/";
        String path = "/Users/chen/study_resource/java_study_project/school/backend/src/main/resources/static/picture/category" + "/";
//        String path = "/Users/admin/work/10.temp_work/01.lan_work/school/backend"+"/";
        UUID uuid = UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        // String fileName = uuid.toString() + originalFilename;
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(path, fileName);
        File filepath = new File(path);
        if (!filepath.exists()) {
            filepath.mkdirs();
        }
        file.transferTo(dir);


        String path1 = "/Users/chen/study_resource/java_study_project/school/backend/target/classes/static/picture/category" + "/";
//        String path = "/Users/admin/work/10.temp_work/01.lan_work/school/backend"+"/";


//
        File dir1 = new File(path1, fileName);
        File filepath1 = new File(path1);
        if (!filepath1.exists()) {
            filepath1.mkdirs();
        }

        Files.copy(dir.toPath(), dir1.toPath());
        return fileName;
    }


}


