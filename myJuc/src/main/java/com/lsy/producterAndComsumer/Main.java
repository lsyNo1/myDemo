package com.lsy.producterAndComsumer;

/**
 * Created by lance on 2023/3/21.
 */
public class Main {

//    public static void main(String[] args) {
//
////        SynchronizedPAndC pAndC = new SynchronizedPAndC();
//        jucPAndC pAndC = new jucPAndC();
//
//        new Thread(() -> {
//            for (int i = 1; i < 100; i++) {
//                try {
//                    pAndC.increment();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, "A").start();
//
//        new Thread(() -> {
//            for (int i = 1; i < 100; i++) {
//                try {
//                    pAndC.decrement();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, "B").start();
//
//        new Thread(() -> {
//            for (int i = 1; i < 100; i++) {
//                try {
//                    pAndC.increment();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, "C").start();
//
//
//        new Thread(() -> {
//            for (int i = 1; i < 100; i++) {
//                try {
//                    pAndC.decrement();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, "D").start();
//    }

    public static void main(String[] args) {
        jucSignalAllPAndC pAndC = new jucSignalAllPAndC();

        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                try {
                    pAndC.printA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                try {
                    pAndC.printB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                try {
                    pAndC.printC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                try {
                    pAndC.printD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "D").start();
    }
}
