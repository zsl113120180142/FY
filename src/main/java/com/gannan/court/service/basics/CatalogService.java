package com.gannan.court.service.basics;

import com.gannan.court.bean.Catalog;
import com.gannan.court.bean.CatalogExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.CatalogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CatalogService
 * @Description: 用来处理分类的基础业务
 * @Author: zsl
 * @Date: 2020/8/2 15:15
 * @Version: v1.0
 */
@Service
public class CatalogService {

    @Autowired
    CatalogMapper catalogMapper;

    /**
     * @Description: findByHcategory方法是通过hcategory查找信息
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/2 16:39
     */
    public List<Catalog> findByHcategory(String hcategory) {
        CatalogExample example = new CatalogExample();
        CatalogExample.Criteria criteria = example.createCriteria();
        criteria.andHcategoryEqualTo(hcategory);
        return catalogMapper.selectByExample(example);
    }

    /**
     * @Description: findHcategory方法是通过自身的category，找到上一级（hcategory），再用上一级的hecategory找到所有list
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 15:08
     */

    public ResponseWrapper findHcategory(String category) {
        if (category.equals("")) {
            return ResponseWrapper.markParamError();
        } else {
            //通过自身类别，找到上一级的类别
            CatalogExample example = new CatalogExample();
            CatalogExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryEqualTo(category);
            List<Catalog> catalogs = catalogMapper.selectByExample(example);
            //通过上一级类别，查询其目录下所有类别
            String hname = catalogs.get(0).getHcategory();
            CatalogExample catalogExample = new CatalogExample();
            CatalogExample.Criteria catalogcriteria = catalogExample.createCriteria();
            catalogcriteria.andHcategoryEqualTo(hname);
            List<Catalog> catalogList = catalogMapper.selectByExample(catalogExample);
            //通过for循环，进行封装
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < catalogList.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("category", catalogList.get(i).getCategory());
                map.put("titlename", catalogList.get(i).getTitlename());
                list.add(map);
            }
            if (catalogList.size() > 0) {
                return ResponseWrapper.markSuccess(list);
            } else {
                return ResponseWrapper.markSuccessButNoData();
            }
        }
    }
}
