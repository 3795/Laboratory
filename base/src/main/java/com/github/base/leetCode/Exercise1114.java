package com.github.base.leetCode;

import java.util.concurrent.CountDownLatch;

/**
 * 使用门栓锁实现多线程之间的顺序执行
 */
public class Exercise1114 {

    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch three = new CountDownLatch(1);

    public Exercise1114() {

    }

    public void first(Runnable printFirst) {
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        three.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Exercise1114 exercise = new Exercise1114();
        Integer[] arr = {2, 3, 1};
        for (int i : arr) {
            new Thread(new Handler(exercise, i)).start();
        }
    }
}

class Handler implements Runnable {

    private Exercise1114 exercise;
    private Integer type;

    public Handler(Exercise1114 exercise1114, int type) {
        this.exercise = exercise1114;
        this.type = type;
    }

    @Override
    public void run() {
        switch (type) {
            case 1:
                First first = new First();
                exercise.first(first);
                break;
            case 2:
                Second second = new Second();
                try {
                    exercise.second(second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Three three = new Three();
                try {
                    exercise.third(three);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("参数错误");
        }
    }
}

class First implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("first");
    }
}

class Second implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second");
    }
}

class Three implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("three");
    }
}
