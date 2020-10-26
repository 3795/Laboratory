package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description: 加油的奔驰跑车
 * Created At 2019/7/7
 */
public class BenzSportCar implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("正在给奔驰跑车加汽油");
    }
}
