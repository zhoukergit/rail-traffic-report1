package com.example.detail.entity.enums;

import lombok.Getter;

/**
 * com.example.detail.entity.enums
 *
 * @author zhouke
 * 2022/4/30
 * 11:15
 * 订单状态(0:订单不可用 1:支付成功 2:转入退款 3:未支付4:已关闭 5:支付失败，其他原因，如银行返回失败) 6:支付超时，二维码已过期)
 */
@Getter
public enum OrderStatusEnum {
    //
    DISABLE(0, "不可用"),
    //
    SUCCESS(1, "支付成功"),

    //
    REFUND(2, "转入退款"),
    //
    NOT_PAYED(3, "未支付"),
    //
    CLOSED(4, "已关闭"),
    //支付失败，其他原因，如银行返回失败
    PAYMENT_FAILED(5, "支付失败"),
    //支付超时，二维码已过期
    TIME_OUT(6, "支付超时");

    private final Integer code;
    private final String name;

    OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Integer converterNameToCode(String name) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getName().equals(name)) {
                return orderStatusEnum.getCode();
            }
        }
        return null;
    }

    public static String converterCodeToName(Integer code) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum.getName();
            }
        }
        return null;
    }
}
