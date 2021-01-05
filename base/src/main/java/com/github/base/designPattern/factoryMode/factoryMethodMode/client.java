package com.github.base.designPattern.factoryMode.factoryMethodMode;


import com.github.base.designPattern.factoryMode.simpleFactoryMode.Operation;

/**
 * Created By Q.Hao
 * Description: 工厂方法模式
 * 该模式使用不同的工厂产生不同的对象实例，可以扩展增加新的工厂
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
