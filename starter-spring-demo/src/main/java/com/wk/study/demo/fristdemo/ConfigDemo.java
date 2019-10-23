package com.wk.study.demo.fristdemo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 11:06
 * @description:
 * @version: 1.0
 */
@Configurable
public class ConfigDemo {

    @Bean
    @Lazy
    public TestService testService(){
        return new TestService();
    }
}
