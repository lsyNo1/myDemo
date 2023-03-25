package com.lsy.lock8Problems;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/22.
 * 2、同一个对象，两个同步方法A和B，A方法等待四秒，谁先执行
 */
class Test2 {
    public static void main(String[] args) {

//        Test1 test = new Test1();
        Test2 test = new Test2();

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
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void b() {
        System.out.println(Thread.currentThread().getName());
    }
}
