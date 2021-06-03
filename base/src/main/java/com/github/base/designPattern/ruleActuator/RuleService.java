package com.github.base.designPattern.ruleActuator;

import com.github.base.designPattern.ruleActuator.base.BaseRule;
import com.github.base.designPattern.ruleActuator.base.RuleDto;

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

    /**
     * 执行器
     *
     * @param dto
     * @return
     */
    public boolean execute(RuleDto dto) {
        for (Map.Entry<Integer, List<BaseRule>> item : hashMap.entrySet()) {
            List<BaseRule> ruleList = item.getValue();
            switch (item.getKey()) {
                case AND:
                    if (!and(dto, ruleList)) {
                        return false;
                    }
                    break;
                case OR:
                    if (!or(dto, ruleList)) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    /**
     * 规则and运算，所有的规则为true才为true
     *
     * @param dto      包含所有判断属性的模型
     * @param ruleList
     * @return
     */
    private boolean and(RuleDto dto, List<BaseRule> ruleList) {
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(dto);
            if (!execute) {
                // 有一个失败，则为false
                return false;
            }
        }
        return true;
    }

    /**
     * 规则or运算
     *
     * @param dto
     * @param ruleList
     * @return
     */
    private boolean or(RuleDto dto, List<BaseRule> ruleList) {
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(dto);
            if (execute) {
                // 有一个成功则为true
                return true;
            }
        }
        return false;
    }
}
