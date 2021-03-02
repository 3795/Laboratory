package com.github.laboratory.enums;

/**
 * Redis锁类型
 */
public enum RedisLockTypeEnum {

    ONE("Business1", "Test1"),
    TWO("Business2", "Test2");

    private String code;

    private String desc;

    RedisLockTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getUniqueKey(String key) {
        return String.format("%s:%s", this.getCode(), key);
    }
}
