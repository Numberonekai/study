package com.wk.study.demo.springdemo;

import com.wk.study.demo.springdemo.result.UserData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
        String[]  names=applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
//        applicationContext.setApplicationContextClass( AnnotationConfigApplicationContext.class );
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext.getBean("userData");
        UserData user =  applicationContext.getBean(UserData.class);
        user.setName("demo");
        System.out.println(user.getName());
    }
}
