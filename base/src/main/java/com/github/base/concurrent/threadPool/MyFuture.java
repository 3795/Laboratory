package com.github.base.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * Created By Seven.wk
 * Description:
 * Created At 2018/11/20
 */
public class MyFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());     // 等任务执行完毕，不然就阻塞

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(f.get());
        System.out.println(f.isDone());

        service.shutdown();

    }
}
