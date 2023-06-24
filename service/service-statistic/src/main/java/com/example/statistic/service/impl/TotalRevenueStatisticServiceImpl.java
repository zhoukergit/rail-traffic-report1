package com.example.statistic.service.impl;

import com.example.common.entity.dto.TotalRevenueDto;
import com.example.statistic.entity.TotalRevenueStatistic;
import com.example.statistic.mapper.TotalRevenueStatisticMapper;
import com.example.statistic.service.TotalRevenueStatisticService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.statistic.service.client.ServiceDetailClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Service
public class TotalRevenueStatisticServiceImpl extends ServiceImpl<TotalRevenueStatisticMapper, TotalRevenueStatistic> implements TotalRevenueStatisticService {
    @Autowired
    ServiceDetailClient serviceDetailClient;
    @Override
    public void saveTotalRevenueStatistic(String date){
        if (!StringUtils.hasLength(date)){
            date = LocalDate.now().toString();
        }

        TotalRevenueDto dto = serviceDetailClient.getTotalRevenueDto(date).getData();
        TotalRevenueStatistic totalRevenueStatistic = new TotalRevenueStatistic();
        BeanUtils.copyProperties(dto,totalRevenueStatistic);
        baseMapper.insert(totalRevenueStatistic);
    }
}
