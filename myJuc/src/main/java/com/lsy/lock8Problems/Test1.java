package com.lsy.lock8Problems;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/22.
 * 1、同一个对象，两个同步方法A和B，谁先执行
 */
class Test1 {
    public static void main(String[] args) {

//        Test1 test = new Test1();
        Test1 test = new Test1();

        new Thread(() -> {
            test.a();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            test.b();
        }, "B").start();


    }
    public synchronized void a() {
        System.out.println(Thread.currentThread().getName());
    }

    public synchronized void b() {
        System.out.println(Thread.currentThread().getName());
    }
}
