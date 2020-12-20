package com.github.base.designPattern.proxyMode.dynamicProxy;

/**
 * Created By Seven.wk
 * Description: 动态代理Demo
 * 动态代理缺点：被代理类一定要实现一个接口
 * Created At 2018/11/07
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        DoSomethingImpl c = new DoSomethingImpl();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(c);
        DoSomething doSomething = (DoSomething) dynamicProxyHandler.newProxyInstance();
        System.out.println("代理对象名称: " + doSomething.getClass().getName());
        System.out.println("返回结果为 " + doSomething.doSomething(111));
    }
}
