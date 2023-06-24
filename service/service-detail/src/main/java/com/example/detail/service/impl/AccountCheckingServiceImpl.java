package com.example.detail.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.detail.entity.bo.AccountAnomalyBo;
import com.example.detail.entity.bo.AccountStatisticBo;
import com.example.detail.entity.dto.AccountAnomalyDto;
import com.example.detail.entity.dto.AccountStatisticDto;
import com.example.detail.entity.enums.OrderStatusEnum;
import com.example.detail.entity.enums.PayUnionOrderTypeEnum;
import com.example.detail.entity.query.AccountCheckingQuery;
import com.example.detail.mapper.AccountCheckingMapper;
import com.example.detail.service.AccountCheckingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.example.detail.service.impl
 *
 * @author zhouke
 * 2022/4/30
 * 11:25
 */
@Service
public class AccountCheckingServiceImpl implements AccountCheckingService {
    @Autowired
    AccountCheckingMapper accountCheckingMapper;

    @Override
    public List<AccountAnomalyDto> accountAnomalyPage(int current, int size, AccountCheckingQuery query) {
        IPage<AccountAnomalyBo> page = new Page<>(current, size);
        if (query == null) {
            accountCheckingMapper.checkAccountAnomaly(null, null, page);
        } else {
            accountCheckingMapper.checkAccountAnomaly(query.getStartTime(), query.getEndTime(), page);
        }
        List<AccountAnomalyDto> list = page.getRecords().stream().map(bo -> {
            System.out.println("bo = " + bo);
            AccountAnomalyDto dto = new AccountAnomalyDto();
            BeanUtils.copyProperties(bo, dto);
            dto.setBankOrderStatus(OrderStatusEnum.converterCodeToName(bo.getBankOrderStatus()));
            dto.setSysOrderType(PayUnionOrderTypeEnum.converterCodeToName(bo.getSysOrderType()));
            dto.setSysOrderStatus(OrderStatusEnum.converterCodeToName(bo.getSysOrderStatus()));
            System.out.println("dto = " + dto);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<AccountStatisticDto> accountStatisticsList(AccountCheckingQuery query) {
            List<AccountStatisticBo> bos;
        if (query != null) {
            bos = accountCheckingMapper.selectAccountStatistics(query.getStartTime(), query.getEndTime());
        }else {
            bos = accountCheckingMapper.selectAccountStatistics(null,null);
        }
        List<AccountStatisticDto> list = bos.stream().map(bo -> {
            AccountStatisticDto dto = new AccountStatisticDto();
            BeanUtils.copyProperties(bo, dto);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }
}
