package com.lsy.basic;

/**
 * Created by lance on 2023/3/21.
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

}
