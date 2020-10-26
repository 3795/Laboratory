package com.github.base.concurrent.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 以下代码能够实现需求
 * 原因：添加了volatile关键字，使其对线程二可见，能够触发提示事件
 * 但是：
 * 1. while循环将会浪费CPU
 * 2. 该代码没有进行同步，结果不是很精确，在高并发情况下可能存在误差
 * Created At 2018/11/14
 */
public class Container2 {
    volatile List<Object> objectList = new ArrayList<>();

    public void add(Object obj) {
        objectList.add(obj);
    }

    public int size() {
        return objectList.size();
    }

    public static void main(String[] args) {
        Container2 container = new Container2();

        // 线程一，向容器中一直添加元素
        new Thread(() -> {
            for (int i =0; i<10; i++) {
                container.add(new Object());
                System.out.println("add" + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        // 线程二，监听容器中元素的个数
        new Thread(() -> {
            while (true) {
                if (container.size() == 5) {
                    break;
                }
            }
            System.out.println("容器一的元素有5个了");
        }, "t2").start();
    }

}
