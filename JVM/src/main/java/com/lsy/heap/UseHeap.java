package com.lsy.heap;

/**
 * Created by lance on 2023/3/28.
 */
public class UseHeap {

    public static void main(String[] args) {
        System.out.println("Max Memory:" + Runtime.getRuntime().maxMemory() + "字节 | " + (Runtime.getRuntime().maxMemory() / 1024 / 1024) + "MB");
        System.out.println("Total Memory:" + Runtime.getRuntime().totalMemory() + "字节 | " + (Runtime.getRuntime().totalMemory() / 1024 / 1024)+ "MB");
    }
}
