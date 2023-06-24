package com.example.statistic.service;

import com.example.statistic.entity.TerminalRevenueStatistic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.statistic.entity.dto.BOMRevenueDto;
import com.example.statistic.entity.dto.TVMRevenueDto;
import com.example.statistic.entity.query.TerminalRevenueStatisticQuery;
import io.swagger.models.auth.In;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
public interface TerminalRevenueStatisticService extends IService<TerminalRevenueStatistic> {
    void saveTerminalRevenueStatistic(@Nullable String date);
    List<BOMRevenueDto> getBOMRevenueStatistics(Integer transType, TerminalRevenueStatisticQuery query);
    List<TVMRevenueDto> getTVMRevenueStatistics(Integer transType, TerminalRevenueStatisticQuery query);
}
