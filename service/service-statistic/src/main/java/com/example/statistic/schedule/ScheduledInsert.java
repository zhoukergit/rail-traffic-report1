package com.example.statistic.schedule;

import com.example.statistic.service.CardIssueStatisticService;
import com.example.statistic.service.TerminalRevenueStatisticService;
import com.example.statistic.service.TotalRevenueStatisticService;
import com.example.statistic.service.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * com.example.statistic.schedule
 *
 * @author zhouke
 * 2022/5/6
 * 15:21
 */
@Component
public class ScheduledInsert {
    @Autowired
    UserStatisticService userStatisticService;

    @Autowired
    CardIssueStatisticService cardIssueStatisticService;

    @Autowired
    TerminalRevenueStatisticService terminalRevenueStatisticService;

    @Autowired
    TotalRevenueStatisticService totalRevenueStatisticService;

    /**
     * 每天凌晨5点通过RPC从对账明细模块获取明细数据,插入对应的统计表
     */
    @Scheduled(cron = "0 0 5 * * ? ")
    public void userStatisticInsert() {
        //由于是在凌晨5点生成数据,需要获取昨天的日期
        String yesterday = LocalDate.now().minusDays(1).toString();
        userStatisticService.save(yesterday);
        cardIssueStatisticService.saveCardIssueStatistics(yesterday);
        terminalRevenueStatisticService.saveTerminalRevenueStatistic(yesterday);
        totalRevenueStatisticService.saveTotalRevenueStatistic(yesterday);
    }

}
