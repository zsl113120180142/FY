package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Ssfwzx;
import com.gannan.court.bean.Zxhd;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.SsfwzxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SsfwzxController
 * @Description: 诉讼服务中心,预约立案的后台
 * @Author: zsl
 * @Date: 2020/8/6 17:05
 * @Version: v1.0
 */
@Api(tags = "处理后台在线互动的请求")
@RestController
public class SsfwzxController {
    @Autowired
    SsfwzxService ssfwzxService;

    /**
     * @Description: deleteYyla方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:38
     */

    @ApiOperation("预约立案删除")
    @DeleteMapping(value = "/deleteYyla")
    public ResponseWrapper deleteYyla(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = ssfwzxService.deleteYyla(ids);
        return wrapper;
    }

    /**
     * @Description: updataYyla方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:38
     */

    @ApiOperation("预约立案修改")
    @PutMapping(value = "/updataYyla")
    public ResponseWrapper updataYyla(Ssfwzx ssfwzx){
        ResponseWrapper wrapper = ssfwzxService.updataYyla(ssfwzx);
        return wrapper;
    }
    /**
     * @Description: YylaLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:39
     */

    @ApiOperation("预约立案模糊查询")
    @GetMapping(value = "/YylaLike")
    public ResponseWrapper YylaLike(@RequestParam("search") String search,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = ssfwzxService.YylaLike(search,pn);
        return wrapper;
    }
}
