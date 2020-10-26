package com.github.base.concurrent.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 弹性线程池，开始时线程池的大小为0，来一个线程，线程池的大小就加1
 * 如果有一个线程超过60s没有使用的话， 就会删除该线程，线程池的大小减1
 * Created At 2018/11/20
 */
public class MyCachedPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        // 线程池大小为0
        System.out.println(service);
        System.out.println();

        for (int i = 0; i < 2; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println();
            });
        }

        // 线程池的大小为2
        System.out.println(service);
        System.out.println();

        TimeUnit.SECONDS.sleep(8);
        // 睡80s的话，就可以看到线程池的大小为0
//        TimeUnit.SECONDS.sleep(80);

        // 线程池的大小为2，完成的线程数为2
        System.out.println(service);

        service.shutdown();

    }
}
