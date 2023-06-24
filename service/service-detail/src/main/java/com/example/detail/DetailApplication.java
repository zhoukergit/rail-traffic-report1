package com.example.detail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * com.example.detail
 *
 * @author zhouke
 * 2022/4/26
 * 10:45
 * Steps：
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.detail.mapper")
@ComponentScan("com.example")
@EnableTransactionManagement
public class DetailApplication {
    public static void main(String[] args) {
        SpringApplication.run(DetailApplication.class,args);
    }
}
