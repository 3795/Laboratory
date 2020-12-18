package com.github.base.designPattern.proxyMode.dynamicProxy;

/**
 * Created By Seven.wk
 * Description: 代理接口实现
 * Created At 2018/11/07
 */
public class ProxyClassImpl implements ProxyClass {

    @Override
    public int doSomething(int num) {
        System.out.println("doSomething方法执行中，num = " + num);
        return num + 100;
    }

    @Override
    public void test(String s) {
        System.out.println("test方法执行中，s = " + s);
    }
}
