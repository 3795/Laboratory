package com.github.base.concurrent.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Seven.wk
 * Description: ReentrantLock可以被其他方法打断
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 * Created At 2018/11/16
 */
public class ReentrantLock4 {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();


        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1 start");

                // 让t1睡死，不释放锁
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);

                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            boolean locked = false;
            try {

                // 等1000秒尝试获得锁
                locked = lock.tryLock(1000, TimeUnit.SECONDS);

                // 因为t1睡死了，不会释放锁，所以t2永远也不会运行，用interrupt方法在其他地方打断t2的运行
                // 可以对interrupt()方法做出响应
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                if (locked) {
                    lock.unlock();
                }
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // t2等待的时间太长了，直接打断
        t2.interrupt();

    }
}
