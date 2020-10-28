package com.github.base.leetCode;

/**
 * 交替打印FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {

    private int n;

    private volatile boolean fooE = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            synchronized (this) {
                while (!fooE) {
                    this.wait();
                }

                printFoo.run();
                fooE = false;
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            synchronized (this) {
                while (fooE) {
                    this.wait();
                }

                printBar.run();
                fooE = true;
                this.notifyAll();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(1000);
        new Thread(new Executor(fooBar, "foo", new Foo())).start();
        new Thread(new Executor(fooBar, "bar", new Bar())).start();
    }
}

class Executor implements Runnable {

    private FooBar fooBar;
    private String type;
    private Runnable runnable;

    public Executor(FooBar fooBar, String type, Runnable runnable) {
        this.fooBar = fooBar;
        this.type = type;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            if ("foo".equals(type)) {
                fooBar.foo(runnable);
            } else {
                fooBar.bar(runnable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Foo implements Runnable {

    @Override
    public void run() {
        System.out.println("foo");
    }
}

class Bar implements Runnable {

    @Override
    public void run() {
        System.out.println("bar");
    }
}