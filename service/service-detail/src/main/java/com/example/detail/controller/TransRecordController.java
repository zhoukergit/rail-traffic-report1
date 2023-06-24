package com.example.detail.controller;


import com.example.common.entity.GlobalException;
import com.example.common.entity.ResultCode;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.detail.entity.dto.*;
import com.example.detail.entity.enums.TransTypeEnum;
import com.example.detail.entity.query.CardPaymentDetailsQuery;
import com.example.detail.entity.query.CardTransDetailsQuery;
import com.example.detail.entity.query.CodePaymentDetailsQuery;
import com.example.detail.service.TransRecordService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 交易记录 前端控制器
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@RestController
@RequestMapping("/detail")
@Api("明细报表.说明:以下所有API均为分页查询")
public class TransRecordController {
    @Autowired
    TransRecordService transRecordService;

    @ApiOperation("获取售卡明细")
    @PostMapping("/sellCardDetail/{current}/{size}")
    public List<SellCardDetailsDto> getSellCardDetails(@RequestBody(required = false) CardTransDetailsQuery query
            , @PathVariable @ApiParam("当前页码") int current
            , @PathVariable @ApiParam("每页显示数量") int size) {
        //封装为Query.Map一时爽,维护火葬场
        try {
            //这一步看情况删
            if (query!=null && query.getTransType() != null) {
                Integer number = TransTypeEnum.converterNameToCode(query.getTransType());
                assert number != null : new GlobalException(ResultCode.INPUT_ERROR, "交易类型输入错误");
                query.setTransType(number.toString());
            }
            List<SellCardDetailsDto> sellCardDetails = transRecordService.getSellCardDetails(current, size, query);
            return sellCardDetails;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(ResultCode.ERROR, "服务器炸了");
        }
    }

    @ApiOperation("获取退卡明细")
    @PostMapping("/refundCardDetail/{current}/{size}")
    public List<RefundCardDetailsDto> getRefundCardDetails(@RequestBody(required = false) CardTransDetailsQuery query
            , @PathVariable @ApiParam("当前页码") int current
            , @PathVariable @ApiParam("每页显示数量") int size) {
        //这一步看情况删
        if (query!=null && query.getTransType() != null) {
            Integer number = TransTypeEnum.converterNameToCode(query.getTransType());
           if (number == null) {
               throw new GlobalException(ResultCode.INPUT_ERROR, "交易类型输入错误");
           }
           query.setTransType(number.toString());
        }
        return transRecordService.getRefundCardDetails(current, size, query);
    }

    @ApiOperation("获取充值明细")
    @PostMapping("/topUpDetail/{current}/{size}")
    public List<TopUpDetailsDto> getTopUpDetails(@RequestBody(required = false) CardTransDetailsQuery query
            , @PathVariable @ApiParam("当前页码") int current
            , @PathVariable @ApiParam("每页显示数量") int size) {
        try {
            //这一步看情况删
            if (query!=null && query.getTransType() != null) {
                Integer number = TransTypeEnum.converterNameToCode(query.getTransType());
                assert number != null : new GlobalException(ResultCode.INPUT_ERROR, "交易类型输入错误");
                query.setTransType(number.toString());
            }
            return transRecordService.getTopUpDetails(current, size, query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(ResultCode.ERROR, "请检查输入");
        }
    }

    @ApiOperation("获取刷卡交易明细")
    @PostMapping("/cardPaymentDetail/{current}/{size}")
    public List<CardPaymentDetailsDto> getCardPaymentDetails(@RequestBody(required = false) CardPaymentDetailsQuery query
            , @PathVariable @ApiParam("当前页码") int current
            , @PathVariable @ApiParam("每页显示数量") int size) {
        return transRecordService.getCardPaymentDetails(current, size, query);
    }

    @ApiOperation("获取扫描交易明细")
    @PostMapping("/codePaymentDetail/{current}/{size}")
    public List<CodePaymentDetailsDto> getCodePaymentDetails(@RequestBody(required = false) CodePaymentDetailsQuery query
            , @PathVariable @ApiParam("当前页码") int current
            , @PathVariable @ApiParam("每页显示数量") int size) {
        //检查输入我就不写了
        return transRecordService.getCodePaymentDetails(current, size, query);
    }




}
