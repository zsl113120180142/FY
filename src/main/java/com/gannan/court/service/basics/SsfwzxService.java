package com.gannan.court.service.basics;

import com.gannan.court.bean.Ssfwzx;
import com.gannan.court.bean.SsfwzxExample;
import com.gannan.court.bean.Zxhd;
import com.gannan.court.bean.ZxhdExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.SsfwzxMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SsfwzxService
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/6 19:19
 * @Version: v1.0
 */
@Service
public class SsfwzxService {
    @Autowired
    SsfwzxMapper ssfwzxMapper;

    /*-----------------后台----------------*/

    /**
     * @Description: deleteYyla方法是删除方法
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:39
     */

    public ResponseWrapper deleteYyla(String ids) {
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
                SsfwzxExample example = new SsfwzxExample();
                SsfwzxExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = ssfwzxMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = ssfwzxMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }

    /**
     * @Description: findAllYyla方法是查询预约立案的全部内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:41
     */

    public List<Ssfwzx> findAllYyla() {
        SsfwzxExample example = new SsfwzxExample();
        example.setOrderByClause("time DESC");
        return ssfwzxMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: updataYyla方法是预约立案的修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:42
     */

    public ResponseWrapper updataYyla(Ssfwzx ssfwzx) {
        if (ssfwzx==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = ssfwzxMapper.updateByPrimaryKeySelective(ssfwzx);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description: YylaLike方法是预约立案模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:43
     */

    public ResponseWrapper YylaLike(String search, Integer pn) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            SsfwzxExample example = new SsfwzxExample();
            SsfwzxExample.Criteria criteria = example.createCriteria();
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Ssfwzx> ssfwzxList = ssfwzxMapper.selectByExample(example);

            PageInfo page = new PageInfo(ssfwzxList, 10);
            return ResponseWrapper.markSuccess(page);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/
    /**
     * @Description: addYyla方法是预约立案的新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:43
     */

    public ResponseWrapper addYyla(Ssfwzx ssfwzx) {
        if (ssfwzx == null) {
            return ResponseWrapper.markParamError();
        } else {
            int wrapper = ssfwzxMapper.insertSelective(ssfwzx);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }




    /*-----------------前台----------------*/
}
