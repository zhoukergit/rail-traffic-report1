package com.example.detail.entity.enums;

import lombok.Getter;

/**
 * com.example.detail.entity.enums
 *
 * @author zhouke
 * 2022/4/30
 * 11:04
 * 订单类型(10:BOM 20:TVM 30:微信 40:...)
 */
@Getter
public enum PayUnionOrderTypeEnum {
    //
    BOM("10","BOM")
    //
    ,TVM("20","TVM")
    //
    , WEI_XIN("30","微信");
    private final String code;
    private final String Name;

    PayUnionOrderTypeEnum(String code, String name) {
        this.code = code;
        Name = name;
    }

    public static String converterNameToCode(String name){
        for (PayUnionOrderTypeEnum orderTypeEnum:PayUnionOrderTypeEnum.values()){
            if (orderTypeEnum.getName().equals(name)){
                return orderTypeEnum.getCode();
            }
        }
        return null;
    }

    public static String converterCodeToName(String code){
        for (PayUnionOrderTypeEnum orderTypeEnum:PayUnionOrderTypeEnum.values()){
            if (orderTypeEnum.getCode().equals(code)){
                return orderTypeEnum.getName();
            }
        }
        return null;
    }
}
