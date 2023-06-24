package com.example.common.entity.dto;

import lombok.Data;

import java.util.PriorityQueue;

/**
 * com.example.common.entity.dto
 *
 * @author zhouke
 * 2022/5/4
 * 16:51
 */
@Data
public class UserStatisticDto {
    private int dataType;
    private int count;
    private int amount;
    private String terminalNo;
    private String userId;
}
