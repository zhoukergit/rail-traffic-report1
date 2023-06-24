package com.example.detail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 发卡信息
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Getter
@Setter
@TableName("card_info")
@ApiModel(value = "CardInfo对象", description = "发卡信息")
public class CardInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("卡片序列号")
    @TableId("card_sn")
    private String cardSn;

    @ApiModelProperty("卡号")
    @TableField("card_no")
    private String cardNo;

    @ApiModelProperty("账户ID")
    @TableField("account_id")
    private String accountId;

    @ApiModelProperty("城市代码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty("发卡机构")
    @TableField("card_issuer")
    private String cardIssuer;

    @ApiModelProperty("票卡类型")
    @TableField("ticket_type")
    private String ticketType;

    @ApiModelProperty("押金")
    @TableField("deposit")
    private Integer deposit;

    @ApiModelProperty("余额")
    @TableField("balance")
    private Integer balance;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人员")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("终端设备编号")
    @TableField("terminal_no")
    private String terminalNo;

    @ApiModelProperty("终端设备序列号")
    @TableField("terminal_sn")
    private String terminalSn;

    @ApiModelProperty("卡片状态")
    @TableField("card_status")
    private Boolean cardStatus;


}
