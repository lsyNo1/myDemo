package com.lsy.lock8Problems;

import java.util.concurrent.TimeUnit;

/**
 * 3、同一个对象，两个同步方法A和B，一个非同步方法C，谁先执行
 */
class Test3 {
    public static void main(String[] args) {
        Test3 test = new Test3();

        new Thread(() -> {
            test.a();
        }, "A").start();

        new Thread(() -> {
            test.b();
        }, "B").start();

        new Thread(() -> {
            test.c();
        }, "C").start();
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
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void c() {
        System.out.println(Thread.currentThread().getName());
    }

}
