package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Dwgz;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.DwgzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: DwgzController
 * @Description: 用于处理后台党建引领的请求
 * @Author: zsl
 * @Date: 2020/8/4 10:17
 * @Version: v1.0
 */
@Api(tags = "处理后台党建引领的请求")
@RestController
public class DwgzController {
    @Autowired
    DwgzService dwgzService;

    /**
     * @Description: addDwgz方法是增加
     * @param: dwgz的post表单请求，可以不满，有哪些更新那些
     * @return: 增加的条数：e
     * @auther: zsl
     * @date: 2020/8/5 19:16
     */

    @ApiOperation("党建增加")
    @PostMapping(value = "/addDwgz")
    public ResponseWrapper addDwgz(Dwgz dwgz){
        ResponseWrapper wrapper = dwgzService.addDwgz(dwgz);
        return wrapper;
    }

    /**
     * @Description: deleteDwgz方法是删除方法
     * @param: ids ： 1-2-3
     * @return: 删除的
     * @auther: zsl
     * @date: 2020/8/5 19:18
     */

    @ApiOperation("党建删除")
    @DeleteMapping(value = "/deleteDwgz")
    public ResponseWrapper deleteDwgz(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = dwgzService.deleteDwgz(ids);
        return wrapper;
    }

    /**
     * @Description: updataDwgz方法是修改方法
     * @param: PUT的请求，有哪些就更新那些
     * @return: 更新的条数：e
     * @auther: zsl
     * @date: 2020/8/5 19:22
     */

    @ApiOperation("党建修改")
    @PutMapping(value = "/updataDwgz")
    public ResponseWrapper updataDwgz(Dwgz dwgz){
        ResponseWrapper wrapper = dwgzService.updataDwgz(dwgz);
        return wrapper;
    }

    /**
     * @Description: dwgzLike方法是模糊查询
     * @param: search：需要查的标签
     * @return: 模糊查询的结果
     * @auther: zsl
     * @date: 2020/8/5 19:24
     */

    @ApiOperation("党建模糊查询")
    @GetMapping(value = "/dwgzLike")
    public ResponseWrapper dwgzLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = dwgzService.dwgzLike(search,pn,category);
        return wrapper;
    }
}
