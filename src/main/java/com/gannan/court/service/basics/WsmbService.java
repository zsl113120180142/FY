package com.gannan.court.service.basics;

import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.WsmbMapper;
import com.gannan.court.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WsmbService
 * @Description: 用来处理文书模板的业务逻辑
 * @Author: zsl
 * @Date: 2020/8/2 20:03
 * @Version: v1.0
 */
@Service
public class WsmbService {
    @Autowired
    WsmbMapper wsmbMapper;
    @Autowired
    FileService fileService;

    /*-----------------后台----------------*/
    /**
     * @Description: findAll方法是查询全部并通过倒序
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:07
     */

    public List<Wsmb> findAll() {
        WsmbExample example =new WsmbExample();
        example.setOrderByClause("time DESC");
        return wsmbMapper.selectByExample(example);
    }

    /**
     * @Description: addWsmb方法是新增
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:07
     */

    public ResponseWrapper addWsmb(Wsmb wsmb) {
        if (wsmb==null){
            return ResponseWrapper.markParamError();
        }else {
            int wrapper = wsmbMapper.insertSelective(wsmb);
            if (wrapper == 1) {
                return ResponseWrapper.markSuccess(null);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: deleteWsmb方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:07
     */

    public ResponseWrapper deleteWsmb(String ids) {
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
                WsmbExample example = new WsmbExample();
                WsmbExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(del_ids);
                int e = wsmbMapper.deleteByExample(example);
                if (e > 0) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            } else {
                Integer id = Integer.parseInt(ids);
                int e = wsmbMapper.deleteByPrimaryKey(id);
                if (e == 1) {
                    return ResponseWrapper.markSuccess(e);
                } else {
                    return ResponseWrapper.markError();
                }
            }
        }
    }


    /**
     * @Description: updataWsmb方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:06
     */

    public ResponseWrapper updataWsmb(Wsmb wsmb) {
        if (wsmb==null){
            return ResponseWrapper.markParamError();
        }else {
            int e = wsmbMapper.updateByPrimaryKeySelective(wsmb);
            if (e == 1) {
                return ResponseWrapper.markSuccess(e);
            } else {
                return ResponseWrapper.markError();
            }
        }
    }


    /**
     * @Description: wsmbLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 20:05
     */

    public ResponseWrapper wsmbLike(String search, Integer pn) {
        if (search.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            PageHelper.startPage(pn, 10);
            WsmbExample example = new WsmbExample();
            WsmbExample.Criteria criteria = example.createCriteria();
            criteria.andTitleLike("%"+search+"%");
            example.setOrderByClause("time DESC");
            List<Wsmb> wsmbList = wsmbMapper.selectByExample(example);

            PageInfo wsmbpage = new PageInfo(wsmbList, 10);
            return ResponseWrapper.markSuccess(wsmbpage);
        }
    }
    /*-----------------后台----------------*/

    /*-----------------前台----------------*/
    /**
     * @Description: findWsmbSon方法是文书模板的显示全部标题
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:48
     */

    public ResponseWrapper findWsmbSon(Integer pn) {
        PageHelper.startPage(pn, 20);
        List<Wsmb> wsmbList = wsmbMapper.selectAll();

        PageInfo page = new PageInfo(wsmbList, 10);
        return ResponseWrapper.markSuccess(page);
    }

    public ResponseWrapper download(HttpServletRequest request, HttpServletResponse response, Integer id) {
        Wsmb wsmb = wsmbMapper.selectByPrimaryKey(id);
        String filePath = wsmb.getFilepath();
        String fileName = wsmb.getFilename();
        ResponseWrapper wrapper = fileService.download(request,response,filePath,fileName);
        return wrapper;
    }
    /*-----------------前台----------------*/
}
