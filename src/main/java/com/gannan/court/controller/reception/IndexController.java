package com.gannan.court.controller.reception;

import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: IndexController
 * @Description: 处理首页面的请求
 * @Author: zsl
 * @Date: 2020/8/5 8:43
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台首页面的请求")
@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    /**
     * @Description: Index方法是包含了首页面内所有的数据
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:57
     */

    @ApiOperation("前端首页面")
    @GetMapping(value = "/index")
    public ResponseWrapper Index() {
        ResponseWrapper wrapper = indexService.findAllIndex();
        return wrapper;
    }

    /**
     * @Description: findGglContent方法是点击之后通过id查找公告栏的数据
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:58
     */

    @ApiOperation("点击查询内容(公告栏）")
    @GetMapping(value = "/findGglContent")
    public ResponseWrapper findGglContent(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = indexService.findGglContent(id);
        return wrapper;
    }

    /**
     * @Description: findNewsContent方法是点击查询内容(新闻类 ）
     * 包括但不限于 ， 新闻中心 ， 图片新闻 ， 以案说法 ， 审务动态 ， 执行动态
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:58
     */

    @ApiOperation("点击查询内容(new类）")
    @GetMapping(value = "/findNewsContent")
    public ResponseWrapper findNewsContent(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = indexService.findNewsContent(id);
        return wrapper;
    }

    /**
     * @Description: findFxydContent方法是击查询法学园地的具体内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:59
     */

    @ApiOperation("点击查询内容(法学院地）")
    @GetMapping(value = "/findFxydContent")
    public ResponseWrapper findFxydContent(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = indexService.findFxydContent(id);
        return wrapper;
    }

    /**
     * @Description: navigationBar方法是点击导航栏查询其目录下的所有子目录，在页面左侧显示
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:59
     */

    @ApiOperation("点击查询导航栏")
    @GetMapping(value = "/navigationBar")
    public ResponseWrapper navigationBar(@RequestParam("category") String category) {
        ResponseWrapper wrapper = indexService.navigationBar(category);
        return wrapper;
    }
}
