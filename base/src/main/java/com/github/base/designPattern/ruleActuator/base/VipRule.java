package com.github.base.designPattern.ruleActuator.base;

/**
 * Description: 北京地区且年满18岁，则为vip，反之不为vip
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
        System.out.println("进行Vip身份判断");
        VipRuleDto dto = (VipRuleDto) t;
        return dto.isVip();
    }
}
