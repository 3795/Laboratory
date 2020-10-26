package com.github.base.designPattern.proxyMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By Seven.wk
 * Description: 动态代理Handler
 * Created At 2018/11/07
 */
public class DynamicProxyHandler implements InvocationHandler {

    // 被代理对象
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * 返回被代理的对象
     * @return
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(),
                proxied.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("method: " + method.getName());
//        System.out.println("args: " + args[0].getClass().getName());
        System.out.println("Before invoke method...");
        Object object = method.invoke(proxied, args);
        System.out.println("After invoke method...");
        return object;
    }
}
