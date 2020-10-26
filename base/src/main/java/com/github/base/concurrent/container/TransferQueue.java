package com.github.base.concurrent.container;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created By Seven.wk
 * Description:
 * 在生产者产生元素后，他不会直接加入队列，而是查找是否有消费者在等待，
 * 如果有消费者等待的话，直接给消费者，否则则加入队列
 * 如果没有业务处理它放进去的元素，就会产生阻塞
 * Created At 2018/11/19
 */
public class TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

//		new Thread(() -> {
//			try {
//				System.out.println(strs.take());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}).start();

        strs.transfer("aaa");

//        strs.put("aaa");


        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
