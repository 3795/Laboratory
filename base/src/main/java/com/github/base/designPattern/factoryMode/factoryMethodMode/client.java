package com.github.base.designPattern.factoryMode.factoryMethodMode;

import designPattern.factoryMode.simpleFactoryMode.Operation;

/**
 * Created By Q.Hao
 * Description: 测试工厂方法模式
 * Created At 2019/7/7
 */
public class client {
    public static void main(String[] args) {
        IFactory factory = new AddFactory();
        Operation operationAdd = factory.CreateOption();
        operationAdd.setValue1(1);
        operationAdd.setValue2(2);
        System.out.println(operationAdd.getResult());
    }
}
