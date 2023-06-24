package com.example.statistic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Getter
@Setter
@TableName("total_revenue_statistic")
@ApiModel(value = "TotalRevenueStatistic对象", description = "")
public class TotalRevenueStatistic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("date")
    private String date;

    @TableField("public_sell")
    private Integer publicSell;

    @TableField("public_consumption")
    private Integer publicConsumption;

    @TableField("public_refund")
    private Integer publicRefund;

    @TableField("public_waiting_refund")
    private Integer publicWaitingRefund;

    @TableField("tvm_cash_deposit")
    private Integer tvmCashDeposit;

    @TableField("tvm_cash_top_up")
    private Integer tvmCashTopUp;

    @TableField("tvm_electric_deposit")
    private Integer tvmElectricDeposit;

    @TableField("tvm_electric_top_up")
    private Integer tvmElectricTopUp;

    @TableField("bom_cash_deposit")
    private Integer bomCashDeposit;

    @TableField("bom_cash_top_up")
    private Integer bomCashTopUp;

    @TableField("bom_electric_deposit")
    private Integer bomElectricDeposit;

    @TableField("bom_electric_top_up")
    private Integer bomElectricTopUp;

    @TableField("bom_electric_refund")
    private Integer bomElectricRefund;


}
