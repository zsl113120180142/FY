package com.gannan.court.controller.backstage;


import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.HomeService;
import com.gannan.court.service.basics.CatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName: HomeController
 * @Description: 处理后台首页面的请求
 * @Author: zsl
 * @Date: 2020/8/2 9:33
 * @Version: v1.0
 */
@Api(tags = "处理后台首页面的请求")
@RestController
public class HomeController {

    @Autowired
    HomeService homeService;
    @Autowired
    CatalogService catalogService;


    /**
     * @Description: tree方法是左侧的树形结构，首页面左边的导航栏
     * @param:
     * @return: 以及一级目录，xxx；各自的二级目录；data
     * @auther: zsl
     * @date: 2020/8/5 19:29
     */

    @ApiOperation("左侧列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "category", value = "类别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "titlename", value = "名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "hcategory", value = "上一级类别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "htitlename", value = "上一级名称", required = true, dataType = "String")
    })
    @GetMapping(value = "/tree")
    public ResponseWrapper tree() {
        ResponseWrapper tree = homeService.Tree();
        return tree;
    }

    /**
     * @Description: findByCategory方法是点击左侧导航栏，找到左侧对应的内容
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 19:36
     */

    @ApiOperation("点击导航栏，通过类别来查询")
    @GetMapping(value = "/findByCategory")
    public ResponseWrapper findByCategory(@RequestParam("hcategory") String hcategory,
                                          @RequestParam(value = "category",defaultValue = "0") String category,
                                          @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
       ResponseWrapper wrapper = homeService.findByCategory(hcategory, category,pn);
        return wrapper;
    }

    /**
     * @Description: categoryList方法是每个修改按钮点击之后，要传递他的类别过来
     * @param: category 传递过来的类别
     * @return: 该目录下的所有类别d
     * @auther: zsl
     * @date: 2020/8/5 19:40
     */

    @ApiOperation("修改的列表")
    @GetMapping(value = "/categoryList")
    public ResponseWrapper categoryList(@RequestParam("category") String category){
        ResponseWrapper wrapper = catalogService.findHcategory(category);
        return wrapper;
    }


}
