package com.lsy.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by lance on 2023/3/17.
 */
public class AfterLog implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行完成，执行的是" + method.getName() + "方法,返回的结果是:" + returnValue);
    }
}
