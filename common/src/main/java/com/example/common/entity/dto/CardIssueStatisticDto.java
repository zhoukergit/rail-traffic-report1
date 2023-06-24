package com.example.common.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;

/**
 * com.example.common.entity.dto
 *
 * @author zhouke
 * 2022/5/8
 * 12:59
 */
@Data
public class CardIssueStatisticDto {

    private LocalDate date;

    private Integer storeCardCount;


    private Integer normalCardCount;

    private Integer studentCardCount;

    private Integer loveCardCount;

}
