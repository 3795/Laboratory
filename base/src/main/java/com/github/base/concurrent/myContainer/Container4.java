package com.github.base.concurrent.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 在Container3的基础上进行修改，实现需求
 * 缺点：线程之间通信太繁琐
 * Created At 2018/11/14
 */
public class Container4 {

    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Container4 container = new Container4();

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
                System.out.println("容器中有5个元素了");

                // 唤醒线程一，因为在此刻，线程一是wait的，如果不唤醒它，它将永远不会执行
                lock.notify();

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

                        // 为了避免不释放锁的尴尬，让线程一wait，释放锁
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
