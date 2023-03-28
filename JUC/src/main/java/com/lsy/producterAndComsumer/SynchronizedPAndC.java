package com.lsy.producterAndComsumer;

/**
 * Created by lance on 2023/3/21.
 */
public class SynchronizedPAndC {

    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
        this.notifyAll();
    }

}
