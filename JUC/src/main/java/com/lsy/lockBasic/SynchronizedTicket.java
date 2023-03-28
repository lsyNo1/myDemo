package com.lsy.lockBasic;

/**
 * Created by lance on 2023/3/21.
 * Java自带 synchronized 关键字，用作锁
 * 可以解决 原子性（单个线程的锁定不会被其他线程打破原子性） 可见性（单个线程的锁定不会在意可见性）
 */
public class SynchronizedTicket {

    private int ticket = 100;

    /**
     * 添加synchronized 关键字
     */
    public synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "开始售卖第" + ticket + "张票，剩余" + (ticket - 1) + "张。");
            ticket--;
        }
    }

    public static void main(String[] args) {
        SynchronizedTicket ticket = new SynchronizedTicket();

        new Thread(() -> {
            for (int i = 1; i < 80; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i < 80; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i < 80; i++) {
                ticket.sale();
            }
        }, "C").start();
    }

}
