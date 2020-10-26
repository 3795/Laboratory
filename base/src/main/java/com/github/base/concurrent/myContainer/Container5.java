package com.github.base.concurrent.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 使用门闩机制实现需求
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续运行
 * Created At 2018/11/14
 */
public class Container5 {
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        Container5 container = new Container5();

        // 设定门闩的值为1
        CountDownLatch latch = new CountDownLatch(1);

        // 线程二
        new Thread(() -> {
            System.out.println("线程启动");
            if (container.size() != 5) {
                try {
                    // 当门闩的值为1时，继续运行
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("容器中的元素个数有5个了");
        },"t2").start();

        // 保证容器二先启动
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        // 线程一
        new Thread(() -> {
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                container.add(new Object());
                System.out.println("add " + i);

                if (container.size() == 5) {
                    // 将门闩的值减一，让t2得以执行
                    latch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();
    }
}
