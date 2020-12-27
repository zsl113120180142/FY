package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Courtintroduce;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.CourtintroduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: CourtintroduceController
 * @Description: 用于处理后台法院介绍的请求
 * @Author: zsl
 * @Date: 2020/8/4 9:25
 * @Version: v1.0
 */
@Api(tags = "处理后台法院介绍的请求")
@RestController
public class CourtintroduceController {

    @Autowired
    CourtintroduceService courtintroduceService;

    /**
     * @Description: addCourtintroduce方法是新增法院介绍
     * @param: post表单请求，可以不满，有哪些更新那些
     * @return: 增加的条数：e
     * @auther: zsl
     * @date: 2020/8/5 19:05
     */

    @ApiOperation("介绍增加")
    @PostMapping(value = "/addCourtintroduce")
    public ResponseWrapper addCourtintroduce(Courtintroduce courtintroduce){
        ResponseWrapper wrapper = courtintroduceService.addCourtintroduce(courtintroduce);
        return wrapper;
    }

    /**
     * @Description: deleteCourtintroduce方法是删除介绍，单/多
     * @param: ids ： 1-2-3
     * @return: 删除的条数：e
     * @auther: zsl
     * @date: 2020/8/5 19:06
     */

    @ApiOperation("介绍删除")
    @DeleteMapping(value = "/deleteCourtintroduce")
    public ResponseWrapper deleteCourtintroduce(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = courtintroduceService.deleteCourtintroduce(ids);
        return wrapper;
    }

    /**
     * @Description: updataCourtintroduce方法是修改
     * @param: PUT的请求，有哪些就更新那些
     * @return: 修改的条数：e
     * @auther: zsl
     * @date: 2020/8/5 19:07
     */

    @ApiOperation("介绍修改")
    @PutMapping(value = "/updataCourtintroduce")
    public ResponseWrapper updataCourtintroduce(Courtintroduce courtintroduce){
        ResponseWrapper wrapper = courtintroduceService.updataCourtintroduce(courtintroduce);
        return wrapper;
    }

    /**
     * @Description: courtintroduceLike方法是模糊查询
     * @param: search：标题模糊查询
     * @return:查询出来的法院介绍的数据
     * @auther: zsl
     * @date: 2020/8/5 19:08
     */

    @ApiOperation("介绍模糊查询")
    @GetMapping(value = "/courtintroduceLike")
    public ResponseWrapper courtintroduceLike(@RequestParam("search") String search,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = courtintroduceService.courtintroduceLike(search,category,pn);
        return wrapper;
    }
}
