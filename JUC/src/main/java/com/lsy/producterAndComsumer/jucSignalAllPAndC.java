package com.lsy.producterAndComsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lance on 2023/3/21.
 * 多线程交替通知
 */
public class jucSignalAllPAndC {

    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition1.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
            condition2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition2.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
            condition3.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition3.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
            condition4.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printD() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition4.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "执行了，结果是" + number);
            condition1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
