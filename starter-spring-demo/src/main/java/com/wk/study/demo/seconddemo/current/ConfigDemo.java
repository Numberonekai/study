package com.wk.study.demo.seconddemo.current;

import com.wk.study.demo.seconddemo.other.ConfigOther;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 11:06
 * @description:
 * @version: 1.0
 */
@Configurable
@Import(ConfigOther.class)
public class ConfigDemo {

    @Bean
    public TestService testService(){
        return new TestService();
    }
}
