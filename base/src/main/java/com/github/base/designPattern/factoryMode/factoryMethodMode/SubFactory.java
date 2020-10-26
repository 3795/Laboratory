package com.github.base.designPattern.factoryMode.factoryMethodMode;

import designPattern.factoryMode.simpleFactoryMode.Operation;
import designPattern.factoryMode.simpleFactoryMode.OperationSub;

/**
 * Created By Q.Hao
 * Description: 减法工厂
 * Created At 2019/7/7
 */
public class SubFactory implements IFactory {
    @Override
    public Operation CreateOption() {
        return new OperationSub();
    }
}
