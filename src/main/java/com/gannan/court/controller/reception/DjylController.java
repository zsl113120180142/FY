package com.gannan.court.controller.reception;

import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.DwgzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DjylController
 * @Description: 前端党建引领的页面
 * @Author: zsl
 * @Date: 2020/8/6 9:48
 * @Version: v1.0
 */
@RequestMapping("/index")
@Api(tags = "处理前台党建引领的请求")
@RestController
public class DjylController {
    @Autowired
    DwgzService dwgzService;

    /**
     * @Description: djylPage方法是点击党建引领的所给出的首页面
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 18:49
     */

    @ApiOperation("党建引领页面")
    @GetMapping(value = "/djylPage")
    public ResponseWrapper djylPage() {
        ResponseWrapper wrapper = dwgzService.findAlldjylPage();
        return wrapper;
    }

    /**
     * @Description: finddjylById方法是点击党建引领的新闻标题时通过id查询全部内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 18:50
     */

    @ApiOperation("党建引领内容页面")
    @GetMapping(value = "/finddjylById")
    public ResponseWrapper finddjylById(@RequestParam("id") Integer id) {
        ResponseWrapper wrapper = dwgzService.finddjylById(id);
        return wrapper;
    }

    /**
     * @Description: djylSon方法是点击党建引领子类的标题所给出该子类下所有的标题
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 18:52
     */

    @ApiOperation("党建引领子页面")
    @GetMapping(value = "/djylSon")
    public ResponseWrapper djylSon(@RequestParam("category") String category,
                                   @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        ResponseWrapper wrapper = dwgzService.finddjylSonByCategory(category, pn);
        return wrapper;
    }

}
