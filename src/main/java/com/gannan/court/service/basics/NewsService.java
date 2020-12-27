package com.gannan.court.service.basics;

import com.gannan.court.bean.Catalog;
import com.gannan.court.bean.Dwgz;
import com.gannan.court.bean.News;
import com.gannan.court.bean.NewsExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.NewsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: NewsService
 * @Description: 用来处理新闻中心的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 14:23
 * @Version: v1.0
 */
@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    CatalogService catalogService;


    /*-----------------后台----------------*/

    /**
     * @Description: findByCategory方法是通过类别显示数据
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 16:57
     */

    public List<News> findByCategory(String category) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        return newsMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: addNews方法是新增新闻
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 17:01
     */

    public ResponseWrapper addNews(News news) {
        if (news == null) {
            return ResponseWrapper.markParamError();
        } else {
            int wrapper = newsMapper.insertSelective(news);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: deleteNews方法是删除新闻（单个，批量）二合一
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 17:08
     */

    public ResponseWrapper deleteNews(String ids) {
        if (ids.equals("")) {
            return ResponseWrapper.markParamError();
        } else {
            //批量删除
            if (ids.contains("-")) {
                List<Integer> del_ids = new ArrayList<>();
                String[] str_ids = ids.split("-");
                //组装id的集合,遍历数组
                for (String string : str_ids) {
                    del_ids.add(Integer.parseInt(string));
                }
                //批量删除的方法
                NewsExample example = new NewsExample();
                NewsExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = newsMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = newsMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }


    /**
     * @Description: updataNews方法是修改新闻
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 17:18
     */

    public ResponseWrapper updataNews(News news) {
        if (news == null) {
            return ResponseWrapper.markParamError();
        } else {
            int e = newsMapper.updateByPrimaryKeySelective(news);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: newsLike方法是模糊查询+分页
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 19:52
     */

    public ResponseWrapper newsLike(String search, Integer pn, String category) {
        if (search.equals("")) {
            return ResponseWrapper.markParamError();
        } else {
            PageHelper.startPage(pn, 10);
            NewsExample example = new NewsExample();
            NewsExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%" + search + "%");
            example.setOrderByClause("time DESC");
            List<News> newsList = newsMapper.selectByExampleWithBLOBs(example);

            PageInfo newspage = new PageInfo(newsList, 10);
            return ResponseWrapper.markSuccess(newspage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/
    /**
     * @Description: findAllNewsPage方法是新闻中心页面
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:34
     */
    
    public ResponseWrapper findAllNewsPage() {
        //用map装着
        List<Catalog> catalogList = catalogService.findByHcategory("news");
        for (Catalog catalog : catalogList) {
            List<News> newsList = newsMapper.selectByCategory(catalog.getCategory());
            catalog.setNewsList(newsList);
            switch (catalog.getCategory()){
                case "fydt":
                    catalog.setUrl("court-dynamic");
                    catalog.setAreaUrl("news-center-item");
                    break;
                case "yasf":
                    catalog.setUrl("case-statement");
                    catalog.setAreaUrl("news-center-item");
                    break;
                case "tpxw":
                    catalog.setUrl("picture-new");
                    catalog.setAreaUrl("news-center-item");
                    break;
            }
        }
        return ResponseWrapper.markSuccess(catalogList);
    }

    /**
     * @Description: findNewsById方法是新闻中心内容页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:36
     */

    public ResponseWrapper findNewsById(Integer id) {
        //用map装起来
        Map<String,Object> map = new HashMap<>();
        //查询出来的内容
        News news= newsMapper.selectByPrimaryKey(id);
        map.put("news",news);
        //上一页
        News lastNews = newsMapper.selectLastById(id);
        map.put("lastNews",lastNews);
        //下一页
        News nextNews = newsMapper.selectNextById(id);
        map.put("nextNews",nextNews);
        return ResponseWrapper.markSuccess(map);
    }

    /**
     * @Description: findNewsSonByCategory方法是新闻中心子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:37
     */

    public ResponseWrapper findNewsSonByCategory(String category, Integer pn) {
        PageHelper.startPage(pn, 20);
        List<News> newsList = newsMapper.selectAllByCategory(category);

        PageInfo page = new PageInfo(newsList, 10);
        return ResponseWrapper.markSuccess(page);
    }
    /*-----------------前台----------------*/
}
