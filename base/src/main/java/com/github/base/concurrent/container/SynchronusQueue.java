package com.github.base.concurrent.container;

/**
 * Created By Seven.wk
 * Description: 同步队列，一种特殊的TransferQueue
 * TransferQueue 在没有消费者的情况下，是可以放到队列中去的
 * SynchronusQueue 必须直接让消费者消费，不能够放到队列中去
 * Created At 2018/11/19
 */
public class SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<String> strs = new SynchronousQueue<>();
//
//        new Thread(()->{
//            try {
//                System.out.println(strs.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        strs.put("aaa"); //阻塞等待消费者消费
//        //strs.add("aaa");
//        System.out.println(strs.size());
    }
}
