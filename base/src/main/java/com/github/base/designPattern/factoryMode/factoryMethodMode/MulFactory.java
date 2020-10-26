package com.github.base.designPattern.factoryMode.factoryMethodMode;

import designPattern.factoryMode.simpleFactoryMode.Operation;
import designPattern.factoryMode.simpleFactoryMode.OperationMul;

/**
 * Created By Q.Hao
 * Description: 乘法工厂类
 * Created At 2019/7/7
 */
public class MulFactory implements IFactory {
    @Override
    public Operation CreateOption() {
        return new OperationMul();
    }
}
