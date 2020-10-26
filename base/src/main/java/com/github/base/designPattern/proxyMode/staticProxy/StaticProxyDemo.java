package com.github.base.designPattern.proxyMode.staticProxy;

/**
 * Created By Seven.wk
 * Description: 静态代理Demo
 * Created At 2018/11/07
 */
public class StaticProxyDemo {

    public static int sing(DoSomething sing, int num) {
        return sing.doSomething(num);
    }

    public static void main(String[] args) {
        int result = StaticProxyDemo.sing(new SingProxy(), 10);
        System.out.println(result);
    }
}
