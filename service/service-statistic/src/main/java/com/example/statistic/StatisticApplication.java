package com.example.statistic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * com.example.statistic
 *
 * @author zhouke
 * 2022/5/4
 * 15:02
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan("com.example.statistic.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class StatisticApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticApplication.class,args);
    }
}
