package com.example.detail.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * com.example.detail.entity.dto
 *
 * @author zhouke
 * 2022/4/29
 * 19:02
 * 商户订单号、交易时间、交易金额、交易流水号
 * 银行流水账单支付详情(支付方式、支付状态、总金额、退款商户订单号、退款状态)、
 * 系统及时反馈支付详情(支付方式、支付状态、总金额）和消费详情
 * 数据来源:pay_union downloadedBill trans_record
 */
@Data
@ApiModel(value = "对账异常", description = "分为三个部分:" +
        "第一部分为trans打头,包括商户订单号,交易时间,交易明细,操作一栏描述不清暂未写入接口" +
        "第二部分为bank打头,对应银行流水账单支付详情" +
        "第三部分为sys打头,对应系统支付明细")
@AllArgsConstructor
@NoArgsConstructor
public class AccountAnomalyDto {
    @ApiModelProperty("商户订单号")
    private String transOutTradeNo;

    @ApiModelProperty("交易时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transTime;

    @ApiModelProperty("交易金额")
    private Integer transAmount;

    @ApiModelProperty("交易流水号")
    private String transSn;

    @ApiModelProperty("支付方式(支付宝：pay.alipay.jspay;微信：pay.weixin.jspay;银联：pay.unionpay.native)")
    private String bankOrderType;

    @ApiModelProperty("支付状态")
    private String bankOrderStatus;

    @ApiModelProperty("退款商户订单编号")
    private String bankOutRefundNo;

    @ApiModelProperty("总金额")
    private Integer bankTotalFee;

    @ApiModelProperty("退款状态(1.SUCCESS—退款成功 2.FAIL—退款失败  3.PROCESSING—退款处理中  4.NOTSURE—未确定  5.CHANGE—转入代发,需要通过其他方式退款。)")
    @TableField("refund_status")
    private Integer bankRefundStatus;

    @ApiModelProperty("支付方式(支付宝：pay.alipay.jspay;微信：pay.weixin.jspay;银联：pay.unionpay.native)")
    private String sysOrderType;

    @ApiModelProperty("支付状态")
    private String sysOrderStatus;

    @ApiModelProperty("总金额")
    private Integer sysTotalFee;

}
