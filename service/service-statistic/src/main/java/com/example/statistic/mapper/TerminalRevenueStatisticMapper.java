package com.example.statistic.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.statistic.entity.TerminalRevenueStatistic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.statistic.entity.bo.TerminalRevenueBo;
import com.example.statistic.entity.query.TerminalRevenueStatisticQuery;
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
public interface TerminalRevenueStatisticMapper extends BaseMapper<TerminalRevenueStatistic> {
    List<TerminalRevenueBo> selectTerminalRevenueStatistic(
            @Param("terminalType") Integer terminalType,
            @Param("transType") Integer transType,
            @Param("ew")QueryWrapper<TerminalRevenueBo> queryWrapper);
}
