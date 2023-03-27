package com.lsy.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lance on 2023/3/26.
 * CAS compare and swap
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10000);

        atomicInteger.compareAndSet(2023, 2024);
    }


}
