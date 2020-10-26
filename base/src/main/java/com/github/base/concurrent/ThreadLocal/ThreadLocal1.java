package com.github.base.concurrent.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 在下面的代码中，两个线程对变量的修改会影响到对方变量，因为加了volatile
 * Created At 2018/11/16
 */
public class ThreadLocal1 {

    volatile static Person person = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(person.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.name = "李四";
        }).start();
    }
}

class Person {
    String name = "张三";
}
