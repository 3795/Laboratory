package com.github.base.concurrent.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 线程池
 * Created At 2018/11/20
 */
public class ThreadPool {

    public static void main(String[] args) {
        // execute()：执行没有返回值的方法
        // submit()：可以执行有返回值的方法，也可以执行没有返回值的方法
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i=0; i<6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(service);
        System.out.println();

        // 关闭线程池，会等线程池里的线程全部执行完之后才关闭
        service.shutdown();
        // 直接关闭线程池，不管线程池里的线程有没有执行完
//         service.shutdownNow();

        // 线程是否执行完毕
        System.out.println(service.isTerminated());
        // 线程是否关闭，只要调用了shutdown()，isShutdown()就会返回true
        System.out.println(service.isShutdown());
        System.out.println(service);
        System.out.println();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
