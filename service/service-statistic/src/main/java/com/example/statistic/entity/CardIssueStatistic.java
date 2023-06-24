package com.example.statistic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("card_issue_statistic")
@ApiModel(value = "CardIssueStatistic对象", description = "")
public class CardIssueStatistic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("date")
    private LocalDate date;

    @TableField("store_card_count")
    private Integer storeCardCount;

    @TableField("normal_card_count")
    private Integer normalCardCount;

    @TableField("student_card_count")
    private Integer studentCardCount;

    @TableField("love_card_count")
    private Integer loveCardCount;


}
