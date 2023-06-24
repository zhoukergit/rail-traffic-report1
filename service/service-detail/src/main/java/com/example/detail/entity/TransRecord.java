package com.example.detail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 交易记录
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Getter
@Setter
@TableName("trans_record")
@NoArgsConstructor
@ApiModel(value = "TransRecord对象", description = "交易记录")
public class TransRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("交易流水号")
    @TableField("trans_sn")
    private String transSn;

    @ApiModelProperty("数据类型")
    @TableField("data_type")
    private Integer dataType;

    @ApiModelProperty("交易类型")
    @TableField("trans_type")
    private Integer transType;

    @ApiModelProperty("票卡类型")
    @TableField("ticket_type")
    private String ticketType;

    @ApiModelProperty("卡号")
    @TableField("card_no")
    private String cardNo;

    @ApiModelProperty("卡片序列号")
    @TableField("card_sn")
    private String cardSn;

    @ApiModelProperty("交易时间")
    @TableField("trans_time")
    private LocalDateTime transTime;

    @ApiModelProperty("交易金额")
    @TableField("trans_amount")
    private Integer transAmount;

    @ApiModelProperty("交易前余额")
    @TableField("balance")
    private Integer balance;

    @ApiModelProperty("押金")
    @TableField("deposit")
    private Integer deposit;

    @ApiModelProperty("优惠金额")
    @TableField("discount")
    private Integer discount;

    @ApiModelProperty("罚款金额")
    @TableField("penalty_excess")
    private Integer penaltyExcess;

    @ApiModelProperty("操作员编号")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("线路编号")
    @TableField("line_id")
    private String lineId;

    @ApiModelProperty("当前使用车站")
    @TableField("station_id")
    private String stationId;

    @ApiModelProperty("上次使用车站")
    @TableField("last_station_id")
    private String lastStationId;

    @ApiModelProperty("车辆编号")
    @TableField("vehicle_id")
    private String vehicleId;

    @ApiModelProperty("终端编号")
    @TableField("terminal_no")
    private String terminalNo;

    @ApiModelProperty("终端设备序列号")
    @TableField("terminal_sn")
    private String terminalSn;

    @ApiModelProperty("终端设备ip")
    @TableField("terminal_ip")
    private String terminalIp;

    @ApiModelProperty("终端交易序号")
    @TableField("terminal_trans_index")
    private Long terminalTransIndex;

    @ApiModelProperty("脱机交易类型")
    @TableField("offline_trans_type")
    private Integer offlineTransType;

    @ApiModelProperty("脱机交易序号")
    @TableField("offline_trans_index")
    private String offlineTransIndex;

    @ApiModelProperty("交易验证码")
    @TableField("tac")
    private String tac;

    @ApiModelProperty("城市代码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty("发卡机构")
    @TableField("card_issuer")
    private String cardIssuer;

    @ApiModelProperty("商户订单号")
    @TableField("out_trade_no")
    private String outTradeNo;


    public TransRecord(String transSn, Integer dataType, Integer transType, String ticketType,
                       String cardNo, String cardSn, LocalDateTime transTime, Integer transAmount,
                       Integer balance, Integer deposit, Integer discount, String userId, String terminalNo,
                       String cardIssuer) {
        this.transSn = transSn;
        this.dataType = dataType;
        this.transType = transType;
        this.ticketType = ticketType;
        this.cardNo = cardNo;
        this.cardSn = cardSn;
        this.transTime = transTime;
        this.transAmount = transAmount;
        this.balance = balance;
        this.deposit = deposit;
        this.discount = discount;
        this.userId = userId;
        this.terminalNo = terminalNo;
        this.cardIssuer = cardIssuer;
    }

    public TransRecord(String transSn, Integer transType, String ticketType, LocalDateTime transTime, Integer transAmount, String outTradeNo, String cardNo, String cardSn) {
        this.transSn = transSn;
        this.transType = transType;
        this.ticketType = ticketType;
        this.transTime = transTime;
        this.transAmount = transAmount;
        this.outTradeNo = outTradeNo;
        this.cardNo = cardNo;
        this.cardSn = cardSn;
    }

    public TransRecord(String transSn, Integer dataType, Integer transType, String ticketType, LocalDateTime transTime, Integer transAmount, String outTradeNo, String cardNo, String cardSn) {
        this.transSn = transSn;
        this.transType = transType;
        this.ticketType = ticketType;
        this.transTime = transTime;
        this.transAmount = transAmount;
        this.outTradeNo = outTradeNo;
        this.cardNo = cardNo;
        this.cardSn = cardSn;
        this.dataType = dataType;
    }
}
