package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/7/7
 */
public class BenzBusinessCar implements BenzCar {

    @Override
    public void gasUp() {
        System.out.println("正在给奔驰商务车加汽油");
    }
}
