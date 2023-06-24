package com.example.statistic.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.statistic.entity.TotalRevenueStatistic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.statistic.entity.bo.TerminalRevenueBo;
import com.example.statistic.entity.dto.BOMRevenueDto;
import com.example.statistic.entity.dto.TVMRevenueDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
public interface TotalRevenueStatisticMapper extends BaseMapper<TotalRevenueStatistic> {

}
