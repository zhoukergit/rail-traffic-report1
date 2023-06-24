package com.example.detail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 支付流水
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Getter
@Setter
@TableName("pay_union")
@NoArgsConstructor
@ApiModel(value = "PayUnion对象", description = "支付流水")
public class PayUnion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商户订单号")
    @TableId("out_trade_no")
    private String outTradeNo;

    @ApiModelProperty("二维码凭证号")
    @TableField("voucher_no")
    private String voucherNo;

    @ApiModelProperty("订单总金额(单位;分)")
    @TableField("total_fee")
    private Integer totalFee;

    @ApiModelProperty("订单类型(10:BOM 20:TVM 30:微信 40:...)")
    @TableField("order_type")
    private String orderType;

    @ApiModelProperty("订单状态(0:订单不可用 1:支付成功 2:转入退款 3:未支付4:已关闭 5:支付失败，其他原因，如银行返回失败) 6:支付超时，二维码已过期)")
    @TableField("order_status")
    private Integer orderStatus;

    @ApiModelProperty("订单消息(订单提交失败原因等)")
    @TableField("order_message")
    private String orderMessage;

    @ApiModelProperty("终端IP")
    @TableField("mch_create_ip")
    private String mchCreateIp;

    @ApiModelProperty("设备编号")
    @TableField("client_sn")
    private String clientSn;

    @ApiModelProperty("订单/商品")
    @TableField("body")
    private String body;

    @ApiModelProperty("二维码链接")
    @TableField("code_url")
    private String codeUrl;

    @ApiModelProperty("二维码图片链接")
    @TableField("code_img_url")
    private String codeImgUrl;

    @ApiModelProperty("删除状态(1正常使用 0删除)")
    @TableField("delete_state")
    private Integer deleteState;

    @ApiModelProperty("备注")
    @TableField("attach")
    private String attach;

    public PayUnion(String outTradeNo, String voucherNo, Integer totalFee, String orderType,String clientSn) {
        this.outTradeNo = outTradeNo;
        this.voucherNo = voucherNo;
        this.totalFee = totalFee;
        this.orderType = orderType;
        this.clientSn = clientSn;
    }
}
