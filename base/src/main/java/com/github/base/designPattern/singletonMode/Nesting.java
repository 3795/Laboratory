package com.github.base.designPattern.singletonMode;

/**
 * Created By Seven.wk
 * Description: 嵌套类实现单例模式
 * Created At 2018/11/08
 */
public class Nesting {

    private Nesting() {}

    private static class Holder {
        private static Nesting nesting = new Nesting();
    }

    public static Nesting getInstance() {
        return Holder.nesting;
    }
}
