package com.example.statistic.entity.query;

import lombok.Data;

/**
 * com.example.statistic.entity.query
 *
 * @author zhouke
 * 2022/5/6
 * 15:34
 */
@Data
public class TerminalRevenueStatisticQuery {
    private String startTime;
    private String endTime;
    private String terminalNo;
}
