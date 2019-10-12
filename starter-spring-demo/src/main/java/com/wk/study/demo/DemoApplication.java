package com.wk.study.demo;

import com.wk.study.demo.thriddemo.ThridTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(DemoApplication.class,args);

        String[] datas=configurableApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i]);
        }
    }

}
