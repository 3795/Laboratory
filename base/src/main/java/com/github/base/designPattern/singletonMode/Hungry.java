package com.github.base.designPattern.singletonMode;

/**
 * Created By Seven.wk
 * Description: 饿汉单例模式
 * Created At 2018/11/08
 */
public class Hungry {

    private static Hungry hungry = new Hungry();

    private Hungry() { }

    public static Hungry getInstance() {
        return hungry;
    }
}
