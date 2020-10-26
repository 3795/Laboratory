package com.github.base.designPattern.factoryMode.factoryMethodMode;

import designPattern.factoryMode.simpleFactoryMode.Operation;
import designPattern.factoryMode.simpleFactoryMode.OperationAdd;

/**
 * Created By Q.Hao
 * Description: 加法2类工厂
 * Created At 2019/7/7
 */
public class AddFactory implements IFactory {
    @Override
    public Operation CreateOption() {
        return new OperationAdd();
    }
}
