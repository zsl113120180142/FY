package com.gannan.court.controller.reception;

import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.CourtintroduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IntroduceController
 * @Description: 处理前台法院介绍请求
 * @Author: zsl
 * @Date: 2020/8/7 13:43
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台法院介绍的请求")
@RestController
public class IntroduceController {
    @Autowired
    CourtintroduceService courtintroduceService;

    /**
     * @Description: findIntroduceByCategory方法是法院介绍的内容页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 19:15
     */

    @ApiOperation("法院介绍内容页面")
    @GetMapping(value = "/findIntroduceByCategory")
    public ResponseWrapper findIntroduceByCategory(@RequestParam("category") String category,
                                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = courtintroduceService.findIntroduceByCategory(category,pn);
        return wrapper;
    }

}
