package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description: 汽车工厂
 * Created At 2019/7/7
 */
public interface CarFactory {
    BenzCar getBenzCar();
    TeslaCar getTeslaCar();
}
