package com.github.base.designPattern.ruleActuator;

import com.github.base.designPattern.ruleActuator.base.AbstractRule;
import com.github.base.designPattern.ruleActuator.base.RuleDto;

/**
 * Description: 年满18岁，则为vip，反之不为vip
 * Created At 2021/6/1
 */
public class VipRule extends AbstractRule {

    @Override
    protected <T> T convert(RuleDto dto) {
        VipRuleDto vipRuleDto = new VipRuleDto();
        if (dto.getAge() >= 18) {
            vipRuleDto.setVip(true);
        } else {
            vipRuleDto.setVip(false);
        }
        return (T) vipRuleDto;
    }

    @Override
    protected <T> boolean executeRule(T t) {
        VipRuleDto dto = (VipRuleDto) t;
        return dto.isVip();
    }
}
