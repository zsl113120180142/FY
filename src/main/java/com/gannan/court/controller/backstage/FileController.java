package com.gannan.court.controller.backstage;

import com.gannan.court.bean.Wsmb;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.dao.WsmbMapper;
import com.gannan.court.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @ClassName: FileController
 * @Description: 文件的上传和下载
 * @Author: zsl
 * @Date: 2020/8/8 15:43
 * @Version: v1.0
 */
@RestController
public class FileController {

    @Autowired
    FileService fileService;

    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    public ResponseWrapper uploading(@RequestParam("file") MultipartFile file) {
       ResponseWrapper wrapper = fileService.uploading(file);
       return wrapper;
    }
}
