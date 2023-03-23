package com.lsy.callable;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lance on 2023/3/22.
 * 门闩，减法计数器
 */
public class UseCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try {
            for (int i = 1; i <= 10; i++) {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                }, String.valueOf(i)).start();
            }
            countDownLatch.await();
            System.out.println("结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
