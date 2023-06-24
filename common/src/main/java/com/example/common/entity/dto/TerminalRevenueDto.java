package com.example.common.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * com.example.common.entity.dto
 *
 * @author zhouke
 * 2022/5/8
 * 15:50
 */
@Data
public class TerminalRevenueDto {
    @ApiModelProperty("线路")
    @TableField("line")
    private Integer line;

    @TableField("station")
    private String station;

    @TableField("terminal_no")
    private String terminalNo;

    @TableField("total")
    private Integer total;

    @ApiModelProperty("0储值卡 1普通卡 2 学生卡 3关爱卡")
    @TableField("card_type")
    private String cardType;

    @TableField("date")
    private LocalDate date;

    @ApiModelProperty("支付方式:1现金支付 2电子支付")
    @TableField("trans_type")
    private Integer transType;

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
