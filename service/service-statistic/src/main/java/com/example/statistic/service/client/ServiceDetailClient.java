package com.example.statistic.service.client;

import com.example.common.entity.R;
import com.example.common.entity.dto.CardIssueStatisticDto;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.common.entity.dto.TotalRevenueDto;
import com.example.common.entity.dto.UserStatisticDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * com.example.statistic.service.client
 *
 * @author zhouke
 * 2022/5/5
 * 19:49
 */
@FeignClient("service-detail")
public interface ServiceDetailClient {

    @GetMapping("/inner/statistic/userStatistic")
    R<List<UserStatisticDto>> getUserStatisticDto(@RequestParam String date);

    @GetMapping("/inner/statistic/cardIssue")
    R<CardIssueStatisticDto> getCardIssueStatistic(@RequestParam String date);

    @GetMapping("/inner/statistic/terminalRevenue")
    R<List<TerminalRevenueDto>> getTerminalRevenueDto(@RequestParam String date);

    @GetMapping("/inner/statistic/totalRevenue")
    R<TotalRevenueDto> getTotalRevenueDto(@RequestParam String date);
}
