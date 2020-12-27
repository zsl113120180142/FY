package com.gannan.court.service.basics;

import com.gannan.court.bean.Picture;
import com.gannan.court.bean.PictureExample;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: PictureService
 * @Description: 用来处理图片管理的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:00
 * @Version: v1.0
 */
@Service
public class PictureService {

    @Autowired
    PictureMapper pictureMapper;

    /**
     * @Description: findAll()方法是查询picture中全部数据
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 10:54
     */

    public List<Picture> findAll() {
        return pictureMapper.selectByExample(null);
    }


    /**
     * @Description: addPicture方法是新增图片信息
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 10:54
     */

    public ResponseWrapper addPicture(Picture picture) {
        if (picture==null){
            return ResponseWrapper.markParamError();
        }else {
            int wrapper = pictureMapper.insertSelective(picture);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }

    /**
     * @Description:
     * deletePicture方法是删除图片
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 11:29
     */

    public ResponseWrapper deletePicture(String ids) {
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
                PictureExample example = new PictureExample();
                PictureExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = pictureMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = pictureMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }

    /**
     * @Description: updataPicture方法是修改图片信息
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 14:51
     */

    public ResponseWrapper updataPicture(Picture picture) {
        if (picture==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = pictureMapper.updateByPrimaryKeySelective(picture);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }
}
