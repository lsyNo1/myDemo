package com.lsy.service;

/**
 * Created by lance on 2023/3/17.
 */
public class PersonServiceImpl implements IPersonService {
    public void add() {
        System.out.println("执行了Add方法");
    }

    public void delete() {
        System.out.println("执行了Delete方法");
    }

    public void update() {
        System.out.println("执行了Update方法");
    }

    public void select() {
        System.out.println("执行了Select方法");
    }
}
