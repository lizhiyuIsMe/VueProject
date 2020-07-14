package com.lizhiyu.demo.config.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    Boolean swaggerEnabled=true;

    //创建两个Docket  其中这个是普通用户的
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.lizhiyu.demo"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                //.paths(PathSelectors.any())
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }


    //创建两个Docket  其中这个是管理员的
    @Bean
    public Docket createAdminRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.lizhiyu.demo"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                //.paths(PathSelectors.any())
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2 的界面")
                .description("本网站的接口和文档")
                // 作者信息
                .contact(new Contact("lizhiyu", "https://www.baidu.com", "2905928567@qq.com"))
                .version("1.0.0")
                .build();
    }
}
