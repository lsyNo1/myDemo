package com.lsy.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lance on 2023/3/22.
 * Thread 不能直接使用callable，需要使用implement了runnable的futureTask，将callable放入其中，然后通过Thread 运行futureTask，间接运行callable
 */
public class UseCallable {

    public static void main(String[] args) {
        // 使用类创建FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());

        // 用lambda 创建 callable
//        FutureTask<Integer> integerFutureTask = new FutureTask<>(() -> {
//            System.out.println("1");
//            return 1;
//        });

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

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开始启动");
        return 1;
    }
}
