package com.example.statistic.entity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * com.example.statistic.entity.bo
 *
 * @author zhouke
 * 2022/5/30
 * 21:26
 */
@Data
public class CardIssueVo {
    @TableId("date")
    private LocalDate date;

    private Integer TVMCardCount;

    private Integer BOMCardCount;

    private Integer normalCardCount;

    private Integer studentCardCount;

    private Integer loveCardCount;
}
