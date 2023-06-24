package com.example.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * com.example.entity
 *
 * @author zhouke
 * 2022/4/14
 * 14:36
 * 全局异常
 */
@EqualsAndHashCode(callSuper = true) //生成equal和hashcode时包含父类的属性
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    private ResultCode code;
    private String msg;
}
