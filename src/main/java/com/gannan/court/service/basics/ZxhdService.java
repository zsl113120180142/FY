package com.gannan.court.service.basics;

/**
 * @ClassName: ZxhdService
 * @Description: 用来处理在线互动的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:05
 * @Version: v1.0
 */

import com.gannan.court.bean.News;
import com.gannan.court.bean.NewsExample;
import com.gannan.court.bean.Zxhd;
import com.gannan.court.bean.ZxhdExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.ZxhdMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZxhdService {
    @Autowired
    ZxhdMapper zxhdMapper;

    /*-----------------后台----------------*/
    /**
     * @Description: findByCategory方法是通过类别查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:12
     */

    public List<Zxhd> findByCategory(String category) {
        ZxhdExample example = new ZxhdExample();
        ZxhdExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        return zxhdMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: deleteZxhd方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:11
     */

    public ResponseWrapper deleteZxhd(String ids) {
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
                ZxhdExample example = new ZxhdExample();
                ZxhdExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = zxhdMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = zxhdMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }

    /**
     * @Description: updataZxhd方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:11
     */

    public ResponseWrapper updataZxhd(Zxhd zxhd) {
        if (zxhd==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = zxhdMapper.updateByPrimaryKeySelective(zxhd);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: zxhdLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:10
     */

    public ResponseWrapper zxhdLike(String search, Integer pn, String category) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            ZxhdExample example = new ZxhdExample();
            ZxhdExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Zxhd> zxhdList = zxhdMapper.selectByExample(example);

            PageInfo zxhdpage = new PageInfo(zxhdList, 10);
            return ResponseWrapper.markSuccess(zxhdpage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/
    /**
     * @Description: addZxhd方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:51
     */

    public ResponseWrapper addZxhd(Zxhd zxhd) {
        if (zxhd == null) {
            return ResponseWrapper.markParamError();
        } else {
            int wrapper = zxhdMapper.insertSelective(zxhd);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }
    /*-----------------前台----------------*/
}
