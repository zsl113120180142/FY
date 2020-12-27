package com.gannan.court.jwt;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName: JWTToken
 * @Description: 配置token 实体bean进行扩展
 * @Author: zsl
 * @Date: 2020/8/1 19:03
 * @Version: v1.0
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String toString() {
        return "JWTToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
