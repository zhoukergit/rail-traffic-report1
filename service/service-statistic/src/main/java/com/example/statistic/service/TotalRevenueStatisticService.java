package com.example.statistic.service;

import com.example.statistic.entity.TotalRevenueStatistic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
public interface TotalRevenueStatisticService extends IService<TotalRevenueStatistic> {
    void saveTotalRevenueStatistic(String date);
}
