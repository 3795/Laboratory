package com.github.base.designPattern.factoryMode.simpleFactoryMode;

// 加法
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getValue1() + getValue2();
    }
}
