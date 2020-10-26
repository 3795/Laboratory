package com.github.base.concurrent.producerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By Seven.wk
 * Description: 使用Lock和Condition实现生产者消费者容器
 * Created At 2018/11/16
 */
public class Container2<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private Integer MAX = 10;     // 容器最大容量为10
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while(list.size() == MAX) { //想想为什么用while而不是用if？
                producer.await();
            }

            list.add(t);
            ++count;
            consumer.signalAll(); //通知消费者线程进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while(list.size() == 0) {
                consumer.await();
            }
            t = list.removeFirst();
            count --;
            producer.signalAll(); //通知生产者进行生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Container2<String> c = new Container2<>();

        // 开启消费者线程
        for (int i=0; i<10; i++) {
            new Thread(() -> {
                for (int j=0; j<5; j++) {
                    System.out.println(c.get());
                }
            }, "消费者" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 开启生产者线程
        for (int i=0; i<2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "生产者" + i).start();
        }
    }
}
