package com.gannan.court.controller.reception;

import com.gannan.court.bean.News;
import com.gannan.court.bean.Zxhd;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.ZxhdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ZxhdIndexController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/7 14:48
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台在线互动的请求")
@RestController
public class ZxhdIndexController {
    @Autowired
    ZxhdService zxhdService;

    /**
     * @Description: addZxhd方法是在线互动的增加
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:26
     */

    @ApiOperation("在线互动增加")
    @PostMapping(value = "/addZxhd")
    public ResponseWrapper addZxhd(Zxhd zxhd){
        ResponseWrapper wrapper = zxhdService.addZxhd(zxhd);
        return wrapper;
    }
}
