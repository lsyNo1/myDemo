package com.lsy.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lance on 2023/3/23.
 */
public class UseExecutor {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 创建单个线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建指定个数线程池
    ExecutorService threadPool = Executors.newCachedThreadPool();//创建弹性线程池

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }

}
