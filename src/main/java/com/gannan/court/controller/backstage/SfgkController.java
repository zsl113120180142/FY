package com.gannan.court.controller.backstage;

import com.gannan.court.bean.News;
import com.gannan.court.bean.Sfgk;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.SfgkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SfgkController
 * @Description: 处理后台司法公开的请求
 * @Author: zsl
 * @Date: 2020/8/3 19:56
 * @Version: v1.0
 */
@Api(tags = "处理后台司法公开的请求")
@RestController
public class SfgkController {
    @Autowired
    SfgkService sfgkService;


    /**
     * @Description: addSfgk方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:45
     */

    @ApiOperation("司法公开增加")
    @PostMapping(value = "/addSfgk")
    public ResponseWrapper addSfgk(Sfgk sfgk){
        ResponseWrapper wrapper = sfgkService.addSfgk(sfgk);
        return wrapper;
    }

    /**
     * @Description: deleteSfgk方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:46
     */

    @ApiOperation("司法公开删除")
    @DeleteMapping(value = "/deleteSfgk")
    public ResponseWrapper deleteSfgk(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = sfgkService.deleteSfgk(ids);
        return wrapper;
    }

    /**
     * @Description: updataSfgk方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:46
     */

    @ApiOperation("司法公开修改")
    @PutMapping(value = "/updataSfgk")
    public ResponseWrapper updataSfgk(Sfgk sfgk){
        ResponseWrapper wrapper = sfgkService.updataNews(sfgk);
        return wrapper;
    }

    /**
     * @Description: sfgkLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:46
     */

    @ApiOperation("司法公开模糊查询")
    @GetMapping(value = "/sfgkLike")
    public ResponseWrapper sfgkLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = sfgkService.sfgkLike(search,pn,category);
        return wrapper;
    }
}
