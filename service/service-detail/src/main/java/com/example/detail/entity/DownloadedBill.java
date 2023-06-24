package com.example.detail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 银行账单
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("downloaded_bill")
@ApiModel(value = "DownloadedBill对象", description = "银行账单")
public class DownloadedBill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("商户订单号")
    @TableField("out_trade_no")
    private String outTradeNo;

    @ApiModelProperty("交易时间")
    @TableField("trans_time")
    private LocalDateTime transTime;

    @ApiModelProperty("支付方式(支付宝：pay.alipay.jspay;微信：pay.weixin.jspay;银联：pay.unionpay.native)")
    @TableField("order_type")
    private String orderType;

    @ApiModelProperty("订单状态")
    @TableField("order_status")
    private Integer orderStatus;

    @ApiModelProperty("设备编号")
    @TableField("client_sn")
    private String clientSn;

    @ApiModelProperty("退款商户订单编号")
    @TableField("out_refund_no")
    private String outRefundNo;

    @ApiModelProperty("退款状态(1.SUCCESS—退款成功 2.FAIL—退款失败  3.PROCESSING—退款处理中  4.NOTSURE—未确定  5.CHANGE—转入代发,需要通过其他方式退款。)")
    @TableField("refund_status")
    private Integer refundStatus;

    @ApiModelProperty("交易金额")
    @TableField("total_fee")
    private Integer totalFee;

    public DownloadedBill(Integer id, String outTradeNo, LocalDateTime transTime, String orderType, Integer totalFee) {
        this.id = id;
        this.outTradeNo = outTradeNo;
        this.transTime = transTime;
        this.orderType = orderType;
        this.totalFee = totalFee;
    }
}
