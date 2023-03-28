package com.lsy.lock8Problems;

import java.util.concurrent.TimeUnit;

/**
 * 4、两个对象，两个同步方法A和B，谁先执行
 */
class Test4 {
    public static void main(String[] args) {
        Test4 test1 = new Test4();
        Test4 test2 = new Test4();

        new Thread(() -> {
            test1.a();
        }, "A").start();

        new Thread(() -> {
            test2.b();
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
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
