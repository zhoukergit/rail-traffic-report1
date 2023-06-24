package com.example.detail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.common.entity.dto.TotalRevenueDto;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.detail.entity.TransRecord;
import com.example.detail.entity.bo.CardPaymentDetailsBo;
import com.example.detail.entity.bo.CodePaymentDetailsBo;
import com.example.detail.entity.dto.*;
import com.example.detail.entity.bo.CardDetailsBo;
import com.example.detail.entity.enums.TransTypeEnum;
import com.example.detail.entity.query.CardPaymentDetailsQuery;
import com.example.detail.entity.query.CardTransDetailsQuery;
import com.example.detail.entity.query.CodePaymentDetailsQuery;
import com.example.detail.mapper.TransRecordMapper;
import com.example.detail.service.TransRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 交易记录 服务实现类
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Service
public class TransRecordServiceImpl extends ServiceImpl<TransRecordMapper, TransRecord> implements TransRecordService {

    @Override
    public List<SellCardDetailsDto> getSellCardDetails(int current, int size, CardTransDetailsQuery query) {
        IPage<CardDetailsBo> page = new Page<>(current, size);
        QueryWrapper<CardDetailsBo> wrapper = new QueryWrapper<>();
        wrapper.eq("data_type", 1);
        if (query != null) {
            wrapper.eq(StringUtils.hasLength(query.getUserId()), "user_id", query.getUserId())
                    .eq(StringUtils.hasLength(query.getTransType()), "trans_type", query.getTransType())
                    .eq(StringUtils.hasLength(query.getTerminalNo()), "terminal_no", query.getTerminalNo())
                    .eq(StringUtils.hasLength(query.getTicketType()), "ticket_type", query.getTicketType())
                    .ge(StringUtils.hasLength(query.getStartTime()), "trans_time", query.getStartTime())
                    .le(StringUtils.hasLength(query.getEndTime()), "trans_time", query.getEndTime())
                    .orderBy(true, false, "trans_time");
        }
        baseMapper.getCardTransDetailsPage(page, wrapper);
        List<CardDetailsBo> records = page.getRecords();
        if (records == null) {
            return null;
        }
        List<SellCardDetailsDto> dtos = records.stream().map(
                bo -> {
                    SellCardDetailsDto dto = new SellCardDetailsDto();
                    BeanUtils.copyProperties(bo, dto);
                    //转换transType 数字->名称,便于前端显示,也可以不修改
                    dto.setTransType(TransTypeEnum.converterCodeToName(bo.getTransType()));
                    //转换TVM,BOM为储值卡
                    if ("BOM".equals(bo.getTicketType()) || "TVM".equals(bo.getTicketType())) {
                        dto.setTicketType("储值票");
                    }
                    return dto;
                }
        ).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<RefundCardDetailsDto> getRefundCardDetails(int current, int size, CardTransDetailsQuery query) {
        IPage<CardDetailsBo> page = new Page<>(current, size);
        QueryWrapper<CardDetailsBo> wrapper = new QueryWrapper<>();
        wrapper.eq("data_type", 2);
        if (query != null) {
            wrapper.eq(StringUtils.hasLength(query.getUserId()), "user_id", query.getUserId())
                    .eq(StringUtils.hasLength(query.getTransType()), "trans_type", query.getTransType())
                    .eq(StringUtils.hasLength(query.getTerminalNo()), "terminal_no", query.getTerminalNo())
                    .eq(StringUtils.hasLength(query.getTicketType()), "ticket_type", query.getTicketType())
                    .ge(StringUtils.hasLength(query.getStartTime()), "trans_time", query.getStartTime())
                    .le(StringUtils.hasLength(query.getEndTime()), "trans_time", query.getEndTime())
                    .orderBy(true, false, "trans_time");

        }
        baseMapper.getCardTransDetailsPage(page, wrapper);
        List<CardDetailsBo> records = page.getRecords();
        if (records == null) {
            return null;
        }
        List<RefundCardDetailsDto> dtos = records.stream().map(
                bo -> {
                    RefundCardDetailsDto dto = new RefundCardDetailsDto();
                    BeanUtils.copyProperties(bo, dto);
                    //修改transType 数字->名称,便于前端显示,也可以不修改
                    dto.setTransType(TransTypeEnum.converterCodeToName(bo.getTransType()));
                    return dto;
                }
        ).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<TopUpDetailsDto> getTopUpDetails(int current, int size, CardTransDetailsQuery query) {
        IPage<CardDetailsBo> page = new Page<>(current, size);
        QueryWrapper<CardDetailsBo> wrapper = new QueryWrapper<>();
        wrapper.eq("data_type", 3);
        if (query != null) {
            wrapper.eq(StringUtils.hasLength(query.getUserId()), "user_id", query.getUserId())
                    .eq(StringUtils.hasLength(query.getTransType()), "trans_type", query.getTransType())
                    .eq(StringUtils.hasLength(query.getTerminalNo()), "terminal_no", query.getTerminalNo())
                    .eq(StringUtils.hasLength(query.getTicketType()), "ticket_type", query.getTicketType())
                    .ge(StringUtils.hasLength(query.getStartTime()), "trans_time", query.getStartTime())
                    .le(StringUtils.hasLength(query.getEndTime()), "trans_time", query.getEndTime())
                    .orderBy(true, false, "trans_time");

        }
        baseMapper.getCardTransDetailsPage(page, wrapper);
        List<CardDetailsBo> records = page.getRecords();
        if (records == null) {
            return null;
        }
        List<TopUpDetailsDto> dtos = records.stream().map(
                bo -> {
                    TopUpDetailsDto dto = new TopUpDetailsDto();
                    BeanUtils.copyProperties(bo, dto);
                    //修改transType 数字->名称,便于前端显示,也可以不修改
                    dto.setTransType(TransTypeEnum.converterCodeToName(bo.getTransType()));
                    //转换TVM,BOM为储值卡
                    if ("BOM".equals(bo.getTicketType()) || "TVM".equals(bo.getTicketType())) {
                        dto.setTicketType("储值票");
                    }
                    return dto;
                }
        ).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<CardPaymentDetailsDto> getCardPaymentDetails(int current, int size, CardPaymentDetailsQuery query) {
        IPage<CardPaymentDetailsBo> page = new Page<>(current, size);
        QueryWrapper<CardPaymentDetailsBo> wrapper = new QueryWrapper<>();
        wrapper.eq("data_type", 4);
        if (query != null) {
            wrapper.eq(StringUtils.hasLength(query.getUserId()), "user_id", query.getUserId())
                    .eq(StringUtils.hasLength(query.getCardNo()), "card_no", query.getCardNo())
                    .eq(StringUtils.hasLength(query.getTerminalNo()), "terminal_no", query.getTerminalNo())
                    .eq(StringUtils.hasLength(query.getTicketType()), "ticket_type", query.getTicketType())
                    .ge(StringUtils.hasLength(query.getStartTime()), "trans_time", query.getStartTime())
                    .le(StringUtils.hasLength(query.getEndTime()), "trans_time", query.getEndTime())
                    .orderBy(true, false, "trans_time");

        }
        baseMapper.getCardPaymentDetailsPage(page, wrapper);
        List<CardPaymentDetailsBo> records = page.getRecords();
        List<CardPaymentDetailsDto> dtoList = records.stream().map(
                bo -> {
                    CardPaymentDetailsDto dto = new CardPaymentDetailsDto();
                    BeanUtils.copyProperties(bo, dto);
                    return dto;
                }
        ).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<CodePaymentDetailsDto> getCodePaymentDetails(int current, int size, CodePaymentDetailsQuery query) {
        IPage<CodePaymentDetailsBo> page = new Page<>(current, size);
        //有个很坑的地方,wrapper可以用在多表查询,但前提是wrapper里面不能包括从表的字段
        //原因使用分页查询时会先查一次count(*) as total,这是单表查询,还会带上wrapper的条件
//        QueryWrapper<CodePaymentDetailsBo> wrapper = new QueryWrapper<>();
//        wrapper.eq("data_type", 5);
//        if (query != null) {
//            wrapper.eq(StringUtils.hasLength(query.getVoucherNo()), "voucher_no", query.getVoucherNo())
//                    .ge(StringUtils.hasLength(query.getStartTime()), "trans_time", query.getStartTime())
//                    .le(StringUtils.hasLength(query.getEndTime()), "trans_time", query.getEndTime())
//                    .orderBy(true, false, "trans_time");
//
//        }
        baseMapper.getCodePaymentDetailsPage(page, query);
        List<CodePaymentDetailsBo> records = page.getRecords();
        List<CodePaymentDetailsDto> dtoList = records.stream().map(
                bo -> {
                    CodePaymentDetailsDto dto = new CodePaymentDetailsDto();
                    BeanUtils.copyProperties(bo, dto);
                    return dto;
                }
        ).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<UserStatisticDto> getBaseUserStatisticFromTransRecord(String date) {
        return baseMapper.selectBaseUserStatisticFromTransRecord(date);
    }

    @Override
    public CardIssueStatisticDto getCardIssueStatistic(String date) {
        return baseMapper.selectCardIssueStatistic(date);
    }

    @Override
    public List<TerminalRevenueDto> getTerminalRevenueDto(String date) {
        return baseMapper.selectTerminalRevenueDto(date);
    }

    @Override
    public TotalRevenueDto getTotalRevenueDto(String date) {
        return baseMapper.selectTotalRevenueDto(date);
    }
}
