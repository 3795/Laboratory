package com.github.base.concurrent.reentrantLock;

import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 使用synchronized实现同步
 * 在lambda表达式中，如果是用对象执行方法，则方法是非静态的
 * 如果是用类来执行方法，则方法是静态的
 * Created At 2018/11/16
 */
public class ReentrantLock1 {

    static synchronized void m1() {
        for (int i=0; i<10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    synchronized void m2() {
        System.out.println("m2.....");
    }

    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();

        new Thread(ReentrantLock1::m1, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(reentrantLock1::m2, "t3").start();

    }
}
