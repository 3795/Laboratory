package com.github.base.designPattern.proxyMode.staticProxy;

/**
 * Created By Seven.wk
 * Description: 被代理的实现类
 * Created At 2018/11/07
 */
public class Sing implements DoSomething {

    @Override
    public int doSomething(int num) {
        System.out.println("Sing a song");
        return num * 10;
    }
}
