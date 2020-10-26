package com.github.base.concurrent.producerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 使用wait和notify实现生产者消费者容器
 * 难点：
 *  1. 为什么用while而不用if
 *  答：使用if的话，只会判断一次，下次被叫醒之后直接从wait处开始运行，可能会产生问题
 *  2. 为什么使用notifyAll而不用notify
 *  答：notify只会叫醒等待池中的一个线程，可是等待池中既有生产者，又有消费者，
 *  如果叫醒了一个生产者线程，而容器容量又等于10，则该生产者就会wait，造成系统假死
 * Created At 2018/11/16
 */
public class Container1<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private Integer MAX = 10;     // 容器最大容量为10

    public synchronized void put(T t) {
        // 当容器容量满了的时候，生产者就等待
        while (list.size() == MAX) {
            try {
                this.wait();
                System.out.println("生产者等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        while (list.size() == 0) {
            try {
                this.wait();
                System.out.println("消费者等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 通知生产者线程进行生产
        this.notifyAll();
        return list.removeFirst();
    }

    public static void main(String[] args) {
        Container1<String> c = new Container1<>();

        // 开启消费者线程
        for (int i=0; i<2; i++) {
            new Thread(() -> {
                for (int j=0; j<25; j++) {
                    System.out.println(c.get());
                }
            }, "消费者" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 开启生产者线程
        for (int i=0; i<2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "生产者" + i).start();
        }
    }
}
