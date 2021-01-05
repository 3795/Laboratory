package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description: 抽象工厂模式，支持增加新的产品线，比如可以在CarFactory中增加一个生产奥迪的方法，
 * 但是对奔驰和特斯拉已有的产品线不会产生任何影响
 * 但是不能对已有产品新增属性，例如不能给奔驰车增加一个播放音乐的方法，这样的话，所有的奔驰车实现都要修改代码
 * Created At 2019/7/7
 */
public class Client {

    public static void main(String[] args) {
        CarFactory sportCarFactory = new SportCarFactory();
        BenzCar sportCar = sportCarFactory.getBenzCar();
        sportCar.gasUp();
    }
}
