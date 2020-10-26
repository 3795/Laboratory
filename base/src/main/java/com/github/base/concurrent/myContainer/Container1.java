package com.github.base.concurrent.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 下列代码并不能实现需求
 * 原因：
 * 线程一对容器的修改对线程二是不可见的，所以线程二不能监听到容器个数的变化，导致线程二不会在容器容量等于5时给出提示。
 * 以下代码不能停止运行，是因为线程二不能够跳出while循环条件，一直在监听
 * Created At 2018/11/13
 */
public class Container1 {

    List<Object> objectList = new ArrayList<>();

    public void add(Object obj) {
        objectList.add(obj);
    }

    public int size() {
        return objectList.size();
    }

    public static void main(String[] args) {
        Container1 container = new Container1();

        // 线程一，向容器中一直添加元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i<10; i++) {
                    container.add(new Object());
                    System.out.println("add" + i);

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
