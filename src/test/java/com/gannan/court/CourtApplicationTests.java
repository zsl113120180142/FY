package com.gannan.court;

import com.gannan.court.bean.Admin;
import com.gannan.court.bean.Catalog;
import com.gannan.court.bean.Picture;
import com.gannan.court.bean.Zxhd;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.AdminMapper;
import com.gannan.court.service.HomeService;
import com.gannan.court.service.IndexService;
import com.gannan.court.service.basics.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CourtApplicationTests {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    HomeService homeService;
    @Autowired
    PictureService pictureService;
    @Autowired
    NewsService newsService;
    @Autowired
    IndexService indexService;
    @Autowired
    DwgzService dwgzService;
    @Autowired
    ZxhdService zxhdService;
    @Autowired
    WhzbService whzbService;

    @Test
    void contextLoads() {

        System.out.println(whzbService.findAllfywhPage());
    }

}
