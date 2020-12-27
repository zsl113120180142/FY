package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Zxhd;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.ZxhdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ZxhdController
 * @Description: 用于处理后台在线互动的请求
 * @Author: zsl
 * @Date: 2020/8/4 11:08
 * @Version: v1.0
 */
@Api(tags = "处理后台在线互动的请求")
@RestController
public class ZxhdController {
    @Autowired
    ZxhdService zxhdService;

    /**
     * @Description: deleteZxhd方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:56
     */

    @ApiOperation("互动删除")
    @DeleteMapping(value = "/deleteZxhd")
    public ResponseWrapper deleteZxhd(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = zxhdService.deleteZxhd(ids);
        return wrapper;
    }

    /**
     * @Description: updataZxhd方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:57
     */

    @ApiOperation("互动修改")
    @PutMapping(value = "/updataZxhd")
    public ResponseWrapper updataZxhd(Zxhd zxhd){
        ResponseWrapper wrapper = zxhdService.updataZxhd(zxhd);
        return wrapper;
    }

    /**
     * @Description: zxhdLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:57
     */

    @ApiOperation("互动模糊查询")
    @GetMapping(value = "/zxhdLike")
    public ResponseWrapper zxhdLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = zxhdService.zxhdLike(search,pn,category);
        return wrapper;
    }

}
