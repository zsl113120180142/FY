package com.gannan.court.service.basics;

import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.WhzbMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Whzx
 * @Description: 用来处理文化展板的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:02
 * @Version: v1.0
 */
@Service
public class WhzbService {
    @Autowired
    WhzbMapper whzbMapper;
    @Autowired
    CatalogService catalogService;

    /*-----------------后台----------------*/
    /**
     * @Description: findByCategory方法是通过类别查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:32
     */
    public List<Whzb> findByCategory(String category) {
        WhzbExample example = new WhzbExample();
        WhzbExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        return whzbMapper.selectByExampleWithBLOBs(example);
    }


    /**
     * @Description: addWhzb方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:51
     */

    public ResponseWrapper addWhzb(Whzb whzb) {
        if (whzb==null){
            return ResponseWrapper.markParamError();
        }else {
            int wrapper = whzbMapper.insertSelective(whzb);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: deleteWhzb方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:51
     */

    public ResponseWrapper deleteWhzb(String ids) {
        if (ids.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            //批量删除
            if (ids.contains("-")) {
                List<Integer> del_ids = new ArrayList<>();
                String[] str_ids = ids.split("-");
                //组装id的集合,遍历数组
                for (String string : str_ids) {
                    del_ids.add(Integer.parseInt(string));
                }
                //批量删除的方法
                WhzbExample example = new WhzbExample();
                WhzbExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = whzbMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = whzbMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }


    /**
     * @Description: updataNews方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:51
     */

    public ResponseWrapper updataNews(Whzb whzb) {
        if (whzb==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = whzbMapper.updateByPrimaryKeySelective(whzb);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: whzbLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:52
     */

    public ResponseWrapper whzbLike(String search, Integer pn,String category) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            WhzbExample example = new WhzbExample();
            WhzbExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Whzb> WhzbList = whzbMapper.selectByExample(example);

            PageInfo whzbpage = new PageInfo(WhzbList, 10);
            return ResponseWrapper.markSuccess(whzbpage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/

    /**
     * @Description: findAllfywhPage方法是展示法院文化的页面
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:45
     */
    
    public ResponseWrapper findAllfywhPage() {
        //用map装着
        Map<String , Object> map = new HashMap<>();
        List<Catalog> catalogList = catalogService.findByHcategory("whzb");
        map.put("whzb",catalogList);
        List<Whzb> fyxd = whzbMapper.selecttitleByCategory("fxyd");
        map.put("fxyd",fyxd);
        return ResponseWrapper.markSuccess(map);
    }

    /**
     * @Description: findfywhSonByCategory方法是法学园地的内容
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:45
     */
    
    public ResponseWrapper findfywhSonByCategory(String category, Integer pn) {
        PageHelper.startPage(pn, 20);
        WhzbExample example = new WhzbExample();
        WhzbExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        List<Whzb> whzbList = whzbMapper.selectByExampleWithBLOBs(example);
        PageInfo page = new PageInfo(whzbList, 10);
        return ResponseWrapper.markSuccess(page);
    }

    /**
     * @Description: findwhzbById方法是法学园地的内容
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:47
     */
    
    public ResponseWrapper findwhzbById(Integer id) {
        //用map装起来
        Map<String,Object> map = new HashMap<>();
        //查询出来的内容
        Whzb whzb= whzbMapper.selectByPrimaryKey(id);
        map.put("whzb",whzb);
        //上一页
        Dwgz lastWhzb = whzbMapper.selectLastById(id);
        map.put("lastWhzb",lastWhzb);
        //下一页
        Dwgz nextWhzb = whzbMapper.selectNextById(id);
        map.put("nextWhzb",nextWhzb);
        return ResponseWrapper.markSuccess(map);
    }

    /**
     * @Description: findwhzbSonByCategory方法是文化展板的类别子页面
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/8 20:48
     */
    
    public ResponseWrapper findwhzbSonByCategory(String category, Integer pn) {
        PageHelper.startPage(pn, 12);
        WhzbExample example =new WhzbExample();
        WhzbExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        List<Whzb> whzbList = whzbMapper.selectByExample(example);

        PageInfo page = new PageInfo(whzbList, 10);
        return ResponseWrapper.markSuccess(page);
    }


    /*-----------------前台----------------*/
}
