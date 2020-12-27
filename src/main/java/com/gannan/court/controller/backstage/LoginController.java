package com.gannan.court.controller.backstage;


import com.gannan.court.bean.Admin;
import com.gannan.court.config.ResponseWrapper;
import com.gannan.court.jwt.JWTUtil;
import com.gannan.court.service.basics.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName: AdminController
 * @Description:关于登录的相关操作
 * @Author: zsl
 * @Date: 2020/8/1 10:30
 * @Version: v1.0
 */
@Api(tags = "关于登录的相关操作" )
@RestController
public class LoginController {

    @Autowired
    AdminService adminService;

    /**
     * @Description: login方法是处理登录方法
     * @param: username 账号 password 密码
     * @return:token 令牌，秘钥；（24小时候过期）
     * @auther: zsl
     * @date: 2020/8/2 9:57
     */
    @ApiOperation("用户登录的操作")
    @PostMapping(value="/login")
    public ResponseWrapper login(Admin admin){
        if (admin==null){
            return ResponseWrapper.markParamError();
        }else {
            Admin userInfo = null;
            List<Admin> list = adminService.getAdminByName(admin.getUsername());
            if (list.size() == 0) {
                return ResponseWrapper.markCustom(false, "1000", "用户不存在", null);
            } else {
                userInfo = list.get(0);
                String realPassword = userInfo.getPassword();
                if (!realPassword.equals(admin.getPassword())) {
                    return ResponseWrapper.markCustom(false, "1000", "密码错误", null);
                }
            }
            Map<String, Object> map = new HashMap<>();
            map.put("token", JWTUtil.createToken(admin.getUsername()));
            return ResponseWrapper.markSuccess(map);
        }
    }
}
