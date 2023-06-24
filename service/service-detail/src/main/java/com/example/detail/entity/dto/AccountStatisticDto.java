package com.example.detail.entity.dto;

import lombok.Data;

/**
 * com.example.detail.entity.bo
 *
 * @author zhouke
 * 2022/5/3
 * 16:53
 * 对账总计表
 * 日期
 * 邮储支付统计 (收入金额,退款金额,总金额,总笔数)
 * 系统支付统计 (收入金额,退款金额,总金额,总笔数)
 */
@Data
public class AccountStatisticDto {
    String transDate;
    int bankIncomeAmount;
    int bankRefundAmount;
    int bankTotalAmount;
    int bankTotalCount;
    int sysIncomeAmount;
    int sysRefundAmount;
    int sysTotalAmount;
    int sysTotalCount;
}

