package com.chen.campus_trade.util;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param page
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, int pageNum, int pageSize, int total, int totalPage, List<?> result) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(total);
        pageResult.setTotalPages(totalPage);
        pageResult.setContent(result);
        return pageResult;
    }
}