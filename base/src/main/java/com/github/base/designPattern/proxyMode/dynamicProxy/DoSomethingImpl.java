package com.github.base.designPattern.proxyMode.dynamicProxy;

/**
 * Created By Seven.wk
 * Description: 代理接口实现
 * Created At 2018/11/07
 */
public class DoSomethingImpl implements DoSomething {

    @Override
    public int doSomething(int num) {
        System.out.println("doSomething方法执行中，num = " + num);
        return num + 100;
    }
}
