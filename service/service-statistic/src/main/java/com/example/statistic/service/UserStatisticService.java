package com.example.statistic.service;

import com.example.statistic.entity.UserStatistic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * <p>
 * 操作员统计表 服务类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
public interface UserStatisticService extends IService<UserStatistic> {
    public boolean save(@Nullable String date);
}
