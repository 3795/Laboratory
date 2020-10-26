package com.github.base.concurrent.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created By Seven.wk
 * Description: 数组阻塞队列
 * ArrayBlockingQueue 是有界队列，当元素达到指定个数时，就不会再往队列中新增元素了
 * Created At 2018/11/19
 */
public class ArrayBlockingQueue {

    static BlockingQueue<String> strs = new java.util.concurrent.ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa");
        //strs.offer("aaa");
        //strs.offer("aaa", 1, TimeUnit.SECONDS);

        System.out.println(strs);
    }

}
