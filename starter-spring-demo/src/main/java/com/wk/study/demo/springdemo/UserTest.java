package com.wk.study.demo.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * @auther: kai2.wang
 * @date: 2019/12/18 09:42
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
public class UserTest {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = (User) applicationContext.getBean(User.class);
//        user.setBeanName("demo");
//        System.out.println(user.getMsg());
//        ((ClassPathXmlApplicationContext) applicationContext).destroy();

        ConfigurableApplicationContext applicationContext= SpringApplication.run(UserTest.class);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean(User.class);
        user.setBeanName("demo");
        System.out.println(user.getMsg());
        ((ClassPathXmlApplicationContext) applicationContext).destroy();
    }
}
