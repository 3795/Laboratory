package com.github.base.designPattern.proxyMode.dynamicProxy;

/**
 * Created By Seven.wk
 * Description: 动态代理Demo
 * 动态代理缺点：被代理类一定要实现一个接口
 * Created At 2018/11/07
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        ProxyClassImpl c = new ProxyClassImpl();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(c);
        ProxyClass proxyClass = (ProxyClass) dynamicProxyHandler.newProxyInstance();
//        System.out.println(proxyClass.getClass().getName());
        System.out.println("返回结果为 " + proxyClass.doSomething(111));
    }
}
