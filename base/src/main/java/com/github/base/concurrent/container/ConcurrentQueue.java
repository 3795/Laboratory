package com.github.base.concurrent.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created By Seven.wk
 * Description:
 * Created At 2018/11/19
 */
public class ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for(int i=0; i<10; i++) {
            strs.offer("a" + i);  //add
        }

        System.out.println(strs);

        System.out.println(strs.size());

        // poll():读取并删除
        System.out.println(strs.poll());
        System.out.println(strs.size());

        // peek():读取不会删除
        System.out.println(strs.peek());
        System.out.println(strs.size());

        //双端队列Deque
    }

}
