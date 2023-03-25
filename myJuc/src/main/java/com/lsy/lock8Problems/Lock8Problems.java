package com.lsy.lock8Problems;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/21.
 * 8锁问题
 * 1、同一个对象，两个同步方法A和B，谁先执行
 * 2、同一个对象，两个同步方法A和B，A方法等待四秒，谁先执行
 * 3、同一个对象，两个同步方法A和B，一个非同步方法C，谁先执行
 * 4、两个对象，两个同步方法A和B，谁先执行
 * 5、同一个对象，两个同步静态方法A和B，谁先执行
 * 6、两个对象，两个同步静态方法A和B，谁先执行
 * 7、一个对象，一个同步方法A，一个静态方法B，谁先执行
 * 8、两个对象，一个同步方法A，一个静态方法B，谁先执行
 */
public class Lock8Problems {

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
}


