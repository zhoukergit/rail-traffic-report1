package com.example.detail.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.example.detail.entity.bo
 *
 * @author zhouke
 * 2022/4/27
 * 16:20
 * 交易流水号、卡号、发卡机构、票卡类型、交易时间、交易类型、交易前余额、交易金额、优惠金额、终端交易序号、终端编号。
 */
@Data
@ApiModel("刷卡交易明细")
public class CardPaymentDetailsDto {
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

    @ApiModelProperty("交易时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transTime;

    @ApiModelProperty("交易金额")
    private String transAmount;

    @ApiModelProperty("交易前余额")
    private Integer balance;

    @ApiModelProperty("优惠金额")
    private Integer discount;

    //对应cardinfo表的terminalNo
    @ApiModelProperty("终端设备编号")
    private String terminalNo;

    @ApiModelProperty("终端交易序号")
    private String terminalTransIndex;

    @ApiModelProperty("TAC")
    private String tac;
}
