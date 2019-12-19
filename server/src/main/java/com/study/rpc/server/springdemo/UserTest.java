package com.study.rpc.server.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther: kai2.wang
 * @date: 2019/12/18 09:42
 * @description:
 * @version: 1.0
 */
public class UserTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        User user=applicationContext.getBean(User.class);
        user.setBeanName("demo");
        System.out.println(user.getMsg());
        ((ClassPathXmlApplicationContext)applicationContext).destroy();
    }
}
