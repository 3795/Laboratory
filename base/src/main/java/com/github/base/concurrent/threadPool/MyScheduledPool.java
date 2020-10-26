package com.github.base.concurrent.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 定时执行线程池
 * Created At 2018/11/20
 */
public class MyScheduledPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName());
            // 每500毫秒来执行一次线程
        }, 0, 2000, TimeUnit.MILLISECONDS);

    }
}
