package com.example.detail.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 账户信息
 * </p>
 *
 * @author zhouke
 * @since 2022-04-26
 */
@Getter
@Setter
@TableName("card_account")
@ApiModel(value = "CardAccount对象", description = "账户信息")
public class CardAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("账户ID")
    @TableId("account_id")
    private String accountId;

    @ApiModelProperty("账户类型")
    @TableField("account_type")
    private String accountType;

    @ApiModelProperty("账户名称")
    @TableField("account_name")
    private String accountName;

    @ApiModelProperty("证件类型")
    @TableField("identity_type")
    private String identityType;

    @ApiModelProperty("证件号码")
    @TableField("identity_no")
    private String identityNo;

    @ApiModelProperty("电话号码")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty("账户状态")
    @TableField("account_status")
    private Boolean accountStatus;




}
