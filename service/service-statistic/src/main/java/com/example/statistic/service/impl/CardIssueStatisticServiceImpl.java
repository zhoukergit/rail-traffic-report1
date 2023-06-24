package com.example.statistic.service.impl;

import com.example.common.entity.GlobalException;
import com.example.common.entity.R;
import com.example.common.entity.ResultCode;
import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.statistic.entity.CardIssueStatistic;
import com.example.statistic.mapper.CardIssueStatisticMapper;
import com.example.statistic.service.CardIssueStatisticService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.statistic.service.client.ServiceDetailClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
public class CardIssueStatisticServiceImpl extends ServiceImpl<CardIssueStatisticMapper, CardIssueStatistic> implements CardIssueStatisticService {
    @Autowired
    ServiceDetailClient serviceDetailClient;

    @Override
    public void saveCardIssueStatistics(@Nullable String date){
        if (!StringUtils.hasLength(date)) {
            date = LocalDate.now().toString();
        }
        R<CardIssueStatisticDto> body = serviceDetailClient.getCardIssueStatistic(date);
        CardIssueStatisticDto dto = body.getData();
        if (dto.getDate() == null){
            throw new GlobalException(ResultCode.ERROR,"未查询到当日数据");
        }
        CardIssueStatistic cardIssueStatistic = new CardIssueStatistic();
        BeanUtils.copyProperties(dto,cardIssueStatistic);
        baseMapper.insert(cardIssueStatistic);
    }
}
