package com.gannan.court.controller.reception;

import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.SfgkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SfgkIndexController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/6 16:23
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台司法公开的请求")
@RestController
public class SfgkIndexController {

    @Autowired
    SfgkService sfgkService;

    /**
     * @Description: findGglById方法是公告栏的内容页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:14
     */

    @ApiOperation("公告栏内容页面")
    @GetMapping(value = "/findGglById")
    public ResponseWrapper findGglById(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = sfgkService.findGglById(id);
        return wrapper;
    }

    /**
     * @Description: GglSon方法是公告栏的子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:17
     */

    @ApiOperation("公告栏子页面")
    @GetMapping(value = "/GglSon")
    public ResponseWrapper GglSon(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        System.out.println(pn);
        ResponseWrapper wrapper = sfgkService.findGglSonByCategory(pn);
        return wrapper;
    }
}
