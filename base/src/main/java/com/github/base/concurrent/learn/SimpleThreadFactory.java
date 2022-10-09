package com.github.base.concurrent.learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 简单线程工厂
 * Created At 2022/10/9
 */
public class SimpleThreadFactory implements ThreadFactory {

    private final int maxThread;
    private final String threadGroupName;
    private final String threadNamePrefix;

    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicInteger threadSeq = new AtomicInteger(0);
    private final ThreadGroup threadGroup;

    public SimpleThreadFactory(int maxThread, String threadGroupName, String threadNamePrefix) {
        this.maxThread = maxThread;
        this.threadGroupName = threadGroupName;
        this.threadNamePrefix = threadNamePrefix;
        this.threadGroup = new ThreadGroup(threadGroupName);
    }

    @Override
    public Thread newThread(Runnable r) {
        int c = count.incrementAndGet();
        if (c > maxThread) {
            return null;
        }
        Thread t = new Thread(threadGroup, r, threadNamePrefix + threadSeq.getAndIncrement());
        // 设置为非守护线程时，则Java虚拟机需要等到所有的子线程执行完成后，才会退出
        t.setDaemon(false);
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadFactory threadFactory = new SimpleThreadFactory(10, "test-thread-group", "test-thread-");
        Thread t = threadFactory.newThread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is task");
            countDownLatch.countDown();
        });
        t.start();
        countDownLatch.await();
        System.out.println("我结束了");
    }
}
