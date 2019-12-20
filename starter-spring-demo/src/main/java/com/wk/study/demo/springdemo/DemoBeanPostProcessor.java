package com.wk.study.demo.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: kai2.wang
 * @date: 2019/12/20 15:57
 * @description:
 * @version: 1.0
 */
@Configuration
public class DemoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessBeforeInitialization------");
        return "123";
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessAfterInitialization------");
        return "456";
    }
}
