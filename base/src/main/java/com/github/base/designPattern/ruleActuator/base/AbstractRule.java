package com.github.base.designPattern.ruleActuator.base;

/**
 * Description: 规则模板
 * 实现类只需要重写convert() 和 executeRule() 即可，最外层直接调用接口的execute()即可判断结果
 * Created At 2021/6/1
 */
public class AbstractRule implements BaseRule {

    /**
     * 根据实际的情况对dto数据进行转换
     * 设置为protected属性，只有子类才能访问到，实现类均要继承该类
     *
     * @param dto
     * @param <T>
     * @return
     */
    protected <T> T convert(RuleDto dto) {
        return (T) dto;
    }

    /**
     * 执行规则，返回true or false
     *
     * @param t
     * @param <T>
     * @return
     */
    protected <T> boolean executeRule(T t) {
        return true;
    }

    @Override
    public boolean execute(RuleDto ruleDto) {
        return executeRule(convert(ruleDto));
    }
}
