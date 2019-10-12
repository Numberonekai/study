package com.wk.study.demo.seconddemo.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 13:54
 * @description:
 * @version: 1.0
 */
@Configuration
public class ConfigOther {

    @Bean
    public OtherService otherService(){
        return new OtherService();
    }
}
