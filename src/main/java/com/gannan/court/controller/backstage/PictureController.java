package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Picture;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.CatalogService;
import com.gannan.court.service.basics.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PictureController
 * @Description: 用来处理关于图片管理
 * @Author: zsl
 * @Date: 2020/8/3 9:54
 * @Version: v1.0
 */
@Api(tags = "处理图片轮播的请求")
@RestController
public class PictureController {
    @Autowired
    PictureService pictureService;

    /**
     * @Description: addPicture方法是新增图片
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/3 11:12
     */
    
    @ApiOperation("图片增加")
    @PostMapping(value = "/addPicture")
    public ResponseWrapper addPicture(Picture picture) {
            ResponseWrapper wrapper = pictureService.addPicture(picture);
            return wrapper;
    }

    /**
     * @Description: deletePicture方法是图片删除
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 14:16
     */
    @ApiOperation("图片删除")
    @DeleteMapping(value = "/deletePicture")
    public ResponseWrapper deletePicture(@RequestParam("ids") String ids){
            ResponseWrapper wrapper = pictureService.deletePicture(ids);
            return wrapper;
    }

    /**
     * @Description: updataPicture方法是图片修改
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/5 15:07
     */

    @ApiOperation("图片修改")
    @PutMapping(value = "/updataPicture")
    public ResponseWrapper updataPicture(Picture picture){
            ResponseWrapper wrapper = pictureService.updataPicture(picture);
            return wrapper;
    }

}
