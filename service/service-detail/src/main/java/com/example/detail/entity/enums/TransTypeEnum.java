package com.example.detail.entity.enums;

/**
 * com.example.detail.entity.enums
 *
 * @author zhouke
 * 2022/4/26
 * 20:08
 * 交易类型枚举类
 */
public enum TransTypeEnum {
    /**
     *
     */
    CASH(1, "现金交易"), ELECT(2, "电子交易"),ON_TRAIN(3,"上车");
    private final Integer code;
    private final String name;

    TransTypeEnum(int number, String type) {
        this.code = number;
        this.name = type;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String converterCodeToName(Integer number){
        for (TransTypeEnum transType: TransTypeEnum.values()){
            if (transType.getCode().equals(number)){
                return transType.getName();
            }
        }
        return null;
    }

    public static Integer converterNameToCode(String type){
        for (TransTypeEnum transType: TransTypeEnum.values()){
            if (transType.getName().equals(type)){
                return transType.getCode();
            }
        }
        return null;
    }


}
