package com.github.base.designPattern.ruleActuator.base;

import lombok.Data;

/**
 * Description: 业务数据,需要对这些业务数据进行if else 判断
 * Created At 2021/6/1
 */
@Data
public class RuleDto {
    // 地址
    private String address;
    // 年龄
    private Integer age;
}
