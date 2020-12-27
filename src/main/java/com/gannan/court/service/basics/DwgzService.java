package com.gannan.court.service.basics;

import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.DwgzMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DwgzService
 * @Description: 用来处理党建引领的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:00
 * @Version: v1.0
 */
@Service
public class DwgzService {

    @Autowired
    DwgzMapper dwgzMapper;
    @Autowired
    CatalogService catalogService;

    /*-----------------后台----------------*/
    /**
     * @Description: findByCategory方法是通过类别查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:03
     */

    public List<Dwgz> findByCategory(String category) {
        DwgzExample example = new DwgzExample();
        DwgzExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryEqualTo(category);
        example.setOrderByClause("time DESC");
        //selectByExample找不到数据库中类型为text的内容，得用selectByExampleWithBLOBs
        return dwgzMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * @Description: addDwgz方法是后台新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:03
     */

    public ResponseWrapper addDwgz(Dwgz dwgz) {
        if (dwgz==null){
            return ResponseWrapper.markParamError();
        }else {
            int wrapper = dwgzMapper.insertSelective(dwgz);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: deleteDwgz方法是后台删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:03
     */

    public ResponseWrapper deleteDwgz(String ids) {
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
                DwgzExample example = new DwgzExample();
                DwgzExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = dwgzMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = dwgzMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }


    /**
     * @Description: updataDwgz方法是后台修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:03
     */

    public ResponseWrapper updataDwgz(Dwgz dwgz) {
        if (dwgz==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = dwgzMapper.updateByPrimaryKeySelective(dwgz);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: dwgzLike方法是后台党建引领的模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:02
     */

    public ResponseWrapper dwgzLike(String search, Integer pn, String category) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            DwgzExample example = new DwgzExample();
            DwgzExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Dwgz> dwgzList = dwgzMapper.selectByExampleWithBLOBs(example);

            PageInfo dwgzpage = new PageInfo(dwgzList, 10);
            return ResponseWrapper.markSuccess(dwgzpage);
        }
    }
    /*-----------------后台----------------*/


    /*-----------------前台----------------*/
    /**
     * @Description: findAlldjylPage方法是前台显示党建引领的页面所有内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/6 10:04
     */

    public ResponseWrapper findAlldjylPage() {
        //用map装着
        List<Catalog> catalogList = catalogService.findByHcategory("dwgz");
        for (Catalog catalog : catalogList){
            List<Dwgz> dwgzList =  dwgzMapper.selectByCategory(catalog.getCategory());
            catalog.setDwgzList(dwgzList);
            switch (catalog.getCategory()){
                case "lxyz":
                    catalog.setUrl("study-do");
                    catalog.setAreaUrl("party-leading-item");
                    break;
                case "ztjy":
                    catalog.setUrl("main-education");
                    catalog.setAreaUrl("party-leading-item");
                    break;
                case "shyk":
                    catalog.setUrl("three-class");
                    catalog.setAreaUrl("party-leading-item");
                    break;
            }
        }
        return ResponseWrapper.markSuccess(catalogList);
    }




    /**
     * @Description: finddjylById方法是通过id查询全部内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/6 10:37
     */

    public ResponseWrapper finddjylById(Integer id) {
        //用map装起来
        Map<String,Object> map = new HashMap<>();
        //查询出来的内容
        Dwgz dwgz= dwgzMapper.selectByPrimaryKey(id);
        map.put("dwgz",dwgz);
        //上一页
        Dwgz lastDwgz = dwgzMapper.selectLastById(id);
        if (lastDwgz==null){
            lastDwgz = new Dwgz();
        }
        map.put("lastDwgz",lastDwgz);
        //下一页
        Dwgz nextDwgz = dwgzMapper.selectNextById(id);
        if (nextDwgz==null){
            nextDwgz = new Dwgz();
        }
        map.put("nextDwgz",nextDwgz);
        return ResponseWrapper.markSuccess(map);
    }

    /**
     * @Description: finddjylSonByCategory方法是党建引领的子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/6 15:45
     */

    public ResponseWrapper finddjylSonByCategory(String category,Integer pn) {
        PageHelper.startPage(pn, 20);
        List<Dwgz> dwgzList = dwgzMapper.selectAllByCategory(category);

        PageInfo page = new PageInfo(dwgzList, 10);
        return ResponseWrapper.markSuccess(page);
    }

    /*-----------------前台----------------*/
}
