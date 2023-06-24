package com.example.statistic.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * com.example.statistic.entity.dto
 *
 * @author zhouke
 * 2022/5/10
 * 11:25
 */
@Data
public class TVMRevenueDto {
    @ApiModelProperty("线路")
    private Integer line;

    @ApiModelProperty("站点")
    private String station;

    @ApiModelProperty("设备编号")
    private String terminalNo;

    @ApiModelProperty("合计")
    private int total;

    @ApiModelProperty("储值卡售卡张数")
    private int storeSellCount;

    @ApiModelProperty("储值卡售卡押金")
    private int storeSellDeposit;

    @ApiModelProperty("储值卡充值次数")
    private int storeTopUpCount;

    @ApiModelProperty("储值卡充值金额")
    private int storeTopUpAmount;

    @ApiModelProperty("普通卡充值次数")
    private int normalTopUpCount;

    @ApiModelProperty("普通卡充值金额")
    private int normalTopUpAmount;

    @ApiModelProperty("学生卡充值次数")
    private int studentTopUpCount;

    @ApiModelProperty("学生卡充值金额")
    private int studentTopUpAmount;

    @ApiModelProperty("爱心卡充值次数")
    private int loveTopUpCount;

    @ApiModelProperty("爱心卡充值金额")
    private int loveTopUpAmount;
}
