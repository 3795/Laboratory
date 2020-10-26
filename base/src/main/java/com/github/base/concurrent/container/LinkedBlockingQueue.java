package com.github.base.concurrent.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description:
 * 1. LinkedBlockingQueue 是无界队列，内存满了的话才不会继续存储
 * 2. 使用该队列可以很容易的实现生产者与消费者模型
 * Created At 2018/11/19
 */
public class LinkedBlockingQueue {

    static BlockingQueue<String> strs = new java.util.concurrent.LinkedBlockingQueue<>();

    static Random r = new Random();

    public static void main(String[] args) {

        // 生产者线程
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" + i); //如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        // 消费者线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //如果空了，就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();

        }
    }

}
