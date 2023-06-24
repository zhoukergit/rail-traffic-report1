package com.example.detail.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.example.detail.entity.vo
 *
 * @author zhouke
 * 2022/4/26
 * 18:48
 * 起始日期,截止日期,交易类型,票卡类型
 */
@ApiModel("售卡明细查询")
@Data
public class CardTransDetailsQuery {
    @ApiModelProperty(value = "起始日期",example = "2021-06-24")
    private String startTime;

    @ApiModelProperty(value = "截止日期",example = "2021-06-24")
    private String endTime;

    @ApiModelProperty(value = "交易类型",example = "现金交易/电子交易")
    private String transType;

    @ApiModelProperty(value = "票卡类型",example = "填普通卡/储值卡")
    private String ticketType;

    @ApiModelProperty(value = "售卡点/退卡点/充值点",example = "B004")
    private String terminalNo;

    @ApiModelProperty(value = "操作员",example = "000004")
    private String userId;


}
