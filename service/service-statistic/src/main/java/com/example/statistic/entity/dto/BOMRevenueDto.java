package com.example.statistic.entity.dto;

import com.example.statistic.entity.BaseCardRevenue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.example.statistic.entity.dto
 *
 * @author zhouke
 * 2022/5/10
 * 11:25
 */
@Data
public class BOMRevenueDto {
    @ApiModelProperty("充值点")
    private String topUpPlace;

    @ApiModelProperty("设备编号")
    private String terminalNo;

    @ApiModelProperty("合计")
    private int total;

    @ApiModelProperty("储值卡营收详情")
    private BaseCardRevenue storedCardRevenue;
    @ApiModelProperty("普通卡营收详情")
    private BaseCardRevenue normalCardRevenue;
    @ApiModelProperty("学生卡营收详情")
    private BaseCardRevenue studentCardRevenue;

    @ApiModelProperty("爱心卡营收详情")
    private BaseCardRevenue loveCardRevenue;


}
