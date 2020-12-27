package com.gannan.court.service;

import com.gannan.court.config.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: FileService
 * @Description: 文件的上传下载
 * @Author: zsl
 * @Date: 2020/8/8 16:21
 * @Version: v1.0
 */
@Service
public class FileService {

    @Value("${filepath}")
    private String filepath;
    @Value("${picture.ip}")
    private String pictureip;

    Logger logger = LoggerFactory.getLogger(FileService.class);

    /**
     * @Description: uploading方法是文件上传
     * @param:
     * @return:
     * @auther: zsl
     * @date: 2020/8/8 16:27
     */

    public ResponseWrapper uploading(MultipartFile file) {
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath + file.getOriginalFilename());) {
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件上传失败!");
            return ResponseWrapper.markError();
        }
        Map<String ,Object> map = new HashMap<>();
        map.put("filePath", filepath + file.getOriginalFilename());
        map.put("fileName",file.getOriginalFilename());
        logger.info("文件上传成功!");
        return ResponseWrapper.markSuccess(map);
    }

    public ResponseWrapper download(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) {
        //下载的文件路径
        //下载后的文件名


        //使用流的形式下载文件
        try {
            File file = new File(filePath);
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            return ResponseWrapper.markSuccess("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseWrapper.markError();
        }
    }


}
