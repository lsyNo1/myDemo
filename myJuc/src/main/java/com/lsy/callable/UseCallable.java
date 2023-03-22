package com.lsy.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lance on 2023/3/22.
 */
public class UseCallable {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();// 两个线程，只打印一个结果

        try {
            Integer o = (Integer) futureTask.get();
            System.out.println("得到的结果是" + o);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开始启动");
        return 1;
    }
}
