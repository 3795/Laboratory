package com.github.base.concurrent.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 * ThreadLocal会导致内存泄露
 * Created At 2018/11/16
 */
public class ThreadLocal2 {

//    volatile static PersonA personA = new PersonA();

    static ThreadLocal<PersonA> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(t1.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.set(new PersonA());
        }).start();
    }
}

class PersonA {
    String name = "张三";
}

