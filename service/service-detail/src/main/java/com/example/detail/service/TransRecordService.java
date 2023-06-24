package com.example.detail.service;

import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.common.entity.dto.TotalRevenueDto;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.detail.entity.TransRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.detail.entity.dto.*;
import com.example.detail.entity.query.CardPaymentDetailsQuery;
import com.example.detail.entity.query.CardTransDetailsQuery;
import com.example.detail.entity.query.CodePaymentDetailsQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * <p>
 * 交易记录 服务类
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
public interface TransRecordService extends IService<TransRecord> {
    List<SellCardDetailsDto> getSellCardDetails(int current, int size, CardTransDetailsQuery query);
    List<RefundCardDetailsDto> getRefundCardDetails(int current, int size, CardTransDetailsQuery query);
    List<TopUpDetailsDto> getTopUpDetails(int current, int size, CardTransDetailsQuery query);
    List<CardPaymentDetailsDto> getCardPaymentDetails(int current, int size, CardPaymentDetailsQuery query);
    List<CodePaymentDetailsDto> getCodePaymentDetails(int current, int size, @Param("query") CodePaymentDetailsQuery query);
    List<UserStatisticDto> getBaseUserStatisticFromTransRecord(String date);
    CardIssueStatisticDto getCardIssueStatistic(String date);
    List<TerminalRevenueDto> getTerminalRevenueDto(String date);

    TotalRevenueDto getTotalRevenueDto(String date);
}
