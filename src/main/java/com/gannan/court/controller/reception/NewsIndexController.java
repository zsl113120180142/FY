package com.gannan.court.controller.reception;

import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: NewsIndexController
 * @Description: 处理前台新闻中心的请求
 * @Author: zsl
 * @Date: 2020/8/6 15:47
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台新闻中心的请求")
@RestController
public class NewsIndexController {
    @Autowired
    NewsService newsService;

    /**
     * @Description: newsPage方法是新闻中心页面
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:03
     */
    
    @ApiOperation("新闻中心页面")
    @GetMapping(value = "/newsPage")
    public ResponseWrapper newsPage() {
        ResponseWrapper wrapper = newsService.findAllNewsPage();
        return wrapper;
    }

    /**
     * @Description: findNewsById方法是新闻中心的内容页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:06
     */

    @ApiOperation("新闻中心内容页面")
    @GetMapping(value = "/findNewsById")
    public ResponseWrapper findNewsById(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = newsService.findNewsById(id);
        return wrapper;
    }

    /**
     * @Description: newsSon方法是新闻中心子目录下所有的页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:08
     */

    @ApiOperation("新闻中心子页面")
    @GetMapping(value = "/newsSon")
    public ResponseWrapper newsSon(@RequestParam("category") String category,
                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        ResponseWrapper wrapper = newsService.findNewsSonByCategory(category,pn);
        return wrapper;
    }

}
