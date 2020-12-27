package com.gannan.court.controller.backstage;

import com.gannan.court.config.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UpLoadController
 * @Description: 文件上传控制器
 * @Author: zsl
 * @Date: 2020/8/1 18:11
 * @Version: v1.0
 */
@Api(tags = "处理后文件上传的请求")
@RequestMapping("/index")
@RestController
public class UpLoadController {
    @Value("${picture.url}")
    private String picturepath;
    @Value("${picture.ip}")
    private String pictureip;

    @ApiOperation("图片上传增加")
    @RequestMapping(value="/fileUpload")
    public ResponseWrapper fileUpload(@RequestParam("file") MultipartFile file,
                                      HttpServletRequest request) throws IOException {
        //获取当前时间，用于创建子文件夹：newDir
        String sPath = picturepath;

//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//        String newDir = df.format(new Date())+"/";
        String serverPath = sPath;


        String resPath = sPath;
       // System.out.println("serverPath========"+serverPath);
       // System.out.println("resPath========"+resPath);
        if(file.isEmpty()){
            return ResponseWrapper.markError();
        }
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String name = String.valueOf(System.currentTimeMillis())+"."+suffix;
        int size = (int) file.getSize();
       // System.out.println(name + "-->" + size);

        //String path = serverPath ;
        File dest = new File(serverPath,name);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
            System.out.println(dest.getParentFile().getAbsolutePath());
        }


            BufferedImage bufferedImage = ImageIO.read(file.getInputStream()); // 通过MultipartFile得到InputStream，从而得到BufferedImage

            Integer width = bufferedImage.getWidth();
            Integer height = bufferedImage.getHeight();


        try {
            //file.transferTo(dest); //保存文件
            //压缩图片后保存
            Thumbnails.of(file.getInputStream())
                    .size(width,height)
//                    .keepAspectRatio(false)
                    .toFile(dest.getPath());


            String img = "http://"+pictureip+"/court/static/" + name;
            return ResponseWrapper.markSuccess(img);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseWrapper.markError();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseWrapper.markError();
        }
    }
}
