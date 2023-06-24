package com.example.statistic.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.example.statistic.entity.bo
 *
 * @author zhouke
 * 2022/5/10
 * 19:40
 */
@Data
public class TerminalRevenueBo {
    @ApiModelProperty("线路")
    private Integer line;

    @ApiModelProperty("站点")
    private String station;

    @ApiModelProperty("设备编号")
    private String terminalNo;
    @ApiModelProperty("票卡类型")
    private String cardType;

    @ApiModelProperty("合计")
    private int total;

    @ApiModelProperty("交易类型")
    private int transType;

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
