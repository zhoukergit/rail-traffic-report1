package com.example.detail.controller;

import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.common.entity.dto.TotalRevenueDto;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.detail.service.TransRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.example.detail.controller
 *
 * @author zhouke
 * 2022/5/5
 * 19:53
 */
@RestController
@RequestMapping("/inner/statistic")
@ApiOperation("不要调这个接口!我懒得设置忽略了")
public class StatisticController {
    @Autowired
    TransRecordService transRecordService;

    @ApiOperation("内部接口,获取当日的设备交易流水")
    @GetMapping("userStatistic")
    public List<UserStatisticDto> getUserStatisticDto(@RequestParam String date) {
        return transRecordService.getBaseUserStatisticFromTransRecord(date);
    }

    @ApiOperation("内部接口,获取票卡发行统计")
    @GetMapping("cardIssue")
    public CardIssueStatisticDto getCardIssueStatistic(@RequestParam String date) {
        return transRecordService.getCardIssueStatistic(date);
    }

    @ApiOperation("内部接口,获取各设备交易流水")
    @GetMapping("terminalRevenue")
    public List<TerminalRevenueDto> getTerminalRevenueDto(@RequestParam String date) {
        return transRecordService.getTerminalRevenueDto(date);
    }

    @ApiOperation("内部接口,获取总交易流水")
    @GetMapping("totalRevenue")
    public TotalRevenueDto getTotalRevenueDto(@RequestParam String date) {
        return transRecordService.getTotalRevenueDto(date);
    }


}
