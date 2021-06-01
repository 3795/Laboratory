package com.github.base.designPattern.ruleActuator.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 执行器构建
 * Created At 2021/6/1
 */
public class RuleService {

    private Map<Integer, List<BaseRule>> hashMap = new HashMap<>();
    private static final int AND = 1;
    private static final int OR = 0;

    public static RuleService create() {
        return new RuleService();
    }

    public RuleService and(List<BaseRule> ruleList) {
        hashMap.put(AND, ruleList);
        return this;
    }

    public RuleService or(List<BaseRule> ruleList) {
        hashMap.put(OR, ruleList);
        return this;
    }
}
