package com.example.detail.controller;

import com.example.detail.entity.bo.AccountStatisticBo;
import com.example.detail.entity.dto.AccountAnomalyDto;
import com.example.detail.entity.dto.AccountStatisticDto;
import com.example.detail.entity.query.AccountCheckingQuery;
import com.example.detail.mapper.AccountCheckingMapper;
import com.example.detail.service.AccountCheckingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.example.detail.controller
 *
 * @author zhouke
 * 2022/4/29
 * 19:00
 * 商户订单号、交易时间、银行流水账单支付详情、系统及时反馈支付详情和消费详情
 */

@RestController
@RequestMapping("/account")
@Api("对账报表")
public class AccountCheckingController {
    @Autowired
    AccountCheckingService accountCheckingService;


    @PostMapping("/anomaly/{current}/{size}")
    @ApiOperation("获取对账异常报表")
    public List<AccountAnomalyDto> getAnomalyReport(@PathVariable int current, @PathVariable int size, @RequestBody(required = false) @ApiParam("startTime,endTime,可选") AccountCheckingQuery query) {
        return accountCheckingService.accountAnomalyPage(current, size, query);
    }

    @PostMapping("/statistics/{current}/{size}")
    @ApiOperation("获取对账统计报表")
    public List<AccountStatisticDto> getStatisticsReport(@RequestBody AccountCheckingQuery query) {
        return accountCheckingService.accountStatisticsList(query);
    }

}
