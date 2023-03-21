package com.lsy.log;

import org.aspectj.lang.annotation.Before;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lance on 2023/3/17.
 */
public class Log implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("我准备执行" + method.getName() + "方法了");
    }
}
