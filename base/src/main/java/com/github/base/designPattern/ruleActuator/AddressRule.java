package com.github.base.designPattern.ruleActuator;

import com.github.base.designPattern.ruleActuator.base.AbstractRule;
import com.github.base.designPattern.ruleActuator.base.RuleDto;

/**
 * Description: 地址规则
 * 直接重写execute()
 * Created At 2021/6/1
 */
public class AddressRule extends AbstractRule {

    private static final String BEI_JING = "北京";

    @Override
    public boolean execute(RuleDto ruleDto) {
        return BEI_JING.equals(ruleDto.getAddress());
    }
}
