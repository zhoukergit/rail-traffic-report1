package com.example.detail.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.example.detail.entity.vo
 *
 * @author zhouke
 * 2022/4/26
 * 11:47
 * 可以用于售卡明细、退卡明细、充值明细查询
 * 交易流水号
 * 交易类型
 * 卡号
 * 发卡机构
 * 票卡类型
 * 出售时间
 * 押金
 * 余额
 * 优惠金额
 * 售卡点
 * 操作员
 */
@Data
public class CardPaymentDetailsBo {
    @ApiModelProperty("交易流水号")
    private String transSn;

    @ApiModelProperty("交易类型")
    private Integer transType;

    @ApiModelProperty("卡号")
    private String cardNo;

    @ApiModelProperty("发卡机构")
    private String cardIssuer;

    @ApiModelProperty("票卡类型")
    private String ticketType;

    @ApiModelProperty("出售时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transTime;

    @ApiModelProperty("操作员编号")
    private String userId;

    @ApiModelProperty("押金")
    private Integer deposit;

    @ApiModelProperty("余额")
    private Integer balance;

    @ApiModelProperty("优惠金额")
    private Integer discount;

    @ApiModelProperty("交易金额")
    private Integer transAmount;

    @ApiModelProperty("售卡点(终端设备编号)")
    private String terminalNo;

    @ApiModelProperty("终端交易序号")
    private String terminalTransIndex;

    @ApiModelProperty("TAC")
    private String tac;


}
