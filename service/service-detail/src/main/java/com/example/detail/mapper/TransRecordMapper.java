package com.example.detail.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.common.entity.dto.TotalRevenueDto;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.detail.entity.TransRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.detail.entity.bo.CardDetailsBo;
import com.example.detail.entity.bo.CardPaymentDetailsBo;
import com.example.detail.entity.bo.CodePaymentDetailsBo;
import com.example.detail.entity.query.CardTransDetailsQuery;
import com.example.detail.entity.query.CodePaymentDetailsQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 交易记录 Mapper 接口
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
public interface TransRecordMapper extends BaseMapper<TransRecord> {
    CardDetailsBo getCardTransDetails(@Param("current") int current, @Param("size") int size, CardTransDetailsQuery sellCardDetailsQuery);

    /**
     * 引入mybatis-plus,增加分页查询
     */
    IPage<CardDetailsBo> getCardTransDetailsPage(IPage<CardDetailsBo> page, @Param("ew") QueryWrapper<CardDetailsBo> wrapper);


    IPage<CodePaymentDetailsBo> getCodePaymentDetailsPage(IPage<CodePaymentDetailsBo> page
            , CodePaymentDetailsQuery query);

    IPage<CardPaymentDetailsBo> getCardPaymentDetailsPage(IPage<CardPaymentDetailsBo> page
            , @Param("ew") QueryWrapper<CardPaymentDetailsBo> wrapper);

    List<UserStatisticDto> selectBaseUserStatisticFromTransRecord(@Param("date") String date);

    CardIssueStatisticDto selectCardIssueStatistic(@Param("date") String date);

    List<TerminalRevenueDto> selectTerminalRevenueDto(@Param("date") String date);

    TotalRevenueDto selectTotalRevenueDto(@Param("date") String date);

}
