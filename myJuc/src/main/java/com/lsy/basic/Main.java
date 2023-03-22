package com.lsy.basic;

/**
 * Created by ${USER} on ${DATE}.
 */
public class Main {
    public static void main(String[] args) {
//        SynchronizedTicket ticket = new SynchronizedTicket();

        ReentrantLockTicket ticket = new ReentrantLockTicket();

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