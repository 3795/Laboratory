package com.github.base.concurrent.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created By Seven.wk
 * Description: 并行计算
 * Created At 2018/11/20
 */
public class ParallelComputing {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 测试单线程运行时间
        Long startTime = System.currentTimeMillis();
        getPrime(1, 200000);
        Long endTime = System.currentTimeMillis();
        System.out.println("单线程花费时间: " + (endTime - startTime));

        // 测试并行计算花费时间
        final int cpuCoreNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        startTime = System.currentTimeMillis();
        // 等待其执行完成
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        endTime = System.currentTimeMillis();
        System.out.println("多线程花费时间: " + (endTime - startTime));

        service.shutdown();
    }

    static class MyTask implements Callable<List<Integer>> {

        int startPoint, endPoint;

        MyTask(int s, int e) {
            this.startPoint = s;
            this.endPoint = e;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(startPoint, endPoint);
        }
    }

    /**
     * 判断是否是质数
     * @param num
     * @return
     */
    static boolean isPrime(int num) {
        for (int i=2; i<num/2; i++) {
            if (num % i ==0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 得到质数
     * @param start
     * @param end
     * @return
     */
    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i=start; i<end; i++) {
            if (isPrime(i)) {
                results.add(i);
            }
        }
        return results;
    }
}
