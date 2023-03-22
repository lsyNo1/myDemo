package com.lsy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7、一个对象，一个同步方法A，一个静态方法B，谁先执行
 */
class Test7 {
    public static void main(String[] args) {
        Test7 test1 = new Test7();

        new Thread(() -> {
            test1.a();
        }, "A").start();

        new Thread(() -> {
            test1.b();
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

    public static synchronized void b() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
