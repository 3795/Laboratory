package com.github.base.designPattern.factoryMode.abstractFactoryMode;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/7/7
 */
public class Client {

    public static void main(String[] args) {
        CarFactory sportCarFactory = new SportCarFactory();
        BenzCar sportCar = sportCarFactory.getBenzCar();
        sportCar.gasUp();
    }
}
