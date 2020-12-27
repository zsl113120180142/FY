package com.gannan.court.controller.backstage;

import com.gannan.court.bean.News;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: NewController
 * @Description: 用来处理后台新闻中心的事务
 * @Author: zsl
 * @Date: 2020/8/3 16:36
 * @Version: v1.0
 */
@Api(tags = "处理后台新闻中心的请求")
@RestController
public class NewController {

    @Autowired
    NewsService newsService;



    /**
     * @Description: addNews方法是增加
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:44
     */

    @ApiOperation("新闻增加")
    @PostMapping(value = "/addNews")
    public ResponseWrapper addNews(News news){
        ResponseWrapper wrapper = newsService.addNews(news);
        return wrapper;
    }

    /**
     * @Description: deleteNews方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:44
     */

    @ApiOperation("新闻删除")
    @DeleteMapping(value = "/deleteNews")
    public ResponseWrapper deleteNews(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = newsService.deleteNews(ids);
        return wrapper;
    }

    /**
     * @Description: updataNews方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:44
     */

    @ApiOperation("新闻修改")
    @PutMapping(value = "/updataNews")
    public ResponseWrapper updataNews(News news){
        ResponseWrapper wrapper = newsService.updataNews(news);
        return wrapper;
    }

    /**
     * @Description: newsLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:45
     */

    @ApiOperation("新闻模糊查询")
    @GetMapping(value = "/newsLike")
    public ResponseWrapper newsLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = newsService.newsLike(search,pn,category);
        return wrapper;
    }

}
