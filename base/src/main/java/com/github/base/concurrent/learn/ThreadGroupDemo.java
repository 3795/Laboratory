package com.github.base.concurrent.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created At 2022/10/9
 */
public class ThreadGroupDemo {

    public static List<Thread> DbConnThread() {
        ThreadGroup dbConnThreadGroup = new ThreadGroup("数据库连接线程组");
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(dbConnThreadGroup, () -> {
                System.out.println("线程名" + Thread.currentThread().getName() + "，所在线程组:" + Thread.currentThread().getThreadGroup().getName());
            }, "db-conn-thread-" + i);
            threadList.add(t);
        }
        return threadList;
    }

    public static List<Thread> httpReqThread() {
        ThreadGroup httpReqThreadGroup = new ThreadGroup("第三方http请求线程组");
        List<Thread> httpReqThreadList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(httpReqThreadGroup, new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: " + Thread.currentThread().getName()
                            + ", 所在线程组: " + Thread.currentThread().getThreadGroup().getName());
                }
            }, "http-req-thread-" + i);
            httpReqThreadList.add(t);
        }
        return httpReqThreadList;
    }

    public static void startThread(List<Thread> threadList) {
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        List<Thread> dbConnThreadList = DbConnThread();
        List<Thread> httpReqThreadList = httpReqThread();
        startThread(dbConnThreadList);
        startThread(httpReqThreadList);
    }
}
