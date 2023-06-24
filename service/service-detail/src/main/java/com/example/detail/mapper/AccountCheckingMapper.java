package com.example.detail.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.detail.entity.bo.AccountAnomalyBo;
import com.example.detail.entity.bo.AccountStatisticBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.example.detail.mapper
 *
 * @author zhouke
 * 2022/4/29
 * 22:12
 */
public interface AccountCheckingMapper {
    IPage<AccountAnomalyBo> checkAccountAnomaly(@Param("startTime") String startTime, @Param("endTime") String endTime, IPage<AccountAnomalyBo> page);

    List<AccountStatisticBo> selectAccountStatistics(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
