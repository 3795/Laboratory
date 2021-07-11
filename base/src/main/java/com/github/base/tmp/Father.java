package com.github.base.tmp;

/**
 * Description: 父类
 * Created At 2021/6/20
 */
public class Father {

    public String name = "father";

    public void printValue() {
        System.out.println("father's printValue() method: " + this.name);
    }

    public void printValue2() {
        System.out.println("father's printValue2() method: "+ this.name);
    }

    public static void printValue3() {
        System.out.println("father's static printValue3() method");
    }
}
