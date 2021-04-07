package com.github.base.tmp;

import java.util.concurrent.*;

/**
 * 测试线程池中线程后对异常线程的处理方式
 */
public class ExecutorsTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolTaskExecutor();

//        executor.execute(() -> sayHi("execute"));       // 堆栈异常直接输出

//        Thread.sleep(100);
//
//        Future<?> submit = executor.submit(() -> sayHi("submit"));     // 堆栈异常没有输出
//
//        try {
//            submit.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        executor.execute(() -> {
            sayHi("execute");
        });
//        Thread.sleep(100);
        executor.execute(() -> {
            sayHi("execute");
        });
//        Thread.sleep(100);

        executor.execute(() -> {
            sayHi("execute-exception");
        });
//        Thread.sleep(100);

        executor.execute(() -> {
            sayHi("execute");
        });
//        Thread.sleep(100);

        executor.execute(() -> {
            sayHi("execute");
        });

        // 在创建线程五之前，线程三就抛出了异常，这时要remove掉之前的线程三，再add新的线程
        // 又因为线程四已经被创建，所以add时就会新建一个name为5的线程，并将这个线程作为原线程三的补位，并且不再执行本轮的后续任务
        // 这时，第五个任务开始被调用执行，此时又需要add一个新的线程，因为name递增，所以这个时候会add一个name为6的线程出来执行第五个任务
        // 这就解释了为啥没有线程为5的线程执行结果，反而有个线程name为6的线程执行结果



    }

    /**
     * 模拟异常
     *
     * @param name
     */
    private static void sayHi(String name) {
        String printStr = "[thread-name:" + Thread.currentThread().getName() + ", 执行方式：" + name + "]";
        System.out.println(printStr);
        if ("execute-exception".equals(name))
            throw new RuntimeException(printStr + "我是异常");
    }

    /**
     * 构建线程池
     *
     * @return
     */
    private static ThreadPoolExecutor buildThreadPoolTaskExecutor() {
        return new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
