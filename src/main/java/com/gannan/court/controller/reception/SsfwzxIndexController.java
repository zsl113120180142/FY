package com.gannan.court.controller.reception;

import com.gannan.court.bean.News;
import com.gannan.court.bean.Ssfwzx;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.SsfwzxService;
import com.gannan.court.service.basics.WsmbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: SsfwzxIndexController
 * @Description: TODO
 * @Author: zsl
 * @Date: 2020/8/7 14:13
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前天诉讼服务中心的请求")
@RestController
public class SsfwzxIndexController {
    @Autowired
    SsfwzxService ssfwzxService;
    @Autowired
    WsmbService wsmbService;

    /**
     * @Description: addYyla方法是增加预约立案
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:25
     */

    @ApiOperation("预约立案增加")
    @PostMapping(value = "/addYyla")
    public ResponseWrapper addYyla(Ssfwzx ssfwzx){
        ResponseWrapper wrapper = ssfwzxService.addYyla(ssfwzx);
        return wrapper;
    }

    /**
     * @Description: wsmbSon方法是显示文书模板的子页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 20:25
     */

    @ApiOperation("文书模板页面")
    @GetMapping(value = "/wsmbSon")
    public ResponseWrapper wsmbSon(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        ResponseWrapper wrapper = wsmbService.findWsmbSon(pn);
        return wrapper;
    }

    @ApiOperation("文书模板下载文件")
    @RequestMapping("/wsmbdownload")
    public ResponseWrapper download(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam("id") Integer id) {
        ResponseWrapper wrapper = wsmbService.download(request,response,id);
        return wrapper;
    }
}
