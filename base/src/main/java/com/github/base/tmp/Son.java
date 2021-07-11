package com.github.base.tmp;

/**
 * Description: 子类
 * Created At 2021/6/20
 */
public class Son extends Father {

    public String name = "son";

    public void printValue() {
        System.out.println("son's printValue method:" + this.name);
    }

    public static void printValue3() {
        System.out.println("son's static printValue3() method");
    }
}
