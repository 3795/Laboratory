package com.github.base.designPattern.proxyMode.dynamicProxy;

/**
 * Created By Seven.wk
 * Description: 代理接口实现
 * Created At 2018/11/07
 */
public class ProxyClassImpl implements ProxyClass {

    @Override
    public int doSomething(int num) {
        System.out.println("方法执行中。。。。");
        return num;
    }

    @Override
    public String test(String s) {
        return s;
    }
}
