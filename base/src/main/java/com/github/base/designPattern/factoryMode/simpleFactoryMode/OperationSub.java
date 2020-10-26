package com.github.base.designPattern.factoryMode.simpleFactoryMode;

// 减法
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return getValue1() - getValue2();
    }
}
