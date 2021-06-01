package com.github.base.designPattern.ruleActuator.base;

/**
 * Description: 规则抽象
 * Created At 2021/6/1
 */
public interface BaseRule {

    boolean execute(RuleDto ruleDto);
}
