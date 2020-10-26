package com.github.base.designPattern.singletonMode;

/**
 * Created By Seven.wk
 * Description: 双重检查的饱汉单例模式
 * Created At 2018/11/08
 */
public class FullWithLock {

    private FullWithLock() {}

    private static volatile FullWithLock fullWithLock;

    public static FullWithLock getInstance() {
        if (fullWithLock == null) {

            synchronized (FullWithLock.class) {
                // 此处再加一次检验，防止并发的情况下出错
                if (fullWithLock == null) {
                    fullWithLock = new FullWithLock();
                    return fullWithLock;
                }
            }
        }

        return fullWithLock;
    }
}
