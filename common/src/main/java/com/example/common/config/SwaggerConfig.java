package com.example.common.config;

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

/**
 *
 * @author zhouke
 * 2022/1/26
 * 21:09
 * Steps：
 */

@Configuration//配置类
@EnableSwagger2 //swagger注解
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))//配置希望被扫描的包
//                .paths(Predicates.and(PathSelectors.regex("/entity/.*?")))
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .groupName("默认分组");

    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("轨道交通生产系统API文档")
                .description("轨道交通运营生产报表系统说明")
                .version("1.0")
                .contact(new Contact("java", "http://rnm.yidongzhenka.top", "shabiyidong@qq.com"))
                .build();
    }
}

