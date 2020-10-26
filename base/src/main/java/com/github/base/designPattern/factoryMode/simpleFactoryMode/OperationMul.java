package com.github.base.designPattern.factoryMode.simpleFactoryMode;

// 乘法
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getValue1() * getValue2();
    }
}
