package com.github.base.designPattern.factoryMode.factoryMethodMode;

import com.github.base.designPattern.factoryMode.simpleFactoryMode.Operation;
import com.github.base.designPattern.factoryMode.simpleFactoryMode.OperationDiv;

/**
 * Created By Q.Hao
 * Description: 除法类工厂
 * Created At 2019/7/7
 */
public class DivFactory implements IFactory {
    @Override
    public Operation CreateOption() {
        return new OperationDiv();
    }
}
