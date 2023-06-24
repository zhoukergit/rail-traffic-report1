package com.example.statistic.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.example.statistic.entity
 *
 * @author zhouke
 * 2022/5/10
 * 12:05
 */
@Data
public class BaseCardRevenue {
    @ApiModelProperty("售卡张数")
    private int sellCount;

    @ApiModelProperty("售卡押金")
    private int sellDeposit;

    @ApiModelProperty("充值次数")
    private int topUpCount;

    @ApiModelProperty("充值金额")
    private int topUpAmount;

    @ApiModelProperty("退卡张数")
    private int returnCount;

    @ApiModelProperty("退卡金额")
    private int returnAmount;
}
