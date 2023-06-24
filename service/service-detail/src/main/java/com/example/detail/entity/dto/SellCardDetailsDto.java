package com.example.detail.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.example.detail.entity.vo
 *
 * @author zhouke
 * 2022/4/26
 * 11:47
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
@ApiModel("售卡明细")
public class SellCardDetailsDto {
    @ApiModelProperty("交易流水号")
    private String transSn;

    @ApiModelProperty("交易类型:现金交易;电子交易")
    private String transType;

    @ApiModelProperty("卡号")
    @TableField("card_no")
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

    //这个两张表都可以
    @ApiModelProperty("押金")
    private Integer deposit;

    //这个从cardinfo表查
    @ApiModelProperty("余额")
    @TableField("balance")
    private Integer balance;

    @ApiModelProperty("优惠金额")
    @TableField("discount")
    private Integer discount;

    //对应cardinfo表的terminalNo
    @ApiModelProperty("售卡点(终端设备编号)")
    private String terminalNo;
}
