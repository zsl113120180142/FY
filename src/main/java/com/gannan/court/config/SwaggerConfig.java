package com.gannan.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description: 用来配置API接口的swagger
 * @Author: zsl
 * @Date: 2020/8/1 16:13
 * @Version: v1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        /*
        通过createRestApi创建docket
        apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
        select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
        扫描cn.huangwei.controller包下面定义的方法作为展示的RestFul api，产生文档内容
         */
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.gannan.court.controller"))
                .paths(PathSelectors.any()).build();
    }

    /*
    定义展示的信息，例如标题、描述、版本等
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("法院网站api文档").description("法院网站api文档")
                .termsOfServiceUrl("http://127.0.0.1:8089/api").version("1.0").build();
    }
}
