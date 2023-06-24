package com.example.statistic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Getter
@Setter
@TableName("terminal_revenue_statistic")
@ApiModel(value = "TerminalRevenueStatistic对象", description = "")
public class TerminalRevenueStatistic implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField("date")
    private LocalDate date;

    @TableField("terminal_no")
    private String terminalNo;

    @ApiModelProperty("0储值卡 1普通卡 2 学生卡 3关爱卡")
    @TableField("card_type")
    private String cardType;

    @TableField("trans_type")
    private Integer transType;

    @ApiModelProperty("线路")
    @TableField("line")
    private Integer line;

    @TableField("station")
    private String station;


    @TableField("total")
    private Integer total;


    @ApiModelProperty("售卡张数")
    @TableField("card_sell_count")
    private Integer cardSellCount;

    @ApiModelProperty("售卡押金")
    @TableField("card_sell_deposit")
    private Integer cardSellDeposit;

    @ApiModelProperty("充值次数")
    @TableField("top_up_count")
    private Integer topUpCount;

    @TableField("top_up_amount")
    private Integer topUpAmount;

    @ApiModelProperty("退卡张数")
    @TableField("card_return_count")
    private Integer cardReturnCount;

    @ApiModelProperty("退卡金额")
    @TableField("card_return_amount")
    private Integer cardReturnAmount;


}
