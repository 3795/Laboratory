package com.github.base.concurrent.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created By Seven.wk
 * Description: 延时队列，可以用来做定时任务队列
 * Created At 2018/11/19
 */
public class DelayQueue {

    static BlockingQueue<MyTask> tasks = new java.util.concurrent.DelayQueue<>();

    static Random r = new Random();

    static class MyTask implements Delayed {
        long runningTime;

        MyTask(long rt) {
            this.runningTime = rt;
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {

            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }


        @Override
        public String toString() {
            return "" + runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        DelayQueue.MyTask t1 = new DelayQueue.MyTask(now + 1000);
        DelayQueue.MyTask t2 = new DelayQueue.MyTask(now + 2000);
        DelayQueue.MyTask t3 = new DelayQueue.MyTask(now + 1500);
        DelayQueue.MyTask t4 = new DelayQueue.MyTask(now + 2500);
        DelayQueue.MyTask t5 = new DelayQueue.MyTask(now + 500);

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        for(int i=0; i<5; i++) {
            System.out.println(tasks.take());
        }
    }
    
}
