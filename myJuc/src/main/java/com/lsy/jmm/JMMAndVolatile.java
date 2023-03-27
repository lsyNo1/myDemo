package com.lsy.jmm;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/26.
 * JMM（Java Memory Model） Java内存模型,一个规定，主内存和线程的运行内存的通信
 */
public class JMMAndVolatile {
    private static boolean state = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (state) {
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        state = true;

        System.out.println(state);
    }
}
