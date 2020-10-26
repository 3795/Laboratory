package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/7/7
 */
public class TeslaSportCar implements TeslaCar {
    @Override
    public void charge() {
        System.out.println("正在给特斯拉跑车充电");
    }
}
