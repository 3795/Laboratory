package com.github.base.concurrent.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Seven.wk
 * Description: 可重入锁2
 * 注意：synchronized遇到异常时，jvm会自动释放锁；但是Lock必须手动释放锁，而且经常在finally中释放锁
 * Created At 2018/11/16
 */
public class ReentrantLock2 {

    Lock lock = new ReentrantLock();

    void m1(){
        // 进行加锁
        lock.lock();
        try {
            for (int i=0; i<10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 在finally块中进行解锁
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
        System.out.println("m2");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 r2 = new ReentrantLock2();

        new Thread(r2::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r2::m2).start();
    }
}
