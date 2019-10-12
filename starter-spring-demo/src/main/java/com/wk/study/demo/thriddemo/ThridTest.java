package com.wk.study.demo.thriddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 14:09
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
@EnableService
public class ThridTest {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(ThridTest.class,args);

        String[] datas=configurableApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }

    }
}
