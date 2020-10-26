package com.github.base.concurrent.threadPool;

import java.util.concurrent.Executor;

/**
 * Created By Seven.wk
 * Description:
 * Created At 2018/11/20
 */
public class MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new MyExecutor().execute(() -> {
            System.out.println("MyExecutor");
        });
    }
}
