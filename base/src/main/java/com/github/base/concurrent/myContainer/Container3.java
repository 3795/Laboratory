package com.github.base.concurrent.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 使用wait和notify，但不能实现需求
 * 注意：wait会释放锁，notify不会释放锁
 * Created At 2018/11/14
 */
public class Container3 {

    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Container3 container = new Container3();

        final Object lock = new Object();

        // 线程二
        new Thread(() -> {
            synchronized(lock) {
                System.out.println("t2启动");
                if (container.size() != 5) {
                    try {
                        // 当不满足条件时，让该线程等待，并释放锁
                        // 注意，当该线程被唤醒继续执行后，将会从这里继续执行
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2执行结束");
            }
        }, "t2").start();

        // 睡眠一秒，保证t2比t1先启动并监听
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 线程一
        new Thread(() -> {
            synchronized(lock) {
                for(int i=0; i<10; i++) {
                    container.add(new Object());
                    System.out.println("add " + i);

                    // 当容量等于5时，唤醒线程二，但不会释放锁，让线程二从等待池中进入锁池
                    if(container.size() == 5) {
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();

    }
}
