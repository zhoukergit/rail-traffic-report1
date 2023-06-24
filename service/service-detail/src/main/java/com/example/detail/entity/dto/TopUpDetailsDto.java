package com.example.detail.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.example.detail.entity.vo
 *
 * @author zhouke
 * 2022/4/27
 * 14:05
 * 充值详情
 * 交易流水号、交易类型、卡号、发卡机构、票卡类型、充值时间、充值前余额、充值金额、优惠金额、充值点、操作员。
 */
@Data
@ApiModel("充值明细")
public class TopUpDetailsDto {
    @ApiModelProperty("交易流水号")
    private String transSn;

    @ApiModelProperty("交易类型:现金交易;电子交易")
    private String transType;

    @ApiModelProperty("卡号")
    private String cardNo;

    @ApiModelProperty("发卡机构")
    private String cardIssuer;

    @ApiModelProperty("票卡类型")
    private String ticketType;

    @ApiModelProperty("充值时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transTime;

    @ApiModelProperty("操作员编号")
    private String userId;


    //这个从cardinfo表查
    @ApiModelProperty("充值前余额")
    private Integer balance;

    @ApiModelProperty("优惠金额")
    private Integer discount;

    @ApiModelProperty("充值金额")
    private Integer transAmount;

    //对应cardinfo表的terminalNo
    @ApiModelProperty("充值点(终端设备编号)")
    private String terminalNo;


}
