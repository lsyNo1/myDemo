package com.lsy.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lance on 2023/3/21.
 */
public class ReentrantLockTicket {

    private int ticket = 100;

    /**
     * 使用reentrant lock ，可冲入锁，lock 接口的实现类
     */
    public void sale() {

        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "开始售卖第" + ticket + "张票，剩余" + (ticket - 1) + "张。");
                ticket--;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
