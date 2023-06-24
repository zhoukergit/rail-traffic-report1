package com.example.common.config;

/**
 * com.example.demo.config
 *
 * @author zhouke
 * 2022/1/26
 * 11:41
 * Steps：
 */

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //加入乐观锁
//        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //加入分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
