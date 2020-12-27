package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Wsmb;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.WsmbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: WsmbController
 * @Description: 用来处理后台文书模板的请求
 * @Author: zsl
 * @Date: 2020/8/4 10:25
 * @Version: v1.0
 */
@Api(tags = "处理后台文书模板的请求")
@RestController
public class WsmbController {
    @Autowired
    WsmbService wsmbService;

    /**
     * @Description: addWsmb方法是文件增加
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:47
     */

    @ApiOperation("文件增加")
    @PostMapping(value = "/addWsmb")
    public ResponseWrapper addWsmb(Wsmb wsmb){
        ResponseWrapper wrapper = wsmbService.addWsmb(wsmb);
        return wrapper;
    }

    /**
     * @Description: deleteWsmb方法是删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:48
     */

    @ApiOperation("文件删除")
    @DeleteMapping(value = "/deleteWsmb")
    public ResponseWrapper deleteWsmb(@RequestParam("ids") String ids){
        ResponseWrapper wrapper = wsmbService.deleteWsmb(ids);
        return wrapper;
    }

    /**
     * @Description: updataWsmb方法是修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:49
     */

    @ApiOperation("文件修改")
    @PutMapping(value = "/updataWsmb")
    public ResponseWrapper updataWsmb(Wsmb wsmb){
        ResponseWrapper wrapper = wsmbService.updataWsmb(wsmb);
        return wrapper;
    }

    /**
     * @Description: wsmbLike方法是模糊查询
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:52
     */

    @ApiOperation("文件模糊查询")
    @GetMapping(value = "/wsmbLike")
    public ResponseWrapper wsmbLike(@RequestParam("search") String search,
                                    @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = wsmbService.wsmbLike(search,pn);
        return wrapper;
    }
}
