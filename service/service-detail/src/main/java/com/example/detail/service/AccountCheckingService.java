package com.example.detail.service;

import com.example.detail.entity.dto.AccountAnomalyDto;
import com.example.detail.entity.dto.AccountStatisticDto;
import com.example.detail.entity.query.AccountCheckingQuery;

import java.util.List;

/**
 * com.example.detail.service
 *
 * @author zhouke
 * 2022/4/30
 * 11:24
 */
public interface AccountCheckingService {
    /**
     * 对账异常
     * @param current
     * @param size
     * @param query
     * @return
     */
    List<AccountAnomalyDto> accountAnomalyPage(int current, int size, AccountCheckingQuery query);

    /**
     * 对账统计
     * @param query
     * @return
     */
    List<AccountStatisticDto> accountStatisticsList(AccountCheckingQuery query);

}
