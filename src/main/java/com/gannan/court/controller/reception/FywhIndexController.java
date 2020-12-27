package com.gannan.court.controller.reception;

import com.gannan.court.bean.Whzb;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.WhzbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FywhIndexController
 * @Description: 处理来在前台法院文化的请求
 * @Author: zsl
 * @Date: 2020/8/7 15:15
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台法院文化的请求")
@RestController
public class FywhIndexController {
    @Autowired
    WhzbService whzbService;

    /**
     * @Description: fywhPage方法是展示法院文化页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 18:59
     */

    @ApiOperation("法院文化页面")
    @GetMapping(value = "/fywhPage")
    public ResponseWrapper fywhPage() {
        ResponseWrapper wrapper = whzbService.findAllfywhPage();
        return wrapper;
    }

    /**
     * @Description: fywhSon方法是法学园地的子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 19:10
     */

    @ApiOperation("法院文化子页面")
    @GetMapping(value = "/fywhSon")
    public ResponseWrapper fywhSon(@RequestParam("category") String category,
                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        ResponseWrapper wrapper = whzbService.findfywhSonByCategory(category,pn);
        return wrapper;
    }

    /**
     * @Description: findfywhById方法是法学园地的点击新闻之后的内容页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 19:10
     */

    @ApiOperation("法院文化内容页面")
    @GetMapping(value = "/findfywhById")
    public ResponseWrapper findfywhById(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = whzbService.findwhzbById(id);
        return wrapper;
    }

    /**
     * @Description: whzbSon方法是文化展板的图片显示页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 19:12
     */

    @ApiOperation("文化展板子页面")
    @GetMapping(value = "/whzbSon")
    public ResponseWrapper whzbSon(@RequestParam("category") String category,
                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        ResponseWrapper wrapper = whzbService.findwhzbSonByCategory(category,pn);
        return wrapper;
    }

}
