package com.github.base.designPattern.ruleActuator.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: Vip规则
 * Created At 2021/6/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VipRuleDto extends RuleDto {

    private boolean vip;
}
