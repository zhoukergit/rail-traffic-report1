package com.example.detail.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.example.detail.entity.query
 *
 * @author zhouke
 * 2022/4/30
 * 11:27
 */
@ApiModel("对账查询")
@Data
public class AccountCheckingQuery {
    @ApiModelProperty(value = "起始日期", example = "2022-05-01")
    private String startTime;

    @ApiModelProperty(value = "截止日期", example = "2022-05-04")
    private String endTime;
}
