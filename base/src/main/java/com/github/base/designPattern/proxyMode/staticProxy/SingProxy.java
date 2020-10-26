package com.github.base.designPattern.proxyMode.staticProxy;

/**
 * Created By Seven.wk
 * Description: 代理类的实现
 * Created At 2018/11/07
 */
public class SingProxy implements DoSomething {

    private DoSomething sing = new Sing();

    @Override
    public int doSomething(int num) {
        System.out.println("Before singing");
        int result = sing.doSomething(num);
        System.out.println("After singing");
        return result;
    }
}
