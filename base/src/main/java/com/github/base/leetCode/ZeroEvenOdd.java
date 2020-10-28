package com.github.base.leetCode;

/**
 * 打印零与奇偶数
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 */
public class ZeroEvenOdd {

    private int n;

    private volatile boolean zeroFlag = true;

    private volatile boolean evenFlag = false;      // 输出偶数信息号量

    private volatile boolean oddFlag = false;       // 输出奇数信息号量

    private volatile boolean flag = true;          // 打印奇数还是偶数


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!zeroFlag) {
                Thread.yield();
            }
            printNumber.accept(0);
            zeroFlag = false;
            if (flag) {
                oddFlag = true;
            } else {
                evenFlag = true;
            }
        }
        // 防止死循环
        oddFlag = true;
        evenFlag = true;
    }

    // 偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!evenFlag) {
                Thread.yield();
            }
            if (i % 2 == 0) {
                printNumber.accept(i);
                zeroFlag = true;
                evenFlag = false;
                flag = true;
            }
        }
    }

    // 奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!oddFlag) {
                Thread.yield();
            }
            if (i % 2 == 1) {
                printNumber.accept(i);
                zeroFlag = true;
                oddFlag = false;
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(20);
        new Thread(new ExecutorA(zeroEvenOdd, 0)).start();
        new Thread(new ExecutorA(zeroEvenOdd, 1)).start();
        new Thread(new ExecutorA(zeroEvenOdd, 2)).start();
    }
}

class ExecutorA implements Runnable {

    private ZeroEvenOdd zeroEvenOdd;
    private int type;
    private IntConsumer intConsumer = new IntConsumer();

    public ExecutorA(ZeroEvenOdd zeroEvenOdd, int type) {
        this.zeroEvenOdd = zeroEvenOdd;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            switch (type) {
                case 0:
                    zeroEvenOdd.zero(intConsumer);
                    break;
                case 1:
                    zeroEvenOdd.odd(intConsumer);
                    break;
                case 2:
                    zeroEvenOdd.even(intConsumer);
                    break;
                default:
                    throw new Exception("参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class IntConsumer {

    public void accept(int x) {
        System.out.print(x);
    }
}
