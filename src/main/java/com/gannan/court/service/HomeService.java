package com.gannan.court.service;

import com.gannan.court.bean.*;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.service.basics.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HomeService
 * @Description: 处理来自HomeController的请求
 * @Author: zsl
 * @Date: 2020/8/2 10:04
 * @Version: v1.0
 */
@Service
public class HomeService {

    @Autowired
    CatalogService catalogService;
    @Autowired
    PictureService pictureService;
    @Autowired
    DwgzService dwgzService;
    @Autowired
    NewsService newsService;
    @Autowired
    CourtintroduceService courtintroduceService;
    @Autowired
    SfgkService sfgkService;
    @Autowired
    WhzbService whzbService;
    @Autowired
    ZxhdService zxhdService;
    @Autowired
    WsmbService wsmbService;
    @Autowired
    SsfwzxService ssfwzxService;


    /**
     * @Description: findByCategory方法是将得到的hcategory进行分类，再通通过category查询全部信息
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/3 9:08
     */

    public ResponseWrapper findByCategory(String hcategory, String category,Integer pn) {
        if (hcategory.equals("")&&category.equals("")){
            return ResponseWrapper.markParamError();
        }else {
            switch (hcategory) {
                case "picture":
                    PageHelper.startPage(pn, 10);
                    List<Picture> pictures = pictureService.findAll();
                    PageInfo picturepage = new PageInfo(pictures, 10);
                    return ResponseWrapper.markSuccess(picturepage);
                case "dwgz":
                    PageHelper.startPage(pn, 10);
                    List<Dwgz> dwgzList = dwgzService.findByCategory(category);
                    PageInfo dwgzpage = new PageInfo(dwgzList, 10);
                    return ResponseWrapper.markSuccess(dwgzpage);
                case "news":
                    PageHelper.startPage(pn, 10);
                    List<News> news = newsService.findByCategory(category);
                    PageInfo newspage = new PageInfo(news, 10);
                    return ResponseWrapper.markSuccess(newspage);
                case "courtintroduce":
                    PageHelper.startPage(pn, 10);
                    List<Courtintroduce> courtintroduces = courtintroduceService.findByCategory(category);
                    PageInfo courtintroducepage = new PageInfo(courtintroduces, 10);
                    return ResponseWrapper.markSuccess(courtintroducepage);
                case "sfgk":
                    PageHelper.startPage(pn, 10);
                    List<Sfgk> sfgkList = sfgkService.findByCategory(category);
                    PageInfo sfgkpage = new PageInfo(sfgkList, 10);
                    return ResponseWrapper.markSuccess(sfgkpage);
                case "fywh":
                    PageHelper.startPage(pn, 10);
                    List<Whzb> whzbList = whzbService.findByCategory(category);
                    PageInfo whzbpage = new PageInfo(whzbList, 10);
                    return ResponseWrapper.markSuccess(whzbpage);
                case "zxhd":
                    PageHelper.startPage(pn, 10);
                    List<Zxhd> zxhdList = zxhdService.findByCategory(category);
                    PageInfo zxhdpage = new PageInfo(zxhdList, 10);
                    return ResponseWrapper.markSuccess(zxhdpage);
                case "ssfwzx":
                    if (category.equals("wsmb")){
                        PageHelper.startPage(pn, 10);
                        List<Wsmb> wsmbList = wsmbService.findAll();
                        PageInfo wsmbpage = new PageInfo(wsmbList, 10);
                        return ResponseWrapper.markSuccess(wsmbpage);
                    }else if (category.equals("yyla")){
                        PageHelper.startPage(pn, 10);
                        List<Ssfwzx> ssfwzxList = ssfwzxService.findAllYyla();
                        PageInfo ssfwzxpage = new PageInfo(ssfwzxList, 10);
                        return ResponseWrapper.markSuccess(ssfwzxpage);
                    }
            }
            return ResponseWrapper.markError();
        }
    }

    /**
     * @Description: Tree方法是构成二级树形，构成左边侧边栏
     * @param: 
     * @return: 
     * @auther: zsl
     * @date: 2020/8/3 9:06
     */
    
    public ResponseWrapper Tree() {
        List<Catalog> catalogs = catalogService.findByHcategory("top");
        for (int i = 0; i < catalogs.size(); i++) {
            String hname = catalogs.get(i).getCategory();
            List<Catalog> catalogList = catalogService.findByHcategory(hname);
            catalogs.get(i).setCatalogList(catalogList);
        }
        Catalog picture = new Catalog();
        picture.setCategory("picture");
        picture.setTitlename("轮播图片管理");
        picture.setHcategory("picture");
        picture.setHtitlename("图片管理");
        Catalog pictureson = new Catalog();
        pictureson.setCategory("picture");
        pictureson.setTitlename("轮播图片管理");
        pictureson.setHcategory("picture");
        pictureson.setHtitlename("图片管理");
        List<Catalog> picturesons = new ArrayList<>();
        picturesons.add(pictureson);
        picture.setCatalogList(picturesons);
        catalogs.add(picture);
        return ResponseWrapper.markSuccess(catalogs);
    }



}
