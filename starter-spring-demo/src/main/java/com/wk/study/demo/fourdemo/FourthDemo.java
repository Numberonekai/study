package com.wk.study.demo.fourdemo;

import com.spring.spi.SpiDemo;
import com.wk.study.demo.thriddemo.ThridTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 15:14
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
public class FourthDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(FourthDemo.class,args);

        SpiDemo spiDemo=configurableApplicationContext.getBean(SpiDemo.class);
        System.out.println(spiDemo.getDemo());
//        String[] datas=configurableApplicationContext.getBeanDefinitionNames();
//        for (int i = 0; i < datas.length; i++) {
//            System.out.println(datas[i]);
//        }

    }
}
