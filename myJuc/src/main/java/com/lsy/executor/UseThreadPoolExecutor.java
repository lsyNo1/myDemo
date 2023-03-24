package com.lsy.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/23.
 */
public class UseThreadPoolExecutor {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, //核心数（银行柜台开放窗口数）
                5, //最大核心数（银行柜台最大窗口数）
                10, //核心释放等待时间
                TimeUnit.SECONDS, //核心释放等待时间单位
                new ArrayBlockingQueue<>(1),// 阻塞队列（银行排队座位）
                Executors.defaultThreadFactory(),//默认设置，线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy()// 拒绝策略
        );

        try {
            for (int i = 1; i <= 10; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            poolExecutor.shutdown();
        }

    }
}
