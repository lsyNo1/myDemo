package com.lsy.example;

import com.lsy.service.IPersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ${USER} on ${DATE}.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IPersonService personService = applicationContext.getBean("personService", IPersonService.class);


        personService.add();

    }
}