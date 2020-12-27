package com.gannan.court.service.basics;

import com.gannan.court.bean.Courtintroduce;
import com.gannan.court.bean.CourtintroduceExample;
import com.gannan.court.bean.News;
import com.gannan.court.bean.NewsExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.CourtintroduceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CourtintroduceService
 * @Description: 用来处理法院介绍的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 19:59
 * @Version: v1.0
 */
@Service
public class CourtintroduceService {
    @Autowired
    CourtintroduceMapper courtintroduceMapper;

    /*-----------------后台----------------*/
    /**
     * @Description: findByCategory方法是通过类别查找
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/4 9:34
     */

    public List<Courtintroduce> findByCategory(String category) {
        CourtintroduceExample example = new CourtintroduceExample();
        CourtintroduceExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        return courtintroduceMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: addCourtintroduce方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/4 9:36
     */
    public ResponseWrapper addCourtintroduce(Courtintroduce courtintroduce) {
        if (courtintroduce == null) {
            return ResponseWrapper.markParamError();
        } else {
            int wrapper = courtintroduceMapper.insertSelective(courtintroduce);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: deleteCourtintroduce方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/4 16:17
     */

    public ResponseWrapper deleteCourtintroduce(String ids) {
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
                CourtintroduceExample example = new CourtintroduceExample();
                CourtintroduceExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = courtintroduceMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = courtintroduceMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }

    /**
     * @Description: updataCourtintroduce方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/4 16:17
     */

    public ResponseWrapper updataCourtintroduce(Courtintroduce courtintroduce) {
        if (courtintroduce == null) {
            return ResponseWrapper.markParamError();
        } else {
            int e = courtintroduceMapper.updateByPrimaryKeySelective(courtintroduce);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: courtintroduceLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/4 16:18
     */

    public ResponseWrapper courtintroduceLike(String search, String category, Integer pn) {
        if (search.equals("")) {
            return ResponseWrapper.markParamError();
        } else {
            PageHelper.startPage(pn, 10);
            CourtintroduceExample example = new CourtintroduceExample();
            CourtintroduceExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%" + search + "%");
            example.setOrderByClause("time DESC");
            List<Courtintroduce> courtintroduceList = courtintroduceMapper.selectByExample(example);

            PageInfo courtintroducepage = new PageInfo(courtintroduceList, 10);
            return ResponseWrapper.markSuccess(courtintroducepage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/

    /**
     * @Description: findIntroduceByCategory方法是通过类别查询所有法院介绍的内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:28
     */

    public ResponseWrapper findIntroduceByCategory(String category, Integer pn) {
        PageHelper.startPage(pn, 12);
        CourtintroduceExample example = new CourtintroduceExample();
        CourtintroduceExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        criteria.andPutonEqualTo(1);
        example.setOrderByClause("time DESC");
        List<Courtintroduce> courtintroduces = courtintroduceMapper.selectByExample(example);

        PageInfo page = new PageInfo(courtintroduces, 10);
        return ResponseWrapper.markSuccess(page);
    }
    /*-----------------前台----------------*/
}
