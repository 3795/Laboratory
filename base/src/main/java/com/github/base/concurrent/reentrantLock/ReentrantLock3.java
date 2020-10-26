package com.github.base.concurrent.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Seven.wk
 * Description: 使用ReentrantLock可以进行尝试锁定
 * 1. 可以使用tryLock进行尝试锁定，synchronized相比，ReentrantLock不管有没有获得锁，方法都会继续执行
 * synchronized如果没有获得锁的话，就会一直在那死等
 * 2. 可以根据tryLock的返回值来判断是否锁定
 * 3. 可以指定tryLock的时间，由于tryLock(time)抛出异常，要注意unlock的处理，必须放到finally中进行处理
 * Created At 2018/11/16
 */
public class ReentrantLock3 {

    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);

                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    void m2() {
//        boolean locked = lock.tryLock();
//        System.out.println("m2...");
//        if (locked) {
//            lock.unlock();
//        }

        boolean locked = false;

        try {
            // 指定等待锁的时间，到了指定等待的时间，不管有没有获得锁，方法都会继续执行
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 ..." + locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 rl = new ReentrantLock3();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
