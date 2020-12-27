package com.gannan.court.service.basics;

import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.SfgkMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SfgkService
 * @Description: 用来处理司法公开业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:01
 * @Version: v1.0
 */
@Service
public class SfgkService {

    @Autowired
    SfgkMapper sfgkMapper;

    /*-----------------后台----------------*/
    /**
     * @Description: findByCategory方法是通过类别查询数据
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:09
     */
    public List<Sfgk> findByCategory(String category) {
        SfgkExample example = new SfgkExample();
        SfgkExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        return sfgkMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: addSfgk方法是增加司法公开
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:09
     */
    public ResponseWrapper addSfgk(Sfgk sfgk) {
        if (sfgk==null){
            return ResponseWrapper.markParamError();
        }else {
            int wrapper = sfgkMapper.insertSelective(sfgk);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: deleteSfgk方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:17
     */
    public ResponseWrapper deleteSfgk(String ids) {
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
                SfgkExample example = new SfgkExample();
                SfgkExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = sfgkMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = sfgkMapper.deleteByPrimaryKey(id);
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
     * @date: 2020/8/3 20:18
     */
    public ResponseWrapper updataNews(Sfgk sfgk) {
        if (sfgk==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = sfgkMapper.updateByPrimaryKeySelective(sfgk);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: sfgkLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 20:18
     */
    public ResponseWrapper sfgkLike(String search, Integer pn,String category) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            SfgkExample example = new SfgkExample();
            SfgkExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Sfgk> sfgkList = sfgkMapper.selectByExample(example);

            PageInfo sfgkpage = new PageInfo(sfgkList, 10);
            return ResponseWrapper.markSuccess(sfgkpage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/
    /**
     * @Description: findGglById方法是公告栏的内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:37
     */

    public ResponseWrapper findGglById(Integer id) {
        //用map装起来
        Map<String,Object> map = new HashMap<>();
        //查询出来的内容
        Sfgk ggl= sfgkMapper.selectByPrimaryKey(id);
        map.put("ggl",ggl);
        //上一页
        Dwgz lastGgl = sfgkMapper.selectLastById(id);
        map.put("lastGgl",lastGgl);
        //下一页
        Dwgz nextGgl = sfgkMapper.selectNextById(id);
        map.put("nextGgl",nextGgl);
        return ResponseWrapper.markSuccess(map);
    }

    /**
     * @Description: findGglSonByCategory方法是公告栏的子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:37
     */

    public ResponseWrapper findGglSonByCategory(Integer pn) {
        PageHelper.startPage(pn, 20);
        List<Sfgk> sfgkList = sfgkMapper.selectAll();
        PageInfo page = new PageInfo(sfgkList, 5);
        return ResponseWrapper.markSuccess(page);
    }


    /*-----------------前台----------------*/
}
