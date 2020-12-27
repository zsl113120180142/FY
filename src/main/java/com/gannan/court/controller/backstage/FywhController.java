package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Whzb;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.WhzbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: FywhController
 * @Description: 用于处理后台法院文化的请求
 * @Author: zsl
 * @Date: 2020/8/3 20:30
 * @Version: v1.0
 */
@Api(tags = "处理后台法院文化的请求")
@RestController
public class FywhController {
    @Autowired
    WhzbService whzbService;

    /**
     * @Description: addFywh方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:25
     */

    @ApiOperation("法院文化增加")
    @PostMapping(value = "/addFywh")
    public ResponseWrapper addFywh(Whzb whzb){
        ResponseWrapper wrapper = whzbService.addWhzb(whzb);
        return wrapper;
    }

    /**
     * @Description: deleteNews方法是删除 多/单
     * @param: ids 1-2-3
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:26
     */

    @ApiOperation("法院文化删除")
    @DeleteMapping(value = "/deleteFywh")
    public ResponseWrapper deleteNews(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = whzbService.deleteWhzb(ids);
        return wrapper;
    }

    /**
     * @Description: updataFywh方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:26
     */

    @ApiOperation("法院文化修改")
    @PutMapping(value = "/updataFywh")
    public ResponseWrapper updataFywh(Whzb whzb){
        ResponseWrapper wrapper = whzbService.updataNews(whzb);
        return wrapper;
    }

    /**
     * @Description: fywhLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:26
     */

    @ApiOperation("法院文化模糊查询")
    @GetMapping(value = "/fywhLike")
    public ResponseWrapper fywhLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = whzbService.whzbLike(search,pn,category);
        return wrapper;
    }

}
