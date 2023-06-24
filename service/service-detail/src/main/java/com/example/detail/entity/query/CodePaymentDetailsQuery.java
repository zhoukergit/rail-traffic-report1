package com.example.detail.entity.query;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.example.detail.entity.vo
 *
 * @author zhouke
 * 2022/4/26
 * 18:48
 * 起始日期,截止日期,交易类型,票卡类型
 */
@ApiModel("扫描交易查询")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodePaymentDetailsQuery {
    @ApiModelProperty(value = "起始日期", example = "2021-06-24")
    private String startTime;

    @ApiModelProperty(value = "截止日期", example = "2021-06-24")
    private String endTime;

    @ApiModelProperty("凭证号")
    private String voucherNo;

}
