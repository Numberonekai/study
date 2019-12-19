package com.wk.study.demo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @auther: kai2.wang
 * @date: 2019/12/17 17:25
 * @description:
 * @version: 1.0
 */
@EnableAsync
public class DemoTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // 发送事件，启动thrift
        context.publishEvent(new DemoEvent(context,"test"));
    }

}