package com.github.base.designPattern.ruleActuator;

import com.github.base.designPattern.ruleActuator.base.RuleDto;

import java.util.Arrays;
import java.util.Collections;

/**
 * Description: 规则执行器示例
 * Created At 2021/6/3
 */
public class RuleServiceTest {

    public static void main(String[] args) {
        // 构造需要判定的规则
        AddressRule addressRule = new AddressRule();
        VipRule vipRule = new VipRule();

        // 构造包含判断属性的模型，一个北京人，年纪为17岁，地区规则为true，vip规则为false
        RuleDto ruleDto = new RuleDto();
        ruleDto.setAddress("北京");
        ruleDto.setAge(17);

        // 构造链模式构造执行器和执行判断
        // and条件
        boolean result1 = RuleService.create().and(Arrays.asList(addressRule, vipRule)).execute(ruleDto);
        System.out.println("And条件判断结果: " + result1);
        // and和or综合
        boolean result2 = RuleService.create()
                .and(Collections.singletonList(addressRule))
                .or(Collections.singletonList(vipRule))     // 因为这个执行为false，所以结果为false
                .execute(ruleDto);
        System.out.println("And 和 Or 条件判断结果: " + result2);
        // and条件
        boolean result3 = RuleService.create().or(Arrays.asList(addressRule, vipRule)).execute(ruleDto);
        System.out.println("Or条件判断结果: " + result3);
    }



}
