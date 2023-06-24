package com.example.statistic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 操作员统计表
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Getter
@Setter
@TableName("user_statistic")
@ApiModel(value = "UserStatistic对象", description = "操作员统计表")
public class UserStatistic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("充值点(设备编号)")
    @TableField("terminal_no")
    private String terminalNo;

    @ApiModelProperty("时间")
    @TableField("operate_date")
    private LocalDate operateDate;

    @TableField("user_id")
    private String userId;

    @TableField("total_count")
    private Integer totalCount;

    @TableField("total_amount")
    private Integer totalAmount;

    @TableField("sell_count")
    private Integer sellCount;

    @TableField("sell_amount")
    private Integer sellAmount;

    @TableField("top_up_count")
    private Integer topUpCount;

    @TableField("top_up_amount")
    private Integer topUpAmount;

    @TableField("refund_count")
    private Integer refundCount;

    @TableField("refund_amount")
    private Integer refundAmount;


}
