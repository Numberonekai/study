package com.wk.study.demo.seconddemo.current;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 11:06
 * @description:
 * @version: 1.0
 */
public class FristTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(ConfigDemo.class);
//        TestService testService= (TestService) annotationConfigApplicationContext.getBean(TestService.class);

//        System.out.println(testService.sayHello());

        String[] datas=annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }

    }

}
