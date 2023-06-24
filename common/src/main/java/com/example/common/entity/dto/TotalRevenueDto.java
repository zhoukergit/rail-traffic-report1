package com.example.common.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class TotalRevenueDto implements Serializable {

    private String date;

    private Integer publicSell;

    private Integer publicConsumption;

    private Integer publicRefund;

    private Integer publicWaitingRefund;

    private Integer tvmCashDeposit;

    private Integer tvmCashTopUp;

    private Integer tvmElectricDeposit;

    private Integer tvmElectricTopUp;

    private Integer bomCashDeposit;

    private Integer bomCashTopUp;

    private Integer bomElectricDeposit;

    private Integer bomElectricTopUp;

    private Integer bomElectricRefund;


}
