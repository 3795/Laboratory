package com.github.base.concurrent.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Seven.wk
 * Description: 使用ReentrantLock可以设置为公平锁
 * Created At 2018/11/16
 */
public class ReentrantLock5 extends Thread {

    //参数为true表示为公平锁，请对比输出结果
    private static ReentrantLock lock=new ReentrantLock(true);

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 rl= new ReentrantLock5();
        Thread th1 = new Thread(rl);
        Thread th2=new Thread(rl);
        th1.start();
        th2.start();
    }
    
}
