package com.example.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.example.educenter
 *
 * @author zhouke
 * 2022/3/15
 * 21:24
 * Steps：
 */
@ComponentScan({"com.example"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("com.example.educenter.mapper")
@EnableDiscoveryClient
public class ServiceUcApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceUcApplication.class, args);
	}
}
