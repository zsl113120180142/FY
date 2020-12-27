package com.gannan.court.service.basics;

import com.gannan.court.bean.Admin;
import com.gannan.court.bean.AdminExample;
import com.gannan.court.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AdminService
 * @Description: 处理登录相关的操作
 * @Author: zsl
 * @Date: 2020/8/1 19:05
 * @Version: v1.0
 */
@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /**
     * @Description: getAdminByName方法是通过用户名查找密码
     * @param:
     * @return: username相匹配的用户信息
     * @auther: zsl
     * @date: 2020/8/1 19:45
     */
    public List<Admin> getAdminByName(String username) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins;
    }

}
