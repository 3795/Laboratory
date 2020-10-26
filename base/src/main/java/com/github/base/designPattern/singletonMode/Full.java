package com.github.base.designPattern.singletonMode;

/**
 * Created By Seven.wk
 * Description: 饱汉单例模式
 * Created At 2018/11/08
 */
public class Full {

    private static Full full;

    private Full() {}

    public static Full getInstance() {
        if (full == null) {
            full = new Full();
            return full;
        }

        return full;
    }
}
