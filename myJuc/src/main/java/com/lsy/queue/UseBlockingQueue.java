package com.lsy.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/23.
 */
public class UseBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(7);

        // 抛出异常
        blockingQueue.add("1");//添加
        blockingQueue.remove();//弹出
        blockingQueue.element();// 查看顶端元素

        // 有返回值
        System.out.println(blockingQueue.offer("2"));//添加
        System.out.println(blockingQueue.poll());//弹出
        System.out.println(blockingQueue.peek());// 查看顶端元素

        // 阻塞等待
        blockingQueue.put("3");
        blockingQueue.take();

        // 超时等待
        System.out.println(blockingQueue.offer("4", 4, TimeUnit.SECONDS));

        // 同步队列 (大小默认是1的)
        BlockingQueue<String> es = new SynchronousQueue<>();
    }
}

