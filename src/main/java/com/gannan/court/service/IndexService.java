package com.gannan.court.service;


import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.*;
import com.gannan.court.service.basics.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: IndexService
 * @Description: 处理前台首页面的事务
 * @Author: zsl
 * @Date: 2020/8/5 8:49
 * @Version: v1.0
 */
@Service
public class IndexService {

    @Autowired
    PictureMapper pictureMapper;
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    SfgkMapper sfgkMapper;
    @Autowired
    CatalogMapper catalogMapper;
    @Autowired
    WhzbMapper whzbMapper;

    /**
     * @Description: findAllIndex方法是首页页面查询所有的内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 15:58
     */

    public ResponseWrapper findAllIndex() {
        //用map储存首页数据
        HashMap<String, Object> map = new HashMap<>();
        //picture
        //顶部轮播
        List<Picture> dblb = pictureMapper.selectByCategory("dblb");
        map.put("dblb", dblb);
        //头部轮播
        List<Picture> tblb = pictureMapper.selectByCategory("tblb");
        map.put("tblb", tblb);
        //栏目图片
        List<Picture> lmtp = pictureMapper.selectByCategory("lmtp");
        map.put("lmtp", lmtp);
        //news
        //10条新闻
        List<News> tenNews = newsMapper.selectTenNews();
        map.put("tenNews", tenNews);
        //图片新闻
        List<News> pictureNews = newsMapper.selectPictureNews();
        map.put("pictureNews", pictureNews);
        //以案说法
        List<News> nineYasf = newsMapper.selectNineByCategory("yasf");
        map.put("nineYasf", nineYasf);
        //审务动态
        List<News> nineSwdt = newsMapper.selectNineByCategory("swdt");
        map.put("nineSwdt", nineSwdt);
        //执行动态
        List<News> nineZxdt = newsMapper.selectNineByCategory("zxdt");
        map.put("nineZxdt", nineZxdt);
        //sfgk
        //公告栏
        List<Sfgk> sfgkList = sfgkMapper.selectAllTitile();
        map.put("ggl", sfgkList);
        //导航栏(缺首页）
        List<Catalog> catalogs = catalogMapper.selectByHcategory("top");
        map.put("navigation", catalogs);
        //法学园地
        List<Whzb> nineFxyd = whzbMapper.selectNineByCategory("fxyd");
        map.put("nineFxyd", nineFxyd);
        return ResponseWrapper.markSuccess(map);
    }


    /**
     * @Description: findContent方法是点击查询内容(新闻类 ）
     *包括但不限于 ， 新闻中心 ， 图片新闻 ， 以案说法 ， 审务动态 ， 执行动态
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 15:59
     */
    public ResponseWrapper findNewsContent(Integer id) {
        News news = newsMapper.selectByPrimaryKey(id);
        return ResponseWrapper.markSuccess(news);
    }

    /**
     * @Description: findGglContent方法是点击查询内容(公告栏）
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 16:06
     */
    public ResponseWrapper findGglContent(Integer id) {
        Sfgk ggl = sfgkMapper.selectByPrimaryKey(id);
        return ResponseWrapper.markSuccess(ggl);
    }

    /**
     * @Description: findFxydContent方法是法学院地
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 16:09
     */

    public ResponseWrapper findFxydContent(Integer id) {
        Whzb fxyd = whzbMapper.selectByPrimaryKey(id);
        return ResponseWrapper.markSuccess(fxyd);
    }

    /**
     * @Description: navigationBar方法是通过自身的类别，查询其目录下的所有子目录
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/5 20:14
     */
    
    public ResponseWrapper navigationBar(String hcategory) {
        List<Catalog> catalogList = catalogMapper.selectByHcategory(hcategory);
        return ResponseWrapper.markSuccess(catalogList);
    }
}
